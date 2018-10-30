package ecole.Pointage;

import ecole.etudiant.Etudiant;
import junit.framework.TestCase;

/**
 * Classe test pour strategie points
 *  @author Rabdi Younes
 *  @see StrategiePoints
 */
public class TestStrategiePoints extends TestCase {
    public void testGetPoints() {
        StrategiePoints strategiePoints = new StrategiePoints();
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.A), 4);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.B), 3);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.C), 2);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.D), 1);
        assertEquals(strategiePoints.getNombrePointsPourNote(Etudiant.Note.E), 0);
    }
}