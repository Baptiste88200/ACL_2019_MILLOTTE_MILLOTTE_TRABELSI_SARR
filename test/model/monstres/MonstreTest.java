/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

 * and open the template in the editor.
 */
package model.monstres;

import java.util.ArrayList;
import java.util.Collection;

import model.Labyrinthe;
import model.creationLabyrinthe.CreationAleatoire;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * *
 *
 *
 *
 *
 *
 *
 *
 *
 * @author ileft *
 *
 *
 *
 */
public class MonstreTest {

    public static Labyrinthe labyrinthe;

    public static Collection<Monstre> monstres;

    public MonstreTest() {

    }

    @BeforeClass

    public static void setUpClass() {

        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));

        monstres = labyrinthe.getMonstres();

    }

    @AfterClass

    public static void tearDownClass() {

    }

    @Before

    public void setUp() {

    }

    @After

    public void tearDown() {

    }

    /**
     * *
     *
     *
     *
     * Test of teleporterAleatoirement method, of class Monstre./ *
     *
     *
     *
     */
    
  /* public void testTeleporterAleatoirement() {

        System.out.println("teleporterAleatoirement");

        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));

        monstres = labyrinthe.getMonstres();

        int i = 0;

        labyrinthe.getMonstres().forEach((mon) -> {

            int x = mon.getX();

            int y = mon.getY();

            mon.teleporterAleatoirement();

            // TODO review the generated test code and remove the default call to fail.
            assertNotEquals(x, mon.getX());

           else assertNotEquals(y, mon.getY());

        });

    }

    /*


*/

    /**




     * Test of subirDegat method, of class Monstre./




     */
    @Test
    public void testSubirDegat() {

        System.out.println("subirDegat Monstre");

        int d = 2;
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        monstres = labyrinthe.getMonstres();
        ArrayList<Monstre> m =labyrinthe.getHero().getMonstreProche();
        labyrinthe.getHero().setAttaque(true);
        labyrinthe.getMonstres().forEach((mon) -> {
           
           int ancienPV= mon.getScore();
           labyrinthe.getHero().attaquer(mon);
          assertTrue(ancienPV > mon.getScore());
       
        });        

    }

     
    /**
     * *
     *
     *
     *
     * Test of attaquer method, of class Monstre. *
     *
     *
     *
     */
    @Test

    public void testAttaquer() {

        System.out.println("attaquer");

        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));

        System.out.println("subirDegat Monstre");

        int d = 2;
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        monstres = labyrinthe.getMonstres();
        ArrayList<Monstre> m =labyrinthe.getHero().getMonstreProche();
        labyrinthe.getHero().setAttaque(true);
        labyrinthe.getMonstres().forEach((mon) -> {
           
           int ancienPV=labyrinthe.getHero().getPV();
           mon.attaquer(labyrinthe.getHero());
          assertTrue(ancienPV > labyrinthe.getHero().getPV());
       });
    }

    /**
     * *
     *
     *
     *
     * Test of enVie method, of class Monstre./ *
     *
     *
     *
     */
    @Test

    public void testEnVie() {

        System.out.println("enVie");

        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));

        monstres = labyrinthe.getMonstres();

        int i = 0;
        labyrinthe.getMonstres().forEach((mon) -> {
            boolean expResult = true;
            boolean result = mon.enVie();
            if (mon.getScore() > 0) {
                assertEquals(expResult, result);
            } else {
                assertEquals(false, result);
            }

        });

    }

    public class MonstreImpl extends Monstre {

        public MonstreImpl() {
            super(0, 0, null, null, 0, 0, 0);
        }
    }

}
