/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

import Snd.Gamelogic.GameObjects.MovingObject;
import Snd.Gamelogic.GameObjects.Ship;
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
public class GameTest {

    public GameTest() {
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
    public void konstruktoriToimii() {
        MyGraphics mg = new MyGraphics("", 10, 10);
        MovingObject.setGraphics(null);
        VisibleCountdownTimer.setGraphics(null);
        Game g = new Game(mg);     
        assertNotNull("MovingObject graphics is null", MovingObject.graphics);
        assertNotNull("VisibleCountdownTimer graphics is null", VisibleCountdownTimer.graphics);

    }

    @Test
    public void updateToimii() {
        MyGraphics mg = new MyGraphics("", 10, 10);
        Game g = new Game(mg);
        g.update();
        Ship s = g.getObjects().getShips().get(1);
        s.getPos().setX(0.1f);
        s.getPos().setY(0.1f);
        s.getSpeedVec().setSpeedX(0.2f);
        s.getSpeedVec().setSpeedY(0.2f);
        g.update();
        assertEquals("",0.3f,g.getObjects().getShips().get(1).getPos().getX(),0.001f);
        assertEquals("",0.3f,g.getObjects().getShips().get(1).getPos().getY(),0.001f);
    }
}