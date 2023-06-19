package boggle.model;

import boggle.Observateur;

import java.util.ArrayList;
import java.util.Random;

public class Boggle  {

    private ArrayList<Observateur> obs = new ArrayList<>(10);
    private static char[] voyelles = {'A', 'E', 'I', 'O', 'U', 'Y'};
    private static char[] consonnes = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'};
    private char[][] lettres;
    private StringBuilder mot;
    private StringBuilder motvalid;
    private int valid;
    private int score = 0;
    private int ligneChoisie, colonneChoisie ;  // dernière case choisie


    /**
     * Des voyelles sur les lignes impaires ; des consonnes sur les lignes paires
     * @param taille
     */
    public Boggle(int taille) {
        this.lettres = new char[taille][taille];
        Random gen = new Random();
        for (int lig = 0; lig < taille; lig++)
            if (lig%2==0)
                for (int col = 0; col < taille; col++)
                    lettres[lig][col] = voyelles[gen.nextInt(6)];
            else
                for (int col = 0; col < taille; col++)
                    lettres[lig][col] = consonnes[gen.nextInt(20)];

        this.valid = 0;
        this.motvalid = new StringBuilder("");
        this.mot = new StringBuilder("");
        this.ligneChoisie = -1 ;
        this.colonneChoisie = -1 ;
    }

    /**
     * @return taille du jeu (carré)
     */
    public int getTaille() {
        return this.lettres.length;
    }

    /**
     * @return score de la partie en cours
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @param l
     * @param c
     * @return lettre de la case spécifiée
     */
    public char getLettre(int l, int c) {
        return this.lettres[l][c] ;
    }

    /**
     * @return mot en cours de construction
     */
    public String getMotChoisi() {
        return this.mot.toString();
    }

    public String getMotValid(){
        return this.motvalid.toString();
    }

    public void resetMotValid(){
        this.motvalid = new StringBuilder("");
    }
    /**
     * @param ligneChoisie
     * @param colonneChoisie
     * @param lig
     * @param col
     * @return vrai si les cases sont contigües
     */
    private boolean casesContigues(int ligneChoisie, int colonneChoisie, int lig, int col) {
        int diffL = Math.abs(ligneChoisie - lig) ;
        int diffC = Math.abs(colonneChoisie - col) ;
        return ! ((diffL == 0) && (diffC == 0))  && diffL <=1 && diffC <=1 ;
    }

    /**
     * Valider le mot en cours de construction
     * s'il est dans le dictionnaire, le score est incrémenté du nombre de lettres
     * sinon, le score est décrementé de 1
     */
    public void valider() {
        Dictionnaire dico = Dictionnaire.getInstance() ;
        if (dico.contient(mot.toString())) {
            this.score += this.mot.length();
            this.motvalid = this.mot;
            this.valid = 1;
        }
        else
            this.score -= 1 ;
        this.mot = new StringBuilder("");
        this.notifierObservateurs();
        this.valid = 0;
    }

    /**
     * Effacer le mot en cours de construction
     */
    public void effacer() {
        this.mot = new StringBuilder("");
        this.ligneChoisie = -1 ;
        this.colonneChoisie = -1 ;
        this.notifierObservateurs();
    }


    /**
     * La lettre en case lig, col a été choisie
     * On conserve la lettre si la case est contigüe à la précédente
     * @param lig
     * @param col
     */
    public void ajouterLettre(int lig, int col) {
        if (this.ligneChoisie==-1 || casesContigues(this.ligneChoisie, this.colonneChoisie, lig, col)) {
            this.mot.append(this.getLettre(lig, col));
            this.ligneChoisie = lig;
            this.colonneChoisie = col;
            this.notifierObservateurs();
        }
    }

    public void ajouterObservateur(Observateur o) {
        this.obs.add(o) ;
    }

    public void notifierObservateurs() {
        for (Observateur o : this.obs) o.reagir() ;
    }

    public int getValid(){
        return this.valid;
    }

}
