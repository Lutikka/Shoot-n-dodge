/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.GameObjects.MovingObject;
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
public class MovingObjectTest {
    
    public MovingObjectTest() {
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
    public void KonstruktoriToimiiOikein() {
        MovingObject mo = new MovingObject(1,2,3,4);
        assertNotNull("Position ei ole initialisoitu",mo.getPos());
        assertNotNull("SpeedVector ei ole initialisoitu",mo.getSpeedVec());
    }
}