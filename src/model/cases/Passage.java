package model.cases;

import model.Constantes;
import model.Hero;
import model.Labyrinthe;
import model.Personnage;
import model.creationLabyrinthe.CreationAleatoire;
import model.factory.ImageFactory;

import java.awt.*;

public class Passage extends Sol {

    private Labyrinthe labyrinthe;

    private int largeur, hauteur;

    public Passage(Labyrinthe labyrinthe, int largeur, int hauteur) {
        this.labyrinthe = labyrinthe;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void declancher(Personnage p) {
        if (p instanceof Hero) {
            CreationAleatoire creationAleatoire = new CreationAleatoire(largeur, hauteur);
            labyrinthe.supprimerLesMonstres();
            labyrinthe.reinitialiserPositionHero();
            creationAleatoire.creerLabyrinthe(labyrinthe);
            labyrinthe.creerMonstreVert();
            labyrinthe.creerMonstreVert();
        }
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        g.drawImage(ImageFactory.getPassage(), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
    }
}
