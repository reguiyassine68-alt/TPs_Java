public class ComptePremium extends Compte {
    private double plafondRetrait;

    public ComptePremium(String numero, String titulaire, double solde, double plafondRetrait) {
        super(numero, titulaire, solde);
        this.plafondRetrait = plafondRetrait;
    }

    public double getPlafondRetrait() {
        return plafondRetrait;
    }

    public void setPlafondRetrait(double plafondRetrait) {
        this.plafondRetrait = plafondRetrait;
    }

    @Override
    public boolean retirer(double montant) {
        if (montant > 0 && montant <= plafondRetrait && solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    @Override
    public void afficher() {
        System.out.println("ComptePremium [N°: " + numero + ", Titulaire: " + titulaire + 
                           ", Solde: " + solde + ", Plafond: " + plafondRetrait + "]");
    }

    public static void main(String[] args) {
        ComptePremium cp = new ComptePremium("200", "Sophie", 5000, 1000);
        cp.afficher();
        cp.deposer(2000);
        cp.afficher();
        boolean retraitable = cp.retirer(800);
        System.out.println("Retrait de 800: " + (retraitable ? "Succès" : "Échec"));
        cp.afficher();
        retraitable = cp.retirer(1500);
        System.out.println("Retrait de 1500: " + (retraitable ? "Succès" : "Échec"));
    }
}
