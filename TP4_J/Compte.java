public class Compte {
    protected String numero;
    protected String titulaire;
    protected double solde;

    public Compte(String numero, String titulaire, double solde) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde >= 0 ? solde : 0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde >= 0 ? solde : 0;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public void afficher() {
        System.out.println("Compte [N°: " + numero + ", Titulaire: " + titulaire + ", Solde: " + solde + "]");
    }

    public static void main(String[] args) {
        Compte c = new Compte("999", "Admin", 10000);
        c.afficher();
        c.deposer(5000);
        c.afficher();
        boolean retraitable = c.retirer(3000);
        System.out.println("Retrait de 3000: " + (retraitable ? "Succès" : "Échec"));
        c.afficher();
    }
}
