package model.cases;

import model.Constantes;

import java.awt.*;

public class Sol implements Case {

    private boolean traversable;

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
        g.setColor(Color.WHITE);
        g.fillRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }

}
