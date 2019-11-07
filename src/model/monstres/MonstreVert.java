package model.monstres;

import model.Constantes;
import model.Labyrinthe;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MonstreVert extends Monstre{

    public MonstreVert(int x, int y, Labyrinthe labyrinthe){
        super(x, y, labyrinthe);
    }

    public void afficher(Graphics2D g){
       /* g.setColor(Color.GREEN);
        g.fillOval(x* Constantes.tailleCase, y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);*/
        URL url=getClass().getResource("/"+Constantes.IMAGE_MONSTRE);
        int i=x*Constantes.tailleCase;
        int j=y*Constantes.tailleCase;
        try {
            g.drawImage(ImageIO.read(url),i,j ,Constantes.tailleCase,Constantes.tailleCase,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
