package model.cases;

import model.Constantes;
import model.Personnage;
import model.factory.ImageFactory;

import java.awt.*;
import model.Labyrinthe;

public class Sol implements Case {

    private boolean traversable;

    private int idImg; // Pour afficher l'image

    public Sol() {
        traversable = true;
        if (Math.random() < 0.92) {
            idImg = 1;
        } else {
            switch ((int) (Math.random() * 2)) {
                case 0:
                    idImg = 2;
                    break;
                case 1:
                    idImg = 3;
                    break;
            }
        }

    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    @Override
    public boolean estTraversable() {
        return traversable;
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        /*g.setColor(Color.WHITE);
        g.fillRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);*/
        g.drawImage(ImageFactory.getSol(idImg), x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase, null);
    }

    public void declancher(Personnage p,Labyrinthe l) {
    }

}
