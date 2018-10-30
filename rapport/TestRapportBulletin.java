package ecole.rapport;

import ecole.etudiant.Etudiant;
import junit.framework.TestCase;

/**
 * Classe tests pour RapportBulletin
 * @author Rabdi Younes
 * @see RapportBulletin
 */
public class TestRapportBulletin extends TestCase {
    public void testMessage() {
        RapportBulletin rapportBulletin = new RapportBulletin();

        assertEquals(RapportBulletin.MESSAGE_A, rapportBulletin.getMessage(Etudiant.Note.A));
        assertEquals(RapportBulletin.MESSAGE_B, rapportBulletin.getMessage(Etudiant.Note.B));
        assertEquals(RapportBulletin.MESSAGE_C, rapportBulletin.getMessage(Etudiant.Note.C));
        assertEquals(RapportBulletin.MESSAGE_D, rapportBulletin.getMessage(Etudiant.Note.D));
        assertEquals(RapportBulletin.MESSAGE_E, rapportBulletin.getMessage(Etudiant.Note.E));
    }
}
