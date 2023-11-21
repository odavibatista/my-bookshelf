/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany._usjt_psc_sistema.managers;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.AdminBookDelete;
import com.mycompany._usjt_psc_sistema.BookEdit;
import com.mycompany._usjt_psc_sistema.BookRegister;
import com.mycompany._usjt_psc_sistema.GenreRegister;
import com.mycompany._usjt_psc_sistema.DAOS.BookDAO;
import com.mycompany._usjt_psc_sistema.DAOS.RateDAO;
import com.mycompany._usjt_psc_sistema.models.Book;
import com.mycompany._usjt_psc_sistema.models.Rate;
import com.mycompany._usjt_psc_sistema.screens.AdminDashboardScreen;

/**
 *
 * @author 823212382
 */
public class AdminBookManager extends javax.swing.JFrame {

    /**
     * Creates new form AdminBookManager
     */
    public AdminBookManager() {
        super("MyBookshelf - Administração de Livros");
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        adminEditBookButton = new javax.swing.JButton();
        adminRegisterBookButton = new javax.swing.JButton();
        adminFinOneBookButton = new javax.swing.JButton();
        adminDeleteBookButton = new javax.swing.JButton();
        adminSeeBooksButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        genreRegisterButton = new javax.swing.JButton();
        rateBookButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Administração de Livros"));

        adminEditBookButton.setText("Editar Livros");
        adminEditBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminEditBookButtonActionPerformed(evt);
            }
        });

        adminRegisterBookButton.setText("Cadastrar Livros");
        adminRegisterBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminRegisterBookButtonActionPerformed(evt);
            }
        });

        adminFinOneBookButton.setText("Ver Livro");
        adminFinOneBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminFindOneBookButtonActionPerformed(evt);
            }
        });

        adminDeleteBookButton.setText("Deletar Livro");
        adminDeleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDeleteBookButtonActionPerformed(evt);
            }
        });

        adminSeeBooksButton.setText("Ver Todos os Livros");
        adminSeeBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSeeBooksButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Voltar");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        genreRegisterButton.setText("Cadastrar Novos Gêneros");
        genreRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreRegisterButtonActionPerformed(evt);
            }
        });

        rateBookButton.setText("Avaliar Livro");
        rateBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateBookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(adminSeeBooksButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminDeleteBookButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminFinOneBookButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminEditBookButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminRegisterBookButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(genreRegisterButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rateBookButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 344,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(17, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(adminRegisterBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adminEditBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adminFinOneBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adminDeleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adminSeeBooksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(genreRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rateBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genreRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genreRegisterButtonActionPerformed
        this.dispose();
        GenreRegister gr = new GenreRegister();
        gr.setVisible(true);
    }// GEN-LAST:event_genreRegisterButtonActionPerformed

    private void rateBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rateBookButtonActionPerformed
        this.dispose();
        AdminRateBook arb = new AdminRateBook();
        arb.setVisible(true);
    }// GEN-LAST:event_rateBookButtonActionPerformed

    private void adminRegisterBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_adminRegisterBookButtonActionPerformed
        this.dispose();
        BookRegister br = new BookRegister();
        br.setVisible(true);
    }// GEN-LAST:event_adminRegisterBookButtonActionPerformed

    private void adminEditBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_adminEditBookButtonActionPerformed
        BookEdit be = new BookEdit();
        this.dispose();
        be.setVisible(true);
    }// GEN-LAST:event_adminEditBookButtonActionPerformed

    private void adminFindOneBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_adminFinOneBookButtonActionPerformed
        this.dispose();
        AdminFindBook afb = new AdminFindBook();
        afb.setVisible(true);
    }// GEN-LAST:event_adminFinOneBookButtonActionPerformed

    private void adminDeleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_adminDeleteBookButtonActionPerformed
        AdminBookDelete bd = new AdminBookDelete();
        this.dispose();
        bd.setVisible(true);
    }// GEN-LAST:event_adminDeleteBookButtonActionPerformed

    private void adminSeeBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_adminSeeBooksButtonActionPerformed
        BookDAO books = new BookDAO();
        RateDAO rates = new RateDAO();

        String message = "";
        try {
            for (Book book : books.getBooks()) {
                int bookId = book.getId();
                String bookTitle = book.getTitle();
                String bookAuthor = book.getAuthor();
                int bookGenre = book.getGenre();
                int ratins = rates.countRatings(bookId);
                // Get all the ratings for the book
                // Get the sum of the ratings
                // Get the average of the ratings

                message += "ID: " + bookId + "\n";
                message += "Título: " + bookTitle + "\n";
                message += "Autor: " + bookAuthor + "\n";
                message += "Gênero: " + bookGenre + "\n";
                message += "Avaliações: " + ratins + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// GEN-LAST:event_adminSeeBooksButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnButtonActionPerformed
        this.dispose();
        AdminDashboardScreen ads = new AdminDashboardScreen();
        ads.setVisible(true);
    }// GEN-LAST:event_returnButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminBookManager.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminBookManager.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminBookManager.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminBookManager.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminBookManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminDeleteBookButton;
    private javax.swing.JButton adminEditBookButton;
    private javax.swing.JButton adminFinOneBookButton;
    private javax.swing.JButton adminRegisterBookButton;
    private javax.swing.JButton adminSeeBooksButton;
    private javax.swing.JButton genreRegisterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rateBookButton;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
