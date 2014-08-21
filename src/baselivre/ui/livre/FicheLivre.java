package baselivre.ui.livre;

/**
 * @author Eddy
 * Constructeur : FicheLivre(InterfaceRoot ir, String modeCMS, String livre_isbn13)
 *  ir pour la récupération de la chaine de connection à la BDD
 *  modeCMS pour le mode d'ouverture de l'écran : soit "C" pour Création, soit "M" pour Modification, soit "S" pour suppression
 *  livre_isbn13 pour la chaine ISBN13 du livre choisi depuis l'écran de la liste livres (pour les modes M et S)
 */

import baselivre.produit.Auteur;
import baselivre.produit.Editeur;
import baselivre.produit.Fournisseur;
import baselivre.produit.SousTheme;
import baselivre.produit.Theme;
import baselivre.ui.auteur.jiAuteurCreation;
import baselivre.ui.editeur.jiEditeurCreation;
import baselivre.ui.frame.InterfaceRoot;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class FicheLivre extends javax.swing.JInternalFrame {
    
    private String sqlConnection;   // Chaine générale de connection à la BDD (reçue en paramètre à la construction de la fenêtre)
    private String modeCMS;         // Mode d'ouverture de l'écran : C(réation) ou M(odification) ou S(uppression)
    private String livre_isbn13;    // paramètre du produit courant ISBN13 unique (sert pour les modes M et S)
    private Connection connection;
    private InterfaceRoot ir;
    
    /**
     * 
     * @param ir InterfaceRoot
     * @param modeCMS String (permet de determiner le mode de la frame)
     * @param livre_isbn13 String (ref du livre en cours)
     */
    
    public FicheLivre(InterfaceRoot ir, String modeCMS, String livre_isbn13)  {
        initComponents();
        this.ir=ir;
        this.sqlConnection= ir.SqlConnexion();
        this.modeCMS=modeCMS;
        this.livre_isbn13=livre_isbn13;
        
        try { //Connexion BDD
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {   
            JOptionPane.showMessageDialog(this, "Driver non trouvé ! "+ex.getMessage());
        }
        try {
            connection = DriverManager.getConnection(this.sqlConnection);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"erreur base de données "+ ex.getErrorCode());
        }
        
        jFileChooser.setVisible(false); // cache par défaut le file chooser de l'image photo
        jFileChooser.setCurrentDirectory(new java.io.File(".\\src\\baselivre\\ui\\")); // positionne son dossier courant dans le dossier prévu pour les photos
        
        // remplissage des contenus des comboBox depuis les infos de la BDD
        jcbEditeur.setModel(initEditeur());
        jcbAuteur.setModel(initAuteur());
        jcbFournisseur.setModel(initFournisseur());
        jcbSousTheme.setModel(initSousTheme());
        
        if (modeCMS.equals("C")){           // Mode création
            // rien à préremplir
        } else if (modeCMS.equals("M")){
            // Mode modification
            try {
            preremplir();   // préremplit dans tous les champs les infos du produit courant 
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Erreur conversion de date "+ ex.getMessage());
            }
        } else if (modeCMS.equals("S")){    
            // Mode suppression
            try {
                preremplir();   // préremplit dans tous les champs les infos du produit courant (pour un rappel plus en détails du produit)
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Erreur conversion de date "+ ex.getMessage());
            }
            griser();       // + grise tous les champs - les rend non modifiables
        }
    }

    private ComboBoxModel initEditeur() {
        return new DefaultComboBoxModel(vEditeurs());
    }
    private ComboBoxModel initAuteur() {
        return new DefaultComboBoxModel(vAuteurs());
    }
    private ComboBoxModel initFournisseur() {
        return new DefaultComboBoxModel(vFournisseurs());
    }
    private ComboBoxModel initSousTheme() {
        return new DefaultComboBoxModel(vSousTheme());
    }
    private Vector vEditeurs() {
        Vector v = new Vector();
        String query = "SELECT id_editeur, editeur_nom FROM editeur ORDER BY editeur_nom";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Editeur e=new Editeur(rs.getString("editeur_nom"), "", true);
                e.setId_editeur(rs.getInt("id_editeur"));
                v.add(e);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL ! "+ex.getMessage());
            return null;
        }
        return v;
    }
    private Vector vAuteurs() {
        Vector v = new Vector();
        String query = "SELECT id_auteur, auteur_nom FROM auteur ORDER BY auteur_nom";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Auteur a=new Auteur(rs.getString("auteur_nom"), "", null);
                a.setIdAuteur(rs.getInt("id_auteur"));
                v.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL ! "+ex.getMessage());
            return null;
        }
        return v;
    }
    private Vector vFournisseurs() {
        Vector v = new Vector();
        String query = "SELECT id_fournisseur, supp_nom FROM fournisseur";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fournisseur f=new Fournisseur(rs.getString("supp_nom"), true);
                f.setId_fournisseur(rs.getInt("id_fournisseur"));
                v.add(f);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL ! "+ex.getMessage());
            return null;
        }
        return v;
    }    
    private Vector vSousTheme() {
        Vector v = new Vector();
        String query = "SELECT id_soustheme, soustheme_nom FROM soustheme";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SousTheme s=new SousTheme(rs.getString("soustheme_nom"), null);
                s.setIdSousTheme(rs.getInt("id_soustheme"));
                v.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL ! "+ex.getMessage());
            return null;
        }
        return v;
    }  
    
    private void preremplir() throws ParseException {
        int idLivre=0;
        String path="/baselivre/ui/"; // postulat a definir !!!!!!!!! Pour le moment images doivent etre dans baselivre-src-baselivre-ui
        String query = "select * " 
                    + "from livre l "
                    + "where l.livre_isbn13='"+livre_isbn13+"'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            java.sql.Date ds = null;
            java.util.Date du = new java.util.Date();
            SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
            while (rs.next()) {
                jtfTitreLivre.setText(rs.getString("livre_titre"));
                jtfSousTitreLivre.setText(rs.getString("livre_soustitre"));
                jlblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(path + rs.getString("livre_photo"))));
                jcbEditeur.setSelectedItem(new Editeur(rs.getInt("id_editeur"), ""));
                jcbFournisseur.setSelectedItem(new Fournisseur(rs.getInt("id_fournisseur"), ""));
                jcbSousTheme.setSelectedItem(new SousTheme(rs.getInt("id_soustheme"), ""));
                if (rs.getInt("livre_actif")==1){
                    jtbActif.setSelected(true);
                    jtbActif.setText("Actif");
                } else {
                    jtbActif.setSelected(false);
                    jtbActif.setText("Inactif");
                }
                jtfFormatLivre.setText(rs.getString("livre_format"));
                jtfNbPagesLivre.setText(Integer.toString(rs.getInt("livre_nbpages")));
                jtfPoidsLivre.setText(Integer.toString(rs.getInt("livre_poids")));
                jtfDimensionLivre.setText(rs.getString("livre_dimension"));
                jtfEditionLivre.setText(Integer.toString(rs.getInt("livre_edition")));
                ds=rs.getDate("livre_parution");
                du.setTime(ds.getTime());
                jtfDateParutionLivre.setText(s.format(du)); // date affichée en string au format YYYYMMDD
                jtfPrixLivre.setText(Integer.toString(rs.getInt("livre_prix")));
                jtfStockLivre.setText(Integer.toString(rs.getInt("livre_stock")));
                jtfISBN10.setText(rs.getString("livre_isbn10"));
                jtfISBN13.setText(rs.getString("livre_isbn13"));
                jtfPhotoLivre.setText(rs.getString("livre_photo"));
                jtaResume.setText(rs.getString("livre_resume"));
                idLivre=rs.getInt("id_livre"); // sert pour le pré-remplissage auteur plus bas...
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL ! "+ex.getMessage());
            return;
        }
        
        // pré-remplissage auteur (doit pouvoir gérer le cas où plusieurs auteurs ressortent pour présélectionner plusieurs lignes dans la combo auteurs...
        query = "select id_auteur from ecriture where id_livre=" + Integer.toString(idLivre);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) { // ATTENTION : peut retourner plusieurs lignes...
                jcbAuteur.setSelectedItem(new Auteur(rs.getInt("id_auteur"), ""));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL ! "+ex.getMessage());
            //return null;
        }

    }
    
    private void griser(){
        jtfTitreLivre.setEnabled(false);
        jtfSousTitreLivre.setEnabled(false);
        jlblImage.setEnabled(false);
        jcbEditeur.setEnabled(false);
        jcbAuteur.setEnabled(false);
        jcbFournisseur.setEnabled(false);
        jcbSousTheme.setEnabled(false);
        jtbActif.setEnabled(false);
        jtfFormatLivre.setEnabled(false);
        jtfNbPagesLivre.setEnabled(false);
        jtfPoidsLivre.setEnabled(false);
        jtfDimensionLivre.setEnabled(false);
        jtfEditionLivre.setEnabled(false);
        jtfDateParutionLivre.setEnabled(false);
        jtfPrixLivre.setEnabled(false);
        jtfStockLivre.setEnabled(false);
        jtfISBN10.setEnabled(false);
        jtfISBN13.setEnabled(false);
        jtfPhotoLivre.setEnabled(false);
        jbFileChooser.setEnabled(false);
        jtaResume.setEnabled(false);
    }

    private void creer(){
        
        String actif;
        if (jtbActif.isSelected()){
            actif="1";
        } else {
            actif="0";
        }
        try{
            String idEditeur=Integer.toString(((Editeur)jcbEditeur.getSelectedItem()).getId_editeur());
            String idAuteur=Integer.toString(((Auteur)jcbAuteur.getSelectedItem()).getIdAuteur());
            String idFournisseur=Integer.toString(((Fournisseur)jcbFournisseur.getSelectedItem()).getId_fournisseur());
            String idSousTheme=Integer.toString(((SousTheme)jcbSousTheme.getSelectedItem()).getIdSousTheme());
            
            Statement stmt=connection.createStatement();
            String sql="INSERT INTO dbo.livre (id_editeur,id_fournisseur,id_soustheme,livre_titre,livre_soustitre,livre_isbn10,livre_isbn13,livre_format,livre_nbpages,livre_parution,livre_edition,livre_dimension,livre_poids,livre_resume,livre_photo,livre_prix,livre_stock,livre_actif) "
                        + "VALUES ("
                        + idEditeur 
                        + "," + idFournisseur 
                        + "," + idSousTheme 
                        + ",'"+jtfTitreLivre.getText()+"'"
                        + ",'"+jtfSousTitreLivre.getText()+"'"
                        + ",'"+jtfISBN10.getText()+"'"
                        + ",'"+jtfISBN13.getText()+"'"
                        + ",'"+jtfFormatLivre.getText()+"'"
                        + ","+jtfNbPagesLivre.getText()+""
                        + ",convert(datetime,'"+jtfDateParutionLivre.getText()+"',112)" //convert(datetime,'20140101',112) AAAAMMJJ
                        + ","+jtfEditionLivre.getText()+""
                        + ",'"+jtfDimensionLivre.getText()+"'"
                        + ","+jtfPoidsLivre.getText()+""
                        + ",'"+jtaResume.getText()+"'"
                        + ",'"+jtfPhotoLivre.getText()+"'"
                        + ","+jtfPrixLivre.getText()+""
                        + ","+jtfStockLivre.getText()+""
                        + ","+actif //ok ?
                        + ")";

            int result=stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problème de création du livre :"+ex.getMessage());
            return;
        }

        int idLivre=0;
        try { // recup id_livre généré pour l'insert d'après
            Statement stmt=connection.createStatement();
            String query = "select id_livre from livre where livre_isbn13='"+jtfISBN13.getText()+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                idLivre=rs.getInt("id_livre");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL ! "+ex.getMessage());
            //return null;
        }
            
        // insert table ecriture (lien avec auteur)
        try{
            String idAuteur=Integer.toString(((Auteur)jcbAuteur.getSelectedItem()).getIdAuteur());
            Statement stmt=connection.createStatement();
            String sql="INSERT INTO dbo.ecriture VALUES ("+idAuteur+","+Integer.toString(idLivre)+")";
            int result=stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problème de création du lien livre/auteur :"+ex.getMessage());
            //return null;
        }
    
    }                                           

    private void modifier(){
        String actif;
        if (jtbActif.isSelected()){
            actif="1";
        } else {
            actif="0";
        }
        try{
            Statement stmt=connection.createStatement();
            String sql="UPDATE dbo.livre SET "
                            + "id_editeur="+ Integer.toString(((Editeur)jcbEditeur.getSelectedItem()).getId_editeur()) 
                            + ", id_fournisseur=" + Integer.toString(((Fournisseur)jcbFournisseur.getSelectedItem()).getId_fournisseur()) 
                            + ", id_soustheme=" + Integer.toString(((SousTheme)jcbSousTheme.getSelectedItem()).getIdSousTheme()) 
                            + ", livre_titre='" + jtfTitreLivre.getText()+ "'" 
                            + ", livre_soustitre='" + jtfSousTitreLivre.getText()+ "'" 
                            + ", livre_ISBN10='" + jtfISBN10.getText()+ "'" 
                            + ", livre_ISBN13='" + jtfISBN13.getText() + "'" 
                            + ", livre_format='" + jtfFormatLivre.getText()+ "'" 
                            + ", livre_nbpages=" + jtfNbPagesLivre.getText()+ "" 
                            + ", livre_parution=convert(datetime,'"+jtfDateParutionLivre.getText()+"',112)" //convert(datetime,'20140101',112) AAAAMMJJ
                            + ", livre_edition=" + jtfEditionLivre.getText()+ ""
                            + ", livre_dimension='" + jtfDimensionLivre.getText()+ "'" 
                            + ", livre_poids=" + jtfPoidsLivre.getText()+ "" 
                            + ", livre_resume='" + jtaResume.getText()+ "'" 
                            + ", livre_photo='" + jtfPhotoLivre.getText()+ "'" 
                            + ", livre_prix=" + jtfPrixLivre.getText()+ "" 
                            + ", livre_stock=" + jtfStockLivre.getText()+ "" 
                            + ", livre_actif=" + actif //ok ?
                            + " WHERE livre_isbn13 = '" + livre_isbn13 + "'";
            int result=stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erreur de modification produit ! " + ex.getMessage());
        }
        
        // update de l'auteur dans table de jointure ecriture :
        // ATTENTION : doit gérer le cas où plusieurs auteurs sont sélectionnés !
        try{
            Statement stmt=connection.createStatement();
            String sql="UPDATE dbo.ecriture SET id_auteur="+ Integer.toString(((Auteur)jcbAuteur.getSelectedItem()).getIdAuteur()) 
                            + " WHERE id_livre = " + Integer.toString(getIdLivre(livre_isbn13));
            int result=stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erreur de modification produit ! (lien auteur) " + ex.getMessage());
        }
 }
    
    private void supprimer(){
        try{
            Statement stmt=connection.createStatement();
            String sql="UPDATE dbo.livre SET livre_actif=0 WHERE livre_isbn13 = '" + livre_isbn13 + "'";
            int result=stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Suppression produit ! " + ex.getMessage());
        }
 }

    private int getIdLivre(String isnb13){
        int idLivre=0;
        try {
            String query = "select id_livre from livre where livre_isbn13='"+isnb13+"'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                    idLivre=rs.getInt("id_livre");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL ! "+ex.getMessage());
            //return;
        }
        return idLivre;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        llblTitreLivre = new javax.swing.JLabel();
        jtfTitreLivre = new javax.swing.JTextField();
        jlblSousTitreLivre = new javax.swing.JLabel();
        jtfSousTitreLivre = new javax.swing.JTextField();
        jlblFormatLivre = new javax.swing.JLabel();
        jtfFormatLivre = new javax.swing.JTextField();
        jlblNbPages = new javax.swing.JLabel();
        jtfNbPagesLivre = new javax.swing.JTextField();
        jlblPoidsLivre = new javax.swing.JLabel();
        jtfPoidsLivre = new javax.swing.JTextField();
        jlblDimensionLivre = new javax.swing.JLabel();
        jtfDimensionLivre = new javax.swing.JTextField();
        jlblEditionLivre = new javax.swing.JLabel();
        jtfEditionLivre = new javax.swing.JTextField();
        jlblDateParution = new javax.swing.JLabel();
        jtfDateParutionLivre = new javax.swing.JTextField();
        jlblPrixLivre = new javax.swing.JLabel();
        jtfPrixLivre = new javax.swing.JTextField();
        jlblStockLivre = new javax.swing.JLabel();
        jtfStockLivre = new javax.swing.JTextField();
        jlblISBN10 = new javax.swing.JLabel();
        jtfISBN10 = new javax.swing.JTextField();
        jlblISBN13 = new javax.swing.JLabel();
        jtfISBN13 = new javax.swing.JTextField();
        jlblPhotoLivre = new javax.swing.JLabel();
        jtfPhotoLivre = new javax.swing.JTextField();
        jbFileChooser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaResume = new javax.swing.JTextArea();
        jlblEditeur = new javax.swing.JLabel();
        jcbEditeur = new javax.swing.JComboBox();
        jbAjoutEditeur = new javax.swing.JButton();
        jlblAuteur = new javax.swing.JLabel();
        jcbAuteur = new javax.swing.JComboBox();
        jbAjoutAuteur = new javax.swing.JButton();
        jlblSousTheme = new javax.swing.JLabel();
        jcbSousTheme = new javax.swing.JComboBox();
        jbAjoutSousTheme = new javax.swing.JButton();
        jlblFournisseur = new javax.swing.JLabel();
        jcbFournisseur = new javax.swing.JComboBox();
        jlblImage = new javax.swing.JLabel();
        jtbActif = new javax.swing.JToggleButton();
        jbtnValider = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setResizable(true);
        setTitle("Fiche livre");
        getContentPane().setLayout(null);

        jFileChooser.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jFileChooser.setCurrentDirectory(new java.io.File("C:\\"));
            jFileChooser.setDialogTitle("Veuillez sélectioner le fichier photo");
            jFileChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jFileChooser.setOpaque(true);
            jFileChooser.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jFileChooserActionPerformed(evt);
                }
            });
            getContentPane().add(jFileChooser);
            jFileChooser.setBounds(170, 100, 583, 385);

            llblTitreLivre.setText("Titre du livre :");
            llblTitreLivre.setMaximumSize(new java.awt.Dimension(20, 40));
            llblTitreLivre.setOpaque(true);
            getContentPane().add(llblTitreLivre);
            llblTitreLivre.setBounds(30, 10, 90, 20);
            getContentPane().add(jtfTitreLivre);
            jtfTitreLivre.setBounds(20, 30, 500, 30);

            jlblSousTitreLivre.setText("Sous titre :");
            jlblSousTitreLivre.setMaximumSize(new java.awt.Dimension(20, 40));
            jlblSousTitreLivre.setOpaque(true);
            getContentPane().add(jlblSousTitreLivre);
            jlblSousTitreLivre.setBounds(30, 70, 190, 14);
            getContentPane().add(jtfSousTitreLivre);
            jtfSousTitreLivre.setBounds(20, 90, 500, 30);

            jlblFormatLivre.setText("Format Livre :");
            jlblFormatLivre.setMaximumSize(new java.awt.Dimension(20, 40));
            jlblFormatLivre.setOpaque(true);
            getContentPane().add(jlblFormatLivre);
            jlblFormatLivre.setBounds(30, 140, 100, 14);
            getContentPane().add(jtfFormatLivre);
            jtfFormatLivre.setBounds(20, 160, 120, 30);

            jlblNbPages.setText("Nombre de pages :");
            jlblNbPages.setOpaque(true);
            getContentPane().add(jlblNbPages);
            jlblNbPages.setBounds(200, 140, 110, 20);
            getContentPane().add(jtfNbPagesLivre);
            jtfNbPagesLivre.setBounds(200, 160, 150, 30);

            jlblPoidsLivre.setText("Poids du livre : ");
            jlblPoidsLivre.setOpaque(true);
            getContentPane().add(jlblPoidsLivre);
            jlblPoidsLivre.setBounds(410, 140, 110, 14);
            getContentPane().add(jtfPoidsLivre);
            jtfPoidsLivre.setBounds(410, 160, 140, 30);

            jlblDimensionLivre.setText("Dimensions :");
            jlblDimensionLivre.setMaximumSize(new java.awt.Dimension(20, 40));
            jlblDimensionLivre.setOpaque(true);
            getContentPane().add(jlblDimensionLivre);
            jlblDimensionLivre.setBounds(600, 140, 100, 20);
            getContentPane().add(jtfDimensionLivre);
            jtfDimensionLivre.setBounds(580, 160, 150, 30);

            jlblEditionLivre.setText("No d'édition du livre :");
            jlblEditionLivre.setOpaque(true);
            getContentPane().add(jlblEditionLivre);
            jlblEditionLivre.setBounds(30, 200, 120, 14);
            getContentPane().add(jtfEditionLivre);
            jtfEditionLivre.setBounds(20, 220, 140, 30);

            jlblDateParution.setText("Date de parution (AAAAMMJJ) :");
            jlblDateParution.setMaximumSize(new java.awt.Dimension(20, 40));
            jlblDateParution.setOpaque(true);
            getContentPane().add(jlblDateParution);
            jlblDateParution.setBounds(200, 200, 180, 20);
            getContentPane().add(jtfDateParutionLivre);
            jtfDateParutionLivre.setBounds(200, 220, 150, 30);

            jlblPrixLivre.setText("Prix :");
            jlblPrixLivre.setMaximumSize(new java.awt.Dimension(20, 40));
            jlblPrixLivre.setOpaque(true);
            getContentPane().add(jlblPrixLivre);
            jlblPrixLivre.setBounds(410, 200, 110, 14);
            getContentPane().add(jtfPrixLivre);
            jtfPrixLivre.setBounds(410, 220, 150, 30);

            jlblStockLivre.setText("Stock :");
            getContentPane().add(jlblStockLivre);
            jlblStockLivre.setBounds(600, 200, 100, 14);
            getContentPane().add(jtfStockLivre);
            jtfStockLivre.setBounds(580, 220, 150, 30);

            jlblISBN10.setText("ISBN 10 :");
            getContentPane().add(jlblISBN10);
            jlblISBN10.setBounds(30, 260, 140, 14);
            getContentPane().add(jtfISBN10);
            jtfISBN10.setBounds(200, 260, 370, 30);

            jlblISBN13.setText("ISBN 13 :");
            getContentPane().add(jlblISBN13);
            jlblISBN13.setBounds(30, 300, 140, 20);
            getContentPane().add(jtfISBN13);
            jtfISBN13.setBounds(200, 300, 370, 30);

            jlblPhotoLivre.setText("Nom fichier photo du livre :");
            getContentPane().add(jlblPhotoLivre);
            jlblPhotoLivre.setBounds(30, 350, 150, 14);
            getContentPane().add(jtfPhotoLivre);
            jtfPhotoLivre.setBounds(200, 340, 310, 30);

            jbFileChooser.setText("...");
            jbFileChooser.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbFileChooserActionPerformed(evt);
                }
            });
            getContentPane().add(jbFileChooser);
            jbFileChooser.setBounds(520, 340, 50, 30);

            jLabel4.setText("Résumé :");
            getContentPane().add(jLabel4);
            jLabel4.setBounds(30, 390, 100, 14);

            jtaResume.setColumns(20);
            jtaResume.setRows(5);
            jScrollPane1.setViewportView(jtaResume);

            getContentPane().add(jScrollPane1);
            jScrollPane1.setBounds(20, 410, 480, 100);

            jlblEditeur.setText("Editeur :");
            getContentPane().add(jlblEditeur);
            jlblEditeur.setBounds(530, 10, 90, 20);

            jcbEditeur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Editeur" }));
            getContentPane().add(jcbEditeur);
            jcbEditeur.setBounds(620, 10, 180, 20);

            jbAjoutEditeur.setText("...");
            jbAjoutEditeur.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbAjoutEditeurActionPerformed(evt);
                }
            });
            getContentPane().add(jbAjoutEditeur);
            jbAjoutEditeur.setBounds(810, 10, 30, 20);

            jlblAuteur.setText("Auteur :");
            getContentPane().add(jlblAuteur);
            jlblAuteur.setBounds(530, 40, 70, 20);

            jcbAuteur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auteur" }));
            getContentPane().add(jcbAuteur);
            jcbAuteur.setBounds(620, 40, 180, 20);

            jbAjoutAuteur.setText("...");
            jbAjoutAuteur.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbAjoutAuteurActionPerformed(evt);
                }
            });
            getContentPane().add(jbAjoutAuteur);
            jbAjoutAuteur.setBounds(810, 40, 30, 20);

            jlblSousTheme.setText("Sous Thème :");
            getContentPane().add(jlblSousTheme);
            jlblSousTheme.setBounds(530, 70, 90, 20);

            jcbSousTheme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sous Theme" }));
            getContentPane().add(jcbSousTheme);
            jcbSousTheme.setBounds(620, 70, 180, 20);

            jbAjoutSousTheme.setText("...");
            jbAjoutSousTheme.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbAjoutSousThemeActionPerformed(evt);
                }
            });
            getContentPane().add(jbAjoutSousTheme);
            jbAjoutSousTheme.setBounds(810, 70, 30, 20);

            jlblFournisseur.setText("Fournisseur :");
            getContentPane().add(jlblFournisseur);
            jlblFournisseur.setBounds(530, 100, 90, 20);

            jcbFournisseur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fournisseur" }));
            getContentPane().add(jcbFournisseur);
            jcbFournisseur.setBounds(620, 100, 180, 20);

            jlblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jlblImage.setText("Photo du livre");
            jlblImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
            getContentPane().add(jlblImage);
            jlblImage.setBounds(580, 260, 260, 200);

            jtbActif.setSelected(true);
            jtbActif.setText("Actif");
            jtbActif.setToolTipText("Actif / Inactif");
            jtbActif.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jtbActifActionPerformed(evt);
                }
            });
            getContentPane().add(jtbActif);
            jtbActif.setBounds(540, 480, 120, 23);

            jbtnValider.setText("Valider");
            jbtnValider.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbtnValiderActionPerformed(evt);
                }
            });
            getContentPane().add(jbtnValider);
            jbtnValider.setBounds(720, 480, 110, 23);

            setBounds(0, 0, 863, 551);
        }// </editor-fold>//GEN-END:initComponents

    private void jbtnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnValiderActionPerformed
        if (modeCMS.equals("C")) {
            if (JOptionPane.showConfirmDialog(this, "Etes-vous sûr de vouloir créer ce livre ?", "Confirmation", YES_NO_OPTION)==YES_OPTION){
                creer();
                try{
                    connection.close();
                } catch ( SQLException ex) {
                    JOptionPane.showMessageDialog(this,"erreur base de données "+ ex.getErrorCode());
                }
                this.dispose();
            }
        } else if (modeCMS.equals("S")) {
            if (JOptionPane.showConfirmDialog(this, "Etes-vous sûr de vouloir supprimer ce livre ?", "Confirmation", YES_NO_OPTION)==YES_OPTION){
                supprimer();
                try{
                    connection.close();
                } catch ( SQLException ex) {
                    JOptionPane.showMessageDialog(this,"erreur base de données "+ ex.getErrorCode());
                }
                this.dispose();
            }
        } else if (modeCMS.equals("M")) {
            if (JOptionPane.showConfirmDialog(this, "Etes-vous sûr de vouloir modifier ce livre ?", "Confirmation", YES_NO_OPTION)==YES_OPTION){
                modifier();
                try{
                    connection.close();
                } catch ( SQLException ex) {
                    JOptionPane.showMessageDialog(this,"erreur base de données "+ ex.getErrorCode());
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_jbtnValiderActionPerformed

    private void jtbActifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbActifActionPerformed
        if (jtbActif.isSelected()) {
            jtbActif.setText("Actif");
        } else {
            jtbActif.setText("Inactif");
        }
    }//GEN-LAST:event_jtbActifActionPerformed

    private void jbFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFileChooserActionPerformed
        if (!jFileChooser.isVisible()){
            jFileChooser.setVisible(true);
        }
    }//GEN-LAST:event_jbFileChooserActionPerformed

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
        if (evt.getActionCommand()=="CancelSelection"){ // Btn Cancel
            jFileChooser.setVisible(false);
        } else { // Btn ouvrir
            File f;
            f=jFileChooser.getSelectedFile();
            jtfPhotoLivre.setText(f.getName());
            jFileChooser.setVisible(false);
        }
    }//GEN-LAST:event_jFileChooserActionPerformed

    private void jbAjoutEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjoutEditeurActionPerformed
        jiEditeurCreation e = new jiEditeurCreation(ir);
        ir.getmainFrame().add(e);
        e.setVisible(true);
        e.toFront();
    }//GEN-LAST:event_jbAjoutEditeurActionPerformed

    private void jbAjoutSousThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjoutSousThemeActionPerformed
        AffichageTheme a = new AffichageTheme(ir);
        ir.getmainFrame().add(a);
        a.setVisible(true);
        a.toFront();
    }//GEN-LAST:event_jbAjoutSousThemeActionPerformed

    private void jbAjoutAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjoutAuteurActionPerformed
        jiAuteurCreation a = new jiAuteurCreation(ir);
        ir.getmainFrame().add(a);
        a.setVisible(true);
        a.toFront();
    }//GEN-LAST:event_jbAjoutAuteurActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAjoutAuteur;
    private javax.swing.JButton jbAjoutEditeur;
    private javax.swing.JButton jbAjoutSousTheme;
    private javax.swing.JButton jbFileChooser;
    private javax.swing.JButton jbtnValider;
    private javax.swing.JComboBox jcbAuteur;
    private javax.swing.JComboBox jcbEditeur;
    private javax.swing.JComboBox jcbFournisseur;
    private javax.swing.JComboBox jcbSousTheme;
    private javax.swing.JLabel jlblAuteur;
    private javax.swing.JLabel jlblDateParution;
    private javax.swing.JLabel jlblDimensionLivre;
    private javax.swing.JLabel jlblEditeur;
    private javax.swing.JLabel jlblEditionLivre;
    private javax.swing.JLabel jlblFormatLivre;
    private javax.swing.JLabel jlblFournisseur;
    private javax.swing.JLabel jlblISBN10;
    private javax.swing.JLabel jlblISBN13;
    private javax.swing.JLabel jlblImage;
    private javax.swing.JLabel jlblNbPages;
    private javax.swing.JLabel jlblPhotoLivre;
    private javax.swing.JLabel jlblPoidsLivre;
    private javax.swing.JLabel jlblPrixLivre;
    private javax.swing.JLabel jlblSousTheme;
    private javax.swing.JLabel jlblSousTitreLivre;
    private javax.swing.JLabel jlblStockLivre;
    private javax.swing.JTextArea jtaResume;
    private javax.swing.JToggleButton jtbActif;
    private javax.swing.JTextField jtfDateParutionLivre;
    private javax.swing.JTextField jtfDimensionLivre;
    private javax.swing.JTextField jtfEditionLivre;
    private javax.swing.JTextField jtfFormatLivre;
    private javax.swing.JTextField jtfISBN10;
    private javax.swing.JTextField jtfISBN13;
    private javax.swing.JTextField jtfNbPagesLivre;
    private javax.swing.JTextField jtfPhotoLivre;
    private javax.swing.JTextField jtfPoidsLivre;
    private javax.swing.JTextField jtfPrixLivre;
    private javax.swing.JTextField jtfSousTitreLivre;
    private javax.swing.JTextField jtfStockLivre;
    private javax.swing.JTextField jtfTitreLivre;
    private javax.swing.JLabel llblTitreLivre;
    // End of variables declaration//GEN-END:variables
}
