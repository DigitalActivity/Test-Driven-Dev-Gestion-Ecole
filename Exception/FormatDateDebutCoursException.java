package ecole.Exception;

/**
 * Classe FormatDateDebutCoursException : date debut cours invalide
 */
public class FormatDateDebutCoursException  extends IllegalArgumentException {
    public FormatDateDebutCoursException(String message) {
        super(message);
    }
}
