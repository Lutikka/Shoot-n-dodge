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
public class SpeedVectorTest {
    
    public SpeedVectorTest() {
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
    public void testToinenKonstruktori() {
        SpeedVector sv;
        float speed=1.5f;
        Position p = new Position(0.0f,0.0f);
        Position p2 = new Position(0.3f,0.4f);
        sv = new SpeedVector(p,p2,speed);
        assertEquals("",0.9f,sv.getSpeedX(),0.001f);
        assertEquals("",1.2f,sv.getSpeedY(),0.001f);
    }
}