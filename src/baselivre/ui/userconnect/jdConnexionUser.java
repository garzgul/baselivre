
package baselivre.ui.userconnect;

import baselivre.ui.frame.InterfaceRoot;
import baselivre.ui.root.Root;

/**
 *
 * @author cdi116
 */
public class jdConnexionUser extends javax.swing.JDialog {
    private Root parent;
    private InterfaceRoot ir;

    
    public jdConnexionUser(Root parent, boolean modal, InterfaceRoot ir) {
        super(parent, modal);
        this.parent = parent;
        this.ir = ir;
        initComponents();
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Connexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 150, 110, 23);

        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 150, 130, 23);

        jLabel1.setText("Nom Utilisateur");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 30, 100, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(120, 30, 160, 30);

        jLabel2.setText("Mot de passe");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 90, 100, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(120, 90, 160, 30);

        setSize(new java.awt.Dimension(416, 229));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        parent.setSqlConnexion(parent.getSqlConnexion()+"user="+jTextField1.getText()+";password="+jTextField2.getText());
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
