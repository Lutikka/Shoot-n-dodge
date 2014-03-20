/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd;

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
public class MainTest {
    
    public MainTest() {
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
    public void testInitToimii(){
        Main m = new Main();
        m.init();
        assertNotNull("Init ei luo instanssia pelista", m.getGame());
        assertTrue("Init ei aseta running = true",m.isRunning());
        
    }
}