package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.GamePainter;
import model.monstres.Monstre;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class LabyrinthePainter implements GamePainter {

	/**
	 * la taille des cases
	 */



	private Labyrinthe labyrinthe;

	/**
	 * appelle constructeur parent
	 *
	 */
	public LabyrinthePainter(Labyrinthe l) {
		labyrinthe = l;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D g = (Graphics2D) im.getGraphics();
		for(int i = 0 ; i < labyrinthe.getWidth() ; i++){
			for(int j = 0 ; j < labyrinthe.getHeight() ; j++){
				labyrinthe.getCase(i,j).afficher(g,i,j);
			}
		}
		labyrinthe.getHero().afficher(g);
		for(Monstre monstre : labyrinthe.getMonstres()){
			monstre.afficher(g);
		}
	}

	@Override
	public int getWidth() {
		return Constantes.tailleCase*labyrinthe.getWidth();
	}

	@Override
	public int getHeight() {
		return Constantes.tailleCase*labyrinthe.getHeight();
	}

}
