package napakalaki;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;
import GUI.*; // Se importa todo de GUI.

/**
 *
 * @author ixjosemi
 */

public class Main {
      
        public static void main(String[] args) {
        
            Napakalaki game = Napakalaki.getInstance();
            
            NapakalakiView napakalakiView = new NapakalakiView();
            Dice.createInstance (napakalakiView);
            
            
            PlayerNamesCapture namesCapture 
                    = new PlayerNamesCapture (napakalakiView,true);
            
            ArrayList<String> names = new ArrayList();
            
            names = namesCapture.getNames();
            
            game.initGame(names);
            
            napakalakiView.setNapakalaki(game);
            
            napakalakiView.setVisible (true); 
        }
}
