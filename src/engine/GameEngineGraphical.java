package engine;

import model.HeroController;
import model.Labyrinthe;
import model.LabyrinthePainter;
import model.creationLabyrinthe.CreationAleatoire;
import model.creationLabyrinthe.CreationFichierTexte;
import model.menu.Menu;
import model.menu.MenuController;

import javax.swing.*;

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
		gui.activeMenu();
		// boucle de game
		while (!this.game.isFinished()) {
			// demande controle utilisateur
			if (!this.gui.isMenuActif()) {
				Cmd c = this.gameController.getCommand();
				this.game.evolve(c);
				Thread.sleep(60);
				if (c == Cmd.ECHAP) {
					gui.activeMenu();
				}
			} else {
				Cmd c = this.menuController.getCommand();
				switch (c) {
					case SAVE:
						save();
						break;
					case ECHAP:
						menuController.setCommand(Cmd.IDLE);
						gui.desactiveMenu();
						break;
					case NEW:
						newGame();
						break;
					case LOAD:
						chargement();
						break;
					case EXIT:
						throw new InterruptedException();
				}
				menuController.setCommand(Cmd.IDLE);
			}
			this.gui.paint();
			Thread.sleep(60);
		}

	}


	public GraphicalInterface getGui() {
		return gui;
	}

	private void newGame() {
		Labyrinthe labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
		game = labyrinthe;
		gamePainter = new LabyrinthePainter(labyrinthe);
		gameController = new HeroController();
		menuController = new MenuController();
		gui.getFrame().dispose();
		gui = null;
		gui = new GraphicalInterface(gamePainter, gameController, menuController);
		gui.desactiveMenu();
	}

	private void newGame(Labyrinthe labyrinthe) {
		//generation
		game = labyrinthe;
		gamePainter = new LabyrinthePainter(labyrinthe);
		gameController = new HeroController();
		menuController = new MenuController();
		gui.getFrame().dispose();
		gui = null;
		gui = new GraphicalInterface(gamePainter, gameController, menuController);
		gui.desactiveMenu();
	}

	public void chargement() {
		JFileChooser fileChooser = new JFileChooser("./niveaux");
		int result = fileChooser.showDialog(gui.getFrame(), "Chargement labyrinthe");
		if (result == JFileChooser.APPROVE_OPTION) {
			System.out.println(fileChooser.getSelectedFile().getName());
			Labyrinthe labyrinthe = new Labyrinthe(new CreationFichierTexte(fileChooser.getSelectedFile().getName()));
			newGame(labyrinthe);
		}
	}

	private void save() {
		Labyrinthe labyrinthe = (Labyrinthe) game;
		System.out.println("labyrinthe.save(filename)");

		gui.desactiveMenu();
	}


}
