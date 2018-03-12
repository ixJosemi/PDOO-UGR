/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.BadConsequence;
import napakalaki.NumericBadConsequence;
import napakalaki.SpecificBadConsequence;
import napakalaki.DeathBadConsequence;
import napakalaki.Treasure;
import napakalaki.TreasureKind;
import java.util.ArrayList;

/**
 *
 * @author ixjosemi
 */

public class PendingBadConsequenceView extends javax.swing.JPanel {

    private BadConsequence pendingModel;
    
    
    public PendingBadConsequenceView() {
        initComponents();
    }

    
    public void setPending (BadConsequence t) {
        
        // se actualiza el atributo de referencia
        pendingModel = t;
             
        if (pendingModel instanceof DeathBadConsequence) {
                        LabelPending.setText("ESTÁS MUERTO.");
        }
        
        // Actualizamos vista del mal rollo pendiente en función de cuál sea este.
        else { 
            
            if (pendingModel instanceof NumericBadConsequence) {
                nvisibles.setText("nVisibles :" + ((NumericBadConsequence)pendingModel).getnVisibleTreasures());
                nocultos.setText("nHidden : " + ((NumericBadConsequence)pendingModel).getnHiddenTreasures());
                spOcultos.setText("specificH : ");
                spVisibles.setText("specificV : ");
            
            }
        
            else {
            
                
                String frase1 = "";
                String frase2 = "";

                ArrayList <TreasureKind> specificHiddenTreasures = ((SpecificBadConsequence)pendingModel).getSpecificHiddenTreasures();
                
                // Crear lista.
                for (TreasureKind s1 : specificHiddenTreasures) {

                    frase1 = frase1 + " " + s1;

                }
                
                ArrayList <TreasureKind> specificVisibleTreasures = ((SpecificBadConsequence)pendingModel).getSpecificVisibleTreasures();
                
                // Crear lista.
                for (TreasureKind s2 : specificVisibleTreasures) {

                    frase2 = frase2 + " " + s2;

                }
        
                // Actualizamos vistas.
                spOcultos.setText("specificH : " + frase1);
                spVisibles.setText("specificV : " + frase2);
                nvisibles.setText("nVisibles : ");
                nocultos.setText("nHidden :");
                
            }
    
        }
            
        // la siguiente instrucción hace que los cambios en la vista sean efectivos
        repaint();
        revalidate();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPending = new javax.swing.JLabel();
        nvisibles = new javax.swing.JLabel();
        nocultos = new javax.swing.JLabel();
        spVisibles = new javax.swing.JLabel();
        spOcultos = new javax.swing.JLabel();

        LabelPending.setText("Mal rollo pendiente :");

        nvisibles.setText("nVisibles:");

        nocultos.setText("nHidden:");

        spVisibles.setText("specificV:");

        spOcultos.setText("specificH:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spOcultos)
                    .addComponent(spVisibles)
                    .addComponent(LabelPending)
                    .addComponent(nvisibles)
                    .addComponent(nocultos))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelPending)
                .addGap(25, 25, 25)
                .addComponent(nvisibles)
                .addGap(18, 18, 18)
                .addComponent(nocultos)
                .addGap(18, 18, 18)
                .addComponent(spVisibles)
                .addGap(18, 18, 18)
                .addComponent(spOcultos)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelPending;
    private javax.swing.JLabel nocultos;
    private javax.swing.JLabel nvisibles;
    private javax.swing.JLabel spOcultos;
    private javax.swing.JLabel spVisibles;
    // End of variables declaration//GEN-END:variables
}
