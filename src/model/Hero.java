package model;

import model.factory.ImageFactory;

import java.awt.*;
import static model.Constantes.INITIAL_SCORE;

public class Hero implements Personnage {

    private int x, y;
   
    private int score;
    int direction;
    
    private int degat;
    Sprite sprite;
    private boolean attaque;
    private boolean controleAleatoire;
    private int cptAttaque;


    public Hero(Labyrinthe l) {
        this.x = -1;
        this.y = -1;
        degat = 1;
        score = INITIAL_SCORE;
        sprite = ImageFactory.getSpriteHero();
        attaque = false;
        setControleAleatoire(false) ;
        setCptAttaque(0);
    }

    public boolean getControleAleatoire() {
        return controleAleatoire;
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
        if (!this.getControleAleatoire()) {
            this.setX(this.getX()-1);
        }
        this.setCptAttaque(Math.max(0,this.getCptAttaque()- 1));
        this.direction = Constantes.GAUCHE;
        this.sprite.setDirection(this.direction);
    }


    public void deplacerDroite() {
        if(!getControleAleatoire()) {
            this.x++;
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.DROITE;
        sprite.setDirection(direction);
    }

    public void deplacerHaut() {
        if(!getControleAleatoire()) {
            this.y--;
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.HAUT;
        sprite.setDirection(direction);

    }

    public void deplacerBas() {
        if(!getControleAleatoire()){
            this.y++;
        }
        cptAttaque = Math.max(0,cptAttaque-1);
        direction = Constantes.BAS;
        sprite.setDirection(direction);
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
    public void teleporterAleatoirement(int[] cord) {
        x = cord[0];
        y = cord[1];
     
     //   SonSingleton.getInstance().magic.play();
    }

    @Override
    public void attaquer(Personnage monstre) {
        int[][] tab = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1},{-1,-1},{-1,1},{1,-1},{1,1}};


        for (int[] c : tab) {
            if (getX() + c[0] == monstre.getX() && getY() + c[1] == getY()) {
                monstre.subirDegat(degat);
                //SonSingleton.getInstance().attack.play();
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
       
    }

    @Override
    public boolean enVie() {
        return score > 0;
    }

    
    public int getPV() {
        return score;
    }

    public void setAttaque(boolean attaque) {

        if (attaque && !this.attaque )
            direction = 0;


        if(getCptAttaque() > 50){
            setControleAleatoire(true) ;
        }else {
            setCptAttaque(getCptAttaque()+1);
            this.attaque = attaque;
        }
    }

    public void setCptAttaque(int x ) {
         cptAttaque = x;
    }

    public int getCptAttaque() {
        return cptAttaque;
    }

    void setControleAleatoire(boolean b) {
        this.controleAleatoire=b;
    }
}
