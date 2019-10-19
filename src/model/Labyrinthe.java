package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;
import model.cases.Case;
import model.creationLabyrinthe.CreationLabyrinthe;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class Labyrinthe implements Game {

	private Case[][] cases;

	public Labyrinthe(CreationLabyrinthe cl, int largeur, int hauteur) {
		cases = cl.creerLabyrinthe(largeur,hauteur);

	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {

	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}

	public Case getCase(int x, int y){
		return cases[x][y];
	}

	public int getWidth() {
		return cases.length;
	}

	public int getHeight() {
		return cases[0].length;
	}

}
