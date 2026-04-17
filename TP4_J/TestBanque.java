public class TestBanque {
    public static void main(String[] args) {
        // 5. Tableau polymorphe
        Compte[] comptes = new Compte[4];
        
        // Initialisation
        comptes[0] = new CompteCourant("001", "Ahmed", 5000, 2000);
        comptes[1] = new CompteEpargne("002", "Fatima", 10000, 3.5);
        comptes[2] = new CompteEpargne("003", "Mohamed", 8000, 2.5);
        comptes[3] = new ComptePremium("004", "Laila", 15000, 5000);

        System.out.println("=== Affichage initial ===");
        for (Compte c : comptes) {
            c.afficher();
        }

        System.out.println("\n=== Opérations (Dépôt et Retrait) ===");
        comptes[0].deposer(1000);
        System.out.println("Dépôt de 1000 sur compte 0:");
        comptes[0].afficher();

        comptes[1].retirer(2000);
        System.out.println("Retrait de 2000 sur compte 1:");
        comptes[1].afficher();

        System.out.println("\n=== 6. Filtrage par type (CompteEpargne) ===");
        for (Compte c : comptes) {
            if (c instanceof CompteEpargne) {
                c.afficher();
            }
        }

        System.out.println("\n=== 7. Downcasting ===");
        Compte c = new CompteEpargne("005", "Test", 5000, 2.0);
        
        // Code qui fonctionne
        if (c instanceof CompteEpargne) {
            CompteEpargne ce = (CompteEpargne) c;
            System.out.println("Downcasting réussi");
            ce.calculerInteret();
            ce.afficher();
        }

        // Code qui génère une exception
        System.out.println("\nTentative de downcasting invalide:");
        Compte c2 = new CompteCourant("006", "Test2", 3000, 1000);
        try {
            CompteEpargne ce2 = (CompteEpargne) c2;
            ce2.afficher();
        } catch (ClassCastException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Raison: CompteCourant ne peut pas être converti en CompteEpargne");
            System.out.println("Solutions: Utiliser instanceof avant le cast ou gérer l'exception");
        }
    }
}
