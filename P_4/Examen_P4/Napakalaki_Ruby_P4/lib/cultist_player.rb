# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CultistPlayer < Player
   
    @@totalCultistPlayers = 0
    
    attr_reader :totalCultistPlayers    
    
    def initialize(p, c)
        Player.crear_copia(p)
        @myCultistCard = c
        @@totalCultistPlayers = @@totalCultistPlayers + 1
    end
    
    protected
    def get_combat_level
        
        combat_level = (super.get_combat_level * 1.2) +
                    (@myCultistCard.get_gained_levels * @@totalCultistPlayers)
        
        combat_level_truncado = combat_level.truncate
        
        return combat_level_truncado
    end
    
    def get_oponent_level(m)
        return m.get_combat_level_against_cultist_player
    end
    
    def give_me_a_treasure  
        
        tVisibles = @visible_treasures
    
        rnd = rand(tVisibles.length)
    
        return (tVisibles.delete_at(rnd))
    end
    
    def should_convert
        return false
    end
    
    def can_you_give_me_a_treasure
        
        t = @enemy.visible_treasures
        have_treasures = !(t.empty?)
        
        return have_treasures
    end
end
