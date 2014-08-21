
package baselivre.userBO;

/**
 *
 * @author user
 */
public class UserBO {
    private String nomUser;
    private String prenomUser;
    private String pseudoUser;
    private String mdpUser;
    private String typeUser;

    public UserBO() {
    }

    public UserBO(String nomUser, String prenomUser, String pseudoUser, String mdpUser, String typeUser) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.pseudoUser = pseudoUser;
        this.mdpUser = mdpUser;
        this.typeUser = typeUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getPseudoUser() {
        return pseudoUser;
    }

    public void setPseudoUser(String pseudoUser) {
        this.pseudoUser = pseudoUser;
    }

    public String getMdpUser() {
        return mdpUser;
    }

    public void setMdpUser(String mdpUser) {
        this.mdpUser = mdpUser;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
    
    
}
