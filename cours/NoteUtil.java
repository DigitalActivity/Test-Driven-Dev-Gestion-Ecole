package ecole.cours;

/**
 * Classe NoteUtil : Convertir et valides les notes
 */
public class NoteUtil {
    /**
     * Convertir string en int
     * @param p_str String representant la note
     * @return int value of p_srt
     */
    public static int convertirNote(String p_str) {
        return Integer.parseInt(p_str);
    }

    public static boolean estValide(String p_note) {
        try {
            convertirNote(p_note);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}