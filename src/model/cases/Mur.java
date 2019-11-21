package model.cases;

import model.Constantes;
import model.factory.ImageFactory;

import java.awt.*;

public class Mur implements Case {

    @Override
    public boolean estTraversable() {
        return false;
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        /*g.setColor(Color.BLACK);
        g.fillRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);*/
        g.drawImage(ImageFactory.getMur(), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);

    }
}
