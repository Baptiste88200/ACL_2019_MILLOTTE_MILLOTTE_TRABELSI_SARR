package model.monstres.deplacement;

import model.Labyrinthe;
import model.cases.Sol;
import model.monstres.Monstre;

public class DeplacementAlea
        extends Deplacement {
    /*  8 */
    public DeplacementAlea(Labyrinthe labyrinthe, Monstre monstre) {
        super(labyrinthe, monstre);
    }


    public int[] deplacer() {
        int direction;
        int x = monstre.getX();
        int y = monstre.getY();
        direction = (int) (Math.random() * 4);
        switch (direction) {
            case 0: //haut
                if (y - 1 >= 0 && labyrinthe.estTraversable(x, y - 1)) {
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(true);
                    y--;
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
            case 1: //bas
                if (y + 1 < labyrinthe.getHeight() && labyrinthe.estTraversable(x, y + 1)) {
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(true);
                    y++;
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
            case 2:  //gauche
                if (x - 1 >= 0 && labyrinthe.estTraversable(x - 1, y)) {
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(true);
                    x--;
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
            case 3: //droite
                if (x + 1 < labyrinthe.getWidth() && labyrinthe.estTraversable(x + 1, y)) {
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(true);
                    x++;
                    ((Sol) labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
        }
        ((Sol) labyrinthe.getCase(x, y)).declancher(monstre);
        return new int[]{x, y};
    }
}

