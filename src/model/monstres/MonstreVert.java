package model.monstres;

import model.Constantes;
import model.Labyrinthe;
import model.factory.ImageFactory;
import model.monstres.deplacement.DeplacementAEtoile;

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

    public MonstreVert(int x, int y, Labyrinthe labyrinthe) {
        super(x, y, labyrinthe, ImageFactory.getSpriteMonstre1(), 20, 8, 1);
        setDeplacement(new DeplacementAEtoile(labyrinthe, this));
    }
}
