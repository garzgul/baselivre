package baselivre.ui.editeur;


import baselivre.produit.Editeur;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class jiEditeurSuppession extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private int idEdit;
    private Editeur edit;
    private InterfaceRoot ir;
//    private Vector ved;

    public jiEditeurSuppession(int idEdit, InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        this.idEdit = idEdit;
        edit = remplissage(idEdit);
        initComponents();
        
    }

    public jiEditeurSuppession(String tata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBValider = new javax.swing.JButton();
        jtfnomEditeur = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        adresseEditeur = new javax.swing.JLabel();
        jtfadresseEditeur = new javax.swing.JTextField();
        codePostalEditeur = new javax.swing.JLabel();
        jtfcpEditeur = new javax.swing.JTextField();
        villeEditeur = new javax.swing.JLabel();
        jtfvilleEditeur = new javax.swing.JTextField();
        editeurPays = new javax.swing.JLabel();
        jtfpaysEditeur = new javax.swing.JTextField();
        telephoneEditeur = new javax.swing.JLabel();
        jtftelEditeur = new javax.swing.JTextField();
        mailEditeur = new javax.swing.JLabel();
        jtfemailEditeur = new javax.swing.JTextField();

        setResizable(true);
        setTitle("Modification  Editeur");
        setToolTipText("");
        getContentPane().setLayout(null);

        jBValider.setText("Valider");
        jBValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBValiderActionPerformed(evt);
            }
        });
        getContentPane().add(jBValider);
        jBValider.setBounds(400, 170, 80, 23);

        jtfnomEditeur.setEditable(false);
        jtfnomEditeur.setText(edit.getNomEditeur());
        jtfnomEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfnomEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(jtfnomEditeur);
        jtfnomEditeur.setBounds(110, 10, 170, 30);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(400, 220, 73, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nom");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 70, 15);

        adresseEditeur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adresseEditeur.setText("Adresse");
        adresseEditeur.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(adresseEditeur);
        adresseEditeur.setBounds(20, 60, 70, 20);

        jtfadresseEditeur.setEditable(false);
        jtfadresseEditeur.setText(edit.getAdresseEditeur());
        jtfadresseEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfadresseEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(jtfadresseEditeur);
        jtfadresseEditeur.setBounds(110, 50, 170, 30);

        codePostalEditeur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codePostalEditeur.setText("Code Postal");
        getContentPane().add(codePostalEditeur);
        codePostalEditeur.setBounds(20, 100, 70, 15);

        jtfcpEditeur.setEditable(false);
        jtfcpEditeur.setText(edit.getCpEditeur());
        getContentPane().add(jtfcpEditeur);
        jtfcpEditeur.setBounds(110, 90, 170, 30);

        villeEditeur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        villeEditeur.setText("Ville");
        getContentPane().add(villeEditeur);
        villeEditeur.setBounds(20, 140, 50, 15);

        jtfvilleEditeur.setEditable(false);
        jtfvilleEditeur.setText(edit.getVilleEditeur());
        jtfvilleEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfvilleEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(jtfvilleEditeur);
        jtfvilleEditeur.setBounds(110, 130, 170, 30);

        editeurPays.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editeurPays.setText("Pays");
        getContentPane().add(editeurPays);
        editeurPays.setBounds(20, 180, 50, 15);

        jtfpaysEditeur.setEditable(false);
        jtfpaysEditeur.setText(edit.getPaysEditeur());
        getContentPane().add(jtfpaysEditeur);
        jtfpaysEditeur.setBounds(110, 170, 170, 30);

        telephoneEditeur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telephoneEditeur.setText("Telephone");
        getContentPane().add(telephoneEditeur);
        telephoneEditeur.setBounds(300, 30, 90, 30);

        jtftelEditeur.setEditable(false);
        jtftelEditeur.setText(edit.getTelEditeur());
        getContentPane().add(jtftelEditeur);
        jtftelEditeur.setBounds(380, 30, 150, 30);

        mailEditeur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mailEditeur.setText("  e_mail @ :");
        getContentPane().add(mailEditeur);
        mailEditeur.setBounds(300, 70, 100, 30);

        jtfemailEditeur.setEditable(false);
        jtfemailEditeur.setText(edit.getEmailEditeur());
        jtfemailEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfemailEditeurActionPerformed(evt);
            }
        });
        getContentPane().add(jtfemailEditeur);
        jtfemailEditeur.setBounds(380, 70, 150, 30);

        getAccessibleContext().setAccessibleName("EDITEUR modification");

        setSize(new java.awt.Dimension(597, 286));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfnomEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnomEditeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfnomEditeurActionPerformed

    private void jtfadresseEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfadresseEditeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfadresseEditeurActionPerformed

    private void jtfvilleEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfvilleEditeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfvilleEditeurActionPerformed

    /**
     * Suppression d'un "Editeur" dans la base SQL "baselivre" Connexion a la
     * base, recolte des attributs de l' entree,  mise a 0 de l'etat actif
     * Fermeture de la connexion
     *
     * @param evt
     */

    private void jBValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBValiderActionPerformed
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
        try {
            Statement stmt = connexion.createStatement();

            String sql = "UPDATE editeur set editeur_actif= 0 WHERE  id_editeur=" + idEdit;
                      
            if (JOptionPane.showConfirmDialog(this,"Confirmez vous la Suppression de cet Editeur ?")== JOptionPane.OK_OPTION){
                stmt.executeUpdate(sql);
            }
            this.dispose();
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane jErreur = new JOptionPane("Erreur de saisie"
                    + ex.getMessage());
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane jErreur = new JOptionPane("Erreur base de donnees"
                    + ex.getMessage());
        }

    }//GEN-LAST:event_jBValiderActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jtfemailEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfemailEditeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfemailEditeurActionPerformed

    private Editeur remplissage(int idEdit) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, " Driver non trouvé : " + ex.getMessage());
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur connexion Base de donnees"
                    + ex.getMessage());
        }
        ResultSet rs = null;
        Editeur editeur = new Editeur();
        try {
            Statement stmt = connexion.createStatement();
            // recupere le nom saisi ds la champ Nom et verifier qu'il n'existe pas dans les inactifs.
            String query = " SELECT * FROM editeur WHERE id_editeur= "+idEdit;
            rs = stmt.executeQuery(query);
                        
           editeur.setNomEditeur(rs.getString("editeur_nom"));
           editeur.setPaysEditeur(rs.getString("editeur_pays"));
           editeur.setAdresseEditeur(rs.getString("editeur_adresse"));
           editeur.setCpEditeur(rs.getString("editeur_cp"));
           editeur.setVilleEditeur(rs.getString("editeur_ville"));
           editeur.setEmailEditeur(rs.getString("editeur_email"));
           editeur.setTelEditeur(rs.getString("editeur_tel"));
           editeur.setActifEditeur(true);

            rs.close();
            stmt.close();
            connexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de saisie"
                    + ex.getMessage() + ":"
                    + ex.getMessage());
            return null;
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de saisie"
                    + ex.getMessage());
            return null;
        }
        return editeur;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adresseEditeur;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codePostalEditeur;
    private javax.swing.JLabel editeurPays;
    private javax.swing.JButton jBValider;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfadresseEditeur;
    private javax.swing.JTextField jtfcpEditeur;
    private javax.swing.JTextField jtfemailEditeur;
    private javax.swing.JTextField jtfnomEditeur;
    private javax.swing.JTextField jtfpaysEditeur;
    private javax.swing.JTextField jtftelEditeur;
    private javax.swing.JTextField jtfvilleEditeur;
    private javax.swing.JLabel mailEditeur;
    private javax.swing.JLabel telephoneEditeur;
    private javax.swing.JLabel villeEditeur;
    // End of variables declaration//GEN-END:variables
}
