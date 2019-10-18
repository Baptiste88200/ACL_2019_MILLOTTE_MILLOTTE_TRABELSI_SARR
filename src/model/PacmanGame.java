<<<<<<< HEAD
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {

	 public Hero hero;
	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source,Hero h) {
		BufferedReader helpReader;
		this.hero=h;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
		
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		 int n;
		System.out.println("Execute "+commande);
		System.out.println("Execute "+commande +"Coordonees Joueur"+this.hero.getCordx()+";"+this.hero.getCordy());
		switch(commande)
		{
			case UP:{
				this.hero.setCordy(this.hero.getCordy()- 1);
				break;}
			case DOWN:{
				this.hero.setCordy(this.hero.getCordy()+1);
				break;}
			case LEFT:
			{
				this.hero.setCordx(this.hero.getCordx()-1);
				break;
			}
			case RIGHT:{
				this.hero.setCordx(this.hero.getCordx()+1);
				break;
				
				
			}
			
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

}
=======
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */

	public PacmanGame(String source) {
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		System.out.println("Execute "+commande);
		/*switch (commande){
			case LEFT:
				pacman.setX(pacman.getX()-1);
				break;
			case RIGHT:
				pacman.setX(pacman.getX()+1);
				break;

		}*/
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}

}
>>>>>>> eed404201019cf359eb3b81e5c7a420e31792d8d
