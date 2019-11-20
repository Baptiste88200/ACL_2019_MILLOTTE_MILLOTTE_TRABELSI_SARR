package model.monstres.deplacement;

import model.Labyrinthe;
import model.monstres.Monstre;

public abstract class Deplacement {
    protected Labyrinthe labyrinthe;
    protected Monstre monstre;

    Deplacement(Labyrinthe labyrinthe, Monstre monstre) {
        /* 11 */
        this.labyrinthe = labyrinthe;
        /* 12 */
        this.monstre = monstre;
    }

    public abstract int[] deplacer();
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/monstres/Deplacement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */