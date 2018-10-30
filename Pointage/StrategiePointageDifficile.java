package ecole.Pointage;

import ecole.etudiant.Etudiant;

/**
 * Classe StrategiePointageDifficile
 *  @author Rabdi Younes
 */
public class StrategiePointageDifficile extends StrategiePoints {
    @Override
    public int getNombrePointsPourNote(Etudiant.Note p_note) {
        int points = super.getNombrePointsPourNote(p_note);

        if (points > 0) {
            points += 1;
        }

        return points;
    }
}
