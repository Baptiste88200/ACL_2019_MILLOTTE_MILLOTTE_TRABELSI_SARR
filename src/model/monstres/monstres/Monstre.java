package model.monstres;

import model.Labyrinthe;
import model.Personnage;
import model.cases.Sol;
import model.monstres.deplacement.Deplacement;
import model.monstres.deplacement.DeplacementAEtoile;

import java.awt.*;

public abstract class Monstre implements Personnage {

    protected int x, y;
    protected Labyrinthe labyrinthe;
    protected Deplacement deplacement;
    protected int score;
    private int degat;
    private int vitesse;
    private int cptVitesse;

    public Monstre(int x, int y, Labyrinthe labyrinthe) {
        this.x = x;
        this.y = y;
        this.score = 6;
        this.labyrinthe = labyrinthe;
        ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(false);
        deplacement = new DeplacementAEtoile(labyrinthe, this);
        vitesse = 2;
        cptVitesse = 0;
        degat = 1;
    }
    public abstract int getDegat();
    public abstract void afficher(Graphics2D g);

    public void deplacer() {
        if (cptVitesse == vitesse) {
            int[] coord = deplacement.deplacer();
            if (labyrinthe.estTraversable(coord[0], coord[1])) {
                labyrinthe.setTraversable(x, y, true);
                labyrinthe.setTraversable(coord[0], coord[1], false);
                this.x = coord[0];
                this.y = coord[1];

            }
            if (deplacement.estACoteDuHero()) {
                attaquer(labyrinthe.getHero());
            }

            cptVitesse = -1;
            ((Sol) (labyrinthe.getCase(x, y))).declancher(this);
        }
        cptVitesse++;

    }

    @Override
    public void teleporterAleatoirement() {
        int[] cord = labyrinthe.getCordTraversable();
        x = cord[0];
        y = cord[1];
    }

    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }

    @Override
    public void subirDegat(int d) {
        System.out.println(score);
        score -= d;
        if (score <= 0)
            labyrinthe.setTraversable(x, y, true);
    }

    @Override
    public void attaquer(Personnage p) {

        p.subirDegat(degat*this.getDegat());
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
        return score > 0;
    }
    public int getScore()
    {
        return this.score;
    }
            

}
