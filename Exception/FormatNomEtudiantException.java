package ecole.Exception;

/**
 * Classe exception FormatNomEtudiantException : Nom etudiant invalide
 */
public class FormatNomEtudiantException extends IllegalArgumentException {
    public FormatNomEtudiantException(String message) {
        super(message);
    }
}