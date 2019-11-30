package model;

import model.cases.Sol;
import model.factory.ImageFactory;
import model.monstres.Monstre;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import static model.Constantes.DIRECTION;
import static model.Constantes.INITIAL_SCORE;
import model.monstres.MonstreVert;

public class Hero implements Personnage {

    private int x, y;
    private Labyrinthe labyrinthe;
    private int score;
    private int direction;
    private int degat;
    private Sprite sprite;


    public Hero(Labyrinthe l) {
        this.x = -1;
        this.y = -1;
        labyrinthe = l;
        degat = 1;
        score = INITIAL_SCORE;
        sprite = ImageFactory.getSpriteHero();
    }

    public void afficher(Graphics2D g) {

        if (score > 0) {
            g.drawImage(sprite.getImage(), x * Constantes.tailleCase, y * Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase,null);

        }
    }

    public void deplacerGauche() {
        this.x--;
        sprite.setDirection(Constantes.GAUCHE);
    }

    public void deplacerDroite() {
        this.x++;
        sprite.setDirection(Constantes.DROITE);
    }

    public void deplacerHaut() {
        this.y--;
        sprite.setDirection(Constantes.HAUT);
    }

    public void deplacerBas() {
        this.y++;
        sprite.setDirection(Constantes.BAS);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void teleporterAleatoirement() {
        int[] cord = labyrinthe.getCordTraversable();
        x = cord[0];
        y = cord[1];
        ((Sol) labyrinthe.getCase(x, y)).setTraversable(false);
    }

    @Override
    public void attaquer(Personnage monstre) {
        int[][] tab = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        for (int[] c : tab) {
            if (getX() + c[0] == monstre.getX() && getY() + c[1] == getY()) {
                monstre.subirDegat(degat);
                break;
            }
        }
        if (monstre.getX() == this.x && monstre.getY() == this.y) {
            subirDegat(0);
        }
    }

    @Override
    public void subirDegat(int d) {
        this.score -= d;
        if (score <= 0)
            labyrinthe.setFinish(true);
    }

    @Override
    public boolean enVie() {
        return score > 0;
    }

    public Monstre getMonstreProche() {
        int[][] tab = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (Monstre m : this.labyrinthe.getMonstres()) {
            for (int[] c : tab) {
                if (this.getX() + c[0] == m.getX() && this.getY() + c[1] == m.getY())
                    return m;
            }
        }
        return null;
    }

    public int getPV() {
        return score;
    }

}
