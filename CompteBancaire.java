public class CompteBancaire {

    // Attributs privés
    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;

    // Variables de classe
    private static int nbComptes = 0;
    private static double tauxInteretAnnuel = 0.03;

    // Compteur pour générer un numéro unique
    private static int compteurNumero = 1000;

    // Constructeur par défaut
    public CompteBancaire() {
        this.numero = ++compteurNumero;
        this.titulaire = "Inconnu";
        this.solde = 0.0;
        this.decouvertAutorise = 0.0;
        nbComptes++;
    }

    // Constructeur paramétré
    public CompteBancaire(String titulaire, double solde, double decouvertAutorise) {
        this.numero = ++compteurNumero;
        setTitulaire(titulaire);
        this.solde = solde;
        setDecouvertAutorise(decouvertAutorise);
        nbComptes++;
    }

    // Getters / Setters avec validations
    public int getNumero() { return numero; }

    public String getTitulaire() { return titulaire; }
    public void setTitulaire(String titulaire) {
        if (titulaire != null && !titulaire.trim().isEmpty())
            this.titulaire = titulaire;
        else
            System.out.println("Titulaire invalide.");
    }

    public double getSolde() { return solde; }

    public double getDecouvertAutorise() { return decouvertAutorise; }
    public void setDecouvertAutorise(double decouvertAutorise) {
        if (decouvertAutorise >= 0)
            this.decouvertAutorise = decouvertAutorise;
        else
            System.out.println("Découvert ne peut pas être négatif.");
    }

    public static int getNbComptes() { return nbComptes; }
    public static double getTauxInteretAnnuel() { return tauxInteretAnnuel; }
    public static void setTauxInteretAnnuel(double taux) { tauxInteretAnnuel = taux; }

    // Afficher
    public void afficher() {
        System.out.println("Compte N°" + numero + " | Titulaire: " + titulaire
                + " | Solde: " + solde + " MAD | Découvert autorisé: " + decouvertAutorise + " MAD");
    }

    // Opérations
    public void deposer(double montant) {
        if (montant > 0)
            solde += montant;
        else
            System.out.println("Montant de dépôt invalide.");
    }

    public void retirer(double montant) {
        if (montant > 0 && (solde - montant) >= -decouvertAutorise)
            solde -= montant;
        else
            System.out.println("Retrait refusé.");
    }

    public void virementVers(CompteBancaire autre, double montant) {
        if (montant > 0 && (solde - montant) >= -decouvertAutorise) {
            this.solde -= montant;
            autre.solde += montant;
        } else {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
        }
    }

    // Calcul des intérêts
    public double calculerSoldeAvecInterets() {
        return solde * (1 + tauxInteretAnnuel);
    }

    public double calculerSoldeAvecInterets(double bonus) {
        return solde * (1 + tauxInteretAnnuel + bonus);
    }

    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire("Test", 1000, 500);
        compte.afficher();
        compte.deposer(500);
        compte.afficher();
    }
}
