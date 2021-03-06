
package baselivre.user;

/**
 *
 * @author user
 */
public class Adresse {
    private String adresseAcheteur1;
    private String adresseAcheteur2;
    private String cpAcheteur;
    private String villeAcheteur;
    private String paysAcheteur;
    private boolean actifAcheteur;

    public Adresse() {
    }

    public Adresse(String adresseAcheteur1, String adresseAcheteur2, String cpAcheteur, String villeAcheteur, String paysAcheteur, boolean actifAcheteur) {
        this.adresseAcheteur1 = adresseAcheteur1;
        this.adresseAcheteur2 = adresseAcheteur2;
        this.cpAcheteur = cpAcheteur;
        this.villeAcheteur = villeAcheteur;
        this.paysAcheteur = paysAcheteur;
        this.actifAcheteur = actifAcheteur;
    }

    public String getAdresseAcheteur1() {
        return adresseAcheteur1;
    }

    public void setAdresseAcheteur1(String adresseAcheteur1) {
        this.adresseAcheteur1 = adresseAcheteur1;
    }

    public String getAdresseAcheteur2() {
        return adresseAcheteur2;
    }

    public void setAdresseAcheteur2(String adresseAcheteur2) {
        this.adresseAcheteur2 = adresseAcheteur2;
    }

    public String getCpAcheteur() {
        return cpAcheteur;
    }

    public void setCpAcheteur(String cpAcheteur) {
        this.cpAcheteur = cpAcheteur;
    }

    public String getVilleAcheteur() {
        return villeAcheteur;
    }

    public void setVilleAcheteur(String villeAcheteur) {
        this.villeAcheteur = villeAcheteur;
    }

    public String getPaysAcheteur() {
        return paysAcheteur;
    }

    public void setPaysAcheteur(String paysAcheteur) {
        this.paysAcheteur = paysAcheteur;
    }

    public boolean isActifAcheteur() {
        return actifAcheteur;
    }

    public void setActifAcheteur(boolean actifAcheteur) {
        this.actifAcheteur = actifAcheteur;
    }
    
    
    
}
