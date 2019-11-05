package model.cases;

import model.Constantes;
import model.Labyrinthe;

import java.awt.*;

public class Tresor extends Sol {

    private Labyrinthe labyrinthe;

    public Tresor(Labyrinthe l){
      labyrinthe = l;
    }

    public void declancher(){
        labyrinthe.setFinish(true);
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x* Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        g.setColor(Color.BLACK);
        g.drawRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
    }

}
