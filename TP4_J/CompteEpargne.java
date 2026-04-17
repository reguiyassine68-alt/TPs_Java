public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String numero, String titulaire, double solde, double tauxInteret) {
        super(numero, titulaire, solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculerInteret() {
        solde = solde + (solde * tauxInteret / 100);
    }

    @Override
    public void afficher() {
        System.out.println("CompteEpargne [N°: " + numero + ", Titulaire: " + titulaire + 
                           ", Solde: " + solde + ", Taux: " + tauxInteret + "%]");
    }

    public static void main(String[] args) {
        CompteEpargne ce = new CompteEpargne("100", "Jean", 1000, 5);
        ce.afficher();
        ce.deposer(500);
        ce.afficher();
        ce.calculerInteret();
        ce.afficher();
    }
}
