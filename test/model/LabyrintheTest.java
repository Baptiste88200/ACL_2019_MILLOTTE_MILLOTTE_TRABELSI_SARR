/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import engine.Cmd;
import java.util.Collection;
import model.cases.Case;
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
    
    public LabyrintheTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of evolve method, of class Labyrinthe.
     */
    @Test
    public void testEvolve() {
        System.out.println("evolve");
        Cmd commande = null;
        Labyrinthe instance = null;
        instance.evolve(commande);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFinished method, of class Labyrinthe.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        Labyrinthe instance = null;
        boolean expResult = false;
        boolean result = instance.isFinished();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCase method, of class Labyrinthe.
     */
    @Test
    public void testGetCase() {
        System.out.println("getCase");
        int x = 0;
        int y = 0;
        Labyrinthe instance = null;
        Case expResult = null;
        Case result = instance.getCase(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Labyrinthe.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Labyrinthe instance = null;
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Labyrinthe.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Labyrinthe instance = null;
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHero method, of class Labyrinthe.
     */
    @Test
    public void testGetHero() {
        System.out.println("getHero");
        Labyrinthe instance = null;
        Hero expResult = null;
        Hero result = instance.getHero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCases method, of class Labyrinthe.
     */
    @Test
    public void testSetCases() {
        System.out.println("setCases");
        Case[][] cases = null;
        Labyrinthe instance = null;
        instance.setCases(cases);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionHero method, of class Labyrinthe.
     */
    @Test
    public void testSetPositionHero() {
        System.out.println("setPositionHero");
        int x = 0;
        int y = 0;
        Labyrinthe instance = null;
        instance.setPositionHero(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonstres method, of class Labyrinthe.
     */
    @Test
    public void testGetMonstres() {
        System.out.println("getMonstres");
        Labyrinthe instance = null;
        Collection<Monstre> expResult = null;
        Collection<Monstre> result = instance.getMonstres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterMonstre method, of class Labyrinthe.
     */
    @Test
    public void testAjouterMonstre() {
        System.out.println("ajouterMonstre");
        Monstre m = null;
        Labyrinthe instance = null;
        instance.ajouterMonstre(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estTraversable method, of class Labyrinthe.
     */
    @Test
    public void testEstTraversable() {
        System.out.println("estTraversable");
        int x = 0;
        int y = 0;
        Labyrinthe instance = null;
        boolean expResult = false;
        boolean result = instance.estTraversable(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCordTraversable method, of class Labyrinthe.
     */
    @Test
    public void testGetCordTraversable() {
        System.out.println("getCordTraversable");
        Labyrinthe instance = null;
        int[] expResult = null;
        int[] result = instance.getCordTraversable();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerMonstreVert method, of class Labyrinthe.
     */
    @Test
    public void testCreerMonstreVert() {
        System.out.println("creerMonstreVert");
        Labyrinthe instance = null;
        instance.creerMonstreVert();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinish method, of class Labyrinthe.
     */
    @Test
    public void testSetFinish() {
        System.out.println("setFinish");
        boolean finish = false;
        Labyrinthe instance = null;
        instance.setFinish(finish);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
