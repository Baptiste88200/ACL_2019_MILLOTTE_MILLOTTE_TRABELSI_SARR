/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import engine.Cmd;
import java.util.Collection;
import model.cases.Case;
import model.creationLabyrinthe.CreationAleatoire;
import model.creationLabyrinthe.CreationLabyrinthe;
import model.monstres.Monstre;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Work
 */
public class LabyrintheTest {
     private static CreationLabyrinthe lab;
    private static Labyrinthe game;
    public LabyrintheTest() {
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
     * Test of getHero method, of class Labyrinthe.
     */
    @Test
    public void testGetHero() {
        System.out.println("getHero");
        Hero hero = game.getHero();
        assertNotNull(hero);
       
    }
    
    @Test
    public void TestInitialPosition()
    {
         System.out.println("InitialPosition Hero");
        Hero hero = game.getHero();
        assertTrue(hero.getX()==-1);
    }

    /**
     * Test of setPositionHero method, of class Labyrinthe.
     */
    @Test
    public void testSetPositionHero() {
        System.out.println("setPositionHero");
        int x = 0;
        int y = 0;
        game.setPositionHero(x, y);
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(game.position(x,y));
    }

    /**
     * Test of ajouterMonstre method, of class Labyrinthe.
     */
    @Test
    public void testAjouterMonstreNull() {
        System.out.println("ajouterMonstreNull");
        Monstre m = null;
        game.ajouterMonstre(m);
        assertNotNull(m);
    }

   

    
}
