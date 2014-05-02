/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.MyGraphics;
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
public class AITest {
    
    public AITest() {
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
   public void testCheckEndConditionsToimii() {
       MyGraphics mg = new MyGraphics("",10,10);
       Game g = new Game(mg);
       Control c= g.getCtrl();
       AI ai = new AI(c);
       c.addShip(0, 0, 0, 0, 1, 2, 0.2f, 0.2f, 1);
       ai.start();
       assertEquals("aluksia ei poistettu kun peli loppui",1,c.getEnemyShipCount());
       c.getPlayerShip().destroy();
       ai.checkEndConditions();
       assertFalse("peli ei pysähtynyt vaikka piti",c.isRunning());
       
   }
   
   @Test
   public void testupdateToimii() {
       MyGraphics mg = new MyGraphics("",10,10);
       Game g = new Game(mg);
       Control c= g.getCtrl();
       AI ai = new AI(c);
       ai.update();
       assertEquals("",1,c.getEnemyShipCount());
       c.getGame().getObjects().getShips().remove(1);
       ai.update();
       assertEquals("",2,c.getEnemyShipCount());
       c.getGame().getObjects().getShips().remove(1);
       c.getGame().getObjects().getShips().remove(1);
       ai.update();
       assertEquals("",4,c.getEnemyShipCount());
   }
}