/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.monstres;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import model.Labyrinthe;
import model.Personnage;
import model.creationLabyrinthe.CreationAleatoire;
import model.creationLabyrinthe.CreationLabyrinthe;
import model.monstres.deplacement.Deplacement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ileft
 */
public class MonstreTest {
    public static Labyrinthe labyrinthe;
    public static Collection <Monstre> monstres;
    public MonstreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
     labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
     monstres =  labyrinthe.getMonstres();
   
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
     * Test of teleporterAleatoirement method, of class Monstre./
     */
    @Test
    public void testTeleporterAleatoirement() {
        System.out.println("teleporterAleatoirement");
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        monstres =  labyrinthe.getMonstres();
        int i =0;
        labyrinthe.getMonstres().forEach((mon) -> {
           int x =mon.getX();
        int y =mon.getY();
         mon.teleporterAleatoirement();
        // TODO review the generated test code and remove the default call to fail.
        assertNotEquals(x,mon.getX());
        assertNotEquals(y,mon.getY());
        });
       
    }

  /*
    /**
     * Test of subirDegat method, of class Monstre./
     */
  /*  @Test
    public void testSubirDegat() {
        System.out.println("subirDegat");
        int d = 0;
        Monstre instance = null;
        instance.subirDegat(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of attaquer method, of class Monstre.
     */
    @Test
    public void testAttaquer() {
        System.out.println("attaquer");
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        monstres =  labyrinthe.getMonstres();
        int i =0;
        labyrinthe.getMonstres().forEach((mon) -> {
          int score =labyrinthe.getHero().getPV();
          mon.attaquer(labyrinthe.getHero());
          assertNotEquals(score,labyrinthe.getHero().getPV());
        });
       
    }

   

    /**
     * Test of enVie method, of class Monstre./
     */
    @Test
    public void testEnVie() {
        
        System.out.println("enVie");
         labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        monstres =  labyrinthe.getMonstres();
        int i =0;
        labyrinthe.getMonstres().forEach((mon) -> {
        boolean expResult = true;
        boolean result = mon.enVie();
        if(mon.getScore()>0)
         assertEquals(expResult, result);
        else 
            assertEquals(false,result);
        });
       
       
     
      
    }

    public class MonstreImpl extends Monstre {

        public MonstreImpl() {
            super(0, 0, null);
        }

        public void afficher(Graphics2D g) {
        }
    }
    
}
