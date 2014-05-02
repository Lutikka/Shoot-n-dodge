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
        Ship s = new TestedShip(0,0,0,0,0,0,0,0,0);
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
        Ship s = new TestedShip(0.5f,0.5f,0,0,2,2,0.0001f,0.0001f,0);
        Ship s1 = new TestedShip(0.2f,0.2f,0,0,2,2,0.002f,0.002f,1);
        oh.addShip(s);
        oh.addProjectile(p);
        oh.checkProjectileCollisions();
        assertTrue("Projectile tuhoutunut vaikkei pitänyt",p.isAlive());
        assertTrue("Ship tuhoutunut vaikkei pitänyt",s.isAlive());
        assertTrue("Ship 2 tuhoutunut vaikkei pitänyt",s1.isAlive());
        
    }
    
    @Test
    public void testShipRemoval() {
        ObjectHolder oh = new ObjectHolder();
        Ship s = new TestedShip(0.5f,0.5f,0,0,2,2,0.0001f,0.0001f,0);
        Ship s1 = new TestedShip(0.2f,0.2f,0,0,2,2,0.002f,0.002f,1);
        oh.addShip(s);
        oh.addShip(s1);
        s.destroy();
        s1.destroy();
        oh.update();
        assertEquals("shippejä jäi eloon vaikka tuhottiin",0,oh.getShips().size());
        
    }
    
    @Test
    public void testCheckShipCollisionsToimiiEiMitaanKollisiota() {
        ObjectHolder oh = new ObjectHolder();
        Ship s = new TestedShip(0.4f,0.6f,0,0,2,2,0.0005f,0.0005f,0);
        oh.addShip(s);
        oh.checkShipCollisions();
        assertEquals("Positio x muuttunut",0.4f,s.getPos().getX(),0.001f);
        assertEquals("Positio y muuttunut",0.6f,s.getPos().getY(),0.001f);
        
        
    }
    
    @Test
    public void testUpdateShip(){
        ObjectHolder oh = new ObjectHolder();
        Ship.setOh(oh);
        Ship s1 = new TestedShip(0.4f,0.6f,-0.3f,-0.5f,2,2,0.0005f,0.0005f,0);
        Ship s2 = new TestedShip(0.4f,0.6f,0.5f,0.3f,2,2,0.0005f,0.0005f,0);
        oh.addShip(s1);
        oh.addShip(s2);
        oh.update();
        Ship s12 = oh.getShips().get(0);
        Ship s22 = oh.getShips().get(1);
        assertEquals("Ship 1: X positio väärä 1 updaten jälkeen",0.1f,s12.getPos().getX(),0.001f);
        assertEquals("Ship 1: Y positio väärä 1 updaten jälkeen",0.1f,s12.getPos().getY(),0.001f);
        assertEquals("Ship 2: X positio väärä 1 updaten jälkeen",0.9f,s22.getPos().getX(),0.001f);
        assertEquals("Ship 2: Y positio väärä 1 updaten jälkeen",0.9f,s22.getPos().getY(),0.001f);
        oh.update();
        Ship s13 = oh.getShips().get(0);
        Ship s23 = oh.getShips().get(1);
        assertEquals("Ship 1: X positio väärä 2 updaten jälkeen",0.0f,s13.getPos().getX(),0.001f);
        assertEquals("Ship 1: Y positio väärä 2 updaten jälkeen",0.0f,s13.getPos().getY(),0.001f);
        assertEquals("Ship 2: X positio väärä 2 updaten jälkeen",1.0f,s23.getPos().getX(),0.001f);
        assertEquals("Ship 2: Y positio väärä 2 updaten jälkeen",1.0f,s23.getPos().getY(),0.001f);
    }
    
    @Test
    public void testUpdateProjectile(){
        ObjectHolder oh = new ObjectHolder();
        Projectile p1 = new Projectile(0.4f,0.6f,-0.3f,-0.5f,1,0);
        Projectile p2 = new Projectile(0.4f,0.6f,0.5f,0.3f,1,0);
        oh.addProjectile(p1);
        oh.addProjectile(p2);
        oh.update();
        Projectile p12 = oh.getProjectiles().get(0);
        Projectile p22 = oh.getProjectiles().get(1);
        assertEquals("Projectile 1: X positio väärä 1 updaten jälkeen",0.1f,p12.getPos().getX(),0.001f);
        assertEquals("Projectile 1: Y positio väärä 1 updaten jälkeen",0.1f,p12.getPos().getY(),0.001f);
        assertEquals("Projectile 2: X positio väärä 1 updaten jälkeen",0.9f,p22.getPos().getX(),0.001f);
        assertEquals("Projectile 2: Y positio väärä 1 updaten jälkeen",0.9f,p22.getPos().getY(),0.001f);
        oh.update();
        oh.update();
        assertEquals("Projectilet hengissä vaikkei pitänyt",0,oh.getProjectiles().size());

    }
}