package ecole.cours;

import ecole.Exception.FormatDateDebutCoursException;
import junit.framework.TestCase;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe tests sur DateUtil
 *  @author Rabdi Younes
 *  @see DateUtil
 */
public class TestDateUtil extends TestCase {
    /**
     * Test de la création d'un objet CoursSession
     */
    public void testCreer() {
        Date date = DateUtil.creerDate(2016, 2, 3);
        Calendar calendrier = new GregorianCalendar();
        calendrier.setTime(date);

        assertEquals(2016, calendrier.get(Calendar.YEAR));
        assertEquals(Calendar.FEBRUARY, calendrier.get(Calendar.MONTH));
        assertEquals(3, calendrier.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Test de validité de la date
     */
    public void testValiditeDate() {
        // Tests avec date invalide
        Date m_date;

        try {
            m_date = DateUtil.creerDate(2016, 4, 31); // Avril à seulement 30 jours
            fail("devrait etre une exception FormatDateDebutCoursException");
        }
        catch (FormatDateDebutCoursException e) {
            assertEquals(e.getMessage(), "Jour invalide");
        }

        try {
            m_date = DateUtil.creerDate(2016, 13, 3); // 13 est un mois invalide
            fail("devrait etre une exception FormatDateDebutCoursException");
        }
        catch (FormatDateDebutCoursException e) {
            assertEquals(e.getMessage(), "Mois invalide");
        }

        try {
            m_date = DateUtil.creerDate(0, 2, 3); // 0 est une année invalide
            fail("devrait etre une exception FormatDateDebutCoursException");
        }
        catch (FormatDateDebutCoursException e) {
            assertEquals(e.getMessage(), "Année invalide");
        }

        // Tests avec date valide
        m_date = DateUtil.creerDate(2016, 4, 30);
        Calendar cal = Calendar.getInstance();
        cal.setTime(m_date);
        assertEquals(cal.get(Calendar.YEAR), 2016);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 30);
        assertEquals(cal.get(Calendar.MONTH), Calendar.APRIL);

    }
}