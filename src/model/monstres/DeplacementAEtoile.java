/*     */
package model.monstres;
/*     */
/*     */

import model.Hero;
import model.Labyrinthe;

import java.util.LinkedList;

/*     */
/*     */

/*     */
/*     */
/*     */ public class DeplacementAEtoile
        /*     */ extends Deplacement
        /*     */ {
    /*     */   private Hero hero;

    /*     */
    /*     */
    public DeplacementAEtoile(Labyrinthe labyrinthe, Monstre monstre) {
        /*  14 */
        super(labyrinthe, monstre);
        /*  15 */
        this.hero = labyrinthe.getHero();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public double distance(int x, int y) {
        /*  27 */
        int xx = this.hero.getX() - x;
        /*  28 */
        int yy = this.hero.getY() - y;
        /*  29 */
        return Math.sqrt((xx * xx + yy * yy));
        /*     */
    }

    /*     */
    /*     */
    public Node plusProche(LinkedList<Node> l) {
        /*  33 */
        Node node = l.get(0);
        /*  34 */
        int i = 0;
        /*  35 */
        int tmpI = i;
        /*  36 */
        for (; i < l.size(); i++) {
            /*     */
            /*  38 */
            if (node.getHeuristique() > ((Node) l.get(i)).getHeuristique()) {
                /*  39 */
                node = l.get(i);
                /*  40 */
                tmpI = i;
                /*     */
            }
            /*     */
        }
        /*  43 */
        l.remove(tmpI);
        /*  44 */
        return node;
        /*     */
    }

    /*     */
    /*     */
    public int[] deplacer() {
        /*  48 */
        LinkedList<Node> ouvert = new LinkedList<>();
        /*  49 */
        LinkedList<Node> ferme = new LinkedList<>();
        /*  50 */
        Node A = new Node(this.monstre.getX(), this.monstre.getY(), 0);
        /*  51 */
        ouvert.push(A);
        /*  52 */
        boolean fisrt = false;
        /*  53 */
        Node nxt = null;
        /*  54 */
        while (ouvert.size() != 0) {
            /*     */
            /*  56 */
            nxt = plusProche(ouvert);
            /*  57 */
            ferme.add(nxt);
            /*  58 */
            if (distance(nxt.getX(), nxt.getY()) == 0.0D) {
                /*  59 */
                return new int[]{nxt.getInitialX(), nxt.getInitialY()};
                /*     */
            }
            /*     */
            /*     */
            /*     */
            /*     */
            /*  65 */
            Node[] succ = {nxt.droite(), nxt.gauche(), nxt.haut(), nxt.bas()};
            /*     */
            /*  67 */
            if (!fisrt) {
                /*     */
                /*  69 */
                for (Node s : succ) {
                    /*     */
                    /*  71 */
                    s.setInitialY(s.getY());
                    /*  72 */
                    s.setInitialX(s.getX());
                    /*     */
                }
                /*  74 */
                fisrt = !fisrt;
                /*     */
            }
            /*  76 */
            for (Node s : succ) {
                /*     */
                /*  78 */
                if (s.canMove() && !contient(ferme, s) && !contient(ouvert, s)) {
                    /*  79 */
                    ouvert.add(s);
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /*     */
        /*     */
        /*  85 */
        return new int[]{this.monstre.getX(), this.monstre.getY()};
        /*     */
    }

    /*     */
    /*     */
    public boolean contient(LinkedList<Node> visited, Node s) {
        /*  89 */
        for (Node n : visited) {
            /*     */
            /*  91 */
            if (n.getX() == s.getX() && n.getY() == s.getY())
                /*  92 */ return true;
            /*     */
        }
        /*  94 */
        return false;
        /*     */
    }

    /*     */
    /*     */   final class Node
            /*     */ implements Comparable<Node>
            /*     */ {
        /*     */ int x;
        /*     */ int y;
        /*     */ int initialX;

        /*     */
        /*     */
        public Node(int x, int y, int cout) {
            /* 105 */
            this.x = x;
            /* 106 */
            this.y = y;
            /* 107 */
            this.cout = cout;
            /* 108 */
            this.heuristique = cout + DeplacementAEtoile.this.distance(x, y);
            /*     */
        }

        /*     */ int initialY;
        double heuristique;
        int cout;

        /*     */
        public Node(int x, int y, int initialX, int initialY, int cout) {
            /* 112 */
            this.x = x;
            /* 113 */
            this.y = y;
            /* 114 */
            this.initialX = initialX;
            /* 115 */
            this.initialY = initialY;
            /* 116 */
            this.cout = cout;
            /* 117 */
            this.heuristique = cout + DeplacementAEtoile.this.distance(x, y);
            /*     */
        }

        /*     */
        /*     */
        /*     */
        /* 122 */
        public int compareTo(Node node) {
            return (int) (this.heuristique - node.heuristique);
        }

        /*     */
        /*     */
        /* 125 */
        public int getX() {
            return this.x;
        }

        /*     */
        /*     */
        /*     */
        /* 129 */
        public void setX(int x) {
            this.x = x;
        }

        /*     */
        /*     */
        /*     */
        /* 133 */
        public int getY() {
            return this.y;
        }

        /*     */
        /*     */
        /*     */
        /* 137 */
        public void setY(int y) {
            this.y = y;
        }

        /*     */
        /*     */
        /*     */
        /* 141 */
        public double getHeuristique() {
            return this.heuristique;
        }

        /*     */
        /*     */
        /*     */
        /* 145 */
        public void setHeuristique(int heuristique) {
            this.heuristique = heuristique;
        }

        /*     */
        /*     */
        /*     */
        /* 149 */
        public void setHeuristique(double heuristique) {
            this.heuristique = heuristique;
        }

        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        /* 156 */
        public Node droite() {
            return new Node(this.x + 1, this.y, this.initialX, this.initialY, 0);
        }

        /*     */
        /*     */
        /*     */
        /*     */
        /* 161 */
        public Node gauche() {
            return new Node(this.x - 1, this.y, this.initialX, this.initialY, 0);
        }

        /*     */
        /*     */
        /*     */
        /* 165 */
        public Node haut() {
            return new Node(this.x, this.y - 1, this.initialX, this.initialY, 0);
        }

        /*     */
        /*     */
        /*     */
        /* 169 */
        public Node bas() {
            return new Node(this.x, this.y + 1, this.initialX, this.initialY, 0);
        }

        /*     */
        /*     */
        /* 172 */
        public boolean canMove() {
            return (this.x >= 0 && this.y >= 0 && this.x < DeplacementAEtoile.this.labyrinthe.getWidth() && this.y < DeplacementAEtoile.this.labyrinthe.getHeight() && DeplacementAEtoile.this.labyrinthe.getCase(this.x, this.y).estTraversable());
        }

        /*     */
        /*     */
        /*     */
        /* 176 */
        public int getInitialX() {
            return this.initialX;
        }

        /*     */
        /*     */
        /*     */
        /* 180 */
        public void setInitialX(int initialX) {
            this.initialX = initialX;
        }

        /*     */
        /*     */
        /*     */
        /* 184 */
        public int getInitialY() {
            return this.initialY;
        }

        /*     */
        /*     */
        /*     */
        /* 188 */
        public void setInitialY(int initialY) {
            this.initialY = initialY;
        }
        /*     */
    }
    /*     */
}


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/monstres/DeplacementAEtoile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */