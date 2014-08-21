package baselivre.ui.rubrique;

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
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author cdi111/cdi108
 */
public class jiGestionRubrique extends javax.swing.JInternalFrame {

    private String sqlConnexion;
    private InterfaceRoot ir;
    private int idRubrique;
    private String rubriqueNom;
    private Date rubriqueDateDbt;
    private Date rubriqueDateFin;
    private int rubriqueActive;

    private Statement stmt;
    private Connection connexion;

    /*
     private DefaultTableModel initTable() {
     DefaultTableModel tm = new DefaultTableModel()
     {
     @Override
     public boolean isCellEditable(int row, int column) {
     return false; 
     }
     };
     return tm;
        
     }//*/
    /**
     * Constructeur pour la frame
     * @param ir InterfaceRoot
     */
    public jiGestionRubrique(InterfaceRoot ir) {
        this.ir = ir;
        this.sqlConnexion = ir.SqlConnexion();
        initComponents();

    }

  
    //Procédure d'affichage des rubriques 
    private DefaultTableModel initTable() {
        Vector rub = new Vector();
        Vector vtitre = new Vector();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion" + ex.getMessage());
            return null;
        }

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
            stmt = connexion.createStatement();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !" + ex.getMessage());
            return null;
        }
        ResultSet rs = null;
        try {

            rs = stmt.executeQuery("SELECT * FROM rubrique");

            // Recupératiojn des données de la base de données (table rubrique).
            String etat;

            while (rs.next()) {
                Vector vv = new Vector();
                if (rs.getInt("rubrique_actif") == 1) {
                    etat = "Actif";
                } else {
                    etat = "Inactif";
                }

                vv.add(rs.getInt("id_rubrique"));
                vv.add(rs.getString("rubrique_nom"));
                vv.add(rs.getDate("rubrique_datedbt"));
                vv.add(rs.getDate("rubrique_datefin"));
                vv.add(etat);
                rub.add(vv);

            }
            // Ajout de titre pour chaque colonne de la table rubrique

            vtitre.add("Id Rubrique");
            vtitre.add("Nom Rubrique");
            vtitre.add("Date de début");
            vtitre.add("Date de fin");
            vtitre.add("Etat");
            rs.close();
            stmt.close();
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL !! " + ex.getErrorCode());
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur a l'affichage\n" + e.getMessage());
            return null;
        }

        DefaultTableModel dt = new DefaultTableModel(rub, vtitre) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return dt;

    }

    // Procéure modifierRubrique
    private void modifierRubrique() {

        int selectedRow = jtRubrique.getSelectedRow();
        int idRub;
        int actif;
        if (JOptionPane.showConfirmDialog(null, "Confirmer la modification\n", "Modifier", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            try {
                if (selectedRow != -1) {

                    idRub = (int) jtRubrique.getValueAt(selectedRow, 0);
                    if (jtfEtat.getText().equalsIgnoreCase("Actif")) {
                        actif = 1;
                    } else {
                        actif = 0;
                    }
                    String sql = "UPDATE rubrique SET rubrique_nom = '" + jtfRubriqueNom.getText()
                            + "', rubrique_datedbt = '" + jtfRubriqueDateDbt.getText() + "', rubrique_datefin = '"
                            + jtfRubriqueDateFin.getText() + "', rubrique_actif = " + Integer.toString(actif) + " WHERE id_rubrique = '" + idRub + "'";
                    stmt.executeUpdate(sql);

                } else {
                    JOptionPane.showMessageDialog(null, "Selectionnez une ligne !");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur !\n" + e.getMessage());
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jpRubrique = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtRubrique = new javax.swing.JTable();
        jbtnCreation = new javax.swing.JButton();
        jbtnModifierTheme = new javax.swing.JButton();
        jbtnSuppression = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfRubriqueNom = new javax.swing.JTextField();
        jtfRubriqueDateDbt = new javax.swing.JTextField();
        jtfRubriqueDateFin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfEtat = new javax.swing.JTextField();
        jlblIdRubrique = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Gestion des Stocks Librairie");
        getContentPane().setLayout(null);

        jPanel4.setLayout(null);
        jTabbedPane4.addTab("Promotion ", jPanel4);

        jpRubrique.setLayout(null);

        jtRubrique.setModel(initTable());
        jtRubrique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRubriqueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtRubrique);

        jpRubrique.add(jScrollPane2);
        jScrollPane2.setBounds(350, 20, 540, 200);

        jbtnCreation.setText("Création ");
        jbtnCreation.setMaximumSize(new java.awt.Dimension(100, 25));
        jbtnCreation.setMinimumSize(new java.awt.Dimension(100, 25));
        jbtnCreation.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnCreation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreationActionPerformed(evt);
            }
        });
        jpRubrique.add(jbtnCreation);
        jbtnCreation.setBounds(10, 230, 100, 25);

        jbtnModifierTheme.setText("Modification ");
        jbtnModifierTheme.setMaximumSize(new java.awt.Dimension(100, 25));
        jbtnModifierTheme.setMinimumSize(new java.awt.Dimension(100, 25));
        jbtnModifierTheme.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnModifierTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModifierThemeActionPerformed(evt);
            }
        });
        jpRubrique.add(jbtnModifierTheme);
        jbtnModifierTheme.setBounds(120, 230, 100, 25);

        jbtnSuppression.setText("Suppression ");
        jbtnSuppression.setMaximumSize(new java.awt.Dimension(100, 25));
        jbtnSuppression.setMinimumSize(new java.awt.Dimension(100, 25));
        jbtnSuppression.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnSuppression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuppressionActionPerformed(evt);
            }
        });
        jpRubrique.add(jbtnSuppression);
        jbtnSuppression.setBounds(230, 230, 120, 25);

        jLabel1.setText("id Rubrique : ");
        jpRubrique.add(jLabel1);
        jLabel1.setBounds(10, 20, 70, 14);

        jLabel2.setText("Rubrique : ");
        jpRubrique.add(jLabel2);
        jLabel2.setBounds(10, 60, 70, 14);

        jLabel3.setText("Date début : ");
        jpRubrique.add(jLabel3);
        jLabel3.setBounds(10, 100, 70, 14);

        jLabel4.setText("Date de fin : ");
        jpRubrique.add(jLabel4);
        jLabel4.setBounds(10, 140, 70, 14);
        jpRubrique.add(jtfRubriqueNom);
        jtfRubriqueNom.setBounds(110, 50, 230, 30);
        jpRubrique.add(jtfRubriqueDateDbt);
        jtfRubriqueDateDbt.setBounds(110, 90, 230, 30);
        jpRubrique.add(jtfRubriqueDateFin);
        jtfRubriqueDateFin.setBounds(110, 130, 230, 30);

        jLabel5.setText("Etat :");
        jpRubrique.add(jLabel5);
        jLabel5.setBounds(10, 180, 60, 14);
        jpRubrique.add(jtfEtat);
        jtfEtat.setBounds(110, 170, 230, 30);

        jlblIdRubrique.setBackground(new java.awt.Color(255, 255, 255));
        jlblIdRubrique.setEnabled(false);
        jlblIdRubrique.setOpaque(true);
        jpRubrique.add(jlblIdRubrique);
        jlblIdRubrique.setBounds(110, 20, 230, 20);

        jTabbedPane4.addTab("Rubrique ", jpRubrique);

        getContentPane().add(jTabbedPane4);
        jTabbedPane4.setBounds(10, 10, 900, 310);

        setBounds(0, 0, 933, 795);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnModifierThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModifierThemeActionPerformed
        // Connection à la base
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion" + ex.getMessage());

        }

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
            stmt = connexion.createStatement();

            modifierRubrique();

            stmt.close();
            connexion.close();
            jtRubrique.setModel(initTable());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !" + ex.getMessage());

        }

        

    }//GEN-LAST:event_jbtnModifierThemeActionPerformed

    private void jtRubriqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRubriqueMouseClicked
        int selectedRow = jtRubrique.getSelectedRow();

        if (selectedRow != -1) {
            jlblIdRubrique.setText(jtRubrique.getValueAt(selectedRow, 0).toString());
            jtfRubriqueNom.setText(jtRubrique.getValueAt(selectedRow, 1).toString());
            jtfRubriqueDateDbt.setText(jtRubrique.getValueAt(selectedRow, 2).toString());
            jtfRubriqueDateFin.setText(jtRubrique.getValueAt(selectedRow, 3).toString());
            jtfEtat.setText(jtRubrique.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_jtRubriqueMouseClicked

    private void jbtnSuppressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuppressionActionPerformed

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion" + ex.getMessage());

        }

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
            stmt = connexion.createStatement();
            //////////////////////

            if (JOptionPane.showConfirmDialog(null, "Confirmer la modification\n", "Modifier", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                int selectedRow = jtRubrique.getSelectedRow();
                if (selectedRow != -1) {

                    String sql = "UPDATE rubrique SET rubrique_actif = 0 WHERE id_rubrique = " + jlblIdRubrique.getText();
                    stmt.executeUpdate(sql);

                    stmt.close();
                    connexion.close();
                    jtRubrique.setModel(initTable());

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !" + ex.getMessage());

        }
    }//GEN-LAST:event_jbtnSuppressionActionPerformed

    private void jbtnCreationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreationActionPerformed
       // Connection à la base
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion" + ex.getMessage());

        }

        try {
            connexion = DriverManager.getConnection(sqlConnexion);
            stmt = connexion.createStatement();

            suppressionRubrique();

            stmt.close();
            connexion.close();
            jtRubrique.setModel(initTable());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connexion !" + ex.getMessage());

        }
    }//GEN-LAST:event_jbtnCreationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JButton jbtnCreation;
    private javax.swing.JButton jbtnModifierTheme;
    private javax.swing.JButton jbtnSuppression;
    private javax.swing.JLabel jlblIdRubrique;
    private javax.swing.JPanel jpRubrique;
    private javax.swing.JTable jtRubrique;
    private javax.swing.JTextField jtfEtat;
    private javax.swing.JTextField jtfRubriqueDateDbt;
    private javax.swing.JTextField jtfRubriqueDateFin;
    private javax.swing.JTextField jtfRubriqueNom;
    // End of variables declaration//GEN-END:variables

    private void suppressionRubrique() {
        
         try{
            
            boolean b = false;
            for(int j = 0; j < jtRubrique.getRowCount() - 1; j++){
                if(jtfRubriqueNom.getText().equalsIgnoreCase((jtRubrique.getValueAt(j, 1)).toString())){
                    b = true;
                    break;
                }
            }
            
            if(b == false){
                if(jtfRubriqueNom.getText().equals("")){
                    JOptionPane.showConfirmDialog(null, "Veuillez saisir le nom de la rubrique");
                }
                //Affaire a suivre, run run run
                //if(jtfRubriqueDateDbt.getText().matches(())){
                
          //  }
                
                stmt.executeUpdate("");
            }
            
            
        }catch(Exception e){
            
        }
           }

}
