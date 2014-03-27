/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.Projectile;
import Snd.Gamelogic.GameObjects.TestedShip;
import Snd.Gamelogic.GameObjects.Ship;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lutikka
 */
public class ObjectHolderTest {
    
    public ObjectHolderTest() {
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
    
    @Test
    public void testKonstruktoriToimiiOikein() {
        ObjectHolder oh = new ObjectHolder();
        assertNotNull("Ships tietorakenne ei initialisoitu",oh.getShips());
        assertNotNull("Projectiles tietorakenne ei initialisoitu",oh.getProjectiles());
    }
    
    @Test
    public void testAddShipToimii() {
        ObjectHolder oh = new ObjectHolder();
        Ship s = new TestedShip(0,0,0,0,0,0,0,0,new ObjectHolder(),0);
        oh.addShip(s);
        assertEquals("Ships add ei toimi",1,oh.getShips().size());
        
    }
    
    @Test
    public void testAddProjectileToimii() {
        ObjectHolder oh = new ObjectHolder();
        Projectile p = new Projectile(0,0,0,0,0,1);
        oh.addProjectile(p);
        assertEquals("Projectiles add ei toimi",1,oh.getProjectiles().size());
    }
    
    @Test
    public void testCheckProjectileCollisionsToimiiEiMitaanKollisiota() {
        ObjectHolder oh = new ObjectHolder();
        Projectile p = new Projectile(0.2f,0.2f,0,0,3,1);
        Ship s = new TestedShip(0.5f,0.5f,0,0,2,2,0.0001f,0.0001f,new ObjectHolder(),0);
        oh.addShip(s);
        oh.addProjectile(p);
        oh.checkProjectileCollisions();
        assertTrue("Projectile tuhoutunut vaikkei pitänyt",p.isAlive());
        assertTrue("Ship tuhoutunut vaikkei pitänyt",s.isAlive());
        
    }
    
    @Test
    public void testCheckShipCollisionsToimiiEiMitaanKollisiota() {
        ObjectHolder oh = new ObjectHolder();
        Ship s = new TestedShip(0.4f,0.6f,0,0,2,2,0.0005f,0.0005f,new ObjectHolder(),0);
        oh.addShip(s);
        oh.checkShipCollisions();
        assertEquals("Positio x muuttunut",0.4f,s.getPos().getX(),0.001f);
        assertEquals("Positio y muuttunut",0.6f,s.getPos().getY(),0.001f);
        
        
    }
}