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

	private Hero hero;

	public Labyrinthe(CreationLabyrinthe cl, int largeur, int hauteur) {
		hero = new Hero(0,hauteur/2);
		cases = cl.creerLabyrinthe(largeur,hauteur);
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		switch (commande){
			case LEFT:
				if(hero.getX()!=0 && getCase(hero.getX()-1,hero.getY()).estTraversable())
					hero.deplacerGauche();
				break;
			case RIGHT:
				if(hero.getX()!= getWidth()-1 && getCase(hero.getX()+1,hero.getY()).estTraversable())
					hero.deplacerDroite();
				break;
			case UP:
				if(hero.getY()!=0 && getCase(hero.getX(),hero.getY()-1).estTraversable())
					hero.deplacerHaut();
				break;
			case DOWN:
				if(hero.getY()!=getHeight()-1 && getCase(hero.getX(),hero.getY()+1).estTraversable())
					hero.deplacerBas();
				break;
		}
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

	public Hero getHero() {
		return hero;
	}
}
