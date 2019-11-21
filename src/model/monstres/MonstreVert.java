package model.monstres;

import model.Constantes;
import model.Labyrinthe;

import java.awt.*;

public class MonstreVert extends Monstre {

    public MonstreVert(int x, int y, Labyrinthe labyrinthe) {
        super(x, y, labyrinthe);
    }

    public void afficher(Graphics2D g) {

        g.setColor(Color.GREEN);
        g.fillOval(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);

    }


}
