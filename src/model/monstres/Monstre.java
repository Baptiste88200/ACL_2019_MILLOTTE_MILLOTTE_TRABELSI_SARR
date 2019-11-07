package model.monstres;

import model.Labyrinthe;
import model.Personnage;
import model.cases.Sol;

import java.awt.*;
import static model.Constantes.*;
public abstract class Monstre implements Personnage {

    protected int x, y;
    protected  int score;
    protected Labyrinthe labyrinthe;
    protected Deplacement deplacement;

    public Monstre(int x, int y, Labyrinthe labyrinthe) {
        this.x = x;
        this.y = y;
        this.labyrinthe = labyrinthe;
        score=INITIAL_SCORE;//from Class Constantes
      //  ((Sol) this.labyrinthe.getCase(x,y)).setTraversable(false);??????
    }
    @Override
    public boolean enVie()
    {
        return score>0;
    }

    @Override
    public void attaquer(Personnage p) {
        p.subirDegat();
    }

    public abstract void afficher(Graphics2D g);

    public void deplacer(){
       // boolean fini = false;
        int direction;

            direction = (int) (Math.random() * 4);
            switch (direction){
                case 0: //haut
                    if(labyrinthe.estTraversable(x, y-1)){
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(true);
                        y--;
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(false);
                    }
                    break;
                case 1: //bas
                    if(labyrinthe.estTraversable(x, y+1)){
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(true);
                        y++;
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(false);
                    }
                    break;
                case 2:  //gauche
                    if(labyrinthe.estTraversable(x-1, y)){
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(true);
                        x--;
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(false);
                    }
                    break;
                case 3: //droite
                    if(labyrinthe.estTraversable(x+1, y)){
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(true);
                        x++;
                        ((Sol)labyrinthe.getCase(x, y)).setTraversable(false);
                        //fini = true;
                    }
                    break;
            }

    }
    public void deplacer2()
    {

        deplacement =new DeplacementAEtoile(labyrinthe, this);
        int[] pos= deplacement.deplacer();
        x=pos[0];
        y=pos[1];
    }
    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    @Override
    public void subirDegat()
    {
        score--;
    }
    @Override
    public int getScore()
    {
        return score;
    }
}
