package model.monstres;

import model.Constantes;
import model.Labyrinthe;
import model.Personnage;
import model.Sprite;
import model.cases.Sol;
import model.factory.ImageFactory;
import model.monstres.deplacement.Deplacement;
import model.monstres.deplacement.DeplacementAEtoile;

import java.awt.*;

public abstract class Monstre implements Personnage {

    protected int x, y;
    protected Labyrinthe labyrinthe;
    protected Deplacement deplacement;
    protected int score;
    protected int degat;
    protected int vitesse;
    protected int cptVitesse;
    protected Sprite sprite;


    public Monstre(int x, int y, Labyrinthe labyrinthe, Sprite sprite, int pv, int vit, int degat) {
        this.x = x;
        this.y = y;
        this.score = pv;
        this.labyrinthe = labyrinthe;
        ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(false);
        vitesse = vit;
        cptVitesse = 0;
        this.degat = degat;
        this.sprite = sprite;
    }

    public void deplacer() {
        if (cptVitesse == vitesse) {
            int[] coord = deplacement.deplacer();
            if (labyrinthe.estTraversable(coord[0], coord[1])) {
                labyrinthe.setTraversable(x, y, true);
                labyrinthe.setTraversable(coord[0], coord[1], false);

                if(coord[0] != this.x){
                    if(coord[0]>this.x){
                        sprite.setDirection(Constantes.DROITE);
                    }else {
                        sprite.setDirection(Constantes.GAUCHE);
                    }
                }else if(coord[1] != this.y){
                    if(coord[1]>this.y){
                        sprite.setDirection(Constantes.BAS);
                    }else {
                        sprite.setDirection(Constantes.HAUT);
                    }
                }

                this.x = coord[0];
                this.y = coord[1];

            }
            if (deplacement.estACoteDuHero()) {
                attaquer(labyrinthe.getHero());
                if(labyrinthe.getHero().getX()+1==this.x){
                    sprite.setDirection(Constantes.GAUCHE);
                }else if(labyrinthe.getHero().getX()-1==this.x){
                    sprite.setDirection(Constantes.DROITE);
                }else if(labyrinthe.getHero().getY()+1==this.y){
                    sprite.setDirection(Constantes.HAUT);
                }else if(labyrinthe.getHero().getY()-1==this.y){
                    sprite.setDirection(Constantes.BAS);
                }
            }

            cptVitesse = -1;
           // ((Sol) (labyrinthe.getCase(x, y))).declancher(this);
        }
        cptVitesse++;

    }

    @Override
    public void teleporterAleatoirement(int[] cord) {
 
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
        p.subirDegat(degat);
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

    public void afficher(Graphics2D g) {
        g.drawImage(sprite.getImage(), x * Constantes.tailleCase, y * Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase,null);
    }

}
