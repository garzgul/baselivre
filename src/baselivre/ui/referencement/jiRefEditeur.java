
package baselivre.ui.referencement;

import baselivre.produit.Auteur;
import baselivre.produit.Editeur;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cdi116
 */
public class jiRefEditeur extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private Vector listeNomEditeur;
    private Vector titres;
    private Vector table;
    private int editeurId;
    private InterfaceRoot ir;
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
    
    
    public jiRefEditeur(InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBRef = new javax.swing.JButton();
        jBDeref = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfEditeurNom = new javax.swing.JTextField();
        jBQuitter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfEditeurPays = new javax.swing.JTextField();
        jBRecherche = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Refrencement Editeur");
        getContentPane().setLayout(null);

        jBRef.setText("Referencer");
        jBRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRefActionPerformed(evt);
            }
        });
        getContentPane().add(jBRef);
        jBRef.setBounds(583, 320, 100, 23);

        jBDeref.setText("Dereferencer");
        jBDeref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDerefActionPerformed(evt);
            }
        });
        getContentPane().add(jBDeref);
        jBDeref.setBounds(583, 360, 100, 23);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(initTable());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 140, 452, 402);

        jLabel1.setText("Pays");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 50, 30);
        getContentPane().add(jtfEditeurNom);
        jtfEditeurNom.setBounds(80, 30, 120, 30);

        jBQuitter.setText("Quitter");
        jBQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitterActionPerformed(evt);
            }
        });
        getContentPane().add(jBQuitter);
        jBQuitter.setBounds(280, 590, 67, 23);

        jLabel4.setText("Nom");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 30, 50, 30);
        getContentPane().add(jtfEditeurPays);
        jtfEditeurPays.setBounds(310, 30, 120, 30);

        jBRecherche.setText("Recherche");
        jBRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheActionPerformed(evt);
            }
        });
        getContentPane().add(jBRecherche);
        jBRecherche.setBounds(500, 40, 100, 23);

        jLabel3.setText("(Obligatoire)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 60, 90, 14);

        setBounds(0, 0, 722, 657);
    }// </editor-fold>//GEN-END:initComponents

    private void jBQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitterActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBQuitterActionPerformed

    private void jBRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane jOErreur = new JOptionPane("Driver non trouvé " + ex.getMessage());
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur de connexion a la base" + ex.getMessage());
        }
        Statement stmt = null;
        try {
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur Compte Utilisateur");
        }
        ResultSet rs = null;
        listeNomEditeur = null;
        titres = new Vector();
        table = new Vector();
        try {
            if (!jtfEditeurPays.getText().equals("")){
               
                    rs = stmt.executeQuery("SELECT * FROM editeur WHERE"
                       + " editeur_nom LIKE '%" + jtfEditeurNom.getText() + "%' AND editeur_pays LIKE '%"+jtfEditeurPays.getText()+""
                            + "%' ORDER BY editeur_nom");
                
            }else{
               rs = stmt.executeQuery("SELECT * FROM editeur WHERE"
                       + " editeur_nom LIKE '%" + jtfEditeurNom.getText() + "%' ORDER BY editeur_nom"); 
            }
                        
            Editeur editeur = null;

            while (rs.next()) {
                listeNomEditeur = new Vector();
                editeur = new Editeur(rs.getString("editeur_nom"), rs.getString("editeur_pays"), true);
                
                listeNomEditeur.add(editeur.getNomEditeur());
                listeNomEditeur.add(editeur.getPaysEditeur());
                table.add(listeNomEditeur);
                
                

            }
            titres.add("Nom");
            titres.add("Pays");
            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);

        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur saisie "+ex.getMessage());
                }
        
        try {
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("erreur base de donnees" +ex.getMessage());
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("erreur Base de Donness" +ex.getMessage());
        }
        
    }//GEN-LAST:event_jBRechercheActionPerformed

    private void jBRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane jOErreur = new JOptionPane("Driver non trouvé " + ex.getMessage());
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur de connexion a la base" + ex.getMessage());
        }
        Statement stmt = null;
        try {
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur Compte Utilisateur");
        }
        ResultSet rs = null;
        Editeur editeur = null;
        try {
            
            for (int l = 0; l < jTable1.getRowCount(); l++) {
                if (jTable1.isRowSelected(l)) {
                    editeur.setNomEditeur(jTable1.getValueAt(l, 1).toString());
                    editeur.setPaysEditeur(jTable1.getValueAt(l, 2).toString());
                }
            }
                rs = stmt.executeQuery("SELECT * FROM editeur WHERE"
                       + " editeur_nom = '" + jtfEditeurNom.getText() + "' AND editeur_pays = '"+jtfEditeurPays+""
                            + "' ORDER BY editeur_nom");
                while (rs.next()){
                    editeurId = rs.getInt("id_editeur");
                }
                stmt.executeUpdate("UPDATE editeur set editeur_actif = 1 WHERE id_editeur = "+editeurId);
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur saisie "+ex.getMessage());
        }
        
        try {
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("erreur base de donnees" +ex.getMessage());
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("erreur Base de Donness" +ex.getMessage());
        }
    }//GEN-LAST:event_jBRefActionPerformed

    private void jBDerefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDerefActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane jOErreur = new JOptionPane("Driver non trouvé " + ex.getMessage());
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur de connexion a la base" + ex.getMessage());
        }
        Statement stmt = null;
        try {
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur Compte Utilisateur");
        }
        ResultSet rs = null;
        Editeur editeur = null;
        try {
            
            for (int l = 0; l < jTable1.getRowCount(); l++) {
                if (jTable1.isRowSelected(l)) {
                    editeur.setNomEditeur(jTable1.getValueAt(l, 1).toString());
                    editeur.setPaysEditeur(jTable1.getValueAt(l, 2).toString());
                }
            }
                rs = stmt.executeQuery("SELECT * FROM editeur WHERE"
                       + " editeur_nom = '" + jtfEditeurNom.getText() + "' AND editeur_pays = '"+jtfEditeurPays+""
                            + "' ORDER BY editeur_nom");
                while (rs.next()){
                    editeurId = rs.getInt("id_editeur");
                }
                stmt.executeUpdate("UPDATE editeur set editeur_actif = 0 WHERE id_editeur = "+editeurId);
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur saisie "+ex.getMessage());
        }
        
        try {
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("erreur base de donnees" +ex.getMessage());
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("erreur Base de Donness" +ex.getMessage());
        }
    }//GEN-LAST:event_jBDerefActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDeref;
    private javax.swing.JButton jBQuitter;
    private javax.swing.JButton jBRecherche;
    private javax.swing.JButton jBRef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfEditeurNom;
    private javax.swing.JTextField jtfEditeurPays;
    // End of variables declaration//GEN-END:variables
}
