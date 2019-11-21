package model;

import engine.GamePainter;
import model.monstres.Monstre;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 * <p>
 * afficheur graphique pour le game
 */
public class LabyrinthePainter implements GamePainter {

    /**
     * la taille des cases
     */


    private Labyrinthe labyrinthe;

    /**
     * appelle constructeur parent
     */

    private Hero hero;

    public LabyrinthePainter(Labyrinthe l) {
        labyrinthe = l;
        hero = l.getHero();
    }

    /**
     * methode  redefinie de Afficheur retourne une image du jeu
     */
    @Override
    public void draw(BufferedImage im) {
        Graphics2D g = (Graphics2D) im.getGraphics();
        for (int i = 0; i < labyrinthe.getWidth(); i++) {
            for (int j = 0; j < labyrinthe.getHeight(); j++) {
                labyrinthe.getCase(i, j).afficher(g, i, j);
            }
        }
        labyrinthe.getHero().afficher(g);
        for (Monstre monstre : labyrinthe.getMonstres()) {
            monstre.afficher(g);
        }

        double pv = hero.getPV();

        double d = pv / Constantes.INITIAL_SCORE;        //0.5->0
        if (pv > Constantes.INITIAL_SCORE / 2) {        //0 -> 255
            g.setColor(new Color((int) (Math.abs(d - 1) * 2 * 255), 255, 0));
        } else {
            g.setColor(new Color(255, Math.max(0, (int) (255 - Math.abs(d - 0.5) * 255 * 2)), 0));
        }
        g.fillRect(0, labyrinthe.getHeight() * Constantes.tailleCase,
                (int) ((Constantes.tailleCase * labyrinthe.getWidth()) * pv / Constantes.INITIAL_SCORE), 2 * Constantes.tailleCase);


        g.setColor(Color.BLACK);
        g.drawRect(0, labyrinthe.getHeight() * Constantes.tailleCase,
                Constantes.tailleCase * labyrinthe.getWidth(), 2 * Constantes.tailleCase);
        g.fillRect(Constantes.tailleCase * labyrinthe.getWidth(), labyrinthe.getHeight() * Constantes.tailleCase,
                Constantes.tailleCase * labyrinthe.getWidth(), 2 * Constantes.tailleCase);


    }

    @Override
    public int getWidth() {
        return Constantes.tailleCase * labyrinthe.getWidth();
    }

    @Override
    public int getHeight() {
        return (Constantes.tailleCase + 2) * labyrinthe.getHeight();
    }

}
