package ecole.cours;

import java.util.Date;

/**
 * Classe de tests pour CoursSession
 * @see CoursSession
 * @author Gabriel T. St-Hilaire
 */
public class TestCoursSession extends TestCours {
    /**
     * Test le nombre de cours session
     */
    public void testCompte() {
        CoursSession.reinitialiserCompte();

        creerCours("", "", new Date());
        assertEquals(1, CoursSession.getCompte());

        creerCours("", "", new Date());
        assertEquals(2, CoursSession.getCompte());
    }

    public void testDateFin() {
        Date dateDebut = DateUtil.creerDate(2016, 2, 23);
        Cours cours = creerCours("Philo", "101", dateDebut);
        Date seizeSemaine = DateUtil.creerDate(2016, 6, 14);
        assertEquals(seizeSemaine, cours.getDateFinSession());
    }

    @Override
    protected Cours creerCours(String p_departement, String p_numero, Date p_dateDebut) {
        return CoursSession.creer(p_departement, p_numero, p_dateDebut);
    }
}
