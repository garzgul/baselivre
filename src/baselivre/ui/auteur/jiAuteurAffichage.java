
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.DateStringConverter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cdi116
 */
public class jiAuteurAffichage extends javax.swing.JInternalFrame {

    private Auteur auteur;
    private String sqlConnexion;
//    private Vector listeNomAuteur;
    private Vector titres;
    private Vector table;
    private int auteurId;
    private InterfaceRoot ir;
    
    public jiAuteurAffichage(InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        this.titres = new Vector();
//        this.listeNomAuteur = new Vector();
        initComponents();
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNomAuteur = new javax.swing.JLabel();
        jtfNomAuteur = new javax.swing.JTextField();
        jbRecherche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtlListeAuteur = new javax.swing.JTable();
        jBCreationAuteur = new javax.swing.JButton();
        jBModificationAuteur = new javax.swing.JButton();
        jBSupprimerAuteur = new javax.swing.JButton();

        setClosable(true);
        setTitle("Liste Auteur");
        getContentPane().setLayout(null);

        jlNomAuteur.setText("Nom");
        getContentPane().add(jlNomAuteur);
        jlNomAuteur.setBounds(80, 10, 70, 30);
        getContentPane().add(jtfNomAuteur);
        jtfNomAuteur.setBounds(170, 10, 230, 30);

        jbRecherche.setText("Recherche");
        jbRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRechercheActionPerformed(evt);
            }
        });
        getContentPane().add(jbRecherche);
        jbRecherche.setBounds(190, 50, 120, 23);

        jtlListeAuteur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Date de naissance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtlListeAuteur.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtlListeAuteur);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 452, 402);

        jBCreationAuteur.setText("Creer");
        jBCreationAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreationAuteurActionPerformed(evt);
            }
        });
        getContentPane().add(jBCreationAuteur);
        jBCreationAuteur.setBounds(30, 500, 80, 23);

        jBModificationAuteur.setText("Modifier");
        jBModificationAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificationAuteurActionPerformed(evt);
            }
        });
        getContentPane().add(jBModificationAuteur);
        jBModificationAuteur.setBounds(210, 500, 80, 23);

        jBSupprimerAuteur.setText("Supprimer");
        jBSupprimerAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSupprimerAuteurActionPerformed(evt);
            }
        });
        getContentPane().add(jBSupprimerAuteur);
        jBSupprimerAuteur.setBounds(380, 500, 80, 23);

        setBounds(0, 0, 522, 572);
    }// </editor-fold>//GEN-END:initComponents

    private void jbRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRechercheActionPerformed
        
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
        try {
            String auteurNom = "";
            Vector tables = new Vector();
            if (jtfNomAuteur.getText().equals("")){
                rs = stmt.executeQuery("SELECT * from auteur where auteur_actif = 1");
            }else{
                auteurNom = jtfNomAuteur.getText();
                rs = stmt.executeQuery("SELECT * FROM auteur where auteur_actif = 1 AND auteur_nom LIKE '%" + auteurNom + "%' ORDER BY auteur_nom");
            }
            
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            

            while (rs.next()) {
                Vector listeNomAuteur = new Vector();
                Auteur auteur = new Auteur (rs.getString("auteur_nom"), rs.getString("auteur_prenom"),
                        sdf.parse(rs.getString("auteur_date_naissance")));
//                if (rs.getString("auteur_date_deces").equals("")){
//                }else{
//                    auteur.setDateDAuteur(sdf.parse(rs.getString("auteur_date_deces")));
//                }

                listeNomAuteur.add(auteur.getNomAuteur());
                listeNomAuteur.add(auteur.getPrenomAuteur());
                listeNomAuteur.add(sdf.format(auteur.getDateNAuteur()));
                tables.add(listeNomAuteur);
            }
            Vector titre = new Vector();
            titre.add("Nom");
            titre.add("prenom");
            titre.add("Date de naissance");
//            titres.add("Date de deces");
            DefaultTableModel tm = new DefaultTableModel(tables, titre) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jtlListeAuteur.setModel(tm);
   
            


        
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
        
        
    }//GEN-LAST:event_jbRechercheActionPerformed
    
    /**Fonction appelant la fenetre de creation d'auteur
     * 
     * @param evt 
     */
    private void jBCreationAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreationAuteurActionPerformed
        jiAuteurCreation jiAuteurCrea = new jiAuteurCreation(ir);
        ir.getmainFrame().add(jiAuteurCrea);
        jiAuteurCrea.setVisible(true);
        jiAuteurCrea.toFront();
        
    }//GEN-LAST:event_jBCreationAuteurActionPerformed
    
    /**Fonction appelant la fenetre de modification de l'entrée auteur
     * Necessite qu'une entrée soit selectionée dans la jTable
     * @param evt 
     */
    
    private void jBSupprimerAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSupprimerAuteurActionPerformed
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
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur Compte Utilisateur" + ex.getMessage());
        }
         ResultSet rs = null;
        try {
            if(jtlListeAuteur.getSelectedRow()!= -1){
            int tableIndex = jtlListeAuteur.getSelectedRow(); 
            rs = stmt.executeQuery("SELECT * FROM auteur where auteur_actif = 1 "
                    + "AND auteur_nom = '" + ((jtlListeAuteur.getValueAt(tableIndex,0)))+ "'");
            while (rs.next()){
            auteurId = rs.getInt("id_auteur");
            }
            
            if(JOptionPane.showConfirmDialog(this,"Souhaitez vous vraiment supprimer cet auteur ?" , "Confirmation suppression",
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                stmt.executeUpdate("UPDATE auteur set auteur_actif = 0 WHERE id_auteur = '"+auteurId+"'");
            }
            
            
            
            }else{
                JOptionPane.showMessageDialog(this,"Aucun auteur selectioné");
            }
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur base de donnees " +ex.getMessage());
        }
        
    }//GEN-LAST:event_jBSupprimerAuteurActionPerformed

    private void jBModificationAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificationAuteurActionPerformed
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
            stmt = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur Compte Utilisateur" + ex.getMessage());
        }
         ResultSet rs = null;
         
        
        try {
            if(jtlListeAuteur.getSelectedRow()!= -1){
                int tableIndex = jtlListeAuteur.getSelectedRow();
                rs = stmt.executeQuery("SELECT * FROM auteur where auteur_actif = 1 "
                        + "AND auteur_nom LIKE '" + jtlListeAuteur.getValueAt(tableIndex, 0).toString() + "'");
                while(rs.next()){
                auteurId = rs.getInt("id_auteur");
                }
                // connexion a la frame de modification
                jiAuteurModification modif = new jiAuteurModification(ir, auteurId);
                ir.getmainFrame().add(modif);
                modif.setVisible(true);
                modif.toFront();


            } else {
                JOptionPane.showMessageDialog(this,"Aucun auteur selectioné");
            }
            rs.close();
            stmt.close();
            connexion.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur base de donnees"+ex.getMessage());
        }
    }//GEN-LAST:event_jBModificationAuteurActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCreationAuteur;
    private javax.swing.JButton jBModificationAuteur;
    private javax.swing.JButton jBSupprimerAuteur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbRecherche;
    private javax.swing.JLabel jlNomAuteur;
    private javax.swing.JTextField jtfNomAuteur;
    private javax.swing.JTable jtlListeAuteur;
    // End of variables declaration//GEN-END:variables
}
