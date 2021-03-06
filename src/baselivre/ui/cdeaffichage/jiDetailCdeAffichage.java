package baselivre.ui.cdeaffichage;

import baselivre.produit.Editeur;
import baselivre.ui.frame.InterfaceRoot;
import baselivre.user.Acheteur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author cdi107
 */
public class jiDetailCdeAffichage extends javax.swing.JInternalFrame {
     private String sqlConnexion;
//     private String nameSearch;
     private int idAcheteur;
     private int idCde;
    /**
     * Creates new form jiDetailCdeAffichage
     * @param ir InterfaceRoot
     * 
     */
    public jiDetailCdeAffichage(InterfaceRoot ir) {
        initComponents();
          this.sqlConnexion = ir.SqlConnexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numCde = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dateCde = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        editFacture = new javax.swing.JButton();
        CancelBton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel1.setText("Commande N°");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 10, 80, 20);

        numCde.setText("Commande");
        numCde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numCdeActionPerformed(evt);
            }
        });
        getContentPane().add(numCde);
        numCde.setBounds(110, 10, 130, 20);

        jLabel2.setText("Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 10, 34, 14);

        dateCde.setText("Date de la commande");
        dateCde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCdeActionPerformed(evt);
            }
        });
        getContentPane().add(dateCde);
        dateCde.setBounds(380, 10, 130, 20);

        jLabel3.setText("Detail de la commande");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 70, 150, 14);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 500, 100);

        jLabel4.setText("Etat");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 260, 20, 14);

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(70, 260, 59, 20);

        jLabel5.setText("Livraison");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(240, 260, 70, 14);

        jTextField4.setText("jTextField4");
        getContentPane().add(jTextField4);
        jTextField4.setBounds(300, 260, 59, 20);

        editFacture.setText("Edition Facture");
        editFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFactureActionPerformed(evt);
            }
        });
        getContentPane().add(editFacture);
        editFacture.setBounds(30, 310, 110, 23);

        CancelBton.setText("Cancel");
        CancelBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtonActionPerformed(evt);
            }
        });
        getContentPane().add(CancelBton);
        CancelBton.setBounds(160, 310, 73, 23);

        jButton3.setText("Nouvelle recherche");
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 310, 125, 23);

        setBounds(0, 0, 580, 392);
    }// </editor-fold>//GEN-END:initComponents

    private void numCdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numCdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numCdeActionPerformed

    private void dateCdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateCdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateCdeActionPerformed

    private void editFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFactureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFactureActionPerformed

    private void CancelBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtonActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_CancelBtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBton;
    private javax.swing.JTextField dateCde;
    private javax.swing.JButton editFacture;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField numCde;
    // End of variables declaration//GEN-END:variables
}
