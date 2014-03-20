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
public class PositionTest {
    
    public PositionTest() {
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
    public void testKonstruktoriToimiiOikein(){
        SpeedVector speedVec = new SpeedVector(1,1);
        Position p = new Position(-10,-1,speedVec);
        assertEquals("posX saa väärän arvon",-10,p.getX(),0.001);
        assertEquals("posY saa väärän arvon",-1,p.getY(),0.001);
        assertNotNull("SpeedVec attribuuttia ei ole määritelty", p.getSpeedVec());
    }
    
    @Test
    public void testUpdateMuuuttaaPositioniaOikeinSpeedVectorinMukaan(){
        SpeedVector speedVec = new SpeedVector(1,-1);
        Position p = new Position(-10,-1,speedVec);
        p.update();
        assertEquals("posX saa väärän arvon 1 updaten jälkeen",-9,p.getX(),0.001);
        assertEquals("posY saa väärän arvon 1 updaten jälkeen",-2,p.getY(),0.001);
        for (int i = 0; i < 10; i++) {
            p.update();
        }
        assertEquals("posX saa väärän arvon 11 updaten jälkeen",1,p.getX(),0.001);
        assertEquals("posY saa väärän arvon 11 updaten jälkeen",-12,p.getY(),0.001);
    }
}