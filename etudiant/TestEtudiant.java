package ecole.etudiant;

import ecole.Exception.FormatNomEtudiantException;
import ecole.Pointage.StrategiePointageDifficile;
import ecole.Pointage.StrategiePoints;
import junit.framework.TestCase;

/**
 *  Classe test pour étudiant
 *  @author Rabdi Younes
 *  @see Etudiant
 */
public class TestEtudiant extends TestCase {
    private static final double TOLERANCE_NOTE = 0.5;
    final private String nomValide1 = "Gabriel Trudeau St-Hilaire";
    final private String nomValide2 = "Younes Rabdi";
    private Etudiant etudiant1;
    private Etudiant etudiant2;

    /**
     * Test de la création d'un objet Etudiant valide
     */
    public void testCreer() {

        etudiant1 = new Etudiant(nomValide1);
        assertEquals(nomValide1, etudiant1.getNomComplet());
        etudiant2 = new Etudiant(nomValide2);
        assertEquals(nomValide2, etudiant2.getNomComplet());
    }

    /**
     * Test nom étudiant valide
     */
    public void testNomEtudiant() {
        etudiant1 = new Etudiant(nomValide1);
        assertEquals("Trudeau", etudiant1.getNom());
        assertEquals("Gabriel", etudiant1.getPrenom());
        assertEquals("St-Hilaire", etudiant1.getDeuxiemeNom());
        assertEquals(nomValide1, etudiant1.getNomComplet());

        etudiant2 = new Etudiant(nomValide2);
        assertEquals("Rabdi", etudiant2.getNom());
        assertEquals("Younes", etudiant2.getPrenom());
        assertEquals("", etudiant2.getDeuxiemeNom());
        assertEquals(nomValide2, etudiant2.getNomComplet());
    }

    /**
     * Test nom étudiants non valides
     */
    public void testNomEtudiantInvalide() {
        // test nom etudiant avec plus de 3 parties
        String nomInvalide3 = "Gabriel Trudeau St Hilaire";

        try {
            etudiant1 = new Etudiant(nomInvalide3);
            fail("devrait etre une exception");
        }
        catch (FormatNomEtudiantException e) {
            assertEquals(e.getMessage(), "Nom etudiant contient plus de 3 parties");
        }

        // test nom etudiant avec moins de 2 parties
        String nomInvalide4 = "Younes";

        try {
            etudiant2 = new Etudiant(nomInvalide4);
            fail("devrait etre une exception");
        }
        catch (FormatNomEtudiantException e) {
            assertEquals(e.getMessage(), "Nom etudiant incomplet");
        }
    }

    /**
     * Test pour vérifier les unites pour un etudiant
     */
    public void testUnites() {
        etudiant1 = new Etudiant(nomValide1);
        assertEquals(0, etudiant1.getUnites());

        etudiant1.ajouterUnites(3);
        assertEquals(3, etudiant1.getUnites());

        etudiant1.ajouterUnites(4);
        assertEquals(7, etudiant1.getUnites());
    }

    /**
     * Test de la création d'étudiant temps plein
     */
    public void testTempsPlein() {
        etudiant2 = new Etudiant(nomValide2);
        assertEquals(0, etudiant2.getUnites());
        assertFalse(etudiant2.estTempsPlein());

        etudiant2.ajouterUnites(3);
        assertEquals(3, etudiant2.getUnites());
        assertFalse(etudiant2.estTempsPlein());

        etudiant2.ajouterUnites(4);
        assertEquals(7, etudiant2.getUnites());
        assertFalse(etudiant2.estTempsPlein());

        etudiant2.ajouterUnites(1);
        assertEquals(Etudiant.UNITES_POUR_TEMPSPLEIN, etudiant2.getUnites());
        assertTrue(etudiant2.estTempsPlein());
    }

    /**
     * Test la provenance de l'étudiant
     */
    public void testEtranger() {
        etudiant1 = new Etudiant(nomValide1);
        assertFalse(etudiant1.estCanadien());

        etudiant1.setPays(Etudiant.CANADIEN);
        assertTrue(etudiant1.estCanadien());

        etudiant1.setPays("FR");
        assertFalse(etudiant1.estCanadien());
    }

    /**
     * Test moyenne de l'étudiant
     */
    public void testMoyenne() {
        etudiant1 = new Etudiant(nomValide2);
        etudiant1.setStrategiePointage(new StrategiePoints());

        assertEquals(0.0, etudiant1.getMoyenne(), TOLERANCE_NOTE);

        etudiant1.ajouterNote(Etudiant.Note.A);
        assertEquals(4.0, etudiant1.getMoyenne(), TOLERANCE_NOTE);

        etudiant1.ajouterNote(Etudiant.Note.B);
        assertEquals(3.5, etudiant1.getMoyenne(), TOLERANCE_NOTE);

        etudiant1.ajouterNote(Etudiant.Note.C);
        assertEquals(3.0, etudiant1.getMoyenne(), TOLERANCE_NOTE);

        etudiant1.ajouterNote(Etudiant.Note.D);
        assertEquals(2.5, etudiant1.getMoyenne(), TOLERANCE_NOTE);

        etudiant1.ajouterNote(Etudiant.Note.E);
        assertEquals(2.0, etudiant1.getMoyenne(), TOLERANCE_NOTE);

        // test avec 2eme Etudiant
        etudiant2 = new Etudiant(nomValide2);
        etudiant2.setStrategiePointage(new StrategiePointageDifficile());

        assertEquals(0.0, etudiant2.getMoyenne(), TOLERANCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.A);
        assertEquals(5.0, etudiant2.getMoyenne(), TOLERANCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.B);
        assertEquals(4.5, etudiant2.getMoyenne(), TOLERANCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.C);
        assertEquals(4.0, etudiant2.getMoyenne(), TOLERANCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.D);
        assertEquals(3.5, etudiant2.getMoyenne(), TOLERANCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.E);
        assertEquals(2.8, etudiant2.getMoyenne(), TOLERANCE_NOTE);
    }
}