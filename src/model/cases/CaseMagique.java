package model.cases;

import model.Constantes;
import model.Personnage;
import model.factory.ImageFactory;

import java.awt.*;
import model.Labyrinthe;

public class CaseMagique extends Sol {

    public CaseMagique() {

    }

    @Override
    public void declancher(Personnage p,Labyrinthe l) {
        p.teleporterAleatoirement(l.getCordTraversable());
        setTraversable(true);
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        /*g.setColor(Color.MAGENTA);
        g.fillRect(x* Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);*/
        g.drawImage(ImageFactory.getCaseMagique(), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
    }

}
