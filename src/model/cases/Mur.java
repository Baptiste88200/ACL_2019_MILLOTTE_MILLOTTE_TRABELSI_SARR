package model.cases;

import model.Constantes;

import java.awt.*;

public class Mur implements Case {

    @Override
    public boolean estTraversable() {
        return false;
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }
}
