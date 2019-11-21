package model;

import model.cases.Sol;
import model.monstres.Monstre;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import static model.Constantes.*;
public class Hero implements Personnage{

    private int x,y;
    private Labyrinthe labyrinthe;
    private int score;
    private DIRECTION d;
    private int degat;



    public Hero(Labyrinthe l) {
        this.x = -1;
        this.y = -1;
        labyrinthe = l;
        degat = 1;
        this.d = DIRECTION.DROITE;
        score=INITIAL_SCORE;
    }

    public void afficher(Graphics2D g){

        if(score > 0) {
            g.setColor(Color.RED);
            g.fillOval(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);
        }
        /*g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", 3, 13));
        g.drawString("Score:" + this.score + " Tresor:" + Character.MIN_VALUE + " magique :" + Character.MIN_VALUE, 10, 15);
        URL url = getClass().getResource("/img/heroDROITE.png");
        switch (this.d) {
            case GAUCHE:
                url = getClass().getResource("/img/heuroGAUCHE.png");
                break;
            case DROITE:
                url = getClass().getResource("/img/heroDROITE.png");
                break;
            case HAUT:
                url = getClass().getResource("/img/heroHAUT.png");
                break;
            case BAS:
                url = getClass().getResource("/img/heroBAS.png");
                break;
        }

        int i = this.x * 40;
        int j = this.y * 40;
        try {
            g.drawImage(ImageIO.read(url), i, j, 40, 40, null);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public void deplacerGauche() {
        this.x--;
        this.d = DIRECTION.GAUCHE;
    }

    public void deplacerDroite() {
        this.x++;
        this.d = DIRECTION.DROITE;
    }

    public void deplacerHaut() {
        this.y--;
        this.d = DIRECTION.HAUT;
    }

    public void deplacerBas() {
        this.y++;
        this.d = DIRECTION.BAS; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void teleporterAleatoirement() {
        int[] cord = labyrinthe.getCordTraversable();
        x = cord[0];
        y = cord[1];
        ((Sol) labyrinthe.getCase(x,y)).setTraversable(false);
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
        if(score <= 0)
            labyrinthe.setFinish(true);
    }

    @Override
    public  boolean enVie(){
        return score>0;
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
