package model.monstres;

import model.Labyrinthe;
import model.Personnage;
import model.cases.Sol;
import model.monstres.deplacement.Deplacement;
import model.monstres.deplacement.DeplacementAEtoile;
import model.monstres.deplacement.DeplacementAlea;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import static model.Constantes.*;
public abstract class Monstre implements Personnage {

    protected int x, y;
    protected Labyrinthe labyrinthe;
    protected Deplacement deplacement;
    protected int score;

    public Monstre(int x, int y, Labyrinthe labyrinthe) {
        this.x = x;
        this.y = y;
        this.score=INITIAL_SCORE;
        this.labyrinthe = labyrinthe;
        ((Sol) this.labyrinthe.getCase(x,y)).setTraversable(false);
        deplacement=new DeplacementAlea(labyrinthe, this);
    }

    public abstract void afficher(Graphics2D g);

    public void deplacer(){
        try {
            Thread.sleep(1000);
            int[] coord=deplacement.deplacer();
            this.x=coord[0];
            this.y=coord[1];
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void teleporterAleatoirement() {
        int[] cord = labyrinthe.getCordTraversable();
        x = cord[0];
        y = cord[1];
    }
    public void setDeplacement(Deplacement deplacement){
        this.deplacement=deplacement;
    }

    @Override
    public void subirDegat(int d) {
      score--;
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
    public boolean enVie() {
        return score>0;
    }
}
