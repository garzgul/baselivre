package baselivre.ui.livre;

import baselivre.produit.SousTheme;
import baselivre.produit.Theme;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

public class AffichageTheme extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private InterfaceRoot ir;
// changer la fonction du sql a l'integration
    public AffichageTheme(InterfaceRoot ir) {
        this.ir = ir;
        sqlConnexion = ir.SqlConnexion();
        initComponents();
    }

    private TreeNode initTree() {
        DefaultMutableTreeNode tmodel = new DefaultMutableTreeNode("Thème");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            return tmodel;
        }

        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !!" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            return tmodel;
        }

        try {
            String query = "SELECT theme.id_theme, theme_nom, id_soustheme, soustheme_nom "
                    + "FROM theme "
                    + "LEFT JOIN  soustheme on theme.id_theme=soustheme.id_theme "
                    + "ORDER BY theme_nom, soustheme_nom ";

            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultMutableTreeNode tnTheme = null;
            DefaultMutableTreeNode tnSousTheme = null;

            String lastTheme = "";
            String lastSousTheme = "";

            while (rs.next()) {
                Theme th = new Theme();
                th.setTheme(rs.getString("theme_nom"));
                th.setId_theme(rs.getInt("id_theme"));

                if (!lastTheme.equalsIgnoreCase(rs.getString("theme_nom"))) {
                    lastTheme = rs.getString("theme_nom");
                    tnTheme = new DefaultMutableTreeNode(th);
                    tmodel.add(tnTheme);
                }
                if (rs.getInt("id_soustheme")!= 0) { 
                    SousTheme sTh = new SousTheme();
                    sTh.setSousTheme(rs.getString("soustheme_nom"));
                    sTh.setIdSousTheme(rs.getInt("id_soustheme"));

                    if (!lastSousTheme.equalsIgnoreCase(rs.getString("soustheme_nom"))) {
                        lastSousTheme = rs.getString("soustheme_nom");
                        tnSousTheme = new DefaultMutableTreeNode(sTh);
                        tnTheme.add(tnSousTheme);
                    }
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur SQL" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            return tmodel;
        }

        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur fermeture" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            return tmodel;
        }


        return tmodel;
    }

    private TreeModel initTreeModel() {
        DefaultTreeModel tm = new DefaultTreeModel(initTree());
        return tm;
    }

    
    //Charger la combobnox Theme parent pour la création d'un nouveau thème et sous thème
    
     private ComboBoxModel initTheme() {
        return new DefaultComboBoxModel(vectorThemes());
    }

    /**
     * Fonction pour recuperer tous les themes de la base de données
     * @return vecteur
     */
    private Vector vectorThemes() {
        Vector v = new Vector();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion" + ex.getMessage());
            return null;
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(
                    sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !" + ex.getMessage());
            return null;
        }

        String query = "SELECT * FROM theme;";

        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                v.add(new Theme(rs.getInt("id_theme"),
                        rs.getString("theme_nom")));
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL !!" + ex.getMessage());
            return null;
        }

        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de fermeture connexion" + ex.getMessage());
            return null;
        }

        return v;
    }
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jbtnCreerTheme = new javax.swing.JButton();
        jbtnModifierTheme = new javax.swing.JButton();
        jbtnQuitter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTheme = new javax.swing.JTree();
        jtfModifTheme = new javax.swing.JTextField();
        jtfNewTheme = new javax.swing.JTextField();
        jrbtTheme = new javax.swing.JRadioButton();
        jrbtSousTheme = new javax.swing.JRadioButton();
        jcbTheme = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Affichage thème"));
        setClosable(true);
        setTitle("Thème");
        getContentPane().setLayout(null);

        jbtnCreerTheme.setText("Créer");
        jbtnCreerTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreerThemeActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCreerTheme);
        jbtnCreerTheme.setBounds(280, 300, 90, 30);

        jbtnModifierTheme.setText("Modifier");
        jbtnModifierTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModifierThemeActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnModifierTheme);
        jbtnModifierTheme.setBounds(490, 50, 90, 30);

        jbtnQuitter.setText("Quitter");
        jbtnQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnQuitterActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnQuitter);
        jbtnQuitter.setBounds(440, 300, 110, 30);

        jtTheme.setModel(initTreeModel());
        jScrollPane1.setViewportView(jtTheme);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 12, 180, 310);
        getContentPane().add(jtfModifTheme);
        jtfModifTheme.setBounds(230, 50, 250, 30);
        getContentPane().add(jtfNewTheme);
        jtfNewTheme.setBounds(240, 160, 320, 30);

        buttonGroup1.add(jrbtTheme);
        jrbtTheme.setText("Thème");
        getContentPane().add(jrbtTheme);
        jrbtTheme.setBounds(240, 200, 80, 23);

        buttonGroup1.add(jrbtSousTheme);
        jrbtSousTheme.setText("Sous thème");
        getContentPane().add(jrbtSousTheme);
        jrbtSousTheme.setBounds(420, 200, 110, 23);

        jcbTheme.setModel(initTheme());
        getContentPane().add(jcbTheme);
        jcbTheme.setBounds(380, 260, 180, 20);

        jLabel1.setText("Modification de l'intitulé du thème ou sous thème :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 20, 340, 20);

        jLabel2.setText("Création d'un nouveau thème ou sous thème :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 134, 320, 20);

        jLabel3.setText("Veuillez selectionner le thème parent :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 230, 220, 20);

        setBounds(0, 0, 606, 452);
    }// </editor-fold>//GEN-END:initComponents

//      Modifier un thème 
    private void jbtnModifierThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModifierThemeActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }

        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !!" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }

        String query = "";
        DefaultMutableTreeNode tn
                = (DefaultMutableTreeNode) jtTheme.getLastSelectedPathComponent();
        
        if (jtTheme.getLastSelectedPathComponent() == null) {
            JOptionPane.showMessageDialog(null, "Vous n'avez rien selectionné !");
        } else if (tn.getUserObject() instanceof Theme) {
            Theme th = (Theme) tn.getUserObject();
            int id_theme = th.getId_theme();
            //jtfModifTheme.setText(th.getTheme());
            String champmodi = jtTheme.getLastSelectedPathComponent().toString();
            String themeModif = jtfModifTheme.getText();

            if (themeModif == "") {
                JOptionPane.showMessageDialog(null, "Veuillez remplir le champ !");
            } else {
                query = "UPDATE theme "
                        + "SET theme_nom = '" + themeModif + "' WHERE id_theme = " + id_theme;
            }

        } else if (tn.getUserObject() instanceof SousTheme) {
            SousTheme sth = (SousTheme) (tn.getUserObject());
            int id_soustheme = sth.getIdSousTheme();
            String champmodi = jtTheme.getLastSelectedPathComponent().toString();
            //jtfModifTheme.setText(sth.getSousTheme());
            String sousThemeModif = jtfModifTheme.getText();

            if (sousThemeModif == "") {
                JOptionPane.showMessageDialog(null, "Veuillez remplir le champ !");
            } else {
                query = "UPDATE soustheme "
                        + "SET soustheme_nom = '" + sousThemeModif + "' WHERE id_soustheme = " + id_soustheme;
            }
        }
        Statement stmt = null;

        try {
           stmt  = connexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur base de données "+ ex.getMessage());
        }
        
        try{
             stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL\n" + ex.getMessage());
        }
         try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur à la fermeture de la connexion" + ex.getMessage());
        }
        jtTheme.setModel(initTreeModel());
        jcbTheme.setModel(initTheme());
        
    }//GEN-LAST:event_jbtnModifierThemeActionPerformed

    /**
     * Création d'un nouveau thème ou sous thème
     * @param evt 
     */
    private void jbtnCreerThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreerThemeActionPerformed
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
        try {
        if (jtfNewTheme.getText()!=""){
            if(jrbtTheme.isSelected()){
                stmt.executeUpdate("INSERT INTO theme VALUES('"+jtfNewTheme.getText()+"')");
            }
            if(jrbtSousTheme.isSelected()){
                if(jcbTheme.getSelectedIndex()!=-1){
                    Theme th = (Theme)jcbTheme.getSelectedItem();
                    int idTheme = th.getId_theme();
                    stmt.executeUpdate("INSERT INTO soustheme VALUES("+idTheme+",'"+jtfNewTheme.getText()+"')");
                }else{
                    JOptionPane.showMessageDialog(this, "Veuillez selectionner un theme parent");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nom de theme ou sous Theme non valide");
            }
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Base de données \n"+" Intitulé déjà existant !");
        }
        
        jtTheme.setModel(initTreeModel());
        jcbTheme.setModel(initTheme());
    }//GEN-LAST:event_jbtnCreerThemeActionPerformed

    //      Quitter l'application
    private void jbtnQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnQuitterActionPerformed
        this.dispose();     //Fermeture de l'application
    }//GEN-LAST:event_jbtnQuitterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCreerTheme;
    private javax.swing.JButton jbtnModifierTheme;
    private javax.swing.JButton jbtnQuitter;
    private javax.swing.JComboBox jcbTheme;
    private javax.swing.JRadioButton jrbtSousTheme;
    private javax.swing.JRadioButton jrbtTheme;
    private javax.swing.JTree jtTheme;
    private javax.swing.JTextField jtfModifTheme;
    private javax.swing.JTextField jtfNewTheme;
    // End of variables declaration//GEN-END:variables
}
