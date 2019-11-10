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

/**
 *
 * @author Work
 */
public class HeroIT {
    
    public HeroIT() {
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
     * Test of afficher method, of class Hero.
     */
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        Graphics2D g = null;
        Hero instance = null;
        instance.afficher(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deplacerGauche method, of class Hero.
     */
    @Test
    public void testDeplacerGauche() {
        System.out.println("deplacerGauche");
        Hero instance = null;
        instance.deplacerGauche();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deplacerDroite method, of class Hero.
     */
    @Test
    public void testDeplacerDroite() {
        System.out.println("deplacerDroite");
        Hero instance = null;
        instance.deplacerDroite();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deplacerHaut method, of class Hero.
     */
    @Test
    public void testDeplacerHaut() {
        System.out.println("deplacerHaut");
        Hero instance = null;
        instance.deplacerHaut();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deplacerBas method, of class Hero.
     */
    @Test
    public void testDeplacerBas() {
        System.out.println("deplacerBas");
        Hero instance = null;
        instance.deplacerBas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
