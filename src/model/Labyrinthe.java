package model;

import engine.Cmd;
import engine.Game;
import model.cases.Case;
import model.creationLabyrinthe.CreationLabyrinthe;
import model.monstres.Monstre;
import model.monstres.MonstreVert;

import java.util.*;

public class Labyrinthe
        implements Game {
    private static int NBMONSTRE = 2;
    private Case[][] cases;
    private Hero hero;
    private HashMap<int[], Integer> caseSpeciales;
    private List<Monstre> monstres;
    private boolean finish;

    public Labyrinthe(CreationLabyrinthe cl, int largeur, int hauteur) {
        this.finish = false;


        this.caseSpeciales = (HashMap) new HashMap<>();
        this.hero = new Hero(0, hauteur / 2);
        this.cases = cl.creerLabyrinthe(largeur, hauteur);


        this.monstres = new ArrayList<>();
        for (int i = 0; i < NBMONSTRE; i++) {
            creerMonstreVert();
        }
        creerCasesSpeciales();
    }

    public void evolve(Cmd commande) {
        if (!this.hero.enVie())
            this.finish = !this.finish;
        this.finish = true;
        for (Monstre monstre : this.monstres) {
            if (monstre.enVie())
                this.finish = false;
        }
        if (!isFinished()) {
            Monstre monstre;
            switch (commande) {
                case LEFT:
                    if (this.hero.getX() != 0 && getCase(this.hero.getX() - 1, this.hero.getY()).estTraversable()) {
                        this.hero.deplacerGauche();
                    }
                    break;

                case RIGHT:
                    if (this.hero.getX() != getWidth() - 1 && getCase(this.hero.getX() + 1, this.hero.getY()).estTraversable()) {
                        this.hero.deplacerDroite();
                    }
                    break;

                case UP:
                    if (this.hero.getY() != 0 && getCase(this.hero.getX(), this.hero.getY() - 1).estTraversable()) {
                        this.hero.deplacerHaut();
                    }
                    break;

                case DOWN:
                    if (this.hero.getY() != getHeight() - 1 && getCase(this.hero.getX(), this.hero.getY() + 1).estTraversable()) {
                        this.hero.deplacerBas();
                    }
                    break;

                case ENTREE:
                    monstre = getMonstreProche();
                    if (monstre != null)
                        this.hero.attaquer((Personnage) monstre);
                    break;
            }
        }
        if (isSpecial(this.hero.getX(), this.hero.getY())) {

            int pos[], type = getTypeCase(this.hero.getX(), this.hero.getY());
            switch (type) {
                case 13:
                    pos = new int[]{this.hero.getX(), this.hero.getY()};
                    while (pos[0] == this.hero.getX() && pos[1] == this.hero.getY()) {
                        pos = getCordTraversable();
                    }
                    this.hero.move(pos[0], pos[1]);
                    break;


                case 12:
                    this.hero.subirDegat();
                    break;

                case 10:
                    System.out.println("Game Over win");
                    this.finish = true;
                    break;
            }


        }
        LinkedList<Integer> MscoreNull = new LinkedList<>();
        int i = 0;
        for (Monstre m : this.monstres) {
            if (!m.enVie()) {
                MscoreNull.add(Integer.valueOf(i));
            }
            m.deplacer2();
            i++;
        }
        for (Iterator<Integer> iterator = MscoreNull.iterator(); iterator.hasNext(); ) {
            int j = ((Integer) iterator.next()).intValue();

            this.monstres.remove(j);
        }

    }


    public boolean isFinished() {
        return this.finish;
    }


    public Case getCase(int x, int y) {
        return this.cases[x][y];
    }


    public int getWidth() {
        return this.cases.length;
    }


    public int getHeight() {
        return (this.cases[0]).length;
    }


    public Hero getHero() {
        return this.hero;
    }


    public List<Monstre> getMonstres() {
        return this.monstres;
    }


    public void ajouterMonstre(Monstre m) {
        this.monstres.add(m);
    }


    public boolean estTraversable(int x, int y) {
        if (x < 0 || y < 0 || x >= (this.cases[0]).length || y >= this.cases.length) {
            return false;
        }
        return this.cases[x][y].estTraversable();
    }


    public int[] getCordTraversable() {
        Random random = new Random();
        int x = random.nextInt((this.cases[0]).length - 2);
        int y = random.nextInt(this.cases.length - 2);
        if (estTraversable(x, y)) {
            return new int[]{x, y};
        }
        return getCordTraversable();
    }


    public void creerMonstreVert() {
        int[] pos = getCordTraversable();
        ajouterMonstre((Monstre) new MonstreVert(pos[0], pos[1], this));
    }


    public void creerCasesSpeciales() {
        Random random = new Random();

        setCasepeciale(3, 10);

        setCasepeciale(random.nextInt(3), 11);

        setCasepeciale(random.nextInt(3), 12);

        setCasepeciale(random.nextInt(6), 13);
    }


    public void setCasepeciale(int i, int type) {
        while (i > 0) {
            int[] pos = getCordTraversable();
            if (!isSpecial(pos[0], pos[1])) {
                this.caseSpeciales.put(pos, Integer.valueOf(type));
                i--;
            }
        }
    }


    public boolean isSpecial(int x, int y) {
        int[] pos = {x, y};
        Set<int[]> coords = (Set) this.caseSpeciales.keySet();
        for (int[] p : coords) {
            if (p[0] == pos[0] && p[1] == pos[1]) {
                return true;
            }
        }

        return false;
    }


    public List<int[]> getCasesSpeciales() {
        ArrayList<int[]> positions = (ArrayList) new ArrayList<>();
        Set<int[]> coords = (Set) this.caseSpeciales.keySet();
        for (int[] p : coords) {
            int[] c = new int[3];
            c[0] = p[0];
            c[1] = p[1];
            c[2] = ((Integer) this.caseSpeciales.get(p)).intValue();
            positions.add(c);
        }
        return (List<int[]>) positions;
    }

    public int getTypeCase(int x, int y) {
        Set<int[]> coords = (Set) this.caseSpeciales.keySet();
        for (int[] p : coords) {
            if (p[0] == x && p[1] == y)
                return ((Integer) this.caseSpeciales.get(p)).intValue();
        }
        return -1;
    }

    public Monstre getMonstreProche() {
        int[][] tab = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        for (Monstre m : this.monstres) {
            for (int[] c : tab) {
                if (this.hero.getX() + c[0] == m.getX() && this.hero.getY() + c[1] == m.getY())
                    return m;
            }
        }
        return null;
    }
}
