/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.managers;

import com.mycompany._usjt_psc_sistema.UserRegister;
import com.mycompany._usjt_psc_sistema.screens.AdminDashboardScreen;

/**
 *
 * @author 823212382
 */
public class AdminUserManager extends javax.swing.JFrame {

    /**
     * Creates new form UserManager
     */
    public AdminUserManager() {
        super("MyBookshelf - Registro de Usuários");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userManagerPanel = new javax.swing.JPanel();
        registerUserButton = new javax.swing.JButton();
        userEditButton = new javax.swing.JButton();
        seeAllUsersButton = new javax.swing.JButton();
        userDeleteButotn = new javax.swing.JButton();
        findOneButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userManagerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciamento de Usuários"));

        registerUserButton.setText("Cadastrar Usuários");
        registerUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUserButtonActionPerformed(evt);
            }
        });

        userEditButton.setText("Editar Informações de Usuário");
        userEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEditButtonActionPerformed(evt);
            }
        });

        seeAllUsersButton.setText("Ver Usuários Existentes");

        userDeleteButotn.setText("Deletar Usuário");
        userDeleteButotn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDeleteButotnActionPerformed(evt);
            }
        });

        findOneButton.setText("Ver Um Usuário");
        findOneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findOneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userManagerPanelLayout = new javax.swing.GroupLayout(userManagerPanel);
        userManagerPanel.setLayout(userManagerPanelLayout);
        userManagerPanelLayout.setHorizontalGroup(
            userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManagerPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findOneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userDeleteButotn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addComponent(seeAllUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        userManagerPanelLayout.setVerticalGroup(
            userManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManagerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userDeleteButotn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findOneButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(seeAllUsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        returnButton.setText("Voltar");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(userManagerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(userManagerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUserButtonActionPerformed
        UserRegister ur = new UserRegister();
        this.dispose();
        ur.setVisible(true);
    }//GEN-LAST:event_registerUserButtonActionPerformed

    private void userEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEditButtonActionPerformed

    private void userDeleteButotnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDeleteButotnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userDeleteButotnActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        this.dispose();
        AdminDashboardScreen ads = new AdminDashboardScreen();
        ads.setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void findOneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findOneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findOneButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUserManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUserManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findOneButton;
    private javax.swing.JButton registerUserButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton seeAllUsersButton;
    private javax.swing.JButton userDeleteButotn;
    private javax.swing.JButton userEditButton;
    private javax.swing.JPanel userManagerPanel;
    // End of variables declaration//GEN-END:variables
}
