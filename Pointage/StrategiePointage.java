package ecole.Pointage;

import ecole.etudiant.Etudiant;

/**
 * Classe StrategiePointage
 *  @author Rabdi Younes
 */
public interface StrategiePointage {
    int getNombrePointsPourNote(Etudiant.Note p_note);
}
