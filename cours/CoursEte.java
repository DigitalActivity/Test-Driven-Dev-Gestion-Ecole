package ecole.cours;

import java.util.Date;

/**
 * Classe représentant un cours pour une session précise
 * @author Gabriel T. St-Hilaire
 */
public class CoursEte extends Cours {
    private static final int DUREE_SESSION = 8;

    /**
     * Constructeur
     * @param p_departement Département du cours
     * @param p_numero Numéro du cours
     * @param p_dateDebut La date de début du cours
     */
    private CoursEte(String p_departement, String p_numero, Date p_dateDebut) {
        super(p_departement, p_numero, p_dateDebut);
    }

    /**
     * Fabrique Cours
     * @param p_departement Département du cours
     * @param p_numero Numéro du cours
     * @param p_dateDebut La date de début du cours
     * @return un CoursSession
     */
    public static CoursEte creer(String p_departement, String p_numero, Date p_dateDebut) {
        return new CoursEte(p_departement, p_numero, p_dateDebut);
    }

    @Override
    protected int getDureeSession() {
        return DUREE_SESSION;
    }
}
