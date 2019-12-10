package model;

public class Constantes {

    public static final int tailleCase = 32;
    public static final int INITIAL_SCORE = 100;
    public static final int NB_ETAGE = 5;
    public static final int TAILLE = 25; //hauteur et largeur du labyrinthe

    public final static int BAS = 0, HAUT = 2, GAUCHE = 1, DROITE = 3;

    public enum DIRECTION {
        HAUT, BAS, GAUCHE, DROITE
    }
}
