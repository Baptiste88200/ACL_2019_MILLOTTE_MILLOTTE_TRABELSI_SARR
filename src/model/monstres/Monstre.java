package model.monstres;

import model.Constantes;
import model.Labyrinthe;
import model.cases.Sol;

import java.awt.*;

public abstract class Monstre {

    protected int x, y;
    protected Labyrinthe labyrinthe;

    public Monstre(int x, int y, Labyrinthe labyrinthe) {
        this.x = x;
        this.y = y;
        this.labyrinthe = labyrinthe;
        ((Sol) this.labyrinthe.getCase(x,y)).setTraversable(false);
    }

    public abstract void afficher(Graphics2D g);

    public void deplacer(){
        boolean fini = false;
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
                        fini = true;
                    }
                    break;
            }

    }
}
