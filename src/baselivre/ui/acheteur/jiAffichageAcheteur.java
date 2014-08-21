
package baselivre.ui.acheteur;

import baselivre.ui.frame.InterfaceRoot;
import baselivre.user.Acheteur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class jiAffichageAcheteur extends javax.swing.JInternalFrame {
    private InterfaceRoot ir;
    private String sqlConnexion;
    private Vector table;
    private Vector titres;
    private Vector listeAcheteur;
    
    
    private DefaultTableModel initTable() {
    DefaultTableModel tm = new DefaultTableModel(table, titres)
    {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        return tm;
        
     }

    /**
     * Creates new form AffichageAcheteur
     * @param ir InterfaceRoot
     */
    public jiAffichageAcheteur(InterfaceRoot ir) {
        this.ir = ir;
        sqlConnexion = ir.SqlConnexion();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNomAcheteur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfPrenomAcheteur = new javax.swing.JTextField();
        jBRechercheAcheteurNom = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfPseudoAcheteur = new javax.swing.JTextField();
        jBRechercheAcheteurPseudo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("Nom");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 40, 60, 20);

        jtfNomAcheteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomAcheteurActionPerformed(evt);
            }
        });
        jPanel1.add(jtfNomAcheteur);
        jtfNomAcheteur.setBounds(60, 40, 110, 20);

        jLabel2.setText("Prenom");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(240, 40, 60, 20);

        jtfPrenomAcheteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrenomAcheteurActionPerformed(evt);
            }
        });
        jPanel1.add(jtfPrenomAcheteur);
        jtfPrenomAcheteur.setBounds(290, 40, 110, 20);

        jBRechercheAcheteurNom.setText("Recherche");
        jBRechercheAcheteurNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheAcheteurNomActionPerformed(evt);
            }
        });
        jPanel1.add(jBRechercheAcheteurNom);
        jBRechercheAcheteurNom.setBounds(520, 40, 120, 23);

        jTabbedPane1.addTab("recherche par nom", jPanel1);

        jPanel2.setLayout(null);

        jLabel3.setText("pseudo");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(220, 40, 60, 20);

        jtfPseudoAcheteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPseudoAcheteurActionPerformed(evt);
            }
        });
        jPanel2.add(jtfPseudoAcheteur);
        jtfPseudoAcheteur.setBounds(270, 40, 110, 20);

        jBRechercheAcheteurPseudo.setText("Recherche");
        jBRechercheAcheteurPseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheAcheteurPseudoActionPerformed(evt);
            }
        });
        jPanel2.add(jBRechercheAcheteurPseudo);
        jBRechercheAcheteurPseudo.setBounds(520, 40, 120, 23);

        jTabbedPane1.addTab("recherche par pseudo", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(40, 30, 690, 130);

        jTable1.setModel(initTable());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 170, 690, 400);

        jButton1.setText("Supprimer Acheteur");
        getContentPane().add(jButton1);
        jButton1.setBounds(510, 600, 130, 23);

        jButton2.setText("Modifier Acheteur");
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 600, 130, 23);

        jButton3.setText("Creer Acheteur");
        getContentPane().add(jButton3);
        jButton3.setBounds(90, 600, 130, 23);

        setBounds(0, 0, 814, 724);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNomAcheteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomAcheteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomAcheteurActionPerformed

    private void jtfPrenomAcheteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrenomAcheteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrenomAcheteurActionPerformed

    private void jtfPseudoAcheteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPseudoAcheteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPseudoAcheteurActionPerformed
    // recherche des acheteurs par nom/prenom et affichage dans la jTable.
    private void jBRechercheAcheteurNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheAcheteurNomActionPerformed
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
        ResultSet rs = null;
        
        try {
            if (jtfNomAcheteur.getText() != "") {
                if (jtfPrenomAcheteur.getText() != "") {
                    rs = stmt.executeQuery("Select * FROM acheteur WHERE acheteur_nom LIKE '%" + jtfNomAcheteur.getText() + "%' AND acheteur_prenom "
                            + "LIKE '%" + jtfPrenomAcheteur.getText() + "%' and achteur_actif = 1");
                } else {
                    rs = stmt.executeQuery("Select * from acheteur where acheteur_nom LIKE '%" + jtfNomAcheteur.getText() + "%' AND acheteur_actif = 1");
                }
                rs = stmt.executeQuery("select * from acheteur where acheteur_actif = 1");
            }
            while (rs.next()){
                Acheteur acheteur = new Acheteur(rs.getString("acheteur_nom"),rs.getString("acheteur_prenom"),rs.getString("acheteur_pseudo"));
                listeAcheteur.add(acheteur);
                table.add(listeAcheteur);
                
            }
            titres.add("nom");
            titres.add("prenom");
            titres.add("pseudo");
            
            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);
            
            rs.close();
            stmt.close();
            connexion.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur base de données "+ ex.getMessage());
        }
    }//GEN-LAST:event_jBRechercheAcheteurNomActionPerformed
    // recherche des acheteurs par pseudo et remplissage de la jTable
    private void jBRechercheAcheteurPseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheAcheteurPseudoActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver non trouvé " + ex.getMessage());

        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de connexion a la base" + ex.getMessage());

        }
        Statement stmt = null;
        try {
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur" + ex.getMessage());
        }
        ResultSet rs = null;
        
        
        
        try {
            if (jtfPseudoAcheteur.getText() !=""){
                rs = stmt.executeQuery("Select * from acheteur where acheteur_pseudo = '"+jtfPseudoAcheteur.getText()+"' AND acheteur_actif = 1");
            }else{
                rs =stmt.executeQuery("Select * from acheteur where acheteur_actif = 1");
            }
            while (rs.next()){
                Acheteur acheteur = new Acheteur(rs.getString("acheteur_nom"),rs.getString("acheteur_prenom"),rs.getString("acheteur_pseudo"));
                listeAcheteur.add(acheteur);
                table.add(listeAcheteur);
                
            }
            titres.add("nom");
            titres.add("prenom");
            titres.add("pseudo");
            
            rs.close();
            stmt.close();
            connexion.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur base de données "+ ex.getMessage());
        }
    }//GEN-LAST:event_jBRechercheAcheteurPseudoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRechercheAcheteurNom;
    private javax.swing.JButton jBRechercheAcheteurPseudo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfNomAcheteur;
    private javax.swing.JTextField jtfPrenomAcheteur;
    private javax.swing.JTextField jtfPseudoAcheteur;
    // End of variables declaration//GEN-END:variables
}
