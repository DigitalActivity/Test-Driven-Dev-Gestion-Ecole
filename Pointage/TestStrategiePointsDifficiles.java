package ecole.Pointage;

import ecole.etudiant.Etudiant;
import junit.framework.TestCase;

/**
 * Classe tests pour strategie de pointage
 *  @author Rabdi Younes
 *  @see StrategiePointage
 */
public class TestStrategiePointsDifficiles extends TestCase {
    public void testGetPointsDifficiles() {
        StrategiePointageDifficile strategiePoints = new StrategiePointageDifficile();
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.A), 5);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.B), 4);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.C), 3);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.D), 2);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.E), 0);
    }
}
