# encoding: utf-8

module NapakalakiRuby

require_relative 'treasure'
require_relative 'monster'
require_relative 'treasure_kind'
require_relative 'combat_result'
require_relative 'dice'
require_relative 'card_dealer'
require_relative 'bad_consequence'
require_relative 'numeric_bad_consequence'
require_relative 'specific_bad_consequence'
require_relative 'death_bad_consequence'
    
class Player
    
    @@MAXLEVEL = 10
    
    # Consultores basicos
    attr_reader :name
    attr_reader :level
    attr_reader :dead
    attr_reader :canISteal
    attr_reader :visible_treasures
    attr_reader :hidden_treasures
    attr_writer :enemy, :pending_bc
    
    # Constructor
    def initialize(name)
                
        @name = name
        @level = 1
        @dead = true
        @canISteal = true
        
        @enemy = nil
        @pending_bc = nil
        
        @visible_treasures = Array.new
        @hidden_treasures = Array.new
    end
    
    def self.crear_copia(p)
        @name = p.name
        @level = p.level
        @dead = p.dead
        @canISteal = p.canISteal
        @enemy = p.enemy
        @pending_bc = p.pending_bc
        @visible_treasures = p.visible_treasures
        @hidden_treasures = p.hidden_treasures
    end
    
    def to_s
        "#{self.name}
        \n Nivel: #{@level.to_s}"
#        \n Enemigo: #{@enemy.name}"
    end
    
    public
    
    def self.get_max_level
        return @@MAXLEVEL
    end
    
    def is_dead
        return @dead
    end
    
    def combat_level
        @lvl = level
    end
    
    def bring_to_life
        @dead = false
    end
    
    def increment_levels(l)
        @level += l
    end
    
    def decrement_levels(l)
        @level -= l
        
        if (@level < 1)
            @level = 1
        end
    end
    
    def get_combat_level
        
        combat_level = @level
        
        @visible_treasures.each do |t| 
            combat_level = combat_level + t.bonus
        end
        
        return (combat_level)
    end
    
    def set_pending_badconsequence(bc)
        @pending_badconseuqnece = bc
    end
    
    def apply_prize(current_monster)
        
        n_levels = current_monster.get_levels_gained
        increment_levels(n_levels)
        
        n_treasures = current_monster.get_treasures_gained
        
        if (n_treasures > 0)
            dealer = CardDealer.instance
            
            n_treasures.times do
                t = dealer.next_treasure
                @hidden_treasures << t
            end
        end
    end
    
    def apply_badconsequence(m)
        
        badconsequence = m.bc
        
        n_levels = badconsequence.someLevels
        
        decrement_levels(n_levels)
       
        @pending_bc = badconsequence.adjust_to_fit_treasure_list(@visible_treasures, @hidden_treasures)
        
        set_pending_badconsequence(@pending_bc)
    end
    
    def can_make_treasure_visible(t)
        
        can = true;
        
        if (@visible_treasures.length < 5) 
        
            type = t.type;
            
            case (type) 
            
            when TreasureKind::ONEHAND 
            
                dos_manos = false
            
                @visible_teasures.each do |tr|
             
                    if (tr.type == TreasureKind::BOTHHANDS) 
                        can = false
                        dos_manos = true
                    end
                end
            
                if (dos_manos == false)            
             
                    i = 0
                    
                    @visible_treasures.each do |tr|
                
                        if (tr.type == TreasureKind::ONEHAND) 
                            i = i+1
                        end
                    end

                    if (i == 2) 
                        can = false 
                    end   
            
                else 
                    @visible_treasures.each do |tr|
                        
                        if (tr.type == type) 
                            can = false
                        end
                    end
                end    
            end
        end
          
        return can      
    end
   
    def how_many_visible_treasures(t_kind)
 
        i = 0
        @visible_treasures.each do |t|
 
            if t.type == t_kind then
                i = i + 1
            end
        end 
        
        return i       
    end
    
    def die_if_no_treasures
        
        if @visible_treasures.empty? && @hidden_treasures.empty?
            @dead = true
        end
    end
    
    def give_me_a_treasure
        @random = rand(CardDealer.unused_treasures.size)
        
        return CardDealer.unused_treasures.get(random)
    end
    
    def combat(m)
       
        my_level = self.get_combat_level
        monster_level = m.combatLevel

        if (my_level > monster_level)
        
            apply_prize(m)
       
            if (self.level >= @@MAXLEVEL) 
                combatResult = CombatResult::WINGAME
                
            else 
                combatResult = CombatResult::WIN 
            end
  
        else
            apply_badconsequence(m)
       
            if (should_convert())
                combatResult = CombatResult::LOSEANDCONVERT;
            else
                combatResult = CombatResult::LOSE;
            end
      
            combatResult = CombatResult::LOSE;
        end
    
        return combatResult
    end
    
    def make_treasure_visible(t)
        
        if(can_make_treasure_visible(t))
            @visible_treasures << t
            
            @hidden_treasures.delete(t)
        end
    end
    
    def discard_visible_treasure(t)
        @visible_treasures.delete(t)
        
        if(@pending_bc != nil && @pending_bc.is_empty)
            @pending_bc.substract_visible_treasure(t)
        end
        
        die_if_no_treasures
    end
    
    def discard_hidden_treasure(t)
        @hidden_treasures.delete(t)
        
        if(@pending_bc != nil && @pending_bc.is_empty)
            @pending_bc.substract_hidden_treasure(t)
        end
        
        die_if_no_treasures
    end
    
    def steal_treasure
        
        treasure = nil
        
        if(@canISteal)
            
            if(can_you_give_me_a_treasure)
                treasure = @enemy.give_me_a_treasure
                
                @hidden_treasures.add(treasure)
                
                self.have_stolen
            end
        end
        
        return treasure
    end
    
    def discard_all_treasures
        
        visible_copy = Array.new(@visible_treasures)
        hidden_copy = Array.new(@hidden_treasures)
        
        visible_copy.each do |t|
            discard_visible_treasure(t)
        end
        
        hidden_copy.each do |t|
            discard_hidden_treasure(t)
        end
    end
    
    def can_you_give_me_a_treasure
        return ((!@visible_treasures.empty?) && !(@hidden_treasures.empty?))
    end
    
    def have_stolen
        @canISteal = false
    end
    
    def init_treasures
        
        dealer = CardDealer.instance
        
        dice = Dice.instance
        
        bring_to_life
        
        treasure = dealer.next_treasure
        @hidden_treasures << treasure
        
        number = dice.next_number
        
        if (number > 1)
            treasure = dealer.next_treasure
            @hidden_treasures << (treasure)
        end
        
        if (number == 6)
            treasure = dealer.next_treasure
            @hidden_treasures << (treasure)
        end
    end
    
    def valid_state
        return (@pending_bc.is_empty && @hidden_treasures.length <= 4)
    end

    def should_convert
        should = false
        
        dice = Dice.instance
        
        if(dice.next_number == 1)
            should = true
        end
        
        return should
    end
    
end
end

