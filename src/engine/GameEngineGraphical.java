package engine;

import model.menu.Menu;
import model.menu.MenuController;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 * <p>
 * moteur de game generique.
 * On lui passe un game et un afficheur et il permet d'executer un game.
 */
public class GameEngineGraphical {

	/**
	 * le game a executer
	 */
	private Game game;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private GamePainter gamePainter;

	/**
	 * le controlleur a utiliser pour recuperer les commandes
	 */
	private GameController gameController;
	private MenuController menuController;

	/**
	 * l'interface graphique
	 */
	private GraphicalInterface gui;

	/**
	 * construit un moteur
	 *
	 * @param game
	 *            game a lancer
	 * @param gamePainter
	 *            afficheur a utiliser
	 * @param gameController
	 *            controlleur a utiliser
	 *            
	 */
	public GameEngineGraphical(Game game, GamePainter gamePainter, GameController gameController) {
		// creation du game
		this.game = game;
		this.gamePainter = gamePainter;
		this.gameController = gameController;
		this.menuController = new MenuController();
		Menu menu = new Menu(gamePainter, menuController);
		// creation de l'interface graphique
		this.gui = new GraphicalInterface(this.gamePainter, this.gameController,menuController);

	}

	/**
	 * permet de lancer le game
	 */
	public void run() throws InterruptedException {

		// boucle de game
		while (!this.game.isFinished()) {
			// demande controle utilisateur
			if (!this.gui.isMenuActif()) {
				Cmd c = this.gameController.getCommand();
				this.game.evolve(c);
				if (c == Cmd.ECHAP) {
					gui.activeMenu();
				}
			} else {
				Cmd c = this.menuController.getCommand();
				switch (c) {
					case PLAY:
						gui.desactiveMenu();

						break;
					case ECHAP:
						gui.desactiveMenu();
						break;
					case NEW:
						//newGame();
						break;
				}
				menuController.setCommand(Cmd.IDLE);
			}

		}

	}

	public GraphicalInterface getGui() {
		return gui;
	}

	public void newGame() {
		gui.desactiveMenu();

	}

	private void loadFile(String dir, String file) {
		if (file != null && dir != null)
			System.out.println(file);
	}

	public void init() {

	}
}
