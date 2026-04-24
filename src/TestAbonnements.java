public class TestAbonnements {
    public static void main(String[] args) {
        // 1. Créer un tableau d'abonnements
        Abonnement[] abonnements = new Abonnement[3];
        
        abonnements[0] = new AbonnementVideo("Netflix Premium", 99.99, 4, true, true);
        abonnements[1] = new AbonnementMusique("Spotify Premium", 69.99, 5, 50, true);
        abonnements[2] = new AbonnementJeux("Xbox Game Pass", 89.99, 2, 75, 50);

        // 2. Afficher informations, coûts et scores
        System.out.println("=== TOUS LES ABONNEMENTS ===\n");
        for (Abonnement ab : abonnements) {
            ab.afficherInfos();
            System.out.println("Coût Mensuel: " + ab.calculerCoutMensuel() + " DH");
            System.out.println("Score de Satisfaction: " + ab.calculerScoreSatisfaction());
            System.out.println();
        }

        // 3. Créer un tableau contenant les abonnements Reducible
        Reducible[] reducibles = new Reducible[2];
        reducibles[0] = (AbonnementVideo) abonnements[0];
        reducibles[1] = (AbonnementMusique) abonnements[1];

        // 4. Tester les réductions
        System.out.println("=== TEST DES RÉDUCTIONS ===\n");
        
        double reduction20 = 20;
        double reduction50 = 50;

        for (int i = 0; i < reducibles.length; i++) {
            String nomType = (i == 0) ? "Video" : "Musique";
            System.out.println("--- Abonnement " + nomType + " ---");
            
            // Réduction 20%
            if (reducibles[i].estEligibleReduction(reduction20)) {
                double coutReduit = reducibles[i].appliquerReduction(reduction20);
                System.out.println("Réduction 20% acceptée. Coût: " + coutReduit + " DH");
            } else {
                System.out.println("Réduction 20% refusée");
            }
            
            // Réduction 50%
            if (reducibles[i].estEligibleReduction(reduction50)) {
                double coutReduit = reducibles[i].appliquerReduction(reduction50);
                System.out.println("Réduction 50% acceptée. Coût: " + coutReduit + " DH");
            } else {
                System.out.println("Réduction 50% refusée (dépasse 30%)");
            }
            
            System.out.println();
        }
    }
}
