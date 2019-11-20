
package model.monstres.deplacement;


import model.Hero;
import model.Labyrinthe;
import model.monstres.Monstre;

import java.util.LinkedList;


public class DeplacementAEtoile  extends Deplacement {
    private Hero hero;

    public DeplacementAEtoile(Labyrinthe labyrinthe, Monstre monstre) {

        super(labyrinthe, monstre);
        this.hero = labyrinthe.getHero();

    }

    public double distance(int x, int y) {
        int xx = this.hero.getX() - x;
        int yy = this.hero.getY() - y;
        return Math.sqrt((xx * xx + yy * yy));
    }

    public Node plusProche(LinkedList<Node> l) {
        Node node = l.get(0);
        int i = 0;
        int tmpI = i;
        for (; i < l.size(); i++) {
            if (node.getHeuristique() > ((Node) l.get(i)).getHeuristique()) {
                node = l.get(i);
                tmpI = i;
            }
        }
        l.remove(tmpI);
        return node;
    }

    public int[] deplacer() {

        LinkedList<Node> ouvert = new LinkedList<>();

        LinkedList<Node> ferme = new LinkedList<>();

        Node A = new Node(this.monstre.getX(), this.monstre.getY(), 0);
        if (distance(monstre.getX(), monstre.getY()) ==0) {

            return new int[]{monstre.getX(), monstre.getY()};
        }
        if (distance(monstre.getX(), monstre.getY()) ==1) {

            return new int[]{hero.getX(), hero.getY()};
        }

        ouvert.push(A);

        boolean fisrt = false;

        Node nxt = null;


        while (ouvert.size() != 0) {
            nxt = plusProche(ouvert);

            ferme.add(nxt);
            if (distance(nxt.getX(), nxt.getY()) == 1) {

                return new int[]{nxt.getInitialX(), nxt.getInitialY()};

            }
            Node[] succ = {nxt.droite(), nxt.gauche(), nxt.haut(), nxt.bas()};
            if (!fisrt) {
                for (Node s : succ) {
                    s.setInitialY(s.getY());
                    s.setInitialX(s.getX());
                }
                fisrt = !fisrt;
            }
            for (Node s : succ) {
                if (s.canMove() && !contient(ferme, s) && !contient(ouvert, s)) {
                    ouvert.add(s);

                }

            }

        }


        return new int[]{this.monstre.getX(), this.monstre.getY()};

    }


    public boolean contient(LinkedList<Node> visited, Node s) {

        for (Node n : visited) {


            if (n.getX() == s.getX() && n.getY() == s.getY())
                return true;

        }

        return false;

    }


    final class Node implements Comparable<Node> {
        int x;
        int y;
        int initialX;
        int initialY;
        double heuristique;
        int cout;
        public Node(int x, int y, int cout) {

            this.x = x;

            this.y = y;

            this.cout = cout;

            this.heuristique = cout + DeplacementAEtoile.this.distance(x, y);

        }

        public Node(int x, int y, int initialX, int initialY, int cout) {

            this.x = x;

            this.y = y;

            this.initialX = initialX;

            this.initialY = initialY;

            this.cout = cout;

            this.heuristique = cout + DeplacementAEtoile.this.distance(x, y);

        }
        public int compareTo(Node node) {
            return (int) (this.heuristique - node.heuristique);
        }


        public int getX() {
            return this.x;
        }


        public void setX(int x) {
            this.x = x;
        }


        public int getY() {
            return this.y;
        }


        public void setY(int y) {
            this.y = y;
        }


        public double getHeuristique() {
            return this.heuristique;
        }


        public void setHeuristique(int heuristique) {
            this.heuristique = heuristique;
        }


        public void setHeuristique(double heuristique) {
            this.heuristique = heuristique;
        }


        public Node droite() {
            return new Node(this.x + 1, this.y, this.initialX, this.initialY, 0);
        }


        public Node gauche() {
            return new Node(this.x - 1, this.y, this.initialX, this.initialY, 0);
        }


        public Node haut() {
            return new Node(this.x, this.y - 1, this.initialX, this.initialY, 0);
        }


        public Node bas() {
            return new Node(this.x, this.y + 1, this.initialX, this.initialY, 0);
        }


        public boolean canMove() {
            return (this.x >= 0 && this.y >= 0 && this.x < DeplacementAEtoile.this.labyrinthe.getWidth() && this.y < DeplacementAEtoile.this.labyrinthe.getHeight() && DeplacementAEtoile.this.labyrinthe.getCase(this.x, this.y).estTraversable());
        }


        public int getInitialX() {
            return this.initialX;
        }

        public void setInitialX(int initialX) {
            this.initialX = initialX;
        }

        public int getInitialY() {
            return this.initialY;
        }

        public void setInitialY(int initialY) {
            this.initialY = initialY;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", initialX=" + initialX +
                    ", initialY=" + initialY +
                    ", heuristique=" + heuristique +
                    ", cout=" + cout +
                    '}';
        }
    }

}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/monstres/DeplacementAEtoile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */