/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

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
    }
    
    @Test
    public void testAddShipToimii() {
        ObjectHolder oh = new ObjectHolder();
        Ship s = new TestedShip(0,0,0,0,0,0);
        oh.addShip(s);
        assertEquals("Ships tietorakenne ei initialisoitu",1,oh.getShips().size());
    }
}