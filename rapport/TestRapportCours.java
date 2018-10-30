package ecole.rapport;

import ecole.cours.CoursSession;
import ecole.cours.DateUtil;
import junit.framework.TestCase;

import java.util.Date;

/**
 * Classe tests pour rapport cours
 * @author Rabdi Younes
 * @see ecole.cours.Cours
 */
public class TestRapportCours extends TestCase {
    public void testRapport() {
        final Date date = DateUtil.creerDate(2014, 1, 20);

        RapportCours rapport = new RapportCours();
        rapport.ajouterCours(CoursSession.creer("FRANÇAIS", "101", date));
        rapport.ajouterCours(CoursSession.creer("MATHÉMATIQUE", "301", date));
        rapport.ajouterCours(CoursSession.creer("PHILOSOPHIE", "301", date));
        rapport.ajouterCours(CoursSession.creer("MATHÉMATIQUE", "201", date));
        rapport.ajouterCours(CoursSession.creer("PHILOSOPHIE", "201", date));

        assertEquals("FRANÇAIS 101" + ConstantesRapport.SAUTLIGNE +
                        "MATHÉMATIQUE 201" + ConstantesRapport.SAUTLIGNE +
                        "MATHÉMATIQUE 301" + ConstantesRapport.SAUTLIGNE +
                        "PHILOSOPHIE 201" + ConstantesRapport.SAUTLIGNE +
                        "PHILOSOPHIE 301" + ConstantesRapport.SAUTLIGNE,
                        rapport.getRapportCours());
    }
}