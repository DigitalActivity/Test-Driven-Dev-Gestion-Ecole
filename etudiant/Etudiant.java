package ecole.etudiant;

import ecole.Exception.FormatNomEtudiantException;
import ecole.Pointage.StrategiePointage;
import ecole.Pointage.StrategiePoints;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  Classe Étudiant
 *  @author Rabdi Younes
 */
public class Etudiant {
    /**
     * Note : Détérminer nombre de points pour une note
     */
    public enum Note {
        A(4),
        B(3),
        C(2),
        D(1),
        E(0);
        private final int m_points;
        Note(int p_points) {
            m_points = p_points;
        }
        public int getPoints() {
            return m_points;
        }
    }

    public static final int UNITES_POUR_TEMPSPLEIN = 8; // Nombre d'unité pour être à temps plein
    public static final String CANADIEN = "CA"; // Code pour le canada
    private String m_nom;
    private String m_prenom;
    private String m_deuxiemeNom;
    private int m_unites; // Unités complétées par un étudiant
    private String m_pays = "";
    private final List<Note> m_notes = new ArrayList<>();
    private StrategiePointage m_strategiePointage = new StrategiePoints();

    /**
     * Constructeur Etudiant
     * @param p_nom Nom de l'étudiant
     */
    public Etudiant(String p_nom) throws FormatNomEtudiantException {
        StringTokenizer st = new StringTokenizer(p_nom, " ");

        if (st.countTokens() > 3) {
            throw new FormatNomEtudiantException("Nom etudiant contient plus de 3 parties");
        }
        if (st.countTokens() < 2 ) {
            throw new FormatNomEtudiantException("Nom etudiant incomplet");
        }

        this.m_unites = 0;
        this.m_prenom = st.nextToken();
        this.m_nom = st.nextToken();
        if(st.hasMoreTokens()) {
            this.m_deuxiemeNom = st.nextToken();
        }
        else {
            this.m_deuxiemeNom = "";
        }
    }

    public String getNom() {
        return m_nom;
    }

    public String getPrenom() {
        return m_prenom;
    }

    public String getDeuxiemeNom() {
        return m_deuxiemeNom;
    }

    /**
     * Obtenir le nom complet : prenom nom deuxiemeNom
     * @return nom complet de l'étudiant
     */
    public String getNomComplet() {
        return this.m_prenom.concat(" ").concat(this.m_nom).concat(this.m_deuxiemeNom.equals("") ? this.m_deuxiemeNom : " " + this.m_deuxiemeNom);
    }

    /**
     * Obtenir nombre unités
     * @return nombre d'unités pour cette étudiant
     */
    public int getUnites() {
        return this.m_unites;
    }

    /**
     * Définir la strategie de pointage
     * @param p_strategiePointage strategie de pointage
     */
    public void setStrategiePointage(StrategiePointage p_strategiePointage) {
        m_strategiePointage = p_strategiePointage;
    }

    /**
     * Associe le pays à l'étudiant
     * @param p_pays Le pays de l'étudiant
     */
    public void setPays(String p_pays) {
        this.m_pays = p_pays;
    }

    /**
     * Ajouter une nouvelle note
     * @param p_note note à ajouter
     */
    public void ajouterNote(Note p_note) {
        m_notes.add(p_note);
    }

    /**
     * Ajoute des unites à l'étudiant
     * @param p_unites Le nombre d'unités à ajouter
     */
    public void ajouterUnites(int p_unites) {
        this.m_unites += p_unites;
    }

    /**
     * Est inscrit à temps plein
     * @return Si l'étudiant est à temps plein
     */
    public boolean estTempsPlein() {
        return this.m_unites >= UNITES_POUR_TEMPSPLEIN;
    }

    /**
     * Est Canadien
     * @return Si l'étudiant est canadien
     */
    public boolean estCanadien() { return this.m_pays.equals(Etudiant.CANADIEN); }

    /**
     * Obtenir la moyenne
     * @return moyenne de l'etudiant
     */
    public double getMoyenne() {
        if (m_notes.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (Note note : m_notes) {
            total += m_strategiePointage.getNombrePointsPourNote(note);
        }

        try {
            return total / m_notes.size();
        }
        catch (ArithmeticException e) {
            System.out.println("Division par zéro");
        }

        return 0.0;
    }
}