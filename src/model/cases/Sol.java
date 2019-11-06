package model.cases;

import model.Constantes;

import java.awt.*;

public class Sol implements SpecialCase {

    private boolean traversable;
    private int type=-1;
    public Sol(){
        traversable = true;
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

        switch (type)
        {
            case Constantes.TRESOR:
                g.setColor(Constantes.TRESOR_COLOR);
                break;
            case Constantes.MAGIQUE:
                g.setColor(Constantes.MAGIQUE_COLOR);
                break;
            case Constantes.PIEGE:
                g.setColor(Constantes.PIEGE_COLOR);
                break;
             case Constantes.PASSAGE:
                 g.setColor(Constantes.PASSAGE_COLOR);
                 break;
            default:
                g.setColor(Color.WHITE);
                break;
        }
        g.fillRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }

    @Override
    public void setType(int type) {
        this.type=type;
    }
}
