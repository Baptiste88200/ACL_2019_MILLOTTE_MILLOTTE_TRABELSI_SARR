package model;

import model.monstres.Monstre;

import java.awt.*;

public class Hero {

    private int x,y;
    private int score;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void afficher(Graphics2D g){
        g.setColor(Color.RED);
        g.fillOval(x*Constantes.tailleCase, y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }
    public void move(int x,int y)
    {
        this.x=x;
        this.y=y;
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
    public int getScore()
    {
        return score;
    }
    public void attaquer(Monstre monstre)
    {

        monstre.subirDegat();
        System.out.println("monstre attaqué");
        if(monstre.getX()==x&&monstre.getY()==y) {
            subirDegat();
            System.out.println("hero attaqué");
        }

    }
    public void subirDegat()
    {
        score--;
    }

}
