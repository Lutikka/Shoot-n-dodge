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
public class CountdownTimerTest {
    
    public CountdownTimerTest() {
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
    public void konstruktoriToimiiTest() {
        CountdownTimer c1 = new CountdownTimer(10);
        CountdownTimer c2 = new CountdownTimer(1010l);
        assertEquals("secs parametrinen konstruktori ei toimi oikein",10000,c1.getTimer());
        assertEquals("msecs parametrinen konstruktori ei toimi oikein",1010,c2.getTimer());
    }
    
    @Test
    public void addToimiiTest() {
        CountdownTimer c1 = new CountdownTimer(10000l);
        c1.addMillis(1001);
        assertEquals("add ei toimi oikein",11001,c1.getTimer());
    }
    
    @Test
    public void toStringToimiiTest() {
        CountdownTimer c1 = new CountdownTimer(12345l);     
        assertEquals("toString palauttaa vääränlaisen merkkijonon","12.3",c1.toString());
    }
    
    @Test
    public void updateToimiiTest() {
        CountdownTimer c1 = new CountdownTimer(12345l);  
        long time= System.currentTimeMillis();
        try{
            Thread.sleep(5);
        }catch(Exception e){}
        time=System.currentTimeMillis()-time;
        c1.update();
        assertEquals("timer laskee väärin",12345-time,c1.getTimer(),7);
    }
}