
package baselivre.ui.gestionstock;

import baselivre.produit.Auteur;
import baselivre.produit.Editeur;
import baselivre.produit.Livre;
import baselivre.ui.frame.InterfaceRoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cdi116
 */
public class jiGestionStock extends javax.swing.JInternalFrame {
    
    private String sqlConnexion;
    private InterfaceRoot ir;
    private Vector titres;
    private Vector table;

    
    
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
     * Constructeur pour la frame
     * @param ir InterfaceRoot
     */
    public jiGestionStock(InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFEditeurPays = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFEditeurNom = new javax.swing.JTextField();
        jBRechercheEditeur = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFAuteurNom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFAuteurPrenom = new javax.swing.JTextField();
        jBRechercheAuteur = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTFLivreTitre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFLivreISBN10 = new javax.swing.JTextField();
        jBRechercheLivre = new javax.swing.JButton();
        jTFLivreISBN13 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCBSousTheme = new javax.swing.JComboBox();
        jCTheme = new javax.swing.JComboBox();
        jBRechercheTheme = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBModificationStock = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gestion des Stocks Librairie");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("Nom");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 60, 30);
        jPanel1.add(jTFEditeurPays);
        jTFEditeurPays.setBounds(300, 20, 130, 30);

        jLabel2.setText("Pays");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 20, 70, 30);
        jPanel1.add(jTFEditeurNom);
        jTFEditeurNom.setBounds(80, 20, 130, 30);

        jBRechercheEditeur.setText("Rechercher");
        jBRechercheEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheEditeurActionPerformed(evt);
            }
        });
        jPanel1.add(jBRechercheEditeur);
        jBRechercheEditeur.setBounds(490, 20, 100, 23);

        jTabbedPane4.addTab("Editeur", jPanel1);

        jPanel2.setLayout(null);

        jLabel3.setText("Nom");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(60, 20, 50, 30);

        jTFAuteurNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAuteurNomActionPerformed(evt);
            }
        });
        jPanel2.add(jTFAuteurNom);
        jTFAuteurNom.setBounds(110, 20, 120, 30);

        jLabel4.setText("Prenom");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(240, 20, 50, 30);

        jTFAuteurPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAuteurPrenomActionPerformed(evt);
            }
        });
        jPanel2.add(jTFAuteurPrenom);
        jTFAuteurPrenom.setBounds(290, 20, 120, 30);

        jBRechercheAuteur.setText("Rechercher");
        jBRechercheAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheAuteurActionPerformed(evt);
            }
        });
        jPanel2.add(jBRechercheAuteur);
        jBRechercheAuteur.setBounds(490, 20, 100, 23);

        jTabbedPane4.addTab("Auteur", jPanel2);

        jPanel3.setLayout(null);

        jLabel5.setText("Titre");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 19, 50, 30);

        jTFLivreTitre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLivreTitreActionPerformed(evt);
            }
        });
        jPanel3.add(jTFLivreTitre);
        jTFLivreTitre.setBounds(50, 20, 120, 30);

        jLabel6.setText("ISBN10");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(190, 20, 50, 30);

        jTFLivreISBN10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLivreISBN10ActionPerformed(evt);
            }
        });
        jPanel3.add(jTFLivreISBN10);
        jTFLivreISBN10.setBounds(230, 20, 120, 30);

        jBRechercheLivre.setText("Rechercher");
        jBRechercheLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheLivreActionPerformed(evt);
            }
        });
        jPanel3.add(jBRechercheLivre);
        jBRechercheLivre.setBounds(540, 20, 100, 23);

        jTFLivreISBN13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLivreISBN13ActionPerformed(evt);
            }
        });
        jPanel3.add(jTFLivreISBN13);
        jTFLivreISBN13.setBounds(410, 20, 120, 30);

        jLabel7.setText("ISBN13");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(360, 20, 50, 30);

        jTabbedPane4.addTab("Livre", jPanel3);

        jPanel4.setLayout(null);

        jCBSousTheme.setModel(SousTheme());
        jCBSousTheme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBSousThemeItemStateChanged(evt);
            }
        });
        jCBSousTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSousThemeActionPerformed(evt);
            }
        });
        jPanel4.add(jCBSousTheme);
        jCBSousTheme.setBounds(330, 20, 100, 20);

        jCTheme.setModel(Theme());
        jCTheme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCThemeItemStateChanged(evt);
            }
        });
        jCTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCThemeActionPerformed(evt);
            }
        });
        jPanel4.add(jCTheme);
        jCTheme.setBounds(80, 20, 100, 20);

        jBRechercheTheme.setText("Recherche");
        jBRechercheTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRechercheThemeActionPerformed(evt);
            }
        });
        jPanel4.add(jBRechercheTheme);
        jBRechercheTheme.setBounds(510, 20, 120, 23);

        jTabbedPane4.addTab("Theme", jPanel4);

        getContentPane().add(jTabbedPane4);
        jTabbedPane4.setBounds(10, 10, 720, 100);

        jTable1.setModel(initTable());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 720, 360);

        jBModificationStock.setText("Modifier le Stock");
        jBModificationStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificationStockActionPerformed(evt);
            }
        });
        getContentPane().add(jBModificationStock);
        jBModificationStock.setBounds(280, 510, 130, 23);

        setBounds(0, 0, 765, 593);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFAuteurPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAuteurPrenomActionPerformed
      
    }//GEN-LAST:event_jTFAuteurPrenomActionPerformed

    private void jTFAuteurNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAuteurNomActionPerformed
      
    }//GEN-LAST:event_jTFAuteurNomActionPerformed

    private void jTFLivreISBN13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLivreISBN13ActionPerformed
       
    }//GEN-LAST:event_jTFLivreISBN13ActionPerformed

    private void jTFLivreISBN10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLivreISBN10ActionPerformed
       
    }//GEN-LAST:event_jTFLivreISBN10ActionPerformed

    private void jTFLivreTitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLivreTitreActionPerformed
       
    }//GEN-LAST:event_jTFLivreTitreActionPerformed

    // Fonction de recherche par Editeur (la recherche doit retourner un seul editeur)
    
    private void jBRechercheEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheEditeurActionPerformed
       
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
        Statement stmt2 = null;
        Statement stmt3 = null;
        try {
            stmt = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt3 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur" + ex.getMessage());
        }
        ResultSet rs = null;
        ResultSet rs2 = null;
        table = new Vector();
        titres = new Vector();
        try {
            
            if (jTFEditeurNom.getText()!=""){
                if (jTFEditeurPays.getText()!=""){
                    rs = stmt.executeQuery("SELECT * from editeur WHERE editeur_nom LIKE '%"+jTFEditeurNom.getText()+"%'"
                            + " AND editeur_pays LIKE '%"+jTFEditeurPays.getText()+"%' AND editeur_actif = 1");
                }else{
                    rs = stmt.executeQuery("SELECT * from editeur where editeur_nom LIKE '%"+jTFEditeurNom.getText()+"%' AND editeur_actif = 1");
                }
            }else{
                if (jTFEditeurPays.getText()!=""){
                    rs = stmt.executeQuery("SELECT * from editeur WHERE editeur_pays LIKE '%"+jTFEditeurPays.getText()+"%' AND editeur_actif = 1"); 
                }else{
                    rs = stmt.executeQuery("SELECT * from editeur WHERE editeur_actif = 1");
                }
            }
            
            int idEditeur = 0;
            Editeur editeur = null;
            Livre livre = null;
            ResultSet rs3 = null;
            int i = 0;
            while (rs.next()) {
                
                
                
                livre = null;
                idEditeur = rs.getInt("id_editeur");

                editeur = new Editeur(rs.getString("editeur_nom"), rs.getString("editeur_pays"), true);
                rs3 = stmt3.executeQuery("SELECT * FROM livre WHERE id_editeur = " + idEditeur + " AND livre_actif = 1");
                int idLivre = 0;
                Vector listeLivre = null;
                
                
                while (rs3.next()) {
                    listeLivre = new Vector();
                    idLivre = rs3.getInt("id_livre");
                    livre = new Livre();
                    livre.setEd(editeur);
                    livre.setActifLivre(true);
                    livre.setTitre(rs3.getString("livre_titre"));
                    livre.setIsbn10(rs3.getString("livre_isbn10"));
                    livre.setIsbn13(rs3.getString("livre_isbn13"));
                    livre.setStock(rs3.getInt("livre_stock"));

                    
                    
                    rs2 = stmt2.executeQuery("SELECT * FROM auteur INNER JOIN ecriture ON auteur.id_auteur = ecriture.id_auteur "
                            + "WHERE ecriture.id_livre = " + idLivre + " AND auteur.auteur_actif = 1");
                    ArrayList<Auteur> listeAuteur = new ArrayList();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    while (rs2.next()) {
                        Auteur auteur = new Auteur(rs2.getString("auteur_nom"), rs2.getString("auteur_prenom"), sdf.parse(rs2.getString("auteur_date_naissance")));
                        listeAuteur.add(auteur);
                        
                    }
                    livre.setListeAu(listeAuteur);
                    
                    listeLivre.add(livre);
                    listeLivre.add(livre.getEd());
                    listeLivre.add(livre.getListeAu().get(0));
                    listeLivre.add(livre.getIsbn10());
                    listeLivre.add(livre.getIsbn13());
                    listeLivre.add(livre.getStock());
                    table.add(listeLivre);
                    
                }
                
                
            }
            titres.add("Titre");
            titres.add("Editeur");
            titres.add("Auteur");
            titres.add("ISBN10");
            titres.add("ISBN13");
            titres.add("Stock");
            
            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);
            rs.close();
            rs2.close();
            rs3.close();
            stmt.close();
            stmt2.close();
            stmt3.close();
            connexion.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur Base de Données "+ex.getMessage());
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"erreur date");
        }
        

    }//GEN-LAST:event_jBRechercheEditeurActionPerformed

    //Fonction de recherche par auteur (la recherche ne doit retourner qu'un seul Auteur
    
    private void jBRechercheAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheAuteurActionPerformed
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
        Statement stmt2 = null;
        Statement stmt3 = null;
        try {
            stmt = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt3 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur" + ex.getMessage());
        }
        ResultSet rs = null;
        ResultSet rs2 = null;
        table = new Vector();
        titres = new Vector();
        try {
            
            if (!jTFAuteurNom.getText().equals("")){
                if (!jTFAuteurPrenom.getText().equals("")){
                    rs = stmt.executeQuery("SELECT * from auteur WHERE auteur_nom LIKE '%"+jTFAuteurNom.getText()+"%'"
                            + " AND auteur_prenom LIKE '%"+jTFAuteurPrenom.getText()+"%' AND auteur_actif = 1");
                }else{
                    rs = stmt.executeQuery("SELECT * from auteur where auteur_nom LIKE '%"+jTFAuteurNom.getText()+"%' AND auteur_actif = 1");
                }
            }else{
                if (!jTFAuteurPrenom.getText().equals("")){
                    rs = stmt.executeQuery("SELECT * from auteur WHERE auteur_prenom LIKE '%"+jTFAuteurPrenom.getText()+"%' AND auteur_actif = 1"); 
                }else{
                    rs = stmt.executeQuery("SELECT * from auteur WHERE auteur_actif = 1");
                }
            }
            int count = 0;

            int idAuteur = 0;
            ResultSet rs3 = null;
            Auteur auteur = null;
            while (rs.next()) {
                idAuteur = rs.getInt("id_auteur");
                auteur = new Auteur(rs.getString("auteur_nom"), rs.getString("auteur_prenom"), true);

                rs3 = stmt3.executeQuery("SELECT * from livre join ecriture on ecriture.id_livre = livre.id_livre where"
                        + " ecriture.id_auteur = " + idAuteur + " AND livre.livre_actif = 1");
                Livre livre = null;
                

                
                while (rs3.next()) {
                    Vector listeLivre = new Vector();
                    livre = new Livre();
                    int idLivre = rs3.getInt("id_livre");
                    int idEditeur = rs3.getInt("id_editeur");
                    
                    livre.setActifLivre(true);
                    livre.setTitre(rs3.getString("livre_titre"));
                    livre.setIsbn10(rs3.getString("livre_isbn10"));
                    livre.setIsbn13(rs3.getString("livre_isbn13"));
                    livre.setStock(rs3.getInt("livre_stock"));
                    rs2 = stmt2.executeQuery("select * from Editeur where id_editeur = " + idEditeur + " AND editeur_actif = 1");
                    Editeur editeur = null;
                    while (rs2.next()){
                    editeur = new Editeur(rs2.getString("editeur_nom"), rs2.getString("Editeur_pays"), true);
                    }
                    ArrayList<Auteur> listeAuteur = new ArrayList();
                    listeAuteur.add(auteur);
                    livre.setEd(editeur);
                    livre.setListeAu(listeAuteur);
                    listeLivre.add(livre);
                    listeLivre.add(livre.getEd());
                    listeLivre.add(livre.getListeAu().get(0));
                    listeLivre.add(livre.getIsbn10());
                    listeLivre.add(livre.getIsbn13());
                    listeLivre.add(livre.getStock());
                    table.add(listeLivre);
                }
            }
            titres.add("Titre");
            titres.add("Editeur");
            titres.add("Auteur");
            titres.add("ISBN10");
            titres.add("ISBN13");
            titres.add("stock");

            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);
            rs.close();
            rs2.close();
            rs3.close();
            stmt.close();
            stmt2.close();
            stmt3.close();
            connexion.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur Base de Données "+ex.getMessage());
        }
    }//GEN-LAST:event_jBRechercheAuteurActionPerformed
    
    // fonction de recherche par titre/ISBN10/ISBN13
    
    private void jBRechercheLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheLivreActionPerformed
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
        Statement stmt2 = null;
        try {
            stmt = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur" + ex.getMessage());
        }
        ResultSet rs = null;
        ResultSet rs2 = null;
        table = new Vector();
        try {
            
            if (!jTFLivreTitre.getText().equals("")){
                if (!jTFLivreISBN10.getText().equals("")){
                    if(!jTFLivreISBN13.getText().equals("")){
                        rs = stmt.executeQuery("SELECT * from livre where livre_titre lIKE '%"+jTFLivreTitre.getText()+"'%"
                            + " AND livre_isbn10 LIKE '%"+jTFLivreISBN10.getText()+"%' AND livre_isbn13 LIKE '%"+jTFLivreISBN13.getText()+"%'"
                                + " AND livre_actif = 1");
                    }else{
                       rs = stmt.executeQuery("SELECT * from livre where livre_titre LIKE '%"+jTFLivreTitre.getText()+"%'"
                            + " AND livre_isbn10 LIKE '%"+jTFLivreISBN10.getText()+"%'"
                                + " AND livre_actif = 1"); 
                    }
                    
                }else{
                    if(!jTFLivreISBN13.getText().equals("")){
                        rs = stmt.executeQuery("SELECT * from livre where livre_titre LIKE '%"+jTFLivreTitre.getText()+"%'"
                            + " AND livre_isbn13 LIKE '%"+jTFLivreISBN13.getText()+"%'"
                                + " AND livre_actif = 1");
                    }else{
                       rs = stmt.executeQuery("SELECT * from livre where livre_titre LIKE '%"+jTFLivreTitre.getText()+"%'"
                            + " AND livre_actif = 1"); 
                    }
                }
            }else{
                if (!jTFLivreISBN10.getText().equals("")){
                    if(!jTFLivreISBN13.getText().equals("")){
                        rs = stmt.executeQuery("SELECT * from livre where livre_isbn10 LIKE '%"+jTFLivreISBN10.getText()+"%'"
                                + " AND livre_isbn13 LIKE '%"+jTFLivreISBN13.getText()+"%'"
                                + " AND livre_actif = 1");
                    }else{
                       rs = stmt.executeQuery("SELECT * from livre where livre_isbn10 LIKE '%"+jTFLivreISBN10.getText()+"%'"
                                + " AND livre_actif = 1"); 
                    }
                    
                }else{
                    if(!jTFLivreISBN13.getText().equals("")){
                        rs = stmt.executeQuery("SELECT * from livre where livre_isbn13 LIKE '%"+jTFLivreISBN13.getText()+"%'"
                                + " AND livre_actif = 1");
                    }else{
                       rs = stmt.executeQuery("SELECT * from livre where livre_actif = 1"); 
                    }
                }
                
            }
            
            int idLivre =0;
            int idEditeur = 0;
            titres = new Vector();
                      
            while (rs.next()) {
                idLivre = rs.getInt("id_livre");
                idEditeur = rs.getInt("id_Editeur");

                rs2 = stmt2.executeQuery("SELECT * from editeur WHERE editeur_actif = 1 AND id_editeur = " + idEditeur);
                Editeur editeur = null;
                while (rs2.next()) {
                    editeur = new Editeur(rs2.getString("editeur_nom"), rs2.getString("editeur_pays"), true);
                }
                rs2 = stmt2.executeQuery("select * from auteur INNER JOIN ecriture on ecriture.id_auteur = auteur.id_auteur where ecriture.id_livre = " + idLivre + ""
                        + " AND auteur_actif = 1");
                ArrayList<Auteur> listeAuteur = new ArrayList();
                while (rs2.next()) {
                    Auteur auteur = new Auteur(rs2.getString("auteur_nom"), rs2.getString("auteur_prenom"), true);
                    listeAuteur.add(auteur);
                }

                Livre livre = null;
                
                    Vector listeLivre = new Vector();
                    livre = new Livre();
                    livre.setActifLivre(true);
                    livre.setTitre(rs.getString("livre_titre"));
                    livre.setEd(editeur);
                    livre.setListeAu(listeAuteur);
                    livre.setIsbn10(rs.getString("livre_isbn10"));
                    livre.setIsbn13(rs.getString("livre_isbn13"));
                    livre.setStock(rs.getInt("livre_stock"));
                    listeLivre.add(livre);
                    listeLivre.add(livre.getEd());
                    listeLivre.add(livre.getListeAu().get(0));
                    listeLivre.add(livre.getIsbn10());
                    listeLivre.add(livre.getIsbn13());
                    listeLivre.add(livre.getStock());
                    table.add(listeLivre);
                }
            titres.add("Titre");
            titres.add("Editeur");
            titres.add("Auteur");
            titres.add("ISBN10");
            titres.add("ISBN13");
            titres.add("stock");
            
            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);
            rs.close();
            rs2.close();
            stmt2.close();
            stmt.close();
            connexion.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur Base de Données "+ex.getMessage());
        }
    }//GEN-LAST:event_jBRechercheLivreActionPerformed
    // fonction de recherche par theme/sous-theme
    private void jBRechercheThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRechercheThemeActionPerformed
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
        Statement stmt2 = null;
        Statement stmt3 = null;
        try {
            stmt = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt3 = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur" + ex.getMessage());
        }
        ResultSet rs = null;
        ResultSet rs2 = null;
        table = new Vector();
        int idSsTheme = 0;
        ArrayList sstheme = new ArrayList();
        ArrayList livreId = new ArrayList();
        try {
            if (jCBSousTheme.getSelectedIndex() != -1 || !jCBSousTheme.getSelectedItem().toString().equals("Choisir un theme d'abord")) {
                if (jCTheme.getSelectedIndex() != -1) {
                    rs = stmt.executeQuery("SELECT * FROM soustheme WHERE soustheme_nom = '" + jCBSousTheme.getSelectedItem().toString() + "'");
                    while (rs.next()){
                        idSsTheme = rs.getInt("id_soustheme");
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"Vous devez au moins choisir un theme");
                }
            } else {
                rs = stmt.executeQuery("Select * FROM theme where theme_nom = '" + jCTheme.getSelectedItem().toString() + "'");
                int idTheme = rs.getInt("id_theme");
                rs = stmt.executeQuery("SELECT * from soustheme where id_theme = " + idTheme);
                while (rs.next()) {
                    sstheme.add(rs.getInt("id_soustheme"));
                }
            }

            if (jCBSousTheme.getSelectedIndex() == -1 || !jCBSousTheme.getSelectedItem().toString().equals("Choisir un theme d'abord")) {
                for (int i = 0; i < sstheme.size(); i++) {
                    rs = stmt.executeQuery("SELECT * FROM livre where id_soustheme = " + (int) sstheme.get(i)+" AND livre_actif = 1");
                    while (rs.next()) {
                        livreId.add(rs.getInt("id_livre"));
                    }
                }
            } else {
                rs = stmt.executeQuery("SELECT * FROM livre WHERE id_soustheme = " + idSsTheme+" AND livre_actif = 1");
                while (rs.next()) {
                    livreId.add(rs.getInt("id_livre"));
                }
            }
            ResultSet rs3 = null;
            titres = new Vector();
            for (int i = 0; i < livreId.size(); i++) {
                Vector listeLivre = new Vector();
                rs = stmt.executeQuery("SELECT * from livre where id_livre = " + livreId.get(i) + " AND livre_actif = 1");

                Livre livre = null;
                while (rs.next()) {
                    listeLivre = new Vector();
                    livre = new Livre();
                    livre.setActifLivre(true);
                    livre.setTitre(rs.getString("livre_titre"));

                    livre.setIsbn10(rs.getString("livre_ISBN10"));
                    livre.setIsbn13(rs.getString("livre_ISBN13"));
                    livre.setStock(rs.getInt("livre_stock"));
                    int idEditeur = rs.getInt("id_editeur");
                    rs2 = stmt2.executeQuery("SELECT * from editeur where id_editeur = " + idEditeur + " AND editeur_actif = 1");
                    Editeur editeur = null;
                    while (rs2.next()) {
                        editeur = new Editeur(rs2.getString("editeur_nom"), rs2.getString("editeur_pays"), true);
                    }

                    livre.setEd(editeur);
                    rs3 = stmt3.executeQuery("Select * from auteur join ecriture on auteur.id_auteur = ecriture.id_auteur "
                            + "Where ecriture.id_livre = " + livreId.get(i) + " AND auteur.auteur_actif = 1");
                    ArrayList<Auteur> listeAuteur = new ArrayList();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    while (rs3.next()) {
                        Auteur auteur = new Auteur(rs3.getString("auteur_nom"), rs3.getString("auteur_prenom"), sdf.parse(rs3.getString("auteur_date_naissance")));
                        listeAuteur.add(auteur);
                    }
                    livre.setListeAu(listeAuteur);
                    listeLivre.add(livre);
                    listeLivre.add(livre.getEd());
                    listeLivre.add(livre.getListeAu().get(0));
                    listeLivre.add(livre.getIsbn10());
                    listeLivre.add(livre.getIsbn13());
                    listeLivre.add(livre.getStock());
                    table.add(listeLivre);

                }
            }
            titres.add("Titre");
            titres.add("Editeur");
            titres.add("Auteur");
            titres.add("ISBN10");
            titres.add("ISBN13");
            titres.add("stock");
            
            DefaultTableModel tm = new DefaultTableModel(table, titres) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tm);
            
            rs.close();
            rs2.close();
            rs3.close();
            stmt.close();
            stmt2.close();
            stmt3.close();
            connexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "erreur Base de Données " + ex.getMessage());

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"erreur conversion de date "+ex.getMessage());
        }
    }//GEN-LAST:event_jBRechercheThemeActionPerformed
    
    private void jCBSousThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSousThemeActionPerformed
        
    }//GEN-LAST:event_jCBSousThemeActionPerformed
    // gestion du stock (on utilise l'ISBN13 en tant qu'identifiant).
    private void jBModificationStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificationStockActionPerformed
        int x = jTable1.getSelectedRow();
        int y = 4;
        
        String ISBN13 = jTable1.getValueAt(x, y).toString();
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
            
            rs = stmt.executeQuery("SELECT * from livre where livre_isbn13 = '" + ISBN13 + "' AND livre_actif = 1");
            int idLivre = 0;
            int Stockdbt = 0;
            while (rs.next()) {
                idLivre = rs.getInt("id_livre");
                Stockdbt = rs.getInt("livre_stock");
                
            }
            String retour = (String) JOptionPane.showInputDialog(this, "Entrez le nouveau stock", "gestion Stock", JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (retour != "") {
                int stockFin = Stockdbt + Integer.valueOf(retour);
                if (stockFin < 0) {
                    JOptionPane.showMessageDialog(this, "valeur entrée non valide \n le stock ne peut etre negatif");
                } else {
                    stmt.executeUpdate("Update livre set livre_stock = " + stockFin + " where id_livre = " + idLivre);
                }
            } else {
                
            }
            rs.close();
            stmt.close();
            connexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur base de données " + ex.getMessage());
        }
     
        
        
    }//GEN-LAST:event_jBModificationStockActionPerformed
    
    private void jCBSousThemeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBSousThemeItemStateChanged
        
    }//GEN-LAST:event_jCBSousThemeItemStateChanged
    // remplissage de la combobox sous theme lorsqu'un theme est selectionné
    private void jCThemeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCThemeItemStateChanged
        Vector listeS = new Vector();
        if (jCTheme.getSelectedIndex()!=-1){
            listeS = initSousTheme();
            DefaultComboBoxModel d = new DefaultComboBoxModel(listeS);
            jCBSousTheme.setModel(d);
        }
    }//GEN-LAST:event_jCThemeItemStateChanged

    private void jCThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCThemeActionPerformed
        
    }//GEN-LAST:event_jCThemeActionPerformed

    // initialisation de la combobox theme
    private ComboBoxModel Theme() {
        return new DefaultComboBoxModel(initTheme());
    }
    
    private Vector initTheme(){
        Vector theme = new Vector();
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
        theme.add("");
        
        try {
            rs = stmt.executeQuery("Select * from theme");
            while (rs.next()){
                theme.add(rs.getString("theme_nom"));
            }
            rs.close();
            stmt.close();
            connexion.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur base de données "+ex.getMessage());
        }
        
        
        return theme;
    }
    // initialisation de la combobox soustheme par defaut (vide)
    private ComboBoxModel SousTheme(){
        return new DefaultComboBoxModel(initSousThemeDefault());
    }
    
    private Vector initSousThemeDefault(){
        Vector sousTheme = new Vector();
        sousTheme.add("");
        return sousTheme;
        
    }
    
    private Vector initSousTheme(){
        Vector sousTheme = new Vector();
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
        Statement stmt2 = null;
        try {
            stmt = connexion.createStatement();
            stmt2 = connexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Compte Utilisateur" + ex.getMessage());
        }
        ResultSet rs = null;
        ResultSet rs2 = null;
        sousTheme.add("Choisir un theme d'abord");
        
        try {
            if (jCTheme.getSelectedIndex() != -1) {
                String theme = jCTheme.getSelectedItem().toString();
                rs2 = stmt2.executeQuery("Select * FROM theme WHERE theme_nom = '" + theme + "'");
                while (rs2.next()) {
                    int themeId = rs2.getInt("id_theme");
                    rs = stmt.executeQuery("Select * from soustheme where id_theme = " + themeId);
                    while (rs.next()) {
                        sousTheme.add(rs.getString("soustheme_nom"));
                    }
                }
            }
            rs.close();
            rs2.close();
            stmt2.close();
            stmt.close();
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur base de données "+ex.getMessage());
        }
        
        
        
        
        return sousTheme;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBModificationStock;
    private javax.swing.JButton jBRechercheAuteur;
    private javax.swing.JButton jBRechercheEditeur;
    private javax.swing.JButton jBRechercheLivre;
    private javax.swing.JButton jBRechercheTheme;
    private javax.swing.JComboBox jCBSousTheme;
    private javax.swing.JComboBox jCTheme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFAuteurNom;
    private javax.swing.JTextField jTFAuteurPrenom;
    private javax.swing.JTextField jTFEditeurNom;
    private javax.swing.JTextField jTFEditeurPays;
    private javax.swing.JTextField jTFLivreISBN10;
    private javax.swing.JTextField jTFLivreISBN13;
    private javax.swing.JTextField jTFLivreTitre;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}