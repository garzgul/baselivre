
package baselivre.ui.frame;

import java.sql.Statement;
import javax.swing.JDesktopPane;

/** InterfaceRoot 
 * Interface permettant de recuperer le string de connexion a la base
 * et le desktop pane.
 *
 * @author cdi116
 */
public interface InterfaceRoot {
    
    public JDesktopPane getmainFrame();
    
    public String SqlConnexion();
    
//    public Statement sqlConnect(String s);
//    
//    public void sqlClose();
//    
}
