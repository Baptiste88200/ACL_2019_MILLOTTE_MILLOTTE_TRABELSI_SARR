package model.monstres;

import model.Constantes;
import model.Labyrinthe;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class MonstreVert extends Monstre {
public TexturePaint monstre;
public final static int DEGAT = 1;
    public MonstreVert(int x, int y, Labyrinthe labyrinthe) {
        super(x, y, labyrinthe);
    }

    public int getDegat()
    {
        return this.DEGAT;
    }
    public void afficher(Graphics2D g) {
         BufferedImage buffer = null;
         Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
        try {
            buffer = ImageIO.read(new File(path.toString()+"/src/model/images/monstrevert.png"));            
        } catch (IOException ex) {
            Logger.getLogger(MonstreVert.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        // g.setColor(Color.GREEN);
        //g.fillOval(x * Constantes.tailleCase, y * Constantes.tailleCase, Constantes.tailleCase, Constantes.tailleCase);
         g.drawImage(buffer, x * Constantes.tailleCase, y * Constantes.tailleCase,Constantes.tailleCase,Constantes.tailleCase,null);
                
    }


}
