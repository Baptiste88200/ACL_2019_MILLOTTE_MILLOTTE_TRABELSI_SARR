package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private static  int NBMONSTRE=2;
	private Case[][] cases;
	private Hero hero;
	private HashMap<int[],Integer>caseSpeciales;
	private List<Monstre> monstres;
	private boolean finish=false;

	public Labyrinthe(CreationLabyrinthe cl, int largeur, int hauteur) {
		caseSpeciales=new HashMap<>();
		hero = new Hero(0,hauteur/2);
		cases = cl.creerLabyrinthe(largeur,hauteur);

		//((Sol)cases[0][hauteur/2]).setTraversable(false);

		monstres = new ArrayList<>();
		for(int i = 0; i < NBMONSTRE; i++){
			creerMonstreVert();
		}
		creerCasesSpeciales();
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
        if(!hero.enVie())
            finish=!finish;
        finish=true;
        for(Monstre monstre:monstres)
            if(monstre.enVie())
                finish=false;
         if(!isFinished())
		switch (commande){
			case LEFT:
				if(hero.getX()!=0 && getCase(hero.getX()-1,hero.getY()).estTraversable()) {
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerGauche();
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case RIGHT:
				if(hero.getX()!= getWidth()-1 && getCase(hero.getX()+1,hero.getY()).estTraversable()) {
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerDroite();
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case UP:
				if(hero.getY()!=0 && getCase(hero.getX(),hero.getY()-1).estTraversable()) {
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerHaut();
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case DOWN:
				if(hero.getY()!=getHeight()-1 && getCase(hero.getX(),hero.getY()+1).estTraversable()) {
				//	((Sol) cases[hero.getX()][hero.getY()]).setTraversable(true);
					hero.deplacerBas();
					//((Sol) cases[hero.getX()][hero.getY()]).setTraversable(false);
				}
				break;
			case ENTREE:
				Monstre monstre=getMonstreProche();
				if(monstre!=null)
					hero.attaquer(monstre);
		}
		if(isSpecial(hero.getX(),hero.getY()))
		{
			int type=getTypeCase(hero.getX(), hero.getY());
			switch (type){
				case Constantes.PASSAGE:
					int[] pos=new int[]{hero.getX(),hero.getY()};
					while(pos[0]==hero.getX()&&pos[1]==hero.getY()){
						pos=getCordTraversable();
					}
					hero.move(pos[0], pos[1]);
					break;
				case Constantes.MAGIQUE:
					//dosomething()
					break;
				case Constantes.PIEGE:
					hero.subirDegat();
					break;
				case Constantes.TRESOR:
					//gameOver
					finish=true;
					break;
			}

		}
		//System.out.println(getClass().getResource("/img").toString());
		LinkedList<Integer>MscoreNull=new LinkedList<>();
		int i=0;
		for(Monstre m : monstres){
			if(!m.enVie())
				MscoreNull.add(i);
		 	//m.deplacer();
			m.deplacer2();
			i++;
		}
		for(int j:MscoreNull)
		{
			monstres.remove(j);
		}
	}
	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
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

	public List<Monstre> getMonstres() {
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

	// Retourner les cordonnées d'une case traversable
	public int[] getCordTraversable(){
		//int x = (int) (Math.random() * cases[0].length);
		//int y = (int) (Math.random() * cases.length);
		Random random=new Random();
		int x=random.nextInt(cases[0].length-2);
		int y=random.nextInt(cases.length-2);
		if(estTraversable(x, y)){

			return new int[]{x, y};
		}else{
			return getCordTraversable();
		}
	}

	public void creerMonstreVert(){
		int[] pos = getCordTraversable();
		ajouterMonstre(new MonstreVert(pos[0], pos[1], this));
	}

	/**
	 * generation des cases speciales
	 */
	public void creerCasesSpeciales()
	{
		Random random=new Random();
	    //generer  une  case Tresor
		setCasepeciale(3,Constantes.TRESOR);
		//generer un nombre aleatoire entre 0 et3 de case Magique
		setCasepeciale(random.nextInt(3),Constantes.MAGIQUE);
		 //generer un nombre aleatoire entre 0 et3 de case piege
		setCasepeciale(random.nextInt(3),Constantes.PIEGE);
		//generer un nombre aleatoire entre 0 et3 de case passage
		setCasepeciale(random.nextInt(6),Constantes.PASSAGE);
	}

	/**
	 * definir un nombre de cases speciales de type  [PASSAGE,MAGIQUE,PIEGE,TRESOR]
	 * @param i le nombre de cases speciales a definir
	 * @param type [PASSAGE,MAGIQUE,PIEGE,TRESOR]
	 */
	public void setCasepeciale(int i,int type)
	{
		while(i>0) {
		int[] pos = getCordTraversable();
			if (!isSpecial(pos[0], pos[1])) {
				caseSpeciales.put(pos,type);
				i--;
			}
		}
	}

	/**
	 * @param x coord a l'abs
	 * @param y coord a l'ord
	 * @return True si la case special False sinon
	 */
	public boolean isSpecial(int x,int y)
	{
		int[] pos={x,y};
		Set<int[]>coords=caseSpeciales.keySet();
		for(int[] p :coords){
			if(p[0]==pos[0]&&p[1]==pos[1])
				return true;

		}

		return false;
	}
	public List<int[]> getCasesSpeciales()
	{
		//(x,y,type de la case)
		ArrayList<int[]>positions=new ArrayList<>();
		Set<int[]>coords=caseSpeciales.keySet();
		 for(int[] p :coords){
		 	int[]c=new int[3];
		 	c[0]=p[0];//recuv X
		 	c[1]=p[1];//y
		 	c[2]=caseSpeciales.get(p);//type case (MAGIQUE,PIEGE,TRESOR)
			 positions.add(c);
		 }
		 return positions;
	}
	public int getTypeCase(int x,int y)
	{
		Set<int[]>coords=caseSpeciales.keySet();
		for(int[] p :coords){
			if(p[0]==x&&p[1]==y)
				return caseSpeciales.get(p);
		}
		return -1;
	}
	public Monstre getMonstreProche()
	{
		int [][]tab=new int[][]{
				{0,0},
				{1,0},
				{-1,0},
				{0,1},
				{0,-1}
		};
		for(Monstre m:monstres){
		   for(int[] c:tab){
		   	if(hero.getX()+c[0]==m.getX()&&hero.getY()+c[1]==m.getY())
		   		return m;
		   }
		}
		return null;
	}
}
