# encoding: utf-8

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative 'monster'
require_relative 'player'
require_relative 'card_dealer'
require_relative 'treasure'

module NapakalakiRuby

class Napakalaki
    
    include Singleton
    
    attr_reader :current_player
    attr_reader :players
    attr_reader :dealer
    attr_reader :current_monster
    
    def initialize
        @current_monster = nil
        @current_player = nil
        @dealer = CardDealer.instance
    end
    
    def init_players(names)
       
        @players = Array.new
        
        names.each do |s|
            players << Player.new(s)
        end
    end
    
    def next_player
        
        total_players = @players.length
        
        if(@current_player == nil)
            next_index = rand(total_players)
            
        else
            current_player_index = @players.index(@current_player)
            
            if (current_player_index == total_players - 1)
                next_index = 0
            else
                next_index = current_player_index + 1
            end
        end
        
        next_player = @players.at(next_index)
        @current_player = next_player
        
        return @current_player
    end
    
    def next_turn_allowed
        
        allowed = false
        
        if (@current_player == nil)
            allowed = true
        else
            allowed = @current_player.valid_state
        end
        
        return allowed
    end
    
    def develop_combat
        
        combatResult = @current_player.combat(@current_monster)
        
        dealer.give_monster_back(current_monster)
        
        return combatResult
    end
    
    def discard_visible_treasure(treasures)
        
        treasures.each do |t|
            
            @current_player.discard_visible_treasure(t)
            
            @dealer.give_treasure_back(t)
        end
    end
    
    def discard_hidden_treasure(treasures)
        
        treasures.each do |t|
            
            @current_player.discard_hidden_treasure(t)
            
            @dealer.give_treasure_back(t)
        end
    end
    
    def make_treasure_visible(treasures)
        
        treasures.each do |t|
            
            @current_player.make_treasure_visible(t)
        end
    end
    
    def init_game (players = Array.new)
        
        init_players(players)
        
        set_enemies
        
        @dealer.init_cards
        
        next_turn
    end
    
    def get_current_player
        return @current_player
    end
    
    def get_current_monster
        return @current_monster
    end
    
    def next_turn
        
        state_ok = next_turn_allowed
        
        if(state_ok == true)
            
            @current_monster = @dealer.next_monster
            @current_player = next_player
            
            if(@current_player.dead == true)
                @current_player.init_treasures
            end
        end
        
        return state_ok
    end
    
    def end_of_game
        return result = WINGAME
    end 
    
    def set_enemies
        
        @players.each do |p|
            num_players = @players.length
            
            random = 0
            
            loop do
                
                random = rand(num_players)
                
                break if random != @players.index(p)
            end
            
            enemy = @players.at(random)
            
            @enemy = enemy
        end
    end
    
end

end