package ecole.rapport;

import ecole.cours.CoursSession;
import ecole.cours.DateUtil;
import ecole.etudiant.Etudiant;
import junit.framework.TestCase;

/**
 * Classe tests pour les rapport d'inscription
 * @author Rabdi Younes
 * @see RapportInscription
 */
public class TestRapportInscription extends TestCase {
    /**
     * Test de la création des rapports d'inscriptons
     */
    public void testRapportInscription() {
        CoursSession coursSession = CoursSession.creer("Philo", "101", DateUtil.creerDate(2016, 2, 2));
        coursSession.inscrire(new Etudiant("Albert Z."));
        coursSession.inscrire(new Etudiant("Céline Q."));

        String rapportInscription = new RapportInscription(coursSession).getRapportInscription();

        assertEquals(RapportInscription.ENTETE_RAPPORT_INSCRIPTION +
                "Albert Z." + ConstantesRapport.SAUTLIGNE +
                "Céline Q." + ConstantesRapport.SAUTLIGNE +
                RapportInscription.PIEDPAGE_RAPPORT_INSCRIPTION + "2", rapportInscription);
    }
}