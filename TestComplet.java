package ecole;

import ecole.Pointage.TestStrategiePoints;
import ecole.Pointage.TestStrategiePointsDifficiles;
import ecole.cours.*;
import ecole.etudiant.TestEtudiant;
import ecole.rapport.TestRapportBulletin;
import ecole.rapport.TestRapportCours;
import ecole.rapport.TestRapportInscription;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Classe test complet
 *  @author Rabdi Younes
 */
public class TestComplet extends TestCase {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestEtudiant.class);
        suite.addTestSuite(TestCoursEte.class);
        suite.addTestSuite(TestCoursSession.class);
        suite.addTestSuite(TestDateUtil.class);
        suite.addTestSuite(TestNoteUtil.class);
        suite.addTestSuite(TestStrategiePoints.class);
        suite.addTestSuite(TestStrategiePointsDifficiles.class);
        suite.addTestSuite(TestRapportInscription.class);
        suite.addTestSuite(TestRapportBulletin.class);
        suite.addTestSuite(TestRapportCours.class);
        return suite;
    }
}