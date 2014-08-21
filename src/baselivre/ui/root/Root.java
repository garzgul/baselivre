
package baselivre.ui.root;


import baselivre.ui.acheteur.jiAffichageAcheteur;
import baselivre.ui.auteur.jiAuteurAffichage;
import baselivre.ui.auteur.jiAuteurCreation;
import baselivre.ui.cdeaffichage.jiCdeAffichage;
import baselivre.ui.commande.ParametresCommande;
import baselivre.ui.editeur.jiEditeurAffichage;
import baselivre.ui.editeur.jiEditeurCreation;
import baselivre.ui.frame.InterfaceRoot;
import baselivre.ui.gestionstock.jiGestionStock;
import baselivre.ui.livre.AffichageTheme;
import baselivre.ui.livre.FicheLivre;
import baselivre.ui.livre.jiLivreAffichage;
import baselivre.ui.referencement.jiRefAuteur;
import baselivre.ui.referencement.jiRefEditeur;
import baselivre.ui.referencement.jiRefLivre;
import baselivre.ui.rubrique.jiGestionRubrique;
import baselivre.ui.userconnect.jdConnexionUser;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Root extends javax.swing.JFrame implements InterfaceRoot {
    
    private String sqlConnexion = "jdbc:sqlserver://localhost:1433;" +
         "databaseName=baselivre;";
    

    @Override
    public String SqlConnexion() {
        return sqlConnexion;
    }

    public void setSqlConnexion(String sqlConnexion) {
        this.sqlConnexion = sqlConnexion;
    }
    
    public String getSqlConnexion(){
        return sqlConnexion;
    }
            

    
    public Root() {
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jDP = new javax.swing.JDesktopPane()
        {
            BufferedImage img;
            {
                try{
                    img = ImageIO.read(getClass().getResource("/resource/carpediemlogofinal24.jpg"));

                }catch (IOException ex){
                    ex.printStackTrace();

                }
            }
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(img, 0, 0,getWidth(),getHeight(), this);
            }
        }

        ;
        jPanel1 = new javax.swing.JPanel();
        jBComment = new javax.swing.JButton();
        jBStock = new javax.swing.JButton();
        jBConnect = new javax.swing.JButton();
        jMenuroot = new javax.swing.JMenuBar();
        jMLibrairie = new javax.swing.JMenu();
        jMLivre = new javax.swing.JMenu();
        jMRechercheLivre = new javax.swing.JMenuItem();
        jMNewLivre = new javax.swing.JMenuItem();
        jMAuteur = new javax.swing.JMenu();
        jMRechercheAuteur = new javax.swing.JMenuItem();
        jMNewAuteur = new javax.swing.JMenuItem();
        jMEditeur = new javax.swing.JMenu();
        jMRechercheEditeur = new javax.swing.JMenuItem();
        jMNewEditeur = new javax.swing.JMenuItem();
        jMRubrique = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMTheme = new javax.swing.JMenu();
        jMRechercheTheme = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMRef = new javax.swing.JMenu();
        jMRefLivre = new javax.swing.JMenuItem();
        jMRefAuteur = new javax.swing.JMenuItem();
        jMRefEditeur = new javax.swing.JMenuItem();
        jMStock = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMQuitter = new javax.swing.JMenuItem();
        jMAcheteur = new javax.swing.JMenu();
        jMGestionAcheteur = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMCommande = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMParametreCommande = new javax.swing.JMenuItem();
        jMUser = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenu4.setText("jMenu4");

        jMenuItem16.setText("jMenuItem16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jDP, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 50));

        jBComment.setText("Validation Commentaire");

        jBStock.setText("Gestion Stock");
        jBStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStockActionPerformed(evt);
            }
        });

        jBConnect.setText("Parametres Connexion");
        jBConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jBConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBStock, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jBComment, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBConnect)
                    .addComponent(jBStock)
                    .addComponent(jBComment))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jMLibrairie.setText("librairie");

        jMLivre.setText("Livre");

        jMRechercheLivre.setText("Recherche livre");
        jMRechercheLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRechercheLivreActionPerformed(evt);
            }
        });
        jMLivre.add(jMRechercheLivre);

        jMNewLivre.setText("Nouveau titre");
        jMNewLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNewLivreActionPerformed(evt);
            }
        });
        jMLivre.add(jMNewLivre);

        jMLibrairie.add(jMLivre);

        jMAuteur.setText("Auteur");

        jMRechercheAuteur.setText("Recherche Auteur");
        jMRechercheAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRechercheAuteurActionPerformed(evt);
            }
        });
        jMAuteur.add(jMRechercheAuteur);

        jMNewAuteur.setText("Nouvel auteur");
        jMNewAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNewAuteurActionPerformed(evt);
            }
        });
        jMAuteur.add(jMNewAuteur);

        jMLibrairie.add(jMAuteur);

        jMEditeur.setText("Editeur");

        jMRechercheEditeur.setText("Recherche Editeur");
        jMRechercheEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRechercheEditeurActionPerformed(evt);
            }
        });
        jMEditeur.add(jMRechercheEditeur);

        jMNewEditeur.setText("Creer editeur");
        jMNewEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNewEditeurActionPerformed(evt);
            }
        });
        jMEditeur.add(jMNewEditeur);

        jMLibrairie.add(jMEditeur);

        jMRubrique.setText("Gestion rubrique");

        jMenu6.setText("Rubrique");

        jMenuItem17.setText("Gestion Rubrique");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuItem15.setText("Nouvelle Rubrique");
        jMenu6.add(jMenuItem15);

        jMRubrique.add(jMenu6);

        jMenu7.setText("Promotion");

        jMenuItem18.setText("Gestion promotion");
        jMenu7.add(jMenuItem18);

        jMenuItem19.setText("Nouvelle promotion");
        jMenu7.add(jMenuItem19);

        jMRubrique.add(jMenu7);

        jMLibrairie.add(jMRubrique);

        jMTheme.setText("Gestion theme");

        jMRechercheTheme.setText("Theme");
        jMRechercheTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRechercheThemeActionPerformed(evt);
            }
        });
        jMTheme.add(jMRechercheTheme);

        jMLibrairie.add(jMTheme);
        jMLibrairie.add(jSeparator4);

        jMRef.setText("Referencement");

        jMRefLivre.setText("Livre");
        jMRefLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRefLivreActionPerformed(evt);
            }
        });
        jMRef.add(jMRefLivre);

        jMRefAuteur.setText("Auteur");
        jMRefAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRefAuteurActionPerformed(evt);
            }
        });
        jMRef.add(jMRefAuteur);

        jMRefEditeur.setText("Editeur");
        jMRefEditeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRefEditeurActionPerformed(evt);
            }
        });
        jMRef.add(jMRefEditeur);

        jMLibrairie.add(jMRef);

        jMStock.setText("Gestion Stock");
        jMStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMStockActionPerformed(evt);
            }
        });
        jMLibrairie.add(jMStock);
        jMLibrairie.add(jSeparator2);

        jMQuitter.setText("Quitter");
        jMQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMQuitterActionPerformed(evt);
            }
        });
        jMLibrairie.add(jMQuitter);

        jMenuroot.add(jMLibrairie);

        jMAcheteur.setText("gestion acheteur");

        jMGestionAcheteur.setText("Gestion Acheteur");

        jMenuItem5.setText("Affichage");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMGestionAcheteur.add(jMenuItem5);

        jMenuItem6.setText("Creation Acheteur");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMGestionAcheteur.add(jMenuItem6);

        jMAcheteur.add(jMGestionAcheteur);

        jMenu9.setText("Commentaire");

        jMenuItem22.setText("Gestion Commentaire");
        jMenu9.add(jMenuItem22);

        jMenuItem23.setText("Validation Commentaire");
        jMenu9.add(jMenuItem23);

        jMAcheteur.add(jMenu9);

        jMenuroot.add(jMAcheteur);

        jMCommande.setText("gestion commande");

        jMenuItem7.setText("Affichage Commande");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMCommande.add(jMenuItem7);

        jMParametreCommande.setText("Parametres Commande");
        jMParametreCommande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMParametreCommandeActionPerformed(evt);
            }
        });
        jMCommande.add(jMParametreCommande);

        jMenuroot.add(jMCommande);

        jMUser.setText("gestion utilisateur");

        jMenuItem9.setText("Gestion utilisateur ");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMUser.add(jMenuItem9);

        jMenuroot.add(jMUser);

        setJMenuBar(jMenuroot);

        setSize(new java.awt.Dimension(1374, 797));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMQuitterActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMQuitterActionPerformed

    private void jMNewAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNewAuteurActionPerformed
        jiAuteurCreation auteur = new jiAuteurCreation(this);
        jDP.add(auteur);
        auteur.setVisible(true);
        auteur.toFront();
    }//GEN-LAST:event_jMNewAuteurActionPerformed

    private void jBConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConnectActionPerformed
        jdConnexionUser connect = new jdConnexionUser(this, false,this);
        connect.setVisible(true);
        connect.toFront();
    }//GEN-LAST:event_jBConnectActionPerformed

    private void jMRefAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRefAuteurActionPerformed
        jiRefAuteur RefAuteur = new jiRefAuteur(this);
        jDP.add(RefAuteur);
        RefAuteur.setVisible(true);
        RefAuteur.toFront();
    }//GEN-LAST:event_jMRefAuteurActionPerformed

    private void jMRefEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRefEditeurActionPerformed
        jiRefEditeur RefEditeur = new jiRefEditeur(this);
        jDP.add(RefEditeur);
        RefEditeur.setVisible(true);
        RefEditeur.toFront();
    }//GEN-LAST:event_jMRefEditeurActionPerformed

    private void jMNewEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNewEditeurActionPerformed
        jiEditeurCreation editeurCrea = new jiEditeurCreation(this);
        jDP.add(editeurCrea);
        editeurCrea.setVisible(true);
        editeurCrea.toFront();
    }//GEN-LAST:event_jMNewEditeurActionPerformed

    private void jMRechercheLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRechercheLivreActionPerformed
        jiLivreAffichage livreScreen = new jiLivreAffichage(this);
        jDP.add(livreScreen);
        livreScreen.setVisible(true);
        livreScreen.toFront();
    }//GEN-LAST:event_jMRechercheLivreActionPerformed

    private void jMStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMStockActionPerformed
        jiGestionStock gestion = new jiGestionStock(this);
        jDP.add(gestion);
        gestion.setVisible(true);
        gestion.toFront();
    }//GEN-LAST:event_jMStockActionPerformed

    private void jBStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStockActionPerformed
        jiGestionStock gestion = new jiGestionStock(this);
        jDP.add(gestion);
        gestion.setVisible(true);
        gestion.toFront();
    }//GEN-LAST:event_jBStockActionPerformed

    private void jMRechercheAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRechercheAuteurActionPerformed
        jiAuteurAffichage auteurAff = new jiAuteurAffichage(this);
        jDP.add(auteurAff);
        auteurAff.setVisible(true);
        auteurAff.toFront();
                
    }//GEN-LAST:event_jMRechercheAuteurActionPerformed

    private void jMRechercheEditeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRechercheEditeurActionPerformed
        jiEditeurAffichage editeurAff = new jiEditeurAffichage(this);
        jDP.add(editeurAff);
        editeurAff.setVisible(true);
        editeurAff.toFront();
        
    }//GEN-LAST:event_jMRechercheEditeurActionPerformed

    private void jMRefLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRefLivreActionPerformed
        jiRefLivre refLivre = new jiRefLivre(this);
        jDP.add(refLivre);
        refLivre.setVisible(true);
        refLivre.toFront();
    }//GEN-LAST:event_jMRefLivreActionPerformed

    private void jMRechercheThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRechercheThemeActionPerformed
        AffichageTheme theme = new AffichageTheme(this);
        jDP.add(theme);
        theme.setVisible(true);
        theme.toFront();
    }//GEN-LAST:event_jMRechercheThemeActionPerformed

    private void jMParametreCommandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMParametreCommandeActionPerformed
        ParametresCommande param = new ParametresCommande(this);
        jDP.add(param);
        param.setVisible(true);
        param.toFront();
    }//GEN-LAST:event_jMParametreCommandeActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        JOptionPane.showMessageDialog(this, "fonction non supportée");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMNewLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNewLivreActionPerformed
        FicheLivre crea = new FicheLivre(this, "C", "");
        jDP.add(crea);
        crea.setVisible(true);
        crea.toFront();
    }//GEN-LAST:event_jMNewLivreActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        jiGestionRubrique rubrique = new jiGestionRubrique(this);
        jDP.add(rubrique);
        rubrique.setVisible(true);
        rubrique.toFront();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JOptionPane.showMessageDialog(this, "fonction non supportée");
//        jiAffichageAcheteur acheteur = new jiAffichageAcheteur(this);
//        jDP.add(acheteur);
//        acheteur.setVisible(true);
//        acheteur.toFront();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JOptionPane.showMessageDialog(this, "fonction non supportée");
//        jiCdeAffichage cde = new jiCdeAffichage(this);
//        jDP.add(cde);
//        cde.setVisible(true);
//        cde.toFront();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JOptionPane.showMessageDialog(this, "fonction non supportée");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Root().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBComment;
    private javax.swing.JButton jBConnect;
    private javax.swing.JButton jBStock;
    private javax.swing.JDesktopPane jDP;
    private javax.swing.JMenu jMAcheteur;
    private javax.swing.JMenu jMAuteur;
    private javax.swing.JMenu jMCommande;
    private javax.swing.JMenu jMEditeur;
    private javax.swing.JMenu jMGestionAcheteur;
    private javax.swing.JMenu jMLibrairie;
    private javax.swing.JMenu jMLivre;
    private javax.swing.JMenuItem jMNewAuteur;
    private javax.swing.JMenuItem jMNewEditeur;
    private javax.swing.JMenuItem jMNewLivre;
    private javax.swing.JMenuItem jMParametreCommande;
    private javax.swing.JMenuItem jMQuitter;
    private javax.swing.JMenuItem jMRechercheAuteur;
    private javax.swing.JMenuItem jMRechercheEditeur;
    private javax.swing.JMenuItem jMRechercheLivre;
    private javax.swing.JMenuItem jMRechercheTheme;
    private javax.swing.JMenu jMRef;
    private javax.swing.JMenuItem jMRefAuteur;
    private javax.swing.JMenuItem jMRefEditeur;
    private javax.swing.JMenuItem jMRefLivre;
    private javax.swing.JMenu jMRubrique;
    private javax.swing.JMenuItem jMStock;
    private javax.swing.JMenu jMTheme;
    private javax.swing.JMenu jMUser;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar jMenuroot;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    // End of variables declaration//GEN-END:variables

    @Override
    public JDesktopPane getmainFrame() {
        return jDP;
    }
    
    

//    @Override
//    public Statement sqlConnect(String s) {
//       try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (ClassNotFoundException ex) {
//            JOptionPane jOErreur = new JOptionPane("Driver non trouvé " + ex.getMessage());
//        }
//        Connection connexion = null;
//        try {
//            connexion = DriverManager.getConnection(sqlConnexion);
//        } catch (SQLException ex) {
//            JOptionPane jOErreur = new JOptionPane("Erreur de connexion a la base" + ex.getErrorCode());
//        }
//        Statement stmt = null;
//        try {
//            stmt = connexion.createStatement();
//        } catch (SQLException ex) {
//            JOptionPane jOErreur = new JOptionPane("Erreur Compte Utilisateur");
//        }
//        return stmt;
//    }
//
//    @Override
//    public void sqlClose() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
    
    
}
