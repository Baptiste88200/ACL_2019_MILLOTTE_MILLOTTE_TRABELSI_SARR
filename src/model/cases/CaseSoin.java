package model.cases;

import model.Constantes;
import model.Personnage;
import model.factory.ImageFactory;

import java.awt.*;

public class CaseSoin extends Sol {

    private boolean utilise;

    public CaseSoin(){
        utilise = false;
    }

    public void declancher(Personnage p) {
        if(!utilise){
            p.subirDegat(-10);
            utilise = true;
        }
    }

    public void afficher(Graphics2D g, int x, int y) {
        if (utilise) {
            g.drawImage(ImageFactory.getSol(1), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
        }else{
            g.drawImage(ImageFactory.getCaseSoin(), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
        }

    }
}
