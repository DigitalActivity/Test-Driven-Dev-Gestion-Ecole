package ecole.rapport;

import ecole.cours.CoursSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe RapportCours
 * @author Rabdi Younes
 */
public class RapportCours {
    private final List<CoursSession> m_coursSession = new ArrayList<>();

    public void ajouterCours(CoursSession p_coursSession) {
        m_coursSession.add(p_coursSession);
    }

    public String getRapportCours() {
        StringBuilder builder = new StringBuilder();

        Collections.sort(m_coursSession);

        for (CoursSession cours : m_coursSession) {
            builder.append(cours.getDepartement()).append(" ").append(cours.getNumero()).append(ConstantesRapport.SAUTLIGNE);
        }

        return builder.toString();
    }
}