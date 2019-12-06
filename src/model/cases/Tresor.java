package model.cases;

import model.Constantes;
import model.Hero;
import model.Labyrinthe;
import model.Personnage;

import java.awt.*;

public class Tresor extends Sol {

    private Labyrinthe labyrinthe;

    public Tresor(Labyrinthe l) {
        labyrinthe = l;
    }

    @Override
    public void declancher(Personnage p,Labyrinthe labyrinthe) {
        if (p instanceof Hero) labyrinthe.setFinish(true);
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);
    }

}
