package ecole.cours;

import java.util.Date;

/**
 * Classe de tests pour CoursSession
 * @see CoursEte
 * @author Gabriel T. St-Hilaire
 */
public class TestCoursEte extends TestCours {
    @Override
    protected Cours creerCours(String p_departement, String p_numero, Date p_dateDebut) {
        return CoursEte.creer(p_departement, p_numero, p_dateDebut);
    }

    public void testDateFin() {
        Date dateDebut = DateUtil.creerDate(2016, 2, 23);
        Cours cours = creerCours("Philo", "101", dateDebut);
        Date huitSemaine = DateUtil.creerDate(2016, 4, 19);
        assertEquals(huitSemaine, cours.getDateFinSession());
    }
}