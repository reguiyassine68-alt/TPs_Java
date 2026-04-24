public abstract class Abonnement {
    private String nom;
    private double prixBase;
    private int nbProfils;

    public Abonnement(String nom, double prixBase, int nbProfils) {
        this.nom = nom;
        this.prixBase = (prixBase <= 0) ? 50.0 : prixBase;
        this.nbProfils = (nbProfils <= 0) ? 1 : nbProfils;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public double getPrixBase() {
        return prixBase;
    }

    public int getNbProfils() {
        return nbProfils;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrixBase(double prixBase) {
        this.prixBase = (prixBase <= 0) ? 50.0 : prixBase;
    }

    public void setNbProfils(int nbProfils) {
        this.nbProfils = (nbProfils <= 0) ? 1 : nbProfils;
    }

    // Méthode estPartageFamilial
    public boolean estPartageFamilial() {
        return nbProfils >= 3;
    }

    // Méthode afficherInfos
    public void afficherInfos() {
        System.out.println("--- Informations Abonnement ---");
        System.out.println("Nom: " + nom);
        System.out.println("Prix Base: " + prixBase + " DH");
        System.out.println("Nombre de Profils: " + nbProfils);
        System.out.println("Partage Familial: " + estPartageFamilial());
    }

    // Méthodes abstraites
    public abstract double calculerCoutMensuel();
    public abstract int calculerScoreSatisfaction();
}
