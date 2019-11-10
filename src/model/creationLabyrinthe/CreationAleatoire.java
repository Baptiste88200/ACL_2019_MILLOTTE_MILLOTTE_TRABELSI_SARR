package model.creationLabyrinthe;

import model.Labyrinthe;
import model.cases.*;

public class CreationAleatoire implements CreationLabyrinthe {

    private int largeur;

    private int hauteur;

    private Labyrinthe l;

    public CreationAleatoire(int largeur, int hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void creerLabyrinthe(Labyrinthe l) {
        Case[][] labyrinthe = new Case[largeur][hauteur];
        boolean[][] tab = new boolean[largeur][hauteur];
        int k = 0, max = largeur*hauteur*3, x = 0, y =hauteur/2, rand;
        tab[x][y] = true;
        while (k<max){
            rand = (int)(Math.random()*4);
            switch (rand){
                case 0 :
                    x++;
                    break;
                case 1:
                    x--;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    y--;
                    break;
            }
            x = Math.max(0,x);
            x = Math.min(largeur-1,x);
            y = Math.max(0,y);
            y = Math.min(hauteur-1,y);
            tab[x][y] = true;
            k++;
        }

        for(int i = 0 ; i < largeur ; i++){
            for(int j = 0 ; j < hauteur ; j++){
                if(tab[i][j]){
                    double r = Math.random();
                    if(r<0.01) {
                        labyrinthe[i][j] = new Piege();
                    }else if(r<0.02) {
                        labyrinthe[i][j] = new CaseMagique();
                    }else{
                        labyrinthe[i][j] = new Sol();
                    }
                }else {
                    labyrinthe[i][j] = new Mur();
                }
            }
        }

        labyrinthe[x][y] = new Tresor(l);

        l.setCases(labyrinthe);

        l.setPositionHero(0, hauteur/2);

    }
}
