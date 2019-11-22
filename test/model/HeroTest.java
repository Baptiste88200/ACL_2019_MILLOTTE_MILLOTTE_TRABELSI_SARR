/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;
import java.util.Arrays;
import model.creationLabyrinthe.CreationAleatoire;
import model.monstres.Monstre;
import model.monstres.MonstreVert;
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
public class HeroTest {
    public Labyrinthe labyrinthe ;
    public HeroTest() {
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
     * Test of deplacerGauche method, of class Hero.
     */
    @Test
    public void testDeplacerMurGauche() {
        System.out.println("deplacerGauche");
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        Hero hero = labyrinthe.getHero();
        int x = hero.getX();
        int y = hero.getY();
        System.out.println(x);
        System.out.println(y);
        if(labyrinthe.estTraversable(x-1, y))
            hero.deplacerGauche();
        assertEquals(x,hero.getX());
    }

    /**
     * Test of deplacerDroite method, of class Hero.
     */
    @Test
    public void testDeplacerMurDroite() {
        System.out.println("deplacerDroite");
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        Hero hero = labyrinthe.getHero();
        int x = hero.getX();
        int y = hero.getY();
        //find traversable y 
        int i=0;
        while(!labyrinthe.estTraversable(24, i)&& i<=24)
            i++;
        if(labyrinthe.estTraversable(24,i)){
        hero.setX(24);
        hero.setY(i);}
        if(labyrinthe.estTraversable(hero.getX(), y)&&i<=24){
            hero.deplacerDroite();
        assertEquals(24,hero.getX());}
    }
    /**
     * Test of teleporterAleatoirement method, of class Hero.
     */
    @Test
    public void testTeleporterAleatoirement() {
        System.out.println("teleporterAleatoirement");
       labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        Hero hero = labyrinthe.getHero();
        int cord[] = {hero.getX(),hero.getY()};
        hero.teleporterAleatoirement();
        int cord2[] = {hero.getX(),hero.getY()};
        assertFalse(Arrays.equals(cord, cord2));
        
    }

    /**
     * Test of subirDegat method, of class Hero.
     */
    @Test
    public void testSubirDegat() {
        System.out.println("subirDegat");
        int d = 2;
        int x ;
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        Hero hero = labyrinthe.getHero();
        x=hero.getPV();
        hero.subirDegat(d);
     assertEquals(hero.getPV(),x-2 );
    }

    /**
     * Test of enVie method, of class Hero.
     */
    @Test
    public void testEnVie() {
        System.out.println("enVie");
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        Hero hero = labyrinthe.getHero();
        hero.subirDegat(hero.getPV());
        boolean expResult = false;
        boolean result = hero.enVie();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getMonstreProche method, of class Hero.
     */
    @Test
    public void testGetMonstreProche() {
        System.out.println("getMonstreProche");
        labyrinthe = new Labyrinthe(new CreationAleatoire(25, 25));
        Hero hero = labyrinthe.getHero();
        int xh=hero.getX();
        int yh=hero.getY();
        Monstre m = new MonstreVert(xh+1,yh,labyrinthe);
        labyrinthe.ajouterMonstre(m);
        Monstre result = hero.getMonstreProche();
        assertEquals(result.getX(), m.getX());
      
    }

    
}
