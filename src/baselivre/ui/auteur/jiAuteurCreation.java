
package baselivre.ui.auteur;

import baselivre.produit.Auteur;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cdi116
 */
public class jiAuteurCreation extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private InterfaceRoot ir;
    
    public jiAuteurCreation(InterfaceRoot ir) {
        this.sqlConnexion = ir.SqlConnexion();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfPrenomAuteur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNomAuteur = new javax.swing.JTextField();
        jtfDateN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDateD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtBiographie = new javax.swing.JTextArea();
        jbCreation = new javax.swing.JButton();
        jbAnnuler = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Auteur Creation");
        getContentPane().setLayout(null);

        jLabel1.setText("prenom");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 70, 70, 30);
        getContentPane().add(jtfPrenomAuteur);
        jtfPrenomAuteur.setBounds(120, 70, 260, 30);

        jLabel2.setText("Nom");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 20, 70, 30);
        getContentPane().add(jtfNomAuteur);
        jtfNomAuteur.setBounds(120, 20, 260, 30);
        getContentPane().add(jtfDateN);
        jtfDateN.setBounds(120, 120, 260, 30);

        jLabel3.setText("Date de Naissance");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 120, 130, 30);
        getContentPane().add(jtfDateD);
        jtfDateD.setBounds(120, 170, 260, 30);

        jLabel4.setText("Biographie");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 270, 70, 30);

        jLabel5.setText("Date de Deces");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 170, 130, 30);

        jtBiographie.setColumns(20);
        jtBiographie.setRows(5);
        jScrollPane1.setViewportView(jtBiographie);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 270, 260, 96);

        jbCreation.setText("Creation Auteur");
        jbCreation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreationActionPerformed(evt);
            }
        });
        getContentPane().add(jbCreation);
        jbCreation.setBounds(60, 390, 110, 23);

        jbAnnuler.setText("Annuler");
        jbAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnnulerActionPerformed(evt);
            }
        });
        getContentPane().add(jbAnnuler);
        jbAnnuler.setBounds(210, 390, 120, 23);

        jLabel6.setText("Date au Format AAAA-mm-jj");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 210, 170, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 110, 400, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 250, 400, 10);

        setBounds(0, 0, 412, 478);
    }// </editor-fold>//GEN-END:initComponents

    private void jbAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbAnnulerActionPerformed

    private void jbCreationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreationActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Driver non trouvé " + ex.getMessage());
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur de connexion a la base" + ex.getMessage());
        }
        Statement stmt = null;
        try {
            stmt = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur Compte Utilisateur" + ex.getMessage());
        }
        
        
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("Select * FROM auteur WHERE auteur_nom = '"+jtfNomAuteur.getText()+"'"
                    + " AND auteur_prenom = '"+jtfPrenomAuteur.getText()+"' AND auteur_date_naissance = '"+jtfDateD.getText()+"'");
            rs.last();
            int ligne = rs.getRow();
            
            if (ligne == 0) {
                
                stmt.executeUpdate("INSERT INTO auteur(auteur_nom,auteur_prenom,auteur_date_naissance,"
                        + "auteur_date_deces, auteur_bio,auteur_actif) VALUES  ('" + jtfNomAuteur.getText() + "',"
                        + "'" + jtfPrenomAuteur.getText() + "','" + jtfDateD.getText() + "','" + jtfDateD.getText() + "',"
                        + "'" + jtBiographie.getText() + "',1)");
                this.dispose();
            }else{
                
                JOptionPane.showMessageDialog(this,"cet auteur existe deja !");
                int idauteur = rs.getInt("id_auteur");
                rs = stmt.executeQuery("SELECT * from auteur WHERE id_auteur = "+idauteur);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                Auteur auteurexport = new Auteur(rs.getString("auteur_nom"), rs.getString("auteur_prenom"),sdf.parse(rs.getString("auteur_date_naissance")));
                auteurexport.setBioAuteur(rs.getString("auteur_bio"));
                auteurexport.setDateDAuteur(rs.getDate("auteur_date_deces"));
                
                jiAuteurModification AuteurModif = new jiAuteurModification(ir, auteurexport.getIdAuteur());
                this.dispose();
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur saisie " + ex.getMessage());
        
                } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "erreur conversion date "+ex.getMessage());
        }
            
            
        try {
            rs.close();
            stmt.close();
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur base de donnees"+ex.getMessage());
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur base de donnees"+ex.getMessage());
        }
        
            
        
    }//GEN-LAST:event_jbCreationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbAnnuler;
    private javax.swing.JButton jbCreation;
    private javax.swing.JTextArea jtBiographie;
    private javax.swing.JTextField jtfDateD;
    private javax.swing.JTextField jtfDateN;
    private javax.swing.JTextField jtfNomAuteur;
    private javax.swing.JTextField jtfPrenomAuteur;
    // End of variables declaration//GEN-END:variables
}
