package model;

import engine.Cmd;
import engine.Game;
import model.cases.Case;
import model.cases.Sol;
import model.creationLabyrinthe.CreationLabyrinthe;
import model.factory.MonstreFactory;
import model.monstres.Fantome;
import model.monstres.Monstre;
import model.son.SonSingleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 * <p>
 * Version avec personnage qui peut se deplacer. A completer dans les
 * versions suivantes.
 */
public class Labyrinthe implements Game {

    private Case[][] cases;

    private Hero hero;

    private Collection<Monstre> monstres;

    private int etageCourant;

    private boolean finish;

    public Labyrinthe(CreationLabyrinthe cl) {
        hero = new Hero(this);
        cl.creerLabyrinthe(this);
        finish = false;
        etageCourant = 1;
        monstres = new ArrayList<>();
        switch(getEtageCourant()){
            case 1:
                 for(int i = 0 ; i<2 ; i++){
                 MonstreFactory.creerMonstreVert(this);
                 MonstreFactory.creerFantome(this); } 
                 break;
            case 2:
                for(int i = 0 ; i<3 ; i++){
                 MonstreFactory.creerMonstreVert(this);
                 MonstreFactory.creerFantome(this); }
                break;
                
            case 3 :
                 for(int i = 0 ; i<4 ; i++){
                 MonstreFactory.creerMonstreVert(this);
                 MonstreFactory.creerFantome(this); }
                 break;
                 
            default:
                for(int i = 0 ; i<5 ; i++){
                MonstreFactory.creerMonstreVert(this);
                MonstreFactory.creerFantome(this); }
                break;            
        }
    }

    /**
     * faire evoluer le jeu suite a une commande
     *
     * @param commande
     */
    @Override
    public void evolve(Cmd commande) {
        System.out.println(commande);
        switch (commande) {
            case LEFT:
                hero.setAttaque(false);
                if (hero.getX() != 0 && getCase(hero.getX() - 1, hero.getY()).estTraversable()) {
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
                    hero.deplacerGauche();
                    SonSingleton.getInstance().hero.play();
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
                }
                else
                    SonSingleton.getInstance().mur.play();               
                break;
            case RIGHT:
                hero.setAttaque(false);
                if (hero.getX() != getWidth() - 1 && getCase(hero.getX() + 1, hero.getY()).estTraversable()) {
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
                    hero.deplacerDroite();
                     SonSingleton.getInstance().hero.play();
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
                }
                 else
                    SonSingleton.getInstance().mur.play();            
                break;
            case UP:
                hero.setAttaque(false);
                if (hero.getY() != 0 && getCase(hero.getX(), hero.getY() - 1).estTraversable()) {
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
                    hero.deplacerHaut();
                     SonSingleton.getInstance().hero.play();
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
                }
                else
                    SonSingleton.getInstance().mur.play();            
                break;
            case DOWN:
                hero.setAttaque(false);
                if (hero.getY() != getHeight() - 1 && getCase(hero.getX(), hero.getY() + 1).estTraversable()) {
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
                    hero.deplacerBas();
                     SonSingleton.getInstance().hero.play();
                    ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
                }
                else
                    SonSingleton.getInstance().mur.play();            
                break;
            case ENTREE:
                Monstre monstre = hero.getMonstreProche();
                hero.setAttaque(true);
                if (monstre != null)
                    this.hero.attaquer(monstre);
                break;

        }

        Iterator<Monstre> iterator = monstres.iterator();
        while (iterator.hasNext()) {
            Monstre m = iterator.next();
            if (m.enVie())
                m.deplacer();
            else
                iterator.remove();
        }

        ((Sol) cases[hero.getX()][hero.getY()]).declancher(hero);
		/*if (!this.hero.enVie())
			this.finish = !this.finish;*/
    }

    /**
     * verifier si le jeu est fini
     */
    @Override
    public boolean isFinished() {
        return finish;
    }

    public Case getCase(int x, int y) {
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

    public void setPositionHero(int x, int y) {
        if (cases[x][y].estTraversable()) {
            if (hero.getX() >= 0 && hero.getY() >= 0) {
                ((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
            }
            hero.setX(x);
            hero.setY(y);
            ((Sol) cases[x][y]).setTraversable(false);
        }

    }

    public boolean position(int x, int y) {
        return hero.getX() == x && hero.getY() == y;
    }


    public Collection<Monstre> getMonstres() {
        return monstres;
    }

    public void ajouterMonstre(Monstre m) {
        monstres.add(m);
    }


    public boolean estTraversable(int x, int y) {
        if (x < 0 || y < 0 || x >= cases[0].length || y >= cases.length) {
            return false;
        }
        return cases[x][y].estTraversable();
    }

    public void setTraversable(int x, int y, boolean traversable) {
        ((Sol) cases[x][y]).setTraversable(traversable);
    }

    // Retourne les cordonnÃ©es d'une case traversable
    public int[] getCordTraversable() {
        int x = (int) (Math.random() * cases.length);
        int y = (int) (Math.random() * cases[0].length);

        if (estTraversable(x, y)) {
            int[] tab = {x, y};
            return tab;
        } else {
            return getCordTraversable();
        }
    }

    public void creerMonstreVert() {
        int[] pos = getCordTraversable();
       // ajouterMonstre(new MonstreVert(pos[0], pos[1], this));
        ajouterMonstre(new Fantome(pos[0], pos[1], this));
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void supprimerLesMonstres() {
        monstres.removeAll(monstres);
    }

    public void reinitialiserPositionHero() {
        hero.setX(-1);
        hero.setY(-1);
    }

    public void changerEtage(){
        etageCourant++;
        SonSingleton.getInstance().nextLevel.play();
    }

    public int getEtageCourant(){
        return etageCourant;
    }

}
