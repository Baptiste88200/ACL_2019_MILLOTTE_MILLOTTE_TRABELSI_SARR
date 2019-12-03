package model.monstres;

import model.Constantes;
import model.Labyrinthe;
import model.factory.ImageFactory;
import model.monstres.deplacement.DeplacementFantome;

public class Fantome extends Monstre{

    public Fantome(int x, int y, Labyrinthe labyrinthe) {
        super(x, y, labyrinthe, ImageFactory.getInstance().getSpriteFantome(), 10, 2, 2);
        setDeplacement(new DeplacementFantome(labyrinthe, this));
    }


    public void deplacer() {
        if (cptVitesse == vitesse) {
            int heroX = labyrinthe.getHero().getX();
            int heroY = labyrinthe.getHero().getY();
            if(heroX == x && heroY == y){ // si le fantome est sur la position du hero, le fantome attaque le hero
                labyrinthe.getHero().subirDegat(degat);
            }else{
                int[] coord = deplacement.deplacer();

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

            }
            cptVitesse = -1;
        }
        cptVitesse++;

    }

}
