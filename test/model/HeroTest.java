/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.*;
import model.creationLabyrinthe.CreationAleatoire;
import model.creationLabyrinthe.CreationLabyrinthe;

/**
 *
 * @author Work
 */
public class HeroTest {
    private static CreationLabyrinthe lab;
    private static Labyrinthe game;
    
    
    public HeroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        lab=new CreationAleatoire(20,20);
        game= new Labyrinthe(lab);
       
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
     * Test of deplacerGauche method, of class Hero.
     */
    @Test
    public void testDeplacerGauche() {
        System.out.println("deplacerGauche");
        game.getHero().setX(0);
        game.getHero().deplacerGauche();
        // TODO review the generated test code and remove the default call to fail.
        int x = game.getHero().getX();
        assertEquals(x,-1);
    }
    
     /**
     * Test of testMurGauche method, of class Hero.
     */
    @Test
    public void testMurGauche()
    {
          System.out.println("testMurGauche");
          game.getHero().deplacerGauche();
          int x = game.getHero().getX();
          assertEquals(x,1);
        
    }

    /**
     * Test of deplacerDroite method, of class Hero.
     */
    @Test
    public void testDeplacerDroite() {
        System.out.println("deplacerDroite");
        game.getHero().deplacerDroite();
        // TODO review the generated test code and remove the default call to fail.
        int x = game.getHero().getX();
        assertEquals(x,0);//x=-1 y =-1 initiale
    }
     /**
     * Test of testMurDroite method, of class Hero.
     */
    @Test
    public void testMurDroite()
    {
          System.out.println("testMurDroite");
          game.getHero().setX(17);
          game.getHero().deplacerGauche();
          int x = game.getHero().getX();
          assertEquals(x,17);//18 is a wall
        
    }
    /**
     * Test of deplacerHaut method, of class Hero.
     */
    @Test
    public void testDeplacerHaut() {
        System.out.println("deplacerHaut");
        game.getHero().setY(0);
        game.getHero().deplacerHaut();
        // TODO review the generated test code and remove the default call to fail.
        int y = game.getHero().getY();
        assertEquals(y,-1);
    }
     /**
     * Test of testMurHaut method, of class Hero.
     */
    @Test
    public void testMurHaut()
    {
          System.out.println("testMurHaut");
          game.getHero().deplacerHaut();
          int y = game.getHero().getY();
          assertEquals(y,-1);
        
    }
    /**
     * Test of deplacerBas method, of class Hero.
     */
    @Test
    public void testDeplacerBas() {
        System.out.println("deplacerBas");
        game.getHero().deplacerBas();
        // TODO review the generated test code and remove the default call to fail.
        int y = game.getHero().getY();
        assertEquals(y,0);
    }
    
     /**
     * Test of testMurBas method, of class Hero.
     */
    @Test
    public void testMurBas()
    {
          System.out.println("testMurGauche");
          game.getHero().setY(17);
          game.getHero().deplacerGauche();
          int y = game.getHero().getY();
          assertEquals(y,17);//18 is a wall
        
    }
    /**
     * Test of getX method, of class Hero.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Hero instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Hero.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Hero instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Hero.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Hero instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Hero.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Hero instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of teleporterAleatoirement method, of class Hero.
     */
    @Test
    public void testTeleporterAleatoirement() {
        System.out.println("teleporterAleatoirement");
        Hero instance = null;
        instance.teleporterAleatoirement();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subirDegat method, of class Hero.
     */
    @Test
    public void testSubirDegat() {
        System.out.println("subirDegat");
        int d = 0;
        Hero instance = null;
        instance.subirDegat(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
