package model;

import model.cases.Sol;

import java.awt.*;

public class Hero implements Personnage{

    private int x,y;
    private Labyrinthe labyrinthe;

    public Hero(int x, int y, Labyrinthe l) {
        this.x = x;
        this.y = y;
        labyrinthe = l;
    }

    public void afficher(Graphics2D g){
        g.setColor(Color.RED);
        g.fillOval(x*Constantes.tailleCase, y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }

    public void deplacerGauche(){ x--; }

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

    @Override
    public void teleporterAleatoirement() {
        int[] cord = labyrinthe.getCordTraversable();
        //System.out.println(cord[0] +" "+ cord[1]);
        x = cord[0];
        y = cord[1];
        ((Sol) labyrinthe.getCase(x,y)).setTraversable(false);
    }

    @Override
    public void subirDegat(int d) {
        // a completer
    }
}
