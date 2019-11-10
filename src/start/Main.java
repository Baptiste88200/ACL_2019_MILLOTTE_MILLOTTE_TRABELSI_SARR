package start;

import model.HeroController;
import model.Labyrinthe;
import model.LabyrinthePainter;
import engine.GameEngineGraphical;
import model.creationLabyrinthe.CreationFichierTexte;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		//Labyrinthe game = new Labyrinthe(new CreationAleatoire(10,20));
		Labyrinthe game = new Labyrinthe(new CreationFichierTexte("test.txt"));
		LabyrinthePainter painter = new LabyrinthePainter(game);
		HeroController controller = new HeroController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
