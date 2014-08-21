package baselivre.ui.editeur;


import baselivre.produit.Editeur;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author cdi107
 */
public class jiEditeurAffichage extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private InterfaceRoot ir;
    private int idEditexport;

    /**
     * Creates new form jiEditeurAffichage
     * @param ir InterfaceRoot
     */
    public jiEditeurAffichage(InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        initComponents();
        jEditeurCombobox.setSelectedIndex(-1);
        
    }

    private ComboBoxModel modelbaselivre() {
        return new DefaultComboBoxModel(initbaselivre());
    }

    private Vector initbaselivre() {
        Vector ed = new Vector();
        

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane jErreur = new JOptionPane(" Driver non trouvé : " + ex.getMessage());
        }
        
        
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane jErreur = new JOptionPane("Erreur connexion Base de donnees"
                    + ex.getMessage());
            
        }
        
        ResultSet rs = null;
        try {
            
            Statement stmt = connexion.createStatement();
            String sql = "SELECT * FROM editeur WHERE editeur_actif = 1 ORDER BY editeur_nom;";

            rs = stmt.executeQuery(sql);
            

            while (rs.next()) {
                Editeur editeur = new Editeur(rs.getString("editeur_nom"), rs.getString("editeur_pays"), true);
                editeur.setId_editeur(rs.getInt("id_editeur"));
                ed.add(editeur);
            }
            
            rs.close();
            stmt.close();
            connexion.close();
            return ed;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur Base de données");
            return null;
        }

    }

    private static class jEditeurCombobox {

        private static void setSelectedIndex(int i) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public jEditeurCombobox() {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jEditeurCombobox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        creaEditeur = new javax.swing.JButton();
        modifEditeur = new javax.swing.JButton();
        supprimEditeur = new javax.swing.JButton();
        jQuitterEditeur = new javax.swing.JButton();

        setClosable(true);
        setTitle("Affichage Editeur");
        getContentPane().setLayout(null);

        jEditeurCombobox.setModel(modelbaselivre());
        jEditeurCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditeurCombobox(evt);
            }
        });
        getContentPane().add(jEditeurCombobox);
        jEditeurCombobox.setBounds(210, 60, 140, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Editeur");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 50, 100, 40);

        creaEditeur.setText("Creer");
        creaEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(creaEditeur);
        creaEditeur.setBounds(50, 190, 90, 40);

        modifEditeur.setText("Modifier");
        modifEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(modifEditeur);
        modifEditeur.setBounds(210, 190, 120, 40);

        supprimEditeur.setText("Supprimer");
        supprimEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(supprimEditeur);
        supprimEditeur.setBounds(370, 190, 130, 40);

        jQuitterEditeur.setText("Quitter");
        jQuitterEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuitterEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(jQuitterEditeur);
        jQuitterEditeur.setBounds(210, 260, 67, 23);

        getAccessibleContext().setAccessibleDescription("");

        setBounds(0, 0, 574, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void creaEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaEditeurActionPerformed
        // insert jEditeurCreation
        jiEditeurCreation newEditeur = new jiEditeurCreation(ir);
        ir.getmainFrame().add(newEditeur);
        newEditeur.setVisible(true);
        newEditeur.toFront();
        // this.setVisible(false);
        
    }//GEN-LAST:event_creaEditeurActionPerformed

    private void supprimEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimEditeurActionPerformed
        Editeur editeur = (Editeur) jEditeurCombobox.getSelectedItem();
        idEditexport= editeur.getId_editeur();
        jiEditeurSuppession editeurSup = new jiEditeurSuppession(idEditexport, ir);
        ir.getmainFrame().add(editeurSup);
        editeurSup.setVisible(true);
        editeurSup.toFront();
        //this.setVisible(false);
    }//GEN-LAST:event_supprimEditeurActionPerformed

    private void jEditeurCombobox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditeurCombobox
        // TODO add your handling code here:
    }//GEN-LAST:event_jEditeurCombobox

    private void modifEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifEditeurActionPerformed
        Editeur editeur = (Editeur) jEditeurCombobox.getSelectedItem();
        idEditexport= editeur.getId_editeur();
        jiEditeurModification editeurModif = new jiEditeurModification(idEditexport, ir);
        ir.getmainFrame().add(editeurModif);
        editeurModif.setVisible(true);
        editeurModif.toFront();
        //this.setVisible(false);
                
        
                
    }//GEN-LAST:event_modifEditeurActionPerformed

    private void jQuitterEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuitterEditeurActionPerformed
        this.dispose();
    }//GEN-LAST:event_jQuitterEditeurActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creaEditeur;
    private javax.swing.JComboBox jEditeurCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jQuitterEditeur;
    private javax.swing.JButton modifEditeur;
    private javax.swing.JButton supprimEditeur;
    // End of variables declaration//GEN-END:variables
}
