package ecole.cours;

import ecole.Exception.FormatDateDebutCoursException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *  @author Rabdi Younes
 */
public class DateUtil {
    /**
     * Constructeur privée pour éviter les instances
     */
    private DateUtil() {}

    /**
     * Création d'une Date
     * @param p_annee année de la date
     * @param p_mois mois de la date
     * @param p_jour jour de la date
     * @return la date créée
     */
    public static Date creerDate(int p_annee, int p_mois, int p_jour) throws FormatDateDebutCoursException {
        GregorianCalendar calendrier = new GregorianCalendar();
        calendrier.clear();
        calendrier.setLenient(false);

        if (p_annee <= calendrier.getMinimum(Calendar.YEAR) || p_annee > calendrier.getMaximum(Calendar.YEAR)) {
            throw new FormatDateDebutCoursException("Année invalide");
        }
        calendrier.set(Calendar.YEAR, p_annee);

        if (p_mois <= 0 || p_mois > 12) {
            throw new FormatDateDebutCoursException("Mois invalide");
        }
        calendrier.set(Calendar.MONTH, p_mois - 1);

        if (p_jour <= 0 || p_jour > calendrier.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            throw new FormatDateDebutCoursException("Jour invalide");
        }
        calendrier.set(Calendar.DAY_OF_MONTH, p_jour);

        return calendrier.getTime();
    }
}