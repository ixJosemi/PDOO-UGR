
module NapakalakiRuby
    
require_relative 'bad_consequence'
require_relative 'numeric_bad_consequence'
require_relative 'player'
    
class DeathBadConsequence < NumericBadConsequence
    
    public_class_method :new
    
    # Constructor
    def initialize (text)
        super(text, Player.get_max_level, BadConsequence.getMaxTreasures,
            BadConsequence.getMaxTreasures)
    end
end

end
