/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.Projectile;
import Snd.Gamelogic.GameObjects.Ship;
import Snd.Gamelogic.GameObjects.TestedShip;
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
public class CheckTest {
    Check c;
    public CheckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c = new Check(1f,1f);
    }
    
    @After
    public void tearDown() {
    }
   
    @Test
    public void testProjectileWallCollisionYlajaVasenEiKollisiota() {
        
        Projectile p = new Projectile(0.001f,0.001f,0,0,0,null,0);
        boolean tmp[] = c.checkWallCollisions(p);
        assertFalse("vasemman seinän kollisio tapahtunut", tmp[0]);
        assertFalse("ylä seinän kollisio tapahtunut", tmp[1]);
        assertFalse("oikean seinän kollisio tapahtunut", tmp[2]);
        assertFalse("ala seinän kollisio tapahtunut", tmp[3]);
        
    }
    
    @Test
    public void testProjectileWallCollisionAlaJaOikeaEiKollisiota() {
        
        Projectile p = new Projectile(c.getFloatMaxX()-0.001f,c.getFloatMaxY()-0.001f,0,0,0,null,0);
        boolean tmp[] = c.checkWallCollisions(p);
        assertFalse("vasemman seinän kollisio tapahtunut", tmp[0]);
        assertFalse("ylä seinän kollisio tapahtunut", tmp[1]);
        assertFalse("oikean seinän kollisio tapahtunut", tmp[2]);
        assertFalse("ala seinän kollisio tapahtunut", tmp[3]);
        
    }
    
    @Test
    public void testProjectileWallCollisionYlajaVasenKollisiolla() {
       
        Projectile p = new Projectile(-0.001f,-0.001f,0,0,0,null,0);
        boolean tmp[] = c.checkWallCollisions(p);
        assertTrue("vasemman seinän kollisio ei tapahtunut", tmp[0]);
        assertTrue("ylä seinän kollisio ei tapahtunut", tmp[1]);
        assertFalse("oikean seinän kollision tapahtunut", tmp[2]);
        assertFalse("ala seinän kollision tapahtunut", tmp[3]);
        
    }
    @Test
    public void testProjectileWallCollisionAlaJaOikeaKollisiolla() {
        
        Projectile p = new Projectile(c.getFloatMaxX()+0.001f,c.getFloatMaxY()+0.001f,0,0,0,null,0);
        boolean tmp[] = c.checkWallCollisions(p);
        assertFalse("vasemman seinän kollisio tapahtunut", tmp[0]);
        assertFalse("ylä seinän kollisio tapahtunut", tmp[1]);
        assertTrue("oikean seinän kollision ei tapahtunut", tmp[2]);
        assertTrue("ala seinän kollision ei tapahtunut", tmp[3]);
        
    }
    
    @Test
    public void testShipWallCollisionAlaJaOikeaKollisiolla() {
        
        Ship s = new TestedShip(c.getFloatMaxX()-0.020f,c.getFloatMaxY()-0.020f,0,0,0,0,0.049f,0.049f,new ObjectHolder(),null,0);
        boolean tmp[] = c.checkWallCollisions(s);
        assertFalse("vasemman seinän kollisio tapahtunut", tmp[0]);
        assertFalse("ylä seinän kollisio tapahtunut", tmp[1]);
        assertTrue("oikean seinän kollision ei tapahtunut", tmp[2]);
        assertTrue("ala seinän kollision ei tapahtunut", tmp[3]);
        
    }
    
    @Test
    public void testShipWallCollisionYlaJaVasenKollisiolla() {
        
        Ship s = new TestedShip(0.020f,0.020f,0,0,0,0,0.049f,0.049f,new ObjectHolder(),null,0);
        boolean tmp[] = c.checkWallCollisions(s);
        assertTrue("vasemman seinän kollisio tapahtunut", tmp[0]);
        assertTrue("ylä seinän kollisio tapahtunut", tmp[1]);
        assertFalse("oikean seinän kollision ei tapahtunut", tmp[2]);
        assertFalse("ala seinän kollision ei tapahtunut", tmp[3]);
        
    }
    
    @Test
    public void testProjectileToShipCollisionVasenKollisiolla() {
        Projectile p = new Projectile(0.50f,0.50f,0,0,0,null,1);
        Ship s = new TestedShip(0.48f,0.50f,0,0,0,0,0.042f,0.042f,new ObjectHolder(),null,0);
        assertTrue("vasen kollisiota ei tapahtunut",c.checkProjectileToShipCollisions(p, s));
    }
    
    @Test
    public void testProjectileToShipCollisionOikeaKollisiolla() {
        Projectile p = new Projectile(0.50f,0.50f,0,0,0,null,1);
        Ship s = new TestedShip(0.52f,0.50f,0,0,0,0,0.042f,0.042f,new ObjectHolder(),null,0);
        assertTrue("oikea kollisiota ei tapahtunut",c.checkProjectileToShipCollisions(p, s));
    }
    
    @Test
    public void testProjectileToShipCollisionYlaKollisiolla() {
        Projectile p = new Projectile(0.50f,0.50f,0,0,0,null,1);
        Ship s = new TestedShip(0.50f,0.48f,0,0,0,0,0.042f,0.042f,new ObjectHolder(),null,0);
        assertTrue("ylä kollisiota ei tapahtunut",c.checkProjectileToShipCollisions(p, s));
    }
    
    @Test
    public void testProjectileToShipCollisionAlaKollisiolla() {
        Projectile p = new Projectile(0.50f,0.50f,0,0,0,null,1);
        Ship s = new TestedShip(0.50f,0.52f,0,0,0,0,0.042f,0.042f,new ObjectHolder(),null,0);
        assertTrue("ala kollisiota ei tapahtunut",c.checkProjectileToShipCollisions(p, s));
    }
    
}