public class AbonnementJeux extends Abonnement {
    private int nbJeuxInclus;
    private int heuresJeuParMois;

    public AbonnementJeux(String nom, double prixBase, int nbProfils, int nbJeuxInclus, int heuresJeuParMois) {
        super(nom, prixBase, nbProfils);
        this.nbJeuxInclus = nbJeuxInclus;
        this.heuresJeuParMois = heuresJeuParMois;
    }

    // Getters et Setters
    public int getNbJeuxInclus() {
        return nbJeuxInclus;
    }

    public void setNbJeuxInclus(int nbJeuxInclus) {
        this.nbJeuxInclus = nbJeuxInclus;
    }

    public int getHeuresJeuParMois() {
        return heuresJeuParMois;
    }

    public void setHeuresJeuParMois(int heuresJeuParMois) {
        this.heuresJeuParMois = heuresJeuParMois;
    }

    @Override
    public double calculerCoutMensuel() {
        double cout = getPrixBase();
        if (nbJeuxInclus > 50) {
            cout += 25;
        }
        if (heuresJeuParMois > 40) {
            cout += 15;
        }
        return cout;
    }

    @Override
    public int calculerScoreSatisfaction() {
        int score = 40;
        if (nbJeuxInclus >= 30) {
            score += 20;
        }
        if (heuresJeuParMois >= 20) {
            score += 20;
        }
        if (getNbProfils() >= 2) {
            score += 10;
        }
        return (score > 100) ? 100 : score;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Nombre de Jeux Inclus: " + nbJeuxInclus);
        System.out.println("Heures de Jeu par Mois: " + heuresJeuParMois);
    }
}
