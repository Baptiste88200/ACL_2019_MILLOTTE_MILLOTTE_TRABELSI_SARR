package model.monstres;

import model.Labyrinthe;
import model.cases.Sol;

public class DeplacementAlea
        extends Deplacement {
    /*  8 */
    public DeplacementAlea(Labyrinthe labyrinthe, Monstre monstre) {
        super(labyrinthe, monstre);
    }


    public int[] deplacer() {
        /* 14 */
        int x = this.monstre.getX();
        /* 15 */
        int y = this.monstre.getY();
        /* 16 */
        int direction = (int) (Math.random() * 4.0D);
        /* 17 */
        switch (direction) {
            case 0:
                /* 19 */
                if (this.labyrinthe.estTraversable(x, y - 1)) {
                    /* 20 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(true);
                    /* 21 */
                    y--;
                    /* 22 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
            case 1:
                /* 26 */
                if (this.labyrinthe.estTraversable(x, y + 1)) {
                    /* 27 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(true);
                    /* 28 */
                    y++;
                    /* 29 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
            case 2:
                /* 33 */
                if (this.labyrinthe.estTraversable(x - 1, y)) {
                    /* 34 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(true);
                    /* 35 */
                    x--;
                    /* 36 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
            case 3:
                /* 40 */
                if (this.labyrinthe.estTraversable(x + 1, y)) {
                    /* 41 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(true);
                    /* 42 */
                    x++;
                    /* 43 */
                    ((Sol) this.labyrinthe.getCase(x, y)).setTraversable(false);
                }
                break;
        }

        /* 48 */
        return new int[]{x, y};
    }
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/monstres/DeplacementAlea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */