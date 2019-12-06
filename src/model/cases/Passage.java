package model.cases;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import model.Constantes;
import model.Hero;
import model.Labyrinthe;
import model.Personnage;
import model.creationLabyrinthe.CreationAleatoire;
import model.creationLabyrinthe.CreationFichierTexte;
import model.creationLabyrinthe.CreationLabyrinthe;
import model.factory.ImageFactory;
import model.factory.MonstreFactory;

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
            CreationLabyrinthe creationLabyrinthe;
            boolean creationAlea = false;
            labyrinthe.changerEtage();
            if(labyrinthe.getEtageCourant() == Constantes.NB_ETAGE){ //Si c'est le dernier niveau
                creationLabyrinthe = new CreationFichierTexte("dernier-niveau.txt");
            }else{
                creationLabyrinthe = new CreationAleatoire(largeur, hauteur);
                creationAlea = true;
            }
            labyrinthe.supprimerLesMonstres();
            labyrinthe.reinitialiserPositionHero();
            creationLabyrinthe.creerLabyrinthe(labyrinthe);
            if(creationAlea) {
                if (labyrinthe.getEtageCourant() <= Constantes.NB_ETAGE / 3) {
                    MonstreFactory.creerMonstreVert(labyrinthe);
                    MonstreFactory.creerMonstreVert(labyrinthe);
                    MonstreFactory.creerMonstreVert(labyrinthe);
                } else if (labyrinthe.getEtageCourant() <= Constantes.NB_ETAGE * 2 / 3) {
                    MonstreFactory.creerMonstreVert(labyrinthe);
                    MonstreFactory.creerFantome(labyrinthe);
                    MonstreFactory.creerMonstreVert(labyrinthe);
                } else {
                    MonstreFactory.creerFantome(labyrinthe);
                    MonstreFactory.creerLoup(labyrinthe);
                    MonstreFactory.creerLoup(labyrinthe);
                    MonstreFactory.creerLoup(labyrinthe);
                }
            }

        }
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        g.drawImage(ImageFactory.getPassage(), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
    }
}
