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
import model.son.SonSingelton;

public class Hero implements Personnage {

    private int x, y;
    private Labyrinthe labyrinthe;
    private int score;
    private int direction;
    private int degat;
    private Sprite sprite;
    private boolean attaque;
    private boolean controleAleatoire;
    private int cptAttaque;


    public Hero(Labyrinthe l) {
        this.x = -1;
        this.y = -1;
        labyrinthe = l;
        degat = 1;
        score = INITIAL_SCORE;
        sprite = ImageFactory.getSpriteHero();
        attaque = false;
        controleAleatoire = false;
        cptAttaque = 0;
    }

    public void afficher(Graphics2D g) {

        if (score > 0) {
            if(attaque) {
                switch (direction) {
                    case (Constantes.HAUT):
                        g.drawImage(ImageFactory.getAttaqueHaut(), (x - 1) * Constantes.tailleCase, (y - 1) * Constantes.tailleCase, Constantes.tailleCase * 3, Constantes.tailleCase * 2, null);
                        break;
                    case (Constantes.BAS):
                        g.drawImage(ImageFactory.getAttaqueBas(), (x - 1) * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase * 3, Constantes.tailleCase * 2, null);
                        break;
                    case (Constantes.GAUCHE):
                        g.drawImage(ImageFactory.getAttaqueGauche(), (x - 1) * Constantes.tailleCase, (y - 1) * Constantes.tailleCase, Constantes.tailleCase * 2, Constantes.tailleCase * 3, null);
                        break;
                    case (Constantes.DROITE):
                        g.drawImage(ImageFactory.getAttaqueDroit(), x * Constantes.tailleCase, (y - 1) * Constantes.tailleCase, Constantes.tailleCase * 2, Constantes.tailleCase * 3, null);
                        break;
                }
                sprite.setDirection(direction);
                direction++;
                if(direction == 4){
                    attaque = false;
                }

            }
            g.drawImage(sprite.getImage(), x * Constantes.tailleCase, y * Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase,null);

        }
    }

    public void deplacerGauche() {
        if(!controleAleatoire) {
            this.x--;
        }else {
            deplacementAleatoire();
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.GAUCHE;
        sprite.setDirection(direction);

    }

    public void deplacerDroite() {
        if(!controleAleatoire) {
            this.x++;
        }else {
            deplacementAleatoire();
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.DROITE;
        sprite.setDirection(direction);
    }

    public void deplacerHaut() {
        if(!controleAleatoire) {
            this.y--;
        }else {
            deplacementAleatoire();
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.HAUT;
        sprite.setDirection(direction);

    }

    public void deplacerBas() {
        if(!controleAleatoire){
            this.y++;
        }else {
            deplacementAleatoire();
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.BAS;
        sprite.setDirection(direction);
    }

    private void deplacementAleatoire(){
        switch ((int)(Math.random()*4)){
            case 0 :
                if(labyrinthe.estTraversable(x+1,y)){
                    x++;
                }
                break;
            case 1:
                if(labyrinthe.estTraversable(x-1,y)){
                    x--;
                }
                break;
            case 2:
                if(labyrinthe.estTraversable(x,y+1)){
                    y++;
                }
                break;
            case 3:
                if(labyrinthe.estTraversable(x,y-1)){
                    y--;
                }
                break;
        }
        cptAttaque -= 2;
        if(cptAttaque<=0)controleAleatoire = false;
        System.out.println(cptAttaque);
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
        SonSingelton.getInstance().deplacement.play();
    }

    @Override
    public void attaquer(Personnage monstre) {
        int[][] tab = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1},{-1,-1},{-1,1},{1,-1},{1,1}};


        for (int[] c : tab) {
            if (getX() + c[0] == monstre.getX() && getY() + c[1] == getY()) {
                monstre.subirDegat(degat);
                SonSingelton.getInstance().attack.play();
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

    public void setAttaque(boolean attaque) {

        if (attaque && !this.attaque )
            direction = 0;


        if(cptAttaque > 50){
            controleAleatoire = true;
        }else {
            cptAttaque++;
            this.attaque = attaque;
        }
    }
}
