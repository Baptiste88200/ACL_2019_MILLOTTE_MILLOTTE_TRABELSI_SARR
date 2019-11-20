package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import engine.Cmd;
import engine.Game;
import model.cases.Case;
import model.cases.Sol;
import model.creationLabyrinthe.CreationLabyrinthe;
import model.monstres.Monstre;
import model.monstres.MonstreVert;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class Labyrinthe implements Game {

	private Case[][] cases;

	private Hero hero;

	private Collection<Monstre> monstres;

	private boolean finish;

	public Labyrinthe(CreationLabyrinthe cl) {
		hero = new Hero(this);
		cl.creerLabyrinthe(this);
		finish = false;
		monstres = new ArrayList<>();
		for(int i = 0; i < 2; i++){
			creerMonstreVert();
		}

	}

    Labyrinthe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		switch (commande){
			case LEFT:
				if(hero.getX()!=0 && getCase(hero.getX()-1,hero.getY()).estTraversable()) {
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerGauche();
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case RIGHT:
				if(hero.getX()!= getWidth()-1 && getCase(hero.getX()+1,hero.getY()).estTraversable()) {
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerDroite();
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case UP:
				if(hero.getY()!=0 && getCase(hero.getX(),hero.getY()-1).estTraversable()) {
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerHaut();
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case DOWN:
				if(hero.getY()!=getHeight()-1 && getCase(hero.getX(),hero.getY()+1).estTraversable()) {
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerBas();
					((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case ENTREE:
			Monstre	monstre = hero.getMonstreProche();
				if (monstre != null)
					this.hero.attaquer((Personnage) monstre);
				break;
		}
		if(monstres.size()==0)
		{
			finish=true;
			return;
		}
		Iterator<Monstre> iterator=monstres.iterator();
		while (iterator.hasNext()){
			Monstre m=iterator.next();
			if(m.enVie())
				m.deplacer();
			else
				iterator.remove();
		}

		((Sol)cases[hero.getX()][hero.getY()]).declancher(hero);
		if (!this.hero.enVie())
			this.finish = !this.finish;
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		return finish;
	}

	public Case getCase(int x, int y){
		return cases[x][y];
	}

	public int getWidth() {
		return cases.length;
	}

	public int getHeight() {
		return cases[0].length;
	}

	public Hero getHero() {
		return hero;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}

	public void setPositionHero(int x, int y){
		if(cases[x][y].estTraversable()){
			if(hero.getX() >= 0 && hero.getY() >= 0){
				((Sol)cases[hero.getX()][hero.getY()]).setTraversable(true);
			}
			hero.setX(x);
			hero.setY(y);
			((Sol)cases[x][y]).setTraversable(false);
		}

	}
        public boolean position(int x , int y)
        {
            if(hero.getX()==x && hero.getY()==y)
                    return true;
            return false;
        }
        

	public Collection<Monstre> getMonstres() {
		return monstres;
	}

	public void ajouterMonstre(Monstre m){
		monstres.add(m);
	}


	public boolean estTraversable(int x, int y){
		if(x < 0 || y < 0 || x >= cases[0].length || y >= cases.length){
			return false;
		}
		return cases[x][y].estTraversable();
	}

	// Retourne les cordonnÃ©es d'une case traversable
	public int[] getCordTraversable(){
		int x = (int) (Math.random() * cases.length);
		int y = (int) (Math.random() * cases[0].length);

		if(estTraversable(x, y)){
			int[] tab = {x, y};
			return tab;
		}else{
			return getCordTraversable();
		}
	}

	public void creerMonstreVert(){
		int[] pos = getCordTraversable();
		ajouterMonstre(new MonstreVert(pos[0], pos[1], this));
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
}
