package ecole.rapport;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Classe de tests pour tout le package ecole.etudiant
 * @author Gabriel T. St-Hilaire
 */
public class TestComplet extends TestCase {
    /**
     * @return la suite de tests à effectuer
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        suite.addTestSuite(TestRapportInscription.class);
        suite.addTestSuite(TestRapportCours.class);
        suite.addTestSuite(TestRapportBulletin.class);

        return suite;
    }
}