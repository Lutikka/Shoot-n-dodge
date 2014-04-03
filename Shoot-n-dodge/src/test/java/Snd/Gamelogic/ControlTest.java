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
    public void PlayerMoveDownToimiiTest() {
        MyGraphics graph = new MyGraphics("",2,2);
        Game g = new Game(graph);
        Control ctrl = new Control(g,graph);
        ctrl.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveDown();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedY()>0); 
    }
    
    @Test
    public void PlayerMoveRightToimiiTest() {
        MyGraphics graph = new MyGraphics("",2,2);
        Game g = new Game(graph);
        Control ctrl = new Control(g,graph);
        ctrl.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveRight();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedX()>0); 
    }
    
    @Test
    public void PlayerMoveUpToimiiTest() {
        MyGraphics graph = new MyGraphics("",2,2);
        Game g = new Game(graph);
        Control ctrl = new Control(g,graph);
        ctrl.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveUp();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedY()<0); 
    }
    
    @Test
    public void PlayerMoveLeftToimiiTest() {
        MyGraphics graph = new MyGraphics("",2,2);
        Game g = new Game(graph);
        Control ctrl = new Control(g,graph);
        ctrl.update();
        ctrl.update();
        ctrl.getPlayerShip().getSpeedVec().setSpeedX(0f);
        ctrl.getPlayerShip().getSpeedVec().setSpeedY(0f);
        ctrl.playerMoveLeft();
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", ctrl.getPlayerShip().getSpeedVec().getSpeedX()<0); 
    }
    
    @Test
    public void PlayerShootAtToimiiTest() {
        MyGraphics graph = new MyGraphics("",2,2);
        Game g = new Game(graph);
        Control ctrl = new Control(g,graph);
        ctrl.update();
        int counter = g.getObjects().getProjectiles().size();        
        ctrl.playerShootAt(0.4f, 0.4f);
        ctrl.update();
        assertTrue("Pelaajan alus ei liiku oikeaan suuntaan tai ollenkaan", g.getObjects().getProjectiles().size()>counter); 
    }
}