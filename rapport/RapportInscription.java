package ecole.rapport;

import ecole.cours.CoursSession;
import ecole.etudiant.Etudiant;

/**
 * Classe représentant un rapport d'inscriptions
 * @author Gabriel T. St-Hilaire
 */
public class RapportInscription {
    public static final String SAUTLIGNE_RAPPORT_INSCRIPTION = System.getProperty("line.separator");
    public static final String ENTETE_RAPPORT_INSCRIPTION = SAUTLIGNE_RAPPORT_INSCRIPTION +
            "----------" +
            SAUTLIGNE_RAPPORT_INSCRIPTION;
    public static final String PIEDPAGE_RAPPORT_INSCRIPTION = SAUTLIGNE_RAPPORT_INSCRIPTION +
            "----------" +
            SAUTLIGNE_RAPPORT_INSCRIPTION +
            "Nombre d'étudiants : ";

    private final CoursSession m_coursSession; // Le cours qui servira pour générer le rapport

    /**
     * Constructeur
     * @param p_coursSession Le cours pour générer le rapport
     */
    RapportInscription(CoursSession p_coursSession) {
        this.m_coursSession = p_coursSession;
    }

    /**
     * @return Un rapport des inscriptions d'élèves
     */
    public String getRapportInscription() {
        StringBuilder builder = new StringBuilder();

        builder.append(ENTETE_RAPPORT_INSCRIPTION);

        for (Etudiant etudiant : this.m_coursSession.getEtudiants()) {
            builder.append(etudiant.getNomComplet());
            builder.append(SAUTLIGNE_RAPPORT_INSCRIPTION);
        }

        builder.append(PIEDPAGE_RAPPORT_INSCRIPTION);
        builder.append(this.m_coursSession.getNombreEleves());

        return builder.toString();
    }
}