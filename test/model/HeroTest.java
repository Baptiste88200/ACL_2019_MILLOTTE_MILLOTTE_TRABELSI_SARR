/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
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
    
  
}  /**
 
