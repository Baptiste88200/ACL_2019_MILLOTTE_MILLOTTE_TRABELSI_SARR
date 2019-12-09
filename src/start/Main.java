package start;

import engine.GameEngineGraphical;
import model.Constantes;
import model.HeroController;
import model.Labyrinthe;
import model.LabyrinthePainter;
import model.creationLabyrinthe.CreationAleatoire;

import javax.swing.*;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Labyrinthe game;
		LabyrinthePainter painter;
		HeroController controller;
		GameEngineGraphical engine;
		do {
			game = new Labyrinthe(new CreationAleatoire(Constantes.TAILLE, Constantes.TAILLE));
			painter = new LabyrinthePainter(game);
			controller = new HeroController();

			// classe qui lance le moteur de jeu generique
			engine = new GameEngineGraphical(game, painter, controller);
			engine.run();
		} while (JOptionPane.showConfirmDialog(engine.getGui().getFrame(), (game.getHero().enVie() ? "Vous avez gagnez" : "Vous avez perdu") + "!!!\n\nVoulez vous continuez")
				== JOptionPane.YES_OPTION
		);
		engine.getGui().getFrame().dispose();
	}

}
