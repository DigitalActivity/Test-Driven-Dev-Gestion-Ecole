package ecole.rapport;

import ecole.etudiant.Etudiant;
import java.util.EnumMap;
import java.util.Map;

/**
 * Classe RapportBulletin
 * @author Rabdi Younes
 */
public class RapportBulletin {
    static public final String MESSAGE_A = "Excellent";
    static public final String MESSAGE_B = "Très bien";
    static public final String MESSAGE_C = "Ok";
    static public final String MESSAGE_D = "À améliorer";
    static public final String MESSAGE_E = "Échec scrub!";

    private Map<Etudiant.Note, String> m_messages = null;

    public String getMessage(Etudiant.Note p_note) {
        return getMessages().get(p_note);
    }

    private Map<Etudiant.Note, String> getMessages() {
        if (m_messages == null) {
            chargerMessages();
        }

        return m_messages;
    }

    private void chargerMessages() {
        m_messages = new EnumMap<Etudiant.Note, String>(Etudiant.Note.class);

        m_messages.put(Etudiant.Note.A, MESSAGE_A);
        m_messages.put(Etudiant.Note.B, MESSAGE_B);
        m_messages.put(Etudiant.Note.C, MESSAGE_C);
        m_messages.put(Etudiant.Note.D, MESSAGE_D);
        m_messages.put(Etudiant.Note.E, MESSAGE_E);
    }
}