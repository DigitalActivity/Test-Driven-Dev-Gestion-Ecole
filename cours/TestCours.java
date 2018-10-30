package ecole.cours;

import ecole.etudiant.Etudiant;
import junit.framework.TestCase;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Classe de tests pour Cours
 * @see Cours
 */
abstract public class TestCours  extends TestCase {
    private Cours m_cours;
    private Date m_dateDebut;

    /**
     * Code à exécuter avant chaque test
     */
    public void setUp() {
        this.m_dateDebut = DateUtil.creerDate(2016, 2, 2);
        this.m_cours = creerCours("Philo", "101", m_dateDebut);
    }

    /**
     * Fabrique pour créer un cours session
     * @return une nouvelle instance de Cours
     */
    abstract protected Cours creerCours(String p_departement, String p_numero, Date p_dateDebut);

    /**
     * Test de la création d'un objet CoursSession
     */
    public void testCreer() {
        assertEquals("Philo", this.m_cours.getDepartement());
        assertEquals("101", this.m_cours.getNumero());
        assertEquals(0, this.m_cours.getNombreEleves());
        assertEquals(this.m_dateDebut, this.m_cours.getDateDebut());
    }

    /**
     * Test d'inscriptions d'étudiants à un CoursSession
     */
    public void testInscrireEtudiants() {
        Etudiant etudiant1 = new Etudiant("Gabriel St-Hilaire");
        this.m_cours.inscrire(etudiant1);
        assertEquals(1, this.m_cours.getNombreEleves());
        assertEquals(etudiant1, m_cours.getEtudiant(0));

        Etudiant etudiant2 = new Etudiant("Bob Binette");
        this.m_cours.inscrire(etudiant2);
        assertEquals(2, this.m_cours.getNombreEleves());
        assertEquals(etudiant1, m_cours.getEtudiant(0));
        assertEquals(etudiant2, m_cours.getEtudiant(1));
    }

    /**
     * Test moyenne des eleves à temps partiel
     */
    public void testMoyenneElevesTempsPartiel() {
        Etudiant etudiant = new Etudiant("Etudiant 1");
        Cours a = creerCours("Philo", "101", m_dateDebut);
        a.setNombreUnites(1);
        Cours b = creerCours("Math", "102", m_dateDebut);
        b.setNombreUnites(3);
        Cours c = creerCours("Francais", "103", m_dateDebut);
        c.setNombreUnites(3);
        Cours d = creerCours("Anglais", "104", m_dateDebut);
        d.setNombreUnites(2);
        Cours e = creerCours("Programmation", "105", m_dateDebut);
        e.setNombreUnites(1);
        Cours f = creerCours("Initiation", "106", m_dateDebut);
        f.setNombreUnites(3);
        Cours g = creerCours("Multimedia", "107", m_dateDebut);
        g.setNombreUnites(2);
        a.inscrire(etudiant);
        b.inscrire(etudiant);
        c.inscrire(etudiant);
        d.inscrire(etudiant);
        e.inscrire(etudiant);
        assertTrue(etudiant.estTempsPlein());
        etudiant.ajouterNote(Etudiant.Note.A);
        etudiant.ajouterNote(Etudiant.Note.B);
        etudiant.ajouterNote(Etudiant.Note.C);
        assertEquals(a.getMoyenneElevesTempsPartiel(), 0.0 ); // aucun etudiant temps partiel

        Etudiant etudiant2 = new Etudiant("Etudiant 2");
        f.inscrire(etudiant2);
        g.inscrire(etudiant2);
        assertFalse(etudiant2.estTempsPlein());
        etudiant2.ajouterNote(Etudiant.Note.C);
        etudiant2.ajouterNote(Etudiant.Note.C);
        etudiant2.ajouterNote(Etudiant.Note.C);

        assertEquals(f.getMoyenneElevesTempsPartiel(), 2.0 ); // c
    }

    public void testIterable() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        for(Iterator<Etudiant> it = m_cours.getEtudiants().iterator(); it.hasNext();) {
            etudiants.add(it.next());
        }
        assertEquals(m_cours.getEtudiants(), etudiants);
    }

    public void testURL() throws MalformedURLException {
        final String url = "http://google.ca/testCourts";
        m_cours.setUrl(url);
        assertEquals(url, m_cours.getUrl().toString());
    }

    public void testInvalideURL()  {
        final String url = "ht//google.ca/testCourts";
        try{
            m_cours.setUrl(url);
            fail("devrait etre une exception");
        }
        catch(MalformedURLException e) {
            System.out.println("Exception gérée dans testInvalideURL : " + e.getMessage());
        }
        assertEquals(null, m_cours.getUrl());
    }
}
