package ecole.cours;

import ecole.etudiant.Etudiant;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 *  Class Cours
 *  @author Rabdi Younes
 */
abstract public class Cours implements Comparable<CoursSession>, Iterable<Etudiant> {
    private final String m_departement;
    private final String m_numero;
    private final ArrayList<Etudiant> m_etudiants = new ArrayList<>();
    private final Date m_dateDebut;
    private int m_nombreUnites = 0;
    private URL m_url;

    /**
     * iterateur sur etudiants
     * @return iterator sur le premier element
     */
    @Override
    public Iterator<Etudiant> iterator() {
        return this.m_etudiants.iterator();
    }

    /**
     * Constructeur
     * @param p_departement Département du cours
     * @param p_numero Numéro du cours
     * @param p_dateDebut La date de début du cours
     */
    protected Cours(String p_departement, String p_numero, Date p_dateDebut) {
        this.m_departement = p_departement;
        this.m_numero = p_numero;
        this.m_dateDebut = p_dateDebut;
    }

    /**
     * Obtenir le département
     * @return nom département
     */
    public String getDepartement() {
        return this.m_departement;
    }

    /**
     * Obtenir le numéro du cours
     * @return numéro du cours
     */
    public String getNumero() {
        return this.m_numero;
    }

    /**
     * Obtenir liste d'étudiant inscrits au cours
     * @return liste étudiants
     */
    public ArrayList<Etudiant> getEtudiants() { return this.m_etudiants; }

    /**
     * Obtenir date début du cours
     * @return date début du cours
     */
    public Date getDateDebut() {
        return this.m_dateDebut;
    }

    /**
     * Obtenir nombre d'étudiants inscrits au cours
     * @return nombre d'étudiants inscrits
     */
    public int getNombreEleves() {
        return this.m_etudiants.size();
    }

    /**
     * Obtenir étudiant selon index
     * @param p_index de l'étudiant
     * @return étudiant
     */
    public Etudiant getEtudiant(int p_index) {
        return this.m_etudiants.get(p_index);
    }

    /**
     * Obtenir date fin de session
     * @return date fin
     */
    public Date getDateFinSession() {
        GregorianCalendar calendrier = new GregorianCalendar();
        calendrier.setTime(m_dateDebut);
        calendrier.add(Calendar.DAY_OF_YEAR, getDureeSession() * 7);

        return calendrier.getTime();
    }

    /**
     * Obtenir la moyenne des étudiants à temps partiel
     * @return moyenne
     */
    public double getMoyenneElevesTempsPartiel() {
        double moyenne = 0.0;
        int cpt = 0;
        for(Etudiant e : getEtudiants()) {
            if( !e.estTempsPlein()) {
                moyenne += e.getMoyenne();
                cpt++;
            }
        }

        if(cpt == 0) {
            return 0.0;
        }

        return moyenne/cpt;
    }

    /**
     * Obtenir la durrée (en semaines) de la session
     * @return durée session
     */
    abstract protected int getDureeSession();

    /**
     * Pour ajouter un élève à la liste des étudiants inscrits au cours
     * @param p_etudiant L'étudiant à inscrire
     */
    public void inscrire(Etudiant p_etudiant) {
        this.m_etudiants.add(p_etudiant);
        p_etudiant.ajouterUnites(m_nombreUnites);
    }

    /**
     * Définir le nombre d'unités
     * @param p_nombreUnites nombre d'unités
     */
    public void setNombreUnites(int p_nombreUnites) {
        this.m_nombreUnites = p_nombreUnites;
    }

    /**
     * Comparer les cours selon departement et numero de cours
     * @param p_coursSession cours à comparer avec
     * @return 0 si egaux, -1 et 1 si plus petit ou plus grand respectivement.
     */
    @Override
    public int compareTo(CoursSession p_coursSession) {
        int compareDepartement = this.getDepartement().
                compareTo(p_coursSession.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return this.getNumero().compareTo(p_coursSession.getNumero());
    }

    /**
     * Définir url
     * @param p_url url à inserer
     * @throws MalformedURLException url format incorrect
     */
    public void setUrl(String p_url) throws MalformedURLException {
        m_url = new URL(p_url);
    }

    /**
     * Obtenir url
     * @return url
     */
    public URL getUrl() {
        return m_url;
    }
}