package model.cases;

import model.Constantes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Mur implements Case {

    @Override
    public boolean estTraversable() {
        return false;
    }

    @Override
    public void afficher(Graphics2D g, int x, int y) {
        //g.setColor(Color.BLACK);
       // g.fillRect(x*Constantes.tailleCase,y*Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase);
        //g.drawImage(ImageIO.read())*/
        URL url=getClass().getResource("/"+Constantes.IMAGE_MUR);
        int i=x*Constantes.tailleCase;
        int j=y*Constantes.tailleCase;
        try {
            g.drawImage(ImageIO.read(url),i,j ,Constantes.tailleCase,Constantes.tailleCase,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // g.dispose();
    }
}
