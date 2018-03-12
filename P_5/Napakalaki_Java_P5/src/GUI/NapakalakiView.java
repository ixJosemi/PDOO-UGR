/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.Napakalaki;
import napakalaki.CombatResult;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ixjosemi
 */
public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki napakalaki){
        napakalakiModel = napakalaki;
        
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView1.setNapakalaki(napakalaki);
        playerView1.getButtonDiscardTreasures().setEnabled(false);
        
        ButtonNextTurn.setEnabled(false);
        ButtonCombat.setEnabled(false);
        
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combatResult = new javax.swing.JTextField();
        showMonster = new javax.swing.JButton();
        LabelCombatResult = new javax.swing.JLabel();
        ButtonCombat = new javax.swing.JButton();
        ButtonMeetTheMonster = new javax.swing.JButton();
        ButtonNextTurn = new javax.swing.JButton();
        combatResult1 = new javax.swing.JTextField();
        showMonster1 = new javax.swing.JButton();
        mensajeLabel = new javax.swing.JLabel();
        mensaje = new javax.swing.JTextField();
        monsterView2 = new GUI.MonsterView();
        playerView1 = new GUI.PlayerView();

        combatResult.setEditable(false);
        combatResult.setText("Resultado");

        showMonster.setText("Mostrar Monstruo");
        showMonster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMonsterMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelCombatResult.setText("Resultado combate");

        ButtonCombat.setForeground(new java.awt.Color(0, 153, 153));
        ButtonCombat.setText("Combat");
        ButtonCombat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ButtonCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCombatActionPerformed(evt);
            }
        });

        ButtonMeetTheMonster.setForeground(new java.awt.Color(0, 153, 153));
        ButtonMeetTheMonster.setText("Meet the Monster");
        ButtonMeetTheMonster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ButtonMeetTheMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMeetTheMonsterActionPerformed(evt);
            }
        });

        ButtonNextTurn.setForeground(new java.awt.Color(0, 153, 153));
        ButtonNextTurn.setText("Next turn");
        ButtonNextTurn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ButtonNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNextTurnActionPerformed(evt);
            }
        });

        combatResult1.setEditable(false);
        combatResult1.setText("Resultado");

        showMonster1.setForeground(new java.awt.Color(0, 153, 153));
        showMonster1.setText("Show monster");
        showMonster1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        showMonster1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMonster1MouseClicked(evt);
            }
        });
        showMonster1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMonster1ActionPerformed(evt);
            }
        });

        mensajeLabel.setText("Otros Mensajes");

        mensaje.setEditable(false);
        mensaje.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combatResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showMonster1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonMeetTheMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonCombat, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonNextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mensajeLabel)
                            .addComponent(LabelCombatResult))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(monsterView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monsterView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCombatResult)
                    .addComponent(combatResult1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mensajeLabel)
                            .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(showMonster1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonNextTurn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonMeetTheMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonCombat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCombatActionPerformed

        this.ButtonCombat.setEnabled(false);
        this.ButtonMeetTheMonster.setEnabled(false);

        // Comprobamos el resultado del combate.
        CombatResult result = napakalakiModel.developCombat();

        //setNapakalaki(napakalakiModel);

        if (result == CombatResult.WINGAME) {   // Gana combate y partida

            JOptionPane.showMessageDialog(null, "El jugador " + this.napakalakiModel.getCurrentPlayer().getName() +
                " HA GANADO EL JUEGO.");
            System.exit(0);
        }

        else {

            if (result == CombatResult.WIN){ // Gana combate
                LabelCombatResult.setText("HAS GANADO EL COMBATE.");
                LabelCombatResult.setVisible(true);
            }

            else {  // Pierde el combate
                LabelCombatResult.setText("HAS PERDIDO EL COMBATE.");
                LabelCombatResult.setVisible(true);
                LabelCombatResult.setForeground(Color.red);
            }

        }

        this.ButtonNextTurn.setEnabled(true);

        //repaint();
        revalidate();
    }//GEN-LAST:event_ButtonCombatActionPerformed

    private void ButtonMeetTheMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMeetTheMonsterActionPerformed

    }//GEN-LAST:event_ButtonMeetTheMonsterActionPerformed

    private void ButtonNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNextTurnActionPerformed
        
        napakalakiModel.nextTurn();
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView1.setNapakalaki(napakalakiModel);
        playerView1.getButtonDiscardTreasures().setEnabled(false);
        playerView1.getButtonMakeVisible().setEnabled(true);
        ButtonCombat.setEnabled(true);
        ButtonNextTurn.setEnabled(false);
        ButtonCombat.setEnabled(false);    
        showMonster.setEnabled(false);
        combatResult.setText("Resultado");
        showMonster.setEnabled(true);
        
        mensaje.setText("");
        
        repaint();

    }//GEN-LAST:event_ButtonNextTurnActionPerformed

    private void showMonsterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMonsterMouseClicked
        monsterView2.setMonster(napakalakiModel.getCurrentMonster());
        ButtonCombat.setEnabled(true);
        showMonster.setEnabled(false);
        playerView1.getButtonMakeVisible().setEnabled(false);
        
        repaint();
    }//GEN-LAST:event_showMonsterMouseClicked

    private void showMonster1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMonster1MouseClicked
        monsterView2.setMonster(napakalakiModel.getCurrentMonster());
        ButtonCombat.setEnabled(true);
        showMonster.setEnabled(false);

        repaint();
    }//GEN-LAST:event_showMonster1MouseClicked

    private void showMonster1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMonster1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showMonster1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void showView() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCombat;
    private javax.swing.JButton ButtonMeetTheMonster;
    private javax.swing.JButton ButtonNextTurn;
    private javax.swing.JLabel LabelCombatResult;
    private javax.swing.JTextField combatResult;
    private javax.swing.JTextField combatResult1;
    private javax.swing.JTextField mensaje;
    private javax.swing.JLabel mensajeLabel;
    private GUI.MonsterView monsterView2;
    private GUI.PlayerView playerView1;
    private javax.swing.JButton showMonster;
    private javax.swing.JButton showMonster1;
    // End of variables declaration//GEN-END:variables
}

