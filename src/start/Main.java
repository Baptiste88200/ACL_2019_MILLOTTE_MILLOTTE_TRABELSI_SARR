package start;

import engine.GameEngineGraphical;
import model.HeroController;
import model.Labyrinthe;
import model.LabyrinthePainter;
import model.creationLabyrinthe.CreationAleatoire;

import javax.swing.*;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) {
		Labyrinthe game = null;
		LabyrinthePainter painter = null;
		HeroController controller = null;
		GameEngineGraphical engine = null;
		do {
			if (engine != null)
				engine.getGui().getFrame().dispose();
			game = new Labyrinthe(new CreationAleatoire(25, 25));
			painter = new LabyrinthePainter(game);
			controller = new HeroController();
			// classe qui lance le moteur de jeu generique
			engine = new GameEngineGraphical(game, painter, controller);
			try {
				engine.run();
			} catch (InterruptedException e) {
				break;
			}
		} while (JOptionPane.showConfirmDialog(engine.getGui().getFrame(), (game.getHero().enVie() ? "Vous avez gagnez" : "Vous avez perdu") + "!!!\n\nVoulez vous continuez")
				== JOptionPane.YES_OPTION
		);
		engine.getGui().getFrame().dispose();
	}

}
