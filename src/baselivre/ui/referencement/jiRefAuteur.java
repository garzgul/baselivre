
package baselivre.ui.referencement;

import baselivre.produit.Auteur;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cdi116
 */
public class jiRefAuteur extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private Vector listeNomAuteur;
    private Vector titres;
    private Vector table;
    private int auteurId;
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
    
    
    public jiRefAuteur(InterfaceRoot ir) {
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
        jLabel2 = new javax.swing.JLabel();
        jtfAuteurDateN = new javax.swing.JTextField();
        jtfAuteurNom = new javax.swing.JTextField();
        jBQuitter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfAuteurPrenom = new javax.swing.JTextField();
        jBRecherche = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Refrencement Auteur");
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

        jLabel1.setText("Prenom");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 50, 30);

        jLabel2.setText("Date de Naissance");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 70, 100, 30);
        getContentPane().add(jtfAuteurDateN);
        jtfAuteurDateN.setBounds(220, 70, 120, 30);
        getContentPane().add(jtfAuteurNom);
        jtfAuteurNom.setBounds(80, 30, 120, 30);

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
        jLabel4.setBounds(20, 20, 50, 30);
        getContentPane().add(jtfAuteurPrenom);
        jtfAuteurPrenom.setBounds(310, 30, 120, 30);

        jBRecherche.setText("Recherche");
        jBRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheActionPerformed(evt);
            }
        });
        getContentPane().add(jBRecherche);
        jBRecherche.setBounds(460, 70, 100, 23);

        jLabel3.setText("(Obligatoire)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 50, 60, 14);

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
        listeNomAuteur = new Vector();
        try {
            if (!jtfAuteurPrenom.getText().equals("")){
                if (!jtfAuteurDateN.getText().equals("")){
                    rs = stmt.executeQuery("SELECT * FROM auteur WHERE"
                       + " auteur_nom LIKE '%" + jtfAuteurNom.getText() + "%' AND auteur_prenom LIKE '%"+jtfAuteurPrenom.getText()+""
                            + "%' AND auteur_date_naissance LIKE '%"+jtfAuteurDateN.getText()+"%' ORDER BY auteur_nom");
                }else{
                    rs = stmt.executeQuery("SELECT * FROM auteur WHERE"
                       + " auteur_nom LIKE '%" + jtfAuteurNom.getText() + "%' AND auteur_prenom LIKE '%"+jtfAuteurPrenom.getText()+""
                            + "%' ORDER BY auteur_nom");
                }
            }else{
               rs = stmt.executeQuery("SELECT * FROM auteur WHERE"
                       + " auteur_nom LIKE '%" + jtfAuteurNom.getText() + "%' ORDER BY auteur_nom"); 
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Auteur auteur = null;
            table = new Vector();
            titres= new Vector();

            while (rs.next()) {
                listeNomAuteur = new Vector();
                auteur = new Auteur (rs.getString("auteur_nom"), rs.getString("auteur_prenom"),
                        sdf.parse(rs.getString("auteur_date_naissance")));
                
                listeNomAuteur.add(auteur);
                listeNomAuteur.add(auteur.getPrenomAuteur());
                listeNomAuteur.add(auteur.getDateNAuteur());
                
                table.add(listeNomAuteur);
                
                

            }
            titres = new Vector();
            titres.add("Nom");
            titres.add("prenom");
            titres.add("Date de naissance");
            
            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);

        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur saisie "+ex.getMessage());
        } catch (ParseException ex) {
            JOptionPane jOErreur = new JOptionPane("Erreur de conversion de date" + ex.getMessage());
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
        Auteur auteur = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM-dd");
                    
            for (int l = 0; l < jTable1.getRowCount(); l++) {
                if (jTable1.isRowSelected(l)) {
                    auteur.setNomAuteur(jTable1.getValueAt(l, 1).toString());
                    auteur.setPrenomAuteur(jTable1.getValueAt(l, 2).toString());
                    auteur.setDateNAuteur(sdf.parse(jTable1.getValueAt(l, 3).toString()));
                }
            }
                rs = stmt.executeQuery("SELECT * FROM auteur WHERE"
                       + " auteur_nom = '" + auteur.getNomAuteur() + "' AND auteur_prenom = '"+auteur.getPrenomAuteur()+""
                            + "' AND auteur_date_naissance = '"+sdf.format(auteur.getDateNAuteur())+"' ORDER BY auteur_nom");
                while (rs.next()) {
                    auteurId = rs.getInt("id_auteur");
                }
                stmt.executeUpdate("UPDATE auteur set auteur_actif = 1 WHERE id_auteur = "+auteurId);
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur saisie "+ex.getMessage());
        } catch (ParseException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur Date "+ex.getMessage());
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
        Auteur auteur = null;
        try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM-dd");
                    
            for (int l = 0; l < jTable1.getRowCount(); l++) {
                if (jTable1.isRowSelected(l)) {
                    auteur.setNomAuteur(jTable1.getValueAt(l, 1).toString());
                    auteur.setPrenomAuteur(jTable1.getValueAt(l, 2).toString());
                    auteur.setDateNAuteur(sdf.parse(jTable1.getValueAt(l, 3).toString()));
                }
        }
                rs = stmt.executeQuery("SELECT * FROM auteur WHERE"
                       + " auteur_nom = '" + auteur.getNomAuteur() + "' AND auteur_prenom = '"+auteur.getPrenomAuteur()+""
                            + "' AND auteur_date_naissance = '"+sdf.format(auteur.getDateNAuteur())+"' ORDER BY auteur_nom");
                auteurId = rs.getInt("id_auteur");
                
                stmt.executeUpdate("UPDATE auteur set auteur_actif = 0 WHERE id_auteur = "+auteurId);
        } catch (SQLException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur saisie "+ex.getMessage());
        } catch (ParseException ex) {
            JOptionPane joErreur = new JOptionPane("Erreur Date "+ex.getMessage());
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfAuteurDateN;
    private javax.swing.JTextField jtfAuteurNom;
    private javax.swing.JTextField jtfAuteurPrenom;
    // End of variables declaration//GEN-END:variables
}
