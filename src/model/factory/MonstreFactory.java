package model.factory;

import model.Labyrinthe;
import model.monstres.Fantome;
import model.monstres.Loup;
import model.monstres.MonstreVert;

public class MonstreFactory {

    public static void creerMonstreVert(Labyrinthe labyrinthe) {
        int[] pos = labyrinthe.getCordTraversable();
        labyrinthe.ajouterMonstre(new MonstreVert(pos[0], pos[1], labyrinthe));
    }

    public static void creerFantome(Labyrinthe labyrinthe) {
        int[] pos = labyrinthe.getCordTraversable();
        //labyrinthe.ajouterMonstre(new Fantome(pos[0], pos[1], labyrinthe));
        labyrinthe.ajouterMonstre(new MonstreVert(pos[0], pos[1], labyrinthe));
    }

    public static void creerLoup(Labyrinthe labyrinthe) {
        int[] pos = labyrinthe.getCordTraversable();
        labyrinthe.ajouterMonstre(new Loup(pos[0], pos[1], labyrinthe));
    }
}
