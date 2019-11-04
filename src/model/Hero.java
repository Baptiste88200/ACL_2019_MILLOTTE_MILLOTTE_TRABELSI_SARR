package model;

import java.awt.*;

public class Hero {

    private int x,y;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void afficher(Graphics2D g){
        g.setColor(Color.RED);
        g.fillOval(x*Constantes.tailleCase, y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }

    public void deplacerGauche(){
        x--;

    }

    public void deplacerDroite(){
        x++;
    }

    public void deplacerHaut(){
        y--;
    }

    public void deplacerBas(){
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
