package baselivre.ui.livre;

import baselivre.produit.Livre;
import baselivre.produit.Theme;
import baselivre.ui.frame.InterfaceRoot;
import baselivre.ui.root.Root;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jiLivreAffichage extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private String titre;
    private String auteur;
    private String editeur;
    private String theme;
    private String isbn13;
    private InterfaceRoot ir;

    public jiLivreAffichage(InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        initComponents();
        jrbISBN10.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgISBN = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListeLivre = new javax.swing.JTable();
        jbtnCree = new javax.swing.JButton();
        jbtnModifier = new javax.swing.JButton();
        jbtnSupprimer = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfTitre = new javax.swing.JTextField();
        jtfAuteur = new javax.swing.JTextField();
        jtfEditeur = new javax.swing.JTextField();
        jbtnTriFiltre = new javax.swing.JButton();
        jlblTitre = new javax.swing.JLabel();
        jlblAuteur = new javax.swing.JLabel();
        jlblEditeur = new javax.swing.JLabel();
        jcbTheme = new javax.swing.JComboBox();
        jlblTheme = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtfISBN = new javax.swing.JTextField();
        jbtnISBN = new javax.swing.JButton();
        jrbISBN10 = new javax.swing.JRadioButton();
        jrbISBN13 = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(" Affichage livre"));
        setClosable(true);
        setTitle("Recherche livre");
        getContentPane().setLayout(null);

        jtListeLivre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Titre", "Auteur", "Editeur", "Thème", "ISBN 10", "ISBN 13"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtListeLivre);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 920, 150);

        jbtnCree.setText("Créer");
        jbtnCree.setMaximumSize(new java.awt.Dimension(81, 23));
        jbtnCree.setMinimumSize(new java.awt.Dimension(81, 23));
        jbtnCree.setPreferredSize(new java.awt.Dimension(81, 23));
        jbtnCree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreeActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCree);
        jbtnCree.setBounds(150, 360, 80, 30);

        jbtnModifier.setText("Modifier");
        jbtnModifier.setMaximumSize(new java.awt.Dimension(81, 23));
        jbtnModifier.setMinimumSize(new java.awt.Dimension(81, 23));
        jbtnModifier.setPreferredSize(new java.awt.Dimension(81, 23));
        jbtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModifierActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnModifier);
        jbtnModifier.setBounds(410, 360, 80, 30);

        jbtnSupprimer.setText("Supprimer");
        jbtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSupprimerActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSupprimer);
        jbtnSupprimer.setBounds(680, 360, 80, 30);

        jPanel1.setLayout(null);
        jPanel1.add(jtfTitre);
        jtfTitre.setBounds(20, 40, 190, 30);
        jPanel1.add(jtfAuteur);
        jtfAuteur.setBounds(240, 40, 180, 30);
        jPanel1.add(jtfEditeur);
        jtfEditeur.setBounds(440, 40, 170, 30);

        jbtnTriFiltre.setText("OK");
        jbtnTriFiltre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTriFiltreActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnTriFiltre);
        jbtnTriFiltre.setBounds(820, 40, 60, 30);

        jlblTitre.setText(" Titre :");
        jlblTitre.setOpaque(true);
        jPanel1.add(jlblTitre);
        jlblTitre.setBounds(20, 10, 60, 20);

        jlblAuteur.setText(" Auteur :");
        jPanel1.add(jlblAuteur);
        jlblAuteur.setBounds(240, 10, 60, 20);

        jlblEditeur.setText(" Editeur :");
        jPanel1.add(jlblEditeur);
        jlblEditeur.setBounds(440, 10, 80, 20);

        jcbTheme.setModel(initTheme());
        jPanel1.add(jcbTheme);
        jcbTheme.setBounds(640, 40, 160, 30);

        jlblTheme.setText(" Thème :");
        jPanel1.add(jlblTheme);
        jlblTheme.setBounds(640, 10, 120, 20);

        jTabbedPane1.addTab("Recherche par Titre/Auteur/Editeur", jPanel1);

        jPanel2.setLayout(null);
        jPanel2.add(jtfISBN);
        jtfISBN.setBounds(380, 30, 320, 30);

        jbtnISBN.setText("OK");
        jbtnISBN.setMaximumSize(new java.awt.Dimension(81, 23));
        jbtnISBN.setMinimumSize(new java.awt.Dimension(81, 23));
        jbtnISBN.setPreferredSize(new java.awt.Dimension(81, 23));
        jbtnISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnISBNActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnISBN);
        jbtnISBN.setBounds(790, 30, 70, 30);

        bgISBN.add(jrbISBN10);
        jrbISBN10.setText(" ISBN 10");
        jPanel2.add(jrbISBN10);
        jrbISBN10.setBounds(30, 40, 90, 23);

        bgISBN.add(jrbISBN13);
        jrbISBN13.setText("ISBN 13");
        jPanel2.add(jrbISBN13);
        jrbISBN13.setBounds(210, 40, 90, 23);

        jTabbedPane1.addTab("Recherche par ISBN", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 20, 920, 120);

        setBounds(0, 0, 974, 516);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Rechercher un livre à partir du numéro ISBN (10 ou 13) dans la base de
     * données s'il existe ou pas
     *
     * @param evt
     */
    private void jbtnISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnISBNActionPerformed

        //Pour la vérification de l'ISBN 10 ou 13 dans le bon format. 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Driver base de donnée");
        }

        
        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Err connexion !!" + ex.getMessage());

        }
        //String query = "";
        boolean essai = false;
        String query = "SELECT temp.id_livre as 'id_livre', "
                + " (select livre_titre from livre where livre.id_livre=temp.id_livre) as 'Titre', "
                + " (select auteur_nom from ecriture inner join auteur on ecriture.id_auteur=auteur.id_auteur "
                + " where ecriture.id_livre=temp.id_livre) as 'Auteur', "
                + " (select editeur_nom from editeur inner join livre on editeur.id_editeur=livre.id_editeur "
                + " where livre.id_livre=temp.id_livre) as 'Editeur', "
                + " (select theme_nom from theme "
                + " inner join soustheme on theme.id_theme=soustheme.id_soustheme "
                + " inner join livre on livre.id_soustheme=soustheme.id_soustheme "
                + " where livre.id_livre=temp.id_livre) as 'Theme',  "
                + " (select livre_isbn10 from livre where livre.id_livre=temp.id_livre) as 'ISBN10', "
                + " (select livre_isbn13 from livre where livre.id_livre=temp.id_livre) as 'ISBN13', "
                + " (select livre_actif from livre where livre.id_livre=temp.id_livre) as 'Etat' "
                + " FROM (select l.id_livre from livre l ";
        String chaine = jtfISBN.getText();
        if (jrbISBN10.isSelected()) {

            Pattern pt = Pattern.compile("([0-9]{1}[-| ][0-9]*[-| ][0-9]*[-| ][0-9]{1})");
            Pattern pt2 = Pattern.compile("([0-9]*{10})");

            Matcher matcher = pt.matcher(chaine);
            Matcher matcher2 = pt2.matcher(chaine);

            if (matcher.matches() && chaine.length() == 13 || matcher2.matches()) {
                query += "WHERE livre_isbn10 LIKE '" + chaine + "') AS temp";
                essai = true;
            } else {
                JOptionPane.showMessageDialog(this, "Format ISBN 10 non valide");

            }
        } else if (jrbISBN13.isSelected()) {

            Pattern pt = Pattern.compile("([0-9]{3}[-| ][0-9]{1}[-| ][0-9]*[-| ][0-9]*[-| ][0-9]{1})");
            Pattern pt3 = Pattern.compile("([0-9]*{13})");

            Matcher matcher = pt.matcher(chaine);
            Matcher matcher3 = pt3.matcher(chaine);
            if (matcher.matches() && chaine.length() == 17 || matcher3.matches()) {
                query += "WHERE livre_isbn13 LIKE '" + chaine + "') AS temp";
                essai = true;
            } else {
                JOptionPane.showMessageDialog(this, "Format ISBN 13 non valide");

            }
        }

        if (true == essai) {
            try {
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                Vector v = new Vector();
                String etat;

                while (rs.next()) {
                    Vector vv = new Vector();
                    if (rs.getInt("Etat") == 1) {
                        etat = "Actif";
                    } else {
                        etat = "Inactif";
                    }
                    vv.add(rs.getString("Titre"));
                    vv.add(rs.getString("Auteur"));
                    vv.add(rs.getString("Editeur"));
                    vv.add(rs.getString("Theme"));
                    vv.add(rs.getString("ISBN10"));
                    vv.add(rs.getString("ISBN13"));
                    vv.add(etat);
                    v.add(vv);

                }
                Vector vtitre = new Vector();
                vtitre.add("Titre");
                vtitre.add("Auteur");
                vtitre.add("Editeur");
                vtitre.add("Theme");
                vtitre.add("ISBN 10");
                vtitre.add("ISBN 13");
                vtitre.add("Etat");
                DefaultTableModel tm = new DefaultTableModel(v, vtitre) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                jtListeLivre.setModel(tm);

                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "SQL !! " + ex.getMessage());

            }
        }
        //Fermeture de la connexion
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Base de Données" + ex.getMessage());
        }


    }//GEN-LAST:event_jbtnISBNActionPerformed

    /**
     * Recherche d'un livre en affichant tous les livres présents dans la base
     * en cliquant sur ok, ou bien en ciblant un critère voir plus par
     * remplissage d'un ou de plusieurs champs (Titre, Auteur, Editeur; Thème).
     *
     * @param evt
     */
    private void jbtnTriFiltreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTriFiltreActionPerformed

        // ouverture connexion
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Diver non trouvé !");

        }
        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de connexion" + ex.getMessage());

        }
        String query = "SELECT temp.id_livre as 'id_livre', "
                + " (select livre_titre from livre where livre.id_livre=temp.id_livre) as 'Titre', "
                + " (select auteur_nom from ecriture inner join auteur on ecriture.id_auteur=auteur.id_auteur "
                + " where ecriture.id_livre=temp.id_livre) as 'Auteur', "
                + " (select editeur_nom from editeur inner join livre on editeur.id_editeur=livre.id_editeur "
                + " where livre.id_livre=temp.id_livre) as 'Editeur', "
                + " (select theme_nom from theme "
                + " inner join soustheme on theme.id_theme=soustheme.id_soustheme "
                + " inner join livre on livre.id_soustheme=soustheme.id_soustheme "
                + " where livre.id_livre=temp.id_livre) as 'Theme',  "
                + " (select livre_isbn10 from livre where livre.id_livre=temp.id_livre) as 'ISBN10', "
                + " (select livre_isbn13 from livre where livre.id_livre=temp.id_livre) as 'ISBN13', "
                + " (select livre_actif from livre where livre.id_livre=temp.id_livre) as 'Etat' "
                + " FROM (select l.id_livre from livre l ";

        if (!jtfAuteur.getText().equalsIgnoreCase("")) {

            query += "INNER JOIN ecriture ON ecriture.id_livre = l.id_livre "
                    + " INNER JOIN auteur ON auteur.id_auteur = ecriture.id_auteur AND auteur_nom  LIKE '%" + jtfAuteur.getText() + "%' ";
        }
        if (!jtfEditeur.getText().equalsIgnoreCase("")) {
            query += " INNER JOIN editeur ON editeur.id_editeur = l.id_editeur "
                    + " AND editeur_nom  LIKE '%" + jtfEditeur.getText() + "%' ";
        }
        if (jcbTheme.getSelectedItem() instanceof Theme) {
            query += " INNER JOIN soustheme ON soustheme.id_soustheme = l.id_soustheme "
                    + " INNER JOIN theme ON theme.id_theme = soustheme.id_theme AND theme.id_theme = "
                    + ((Theme) jcbTheme.getSelectedItem()).getId_theme();
        }
//        query += " WHERE l.livre_actif = 1 ";
        if (!jtfTitre.getText().equalsIgnoreCase("")) {
            query += " WHERE l.livre_titre LIKE '%" + jtfTitre.getText() + "%' ";
        }
        query += ") AS temp ORDER BY Titre DESC; ";

        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Vector v = new Vector();
            String etat;
            while (rs.next()) {
                Vector vv = new Vector();
                if (rs.getInt("Etat") == 1) {
                    etat = "Actif";
                } else {
                    etat = "Inactif";
                }
                vv.add(rs.getString("Titre"));
                vv.add(rs.getString("Auteur"));
                vv.add(rs.getString("Editeur"));
                vv.add(rs.getString("Theme"));
                vv.add(rs.getString("ISBN10"));
                vv.add(rs.getString("ISBN13"));
                vv.add(etat);
                v.add(vv);

            }
            Vector vtitre = new Vector();
            vtitre.add("Titre");
            vtitre.add("Auteur");
            vtitre.add("Editeur");
            vtitre.add("Theme");
            vtitre.add("ISBN 10");
            vtitre.add("ISBN 13");
            vtitre.add("Etat");
            DefaultTableModel tm = new DefaultTableModel(v, vtitre) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jtListeLivre.setModel(tm);

            //jScrollPane1.setViewportView(jtListeLivre);
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL\n" + ex.getMessage());

        } catch (Throwable ex) {
            Logger.getLogger(jiLivreAffichage.class.getName()).log(Level.SEVERE, null, ex);
        }
        // try catch avec jdialogueFrame

        //Fermeture de la connexion
        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur à la fermeture de la connexion" + ex.getMessage());
        }

    }//GEN-LAST:event_jbtnTriFiltreActionPerformed

    /**
     * Ajout d'un nouveau livre dans la base de données
     * @param evt 
     */
    
    private void jbtnCreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreeActionPerformed
        FicheLivre ficheL = new FicheLivre(ir, "C", "");
        ir.getmainFrame().add(ficheL);
        ficheL.setVisible(true);
        ficheL.toFront();
    }//GEN-LAST:event_jbtnCreeActionPerformed

    /**
     * Modifier une fiche livre
     * @param evt 
     */
    private void jbtnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModifierActionPerformed
        int rowSelected = jtListeLivre.getSelectedRow();
        if (rowSelected != -1) {
            isbn13 = jtListeLivre.getValueAt(rowSelected,5).toString();
            FicheLivre ficheL = new FicheLivre(ir, "M", isbn13);
            ir.getmainFrame().add(ficheL);
            ficheL.setVisible(true);
            ficheL.toFront();
        } else {
            JOptionPane.showMessageDialog(null, "Selectionnez une ligne !");
        }

    }//GEN-LAST:event_jbtnModifierActionPerformed

    /**
     * Suppression d'une fiche live
     * @param evt 
     */
    private void jbtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSupprimerActionPerformed
        int rowSelected = jtListeLivre.getSelectedRow();
        if (rowSelected != -1) {
            isbn13 = jtListeLivre.getValueAt(rowSelected,5).toString();
            FicheLivre ficheL = new FicheLivre(ir, "S", isbn13);
            ir.getmainFrame().add(ficheL);
            ficheL.setVisible(true);
            ficheL.toFront();
        } else {
            JOptionPane.showMessageDialog(null, "Selectionnez une ligne !");
        }
    }//GEN-LAST:event_jbtnSupprimerActionPerformed

    /**
     * Affichage de tous les thèmes dans la combobox jcbTheme
     * @return une comboBoxModel 
     */
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
            connexion = DriverManager.getConnection(sqlConnexion);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgISBN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnCree;
    private javax.swing.JButton jbtnISBN;
    private javax.swing.JButton jbtnModifier;
    private javax.swing.JButton jbtnSupprimer;
    private javax.swing.JButton jbtnTriFiltre;
    private javax.swing.JComboBox jcbTheme;
    private javax.swing.JLabel jlblAuteur;
    private javax.swing.JLabel jlblEditeur;
    private javax.swing.JLabel jlblTheme;
    private javax.swing.JLabel jlblTitre;
    private javax.swing.JRadioButton jrbISBN10;
    private javax.swing.JRadioButton jrbISBN13;
    private javax.swing.JTable jtListeLivre;
    private javax.swing.JTextField jtfAuteur;
    private javax.swing.JTextField jtfEditeur;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfTitre;
    // End of variables declaration//GEN-END:variables

}
