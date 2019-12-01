package model.monstres;

import model.Labyrinthe;
import model.factory.ImageFactory;
import model.monstres.deplacement.DeplacementAEtoile;

public class Loup extends Monstre{

    public Loup(int x, int y, Labyrinthe labyrinthe) {
        super(x, y, labyrinthe, ImageFactory.getSpriteLoup(), 6, 1, 2);
        setDeplacement(new DeplacementAEtoile(labyrinthe, this));
    }



}
