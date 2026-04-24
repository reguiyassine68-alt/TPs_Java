public class AbonnementMusique extends Abonnement implements Reducible {
    private int nbPlaylists;
    private boolean optionOffline;

    public AbonnementMusique(String nom, double prixBase, int nbProfils, int nbPlaylists, boolean optionOffline) {
        super(nom, prixBase, nbProfils);
        this.nbPlaylists = nbPlaylists;
        this.optionOffline = optionOffline;
    }

    // Getters et Setters
    public int getNbPlaylists() {
        return nbPlaylists;
    }

    public void setNbPlaylists(int nbPlaylists) {
        this.nbPlaylists = nbPlaylists;
    }

    public boolean isOptionOffline() {
        return optionOffline;
    }

    public void setOptionOffline(boolean optionOffline) {
        this.optionOffline = optionOffline;
    }

    @Override
    public double calculerCoutMensuel() {
        double cout = getPrixBase();
        if (optionOffline) {
            cout += 15;
        }
        return cout;
    }

    @Override
    public int calculerScoreSatisfaction() {
        int score = 50;
        if (nbPlaylists > 20) {
            score += 20;
        }
        if (optionOffline) {
            score += 20;
        }
        if (getNbProfils() > 1) {
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
        System.out.println("Nombre de Playlists: " + nbPlaylists);
        System.out.println("Option Offline: " + optionOffline);
    }
}
