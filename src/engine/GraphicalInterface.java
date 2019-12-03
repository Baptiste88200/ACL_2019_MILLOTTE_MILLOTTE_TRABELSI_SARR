package engine;

import model.menu.Menu;
import model.menu.MenuController;

import javax.swing.*;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface {

	/**
	 * le Panel pour l'afficheur
	 */
	private DrawingPanel panel;
	private Menu menuPanel;
	JFrame f;
	private boolean menuActif = false;

	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 *
	 * @param gamePainter    l'afficheur a utiliser dans le moteur
	 * @param gameController l'afficheur a utiliser dans le moteur
	 */
	public GraphicalInterface(GamePainter gamePainter, GameController gameController, MenuController menuController) {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// attacher le panel contenant l'afficheur du game
		this.panel = new DrawingPanel(gamePainter);
		menuPanel = new Menu(gamePainter, menuController);
		// attacher controller au panel du game
		this.panel.addKeyListener(gameController);
		f.setContentPane(panel);
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	/**
	 * mise a jour du dessin
	 */
	public void paint() {
		if (!isMenuActif())
			panel.drawGame();
	}


	public JFrame getFrame() {
		return f;
	}

	public void activeMenu() {
		menuActif = true;
		f.setContentPane(menuPanel);
		f.validate();
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();


	}

	public void desactiveMenu() {
		menuActif = false;
		f.setContentPane(panel);
		f.validate();
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();

	}

	public boolean isMenuActif() {
		return menuActif;
	}


}
