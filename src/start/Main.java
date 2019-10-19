package start;

import model.LabyrinthePainter;
import engine.GameEngineGraphical;
import model.HeroController;
import model.Labyrinthe;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		Labyrinthe game = new Labyrinthe("helpFilePacman.txt");
		LabyrinthePainter painter = new LabyrinthePainter();
		HeroController controller = new HeroController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
