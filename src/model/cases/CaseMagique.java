package model.cases;

import model.Constantes;
import model.Personnage;

import java.awt.*;

public class CaseMagique extends Sol {

    public CaseMagique(){

    }

    @Override
    public void declancher(Personnage p){
        p.teleporterAleatoirement();
        setTraversable(true);
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x* Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }

}
