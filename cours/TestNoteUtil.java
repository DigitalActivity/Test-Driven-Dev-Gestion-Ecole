package ecole.cours;

import junit.framework.TestCase;

/**
 * Classe tests pour NoteUtil
 * @author Younes Rabdi
 * @see NoteUtil
 */
public class TestNoteUtil extends TestCase {
    public void testSaisieNote() {
        assertEquals(75, NoteUtil.convertirNote("75"));
    }

    public void testMauvaiseNote() {
        try{
            NoteUtil.convertirNote("10s");
            fail("Mauavis format de nombre");
        }
        catch (NumberFormatException e) {
            System.out.println("Exception gérée dans testMauvaiseNote : " + e.getMessage());
        }
    }

    public void testInvalide() {
        assertTrue(NoteUtil.estValide("98"));
        assertTrue(!NoteUtil.estValide("ad"));
    }
}