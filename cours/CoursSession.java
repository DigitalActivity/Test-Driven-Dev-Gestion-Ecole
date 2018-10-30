package ecole.cours;

import java.util.Date;

/**
 * Classe représentant un cours pour une session précise
 * @author Gabriel T. St-Hilaire
 */
public class CoursSession extends Cours {
    private static final int DUREE_SESSION = 16;
    private static int m_compteur = 0;

    /**
     * Constructeur
     * @param p_departement Département du cours
     * @param p_numero Numéro du cours
     * @param p_dateDebut La date de début du cours
     */
    private CoursSession(String p_departement, String p_numero, Date p_dateDebut) {
        super(p_departement, p_numero, p_dateDebut);
    }

    /**
     * Fabrique pour CoursSession
     * @param p_departement Département du cours
     * @param p_numero Numéro du cours
     * @param p_dateDebut La date de début du cours
     * @return un CoursSession
     */
    public static CoursSession creer(String p_departement, String p_numero, Date p_dateDebut) {
        CoursSession.incrementerCompte();
        return new CoursSession(p_departement, p_numero, p_dateDebut);
    }

    public static int getCompte() {
        return m_compteur;
    }

    public static void reinitialiserCompte() {
        m_compteur = 0;
    }

    private static void incrementerCompte() {
        m_compteur += 1;
    }

    @Override
    protected int getDureeSession() {
        return DUREE_SESSION;
    }
}
