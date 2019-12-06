package model.cases;

import model.Constantes;
import model.Personnage;
import model.factory.ImageFactory;

import java.awt.*;
import model.Labyrinthe;

public class Piege extends Sol {

    public Piege() {

    }

    @Override
    public void declancher(Personnage p,Labyrinthe l) {
        p.subirDegat(1);
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        /*g.setColor(Color.gray);
        g.fillRect(x* Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);*/
        g.drawImage(ImageFactory.getPiege(), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
    }

}
