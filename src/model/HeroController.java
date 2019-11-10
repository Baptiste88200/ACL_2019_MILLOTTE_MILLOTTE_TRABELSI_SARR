package model;

import java.awt.event.KeyEvent;

import engine.Cmd;
import engine.GameController;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * controleur de type KeyListener
 * 
 */
public class HeroController implements GameController {

	/**
	 * commande en cours
	 */
	private Cmd commandeEnCours;
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public HeroController() {
		this.commandeEnCours = Cmd.IDLE;
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return this.commandeEnCours;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()){
			case (KeyEvent.VK_DOWN):
			case (KeyEvent.VK_S):
				commandeEnCours = Cmd.DOWN;
				break;
			case (KeyEvent.VK_UP):
			case (KeyEvent.VK_Z):
				commandeEnCours = Cmd.UP;
				break;
			case(KeyEvent.VK_RIGHT):
			case (KeyEvent.VK_D):
				commandeEnCours = Cmd.RIGHT;
				break;
			case (KeyEvent.VK_LEFT):
			case (KeyEvent.VK_Q):
				commandeEnCours = Cmd.LEFT;
				break;


		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
