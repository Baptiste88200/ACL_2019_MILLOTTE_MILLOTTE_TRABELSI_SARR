package model.monstres.deplacement;

import model.Labyrinthe;
import model.monstres.Monstre;

public class DeplacementFantome extends Deplacement{

    public DeplacementFantome(Labyrinthe labyrinthe, Monstre monstre) {
        super(labyrinthe, monstre);
    }

    public int[] deplacer(){
        int heroX = labyrinthe.getHero().getX();
        int heroY = labyrinthe.getHero().getY();
        int monstreX = monstre.getX();
        int monstreY = monstre.getY();
        int diffX = heroX - monstreX;
        int diffY = heroY - monstreY;
        if(Math.abs(diffX) > Math.abs(diffY)){
            if(diffX > 0){
                monstreX++;
            }else{
                monstreX--;
            }
        }else{
            if(diffY > 0){
                monstreY++;
            }else{
                monstreY--;
            }
        }

        return new int[]{monstreX, monstreY};
    }

}
