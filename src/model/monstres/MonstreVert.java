package model.monstres;

import model.Constantes;
import model.Hero;
import model.Labyrinthe;
import model.Personnage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MonstreVert extends Monstre{

    public MonstreVert(int x, int y, Labyrinthe labyrinthe){
        super(x, y, labyrinthe);
    }

    public void afficher(Graphics2D g){
      /*  g.setColor(Color.GREEN);
        g.fillOval(x* Constantes.tailleCase, y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);*/
        URL url = getClass().getResource("/img/monstre.jpg");


        int i = this.x * 40;

        int j = this.y * 40;
        try {
            if(url!=null)
            g.drawImage(ImageIO.read(url), i, j, 40, 40, null);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void attaquer(Personnage p) {
        p.subirDegat(0);
    }
}
