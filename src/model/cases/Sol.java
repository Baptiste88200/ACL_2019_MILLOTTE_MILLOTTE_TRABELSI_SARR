package model.cases;

import model.Constantes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

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
        URL url=null;
        switch (type)
        {
            case Constantes.TRESOR:
                url=getClass().getResource("/"+Constantes.IMAGE_TRESOR);
                break;
            case Constantes.MAGIQUE:
                url=getClass().getResource("/"+Constantes.IMAGE_MAGIQUE);
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
        if(url==null) {
            g.fillRect(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);
            g.setColor(Color.BLACK);
            g.drawRect(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);
        }else {
            int i=x*Constantes.tailleCase;
            int j=y*Constantes.tailleCase;
            try {
                g.drawImage(ImageIO.read(url),i,j ,Constantes.tailleCase,Constantes.tailleCase,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setType(int type) {
        this.type=type;
    }
}
