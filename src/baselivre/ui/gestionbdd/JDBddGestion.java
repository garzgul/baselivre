
package baselivre.ui.gestionbdd;

import baselivre.ui.frame.InterfaceRoot;
import baselivre.ui.root.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author cdi116
 */
public class JDBddGestion extends javax.swing.JDialog {

    private String sqlConnexion;
    private Root parent;
    

    /**
     * JDialogue de gestion des coordonnées de la base
     * @param parent frame root
     * @param modal mise a true
     * Frame en cours de creation
     */
    public JDBddGestion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = (Root)parent;
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTFAdresseServeur = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFPortServeur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFNomBDD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion BDD");
        getContentPane().setLayout(null);

        jButton1.setText("Mise A Jour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 400, 100, 23);

        jButton2.setText("Annuler");
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 400, 90, 23);
        getContentPane().add(jTFAdresseServeur);
        jTFAdresseServeur.setBounds(190, 180, 160, 30);

        jLabel1.setText("Type de BDD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 110, 90, 20);
        getContentPane().add(jTFPortServeur);
        jTFPortServeur.setBounds(190, 230, 160, 30);

        jLabel2.setText("port du serveur");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 230, 90, 30);
        getContentPane().add(jTFNomBDD);
        jTFNomBDD.setBounds(190, 300, 160, 30);

        jLabel3.setText("Nom de la base");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 300, 90, 30);

        jLabel4.setText("adresse du serveur");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 180, 110, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 280, 400, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 160, 400, 10);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(190, 110, 160, 20);

        jLabel5.setText("Gestion de la Base de données");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 40, 160, 50);

        setSize(new java.awt.Dimension(416, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.sqlConnexion = parent.getSqlConnexion();
        sqlConnexion = "jdbc:sqlserver://"+jTFAdresseServeur+":"+jTFPortServeur+";databaseName="+jTFNomBDD;
        JOptionPane confirm = new JOptionPane("Voulez vous vraiment changer les parametres la base");
        parent.getmainFrame().add(confirm);
        confirm.setVisible(true);
        
        // en cours
        
        
        parent.setSqlConnexion(sqlConnexion);
        

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JDBddGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDBddGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDBddGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBddGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDBddGestion dialog = new JDBddGestion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTFAdresseServeur;
    private javax.swing.JTextField jTFNomBDD;
    private javax.swing.JTextField jTFPortServeur;
    // End of variables declaration//GEN-END:variables
}
