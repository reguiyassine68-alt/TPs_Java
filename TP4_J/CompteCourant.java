public class CompteCourant extends Compte {
    private double decouvertAutorise;

    public CompteCourant(String numero, String titulaire, double solde, double decouvertAutorise) {
        super(numero, titulaire, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public boolean retirer(double montant) {
        if (montant > 0 && (solde + decouvertAutorise) >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    @Override
    public void afficher() {
        System.out.println("CompteCourant [N°: " + numero + ", Titulaire: " + titulaire + 
                           ", Solde: " + solde + ", Découvert: " + decouvertAutorise + "]");
    }

    public static void main(String[] args) {
        CompteCourant cc = new CompteCourant("050", "Marc", 2000, 1000);
        cc.afficher();
        cc.deposer(1500);
        cc.afficher();
        boolean retraitable = cc.retirer(2500);
        System.out.println("Retrait de 2500 (avec découvert): " + (retraitable ? "Succès" : "Échec"));
        cc.afficher();
    }
}
