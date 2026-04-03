public class Banque {

    private String nom;
    private CompteBancaire[] comptes;
    private int nbActuels;

    public Banque(String nom, int capacite) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capacite];
        this.nbActuels = 0;
    }

    public void ajouterCompte(CompteBancaire c) {
        if (nbActuels < comptes.length) {
            comptes[nbActuels] = c;
            nbActuels++;
        } else {
            System.out.println("Capacité maximale atteinte.");
        }
    }

    public void afficherTous() {
        System.out.println("=== Comptes de la banque : " + nom + " ===");
        for (int i = 0; i < nbActuels; i++) {
            comptes[i].afficher();
        }
    }

    public static void main(String[] args) {
        // 1. Créer la banque
        Banque banque = new Banque("MarocBank", 1500);

        // 2. Créer trois comptes
        CompteBancaire c1 = new CompteBancaire("Ali Hassan", 1000, 500);
        CompteBancaire c2 = new CompteBancaire("Sara Bennani", 2000, 300);
        CompteBancaire c3 = new CompteBancaire("Youssef Alami", 500, 200);

        // 3. Ajouter à la banque
        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);
        banque.ajouterCompte(c3);

        // 4. Opérations
        c1.deposer(500);         // c1 solde → 1500
        c1.retirer(200);         // c1 solde → 1300
        c2.virementVers(c3, 400); // c2 → 1600, c3 → 900

        // 5. Afficher tous les comptes
        banque.afficherTous();

        // 6. Calcul des intérêts sur c2
        System.out.println("Solde c2 avec intérêts (3%): " + c2.calculerSoldeAvecInterets());
        System.out.println("Solde c2 avec intérêts (3% + 1.5%): " + c2.calculerSoldeAvecInterets(0.015));

        // 7. Infos globales
        System.out.println("Nombre total de comptes créés : " + CompteBancaire.getNbComptes());
        System.out.println("Taux d'intérêt annuel : " + CompteBancaire.getTauxInteretAnnuel());
    }
}
