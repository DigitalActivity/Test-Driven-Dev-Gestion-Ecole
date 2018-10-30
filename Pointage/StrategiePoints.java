package ecole.Pointage;

import ecole.etudiant.Etudiant;

/**
 * Classe StrategiePoints
 *  @author Rabdi Younes
 */
public class StrategiePoints implements StrategiePointage {
    @Override
    public int getNombrePointsPourNote(Etudiant.Note p_note) {
        return p_note.getPoints();
    }
}