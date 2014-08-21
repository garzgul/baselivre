
package baselivre.ui.acheteur;

import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class jiAcheteur extends javax.swing.JInternalFrame {
    private String sqlConnexion;
    private InterfaceRoot ir;
    

    /**
     * Fiche Acheteur
     * @param ir InterfaceRoot
     */
    public jiAcheteur(InterfaceRoot ir) {
        this.ir = ir;
        sqlConnexion = ir.SqlConnexion();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfPseudo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfMdp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfPrenom = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jBQuitter = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(null);

        jLabel1.setText("pseudo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 130, 100, 30);
        getContentPane().add(jtfPseudo);
        jtfPseudo.setBounds(140, 130, 180, 30);

        jLabel2.setText("Mot de passe");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 190, 100, 30);
        getContentPane().add(jtfMdp);
        jtfMdp.setBounds(140, 190, 180, 30);

        jLabel3.setText("Email @");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 250, 100, 30);
        getContentPane().add(jtfEmail);
        jtfEmail.setBounds(140, 250, 180, 30);

        jLabel4.setText("Telephone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 310, 100, 30);
        getContentPane().add(jtfTel);
        jtfTel.setBounds(140, 310, 180, 30);

        jLabel5.setText("Nom");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 20, 100, 30);
        getContentPane().add(jtfNom);
        jtfNom.setBounds(140, 20, 180, 30);

        jLabel6.setText("Prenom");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 70, 100, 30);
        getContentPane().add(jtfPrenom);
        jtfPrenom.setBounds(140, 70, 180, 30);

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 480, 73, 23);

        jBQuitter.setText("Quitter");
        jBQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitterActionPerformed(evt);
            }
        });
        getContentPane().add(jBQuitter);
        jBQuitter.setBounds(270, 480, 73, 23);

        jLabel7.setText("Obligatoire");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(350, 140, 70, 14);

        jLabel8.setText("Obligatoire");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(350, 200, 70, 14);

        jLabel9.setText("Obligatoire");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(350, 30, 70, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBQuitterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver non trouvé " + ex.getMessage());

        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de connexion a la base " + ex.getMessage());

        }
        Statement stmt = null;
        try {
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur " + ex.getMessage());
        }
        if (jtfNom.getText().equals("") || jtfPseudo.getText().equals("") || jtfMdp.getText().equals("")){
            JOptionPane.showMessageDialog(this, "champs obligatoires non remplis");
        }else{
            try {
                stmt.executeUpdate("INSERT INTO acheteur values()");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "erreur base de données "+ex.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBQuitter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfMdp;
    private javax.swing.JTextField jtfNom;
    private javax.swing.JTextField jtfPrenom;
    private javax.swing.JTextField jtfPseudo;
    private javax.swing.JTextField jtfTel;
    // End of variables declaration//GEN-END:variables
}
