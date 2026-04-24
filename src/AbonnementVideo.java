public class AbonnementVideo extends Abonnement implements Reducible {
    private boolean optionHD;
    private boolean option4K;

    public AbonnementVideo(String nom, double prixBase, int nbProfils, boolean optionHD, boolean option4K) {
        super(nom, prixBase, nbProfils);
        this.optionHD = optionHD;
        this.option4K = option4K;
    }

    // Getters et Setters
    public boolean isOptionHD() {
        return optionHD;
    }

    public void setOptionHD(boolean optionHD) {
        this.optionHD = optionHD;
    }

    public boolean isOption4K() {
        return option4K;
    }

    public void setOption4K(boolean option4K) {
        this.option4K = option4K;
    }

    @Override
    public double calculerCoutMensuel() {
        double cout = getPrixBase();
        if (optionHD) {
            cout += 10;
        }
        if (option4K) {
            cout += 20;
        }
        return cout;
    }

    @Override
    public int calculerScoreSatisfaction() {
        int score = 60;
        if (optionHD) {
            score += 10;
        }
        if (option4K) {
            score += 20;
        }
        if (getNbProfils() >= 4) {
            score += 10;
        }
        return (score > 100) ? 100 : score;
    }

    @Override
    public double appliquerReduction(double pourcentage) {
        if (estEligibleReduction(pourcentage)) {
            return calculerCoutMensuel() * (1 - pourcentage / 100);
        }
        return calculerCoutMensuel();
    }

    @Override
    public boolean estEligibleReduction(double pourcentage) {
        return pourcentage <= 30;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Option HD: " + optionHD);
        System.out.println("Option 4K: " + option4K);
    }
}
