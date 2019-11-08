package model;

import engine.GamePainter;
import model.cases.SpecialCase;
import model.monstres.Monstre;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LabyrinthePainter implements GamePainter {
    private Labyrinthe labyrinthe;

    public LabyrinthePainter(Labyrinthe l) {
        this.labyrinthe = l;
    }

    public void draw(BufferedImage im) {
        Graphics2D g = (Graphics2D) im.getGraphics();

        for (int i = 0; i < this.labyrinthe.getWidth(); i++) {
            for (int j = 0; j < this.labyrinthe.getHeight(); j++) {

                if (this.labyrinthe.getCase(i, j) instanceof SpecialCase && this.labyrinthe.isSpecial(i, j)) {
                    ((SpecialCase) this.labyrinthe.getCase(i, j)).setType(this.labyrinthe.getTypeCase(i, j));
                }

                this.labyrinthe.getCase(i, j).afficher(g, i, j);
            }
        }
        this.labyrinthe.getHero().afficher(g);
        for (Monstre monstre : this.labyrinthe.getMonstres()) {
            monstre.afficher(g);
        }
    }

    public int getWidth() {
        return 40 * this.labyrinthe.getWidth();
    }

    public int getHeight() {
        return 40 * this.labyrinthe.getHeight();
    }
}

