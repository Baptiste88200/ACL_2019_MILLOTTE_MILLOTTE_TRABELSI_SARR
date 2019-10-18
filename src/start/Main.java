package start;

import model.PacmanPainter;
<<<<<<< HEAD
import model.Hero;
=======
>>>>>>> eed404201019cf359eb3b81e5c7a420e31792d8d
import engine.GameEngineGraphical;
import model.PacmanController;
import model.PacmanGame;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
<<<<<<< HEAD
         Hero hero= new Hero();
		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt",hero);
		PacmanPainter painter = new PacmanPainter(hero);
=======

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter();
>>>>>>> eed404201019cf359eb3b81e5c7a420e31792d8d
		PacmanController controller = new PacmanController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
