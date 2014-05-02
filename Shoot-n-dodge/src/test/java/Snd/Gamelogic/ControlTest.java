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
public class ControlTest {

    public ControlTest() {
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
    public void testPlayerMoveDownToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveDown();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedY() > 0);
    }

    @Test
    public void testPlayerMoveRightToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveRight();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedX() > 0);
    }

    @Test
    public void testPlayerMoveUpToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveUp();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedY() < 0);
    }

    @Test
    public void testPlayerMoveLeftToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveLeft();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedX() < 0);
    }

    @Test
    public void testPlayerStopToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveLeft();
        ctrl.playerMoveUp();
        ctrl.update();
        ctrl.playerStopMoveLeft();
        ctrl.playerStopMoveUp();
        ctrl.update();
        ctrl.update();
        assertEquals("Pelaajan alus liikkuu x suunnassa vaikkei pitänyt", 0, ctrl.getPlayerShip().getSpeedVec().getSpeedX(), 0.001);
        assertEquals("Pelaajan alus liikkuu y suunnassa vaikkei pitänyt", 0, ctrl.getPlayerShip().getSpeedVec().getSpeedY(), 0.001);
    }

    @Test
    public void testSamallaAksellillaYhteensuuntaanLiikkuminenEstaaToiseenSuuntaanLiikkumisen() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveDown();
        ctrl.playerMoveRight();
        ctrl.playerMoveLeft();
        ctrl.playerMoveUp();
        ctrl.update();
        ctrl.playerStopMoveLeft();
        ctrl.playerStopMoveUp();
        ctrl.update();
        assertEquals("Pelaajan alus liikkuu x suunnassa vaikkei pitänyt", 0, ctrl.getPlayerShip().getSpeedVec().getSpeedX(), 0.001);
        assertEquals("Pelaajan alus liikkuu y suunnassa vaikkei pitänyt", 0, ctrl.getPlayerShip().getSpeedVec().getSpeedY(), 0.001);
        ctrl.playerMoveLeft();
        ctrl.playerMoveUp();
        ctrl.playerMoveDown();
        ctrl.playerMoveRight();
        ctrl.update();
        ctrl.playerStopMoveDown();
        ctrl.playerStopMoveRight();
        ctrl.update();
        assertEquals("Pelaajan alus liikkuu x suunnassa vaikkei pitänyt", 0, ctrl.getPlayerShip().getSpeedVec().getSpeedX(), 0.001);
        assertEquals("Pelaajan alus liikkuu y suunnassa vaikkei pitänyt", 0, ctrl.getPlayerShip().getSpeedVec().getSpeedY(), 0.001);
    }

    @Test
    public void testgetEnemyShipCountToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        ctrl.update();
        ctrl.addShip(0.5f, 0.8f, 0f, 0f, 1, 5, 0.04f, 0.04f, 1);
        ctrl.addShip(0.5f, 0.8f, 0f, 0f, 1, 5, 0.04f, 0.04f, 1);
        ctrl.addShip(0.5f, 0.8f, 0f, 0f, 1, 5, 0.04f, 0.04f, 1);
        ctrl.addShip(0.5f, 0.8f, 0f, 0f, 1, 5, 0.04f, 0.04f, 1);
        ctrl.addShip(0.5f, 0.8f, 0f, 0f, 1, 5, 0.04f, 0.04f, 1);
        //peli tekee yhden eli 5+1
        assertEquals("Laskee vihollis alukset väärin", 6, ctrl.getEnemyShipCount());

    }

    @Test
    public void testPlayerShootAtToimii() {
        MyGraphics graph = new MyGraphics("", 2, 2);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        int counter = g.getObjects().getProjectiles().size();
        ctrl.playerShootAt(0.4f, 0.1f);
        ctrl.update();
        assertTrue("pelaajan alus ei ammu vaikka pitäisi", g.getObjects().getProjectiles().size() > counter);
    }

    @Test
    public void testPlayerShootAt2Toimii() {
        MyGraphics graph = new MyGraphics("", 100, 100);
        Game g = new Game(graph);
        Control ctrl = g.getCtrl();
        g.update();
        int counter = g.getObjects().getProjectiles().size();
        ctrl.playerShootAt(4, 4);
        ctrl.update();
        assertTrue("pelaajan alus ei ammu vaikka pitäisi", g.getObjects().getProjectiles().size() > counter);
    }
}