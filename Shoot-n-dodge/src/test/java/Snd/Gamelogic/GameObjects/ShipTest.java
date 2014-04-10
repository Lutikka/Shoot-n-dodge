/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.GameObjects.TestedShip;
import Snd.Gamelogic.GameObjects.Ship;
import Snd.Gamelogic.ObjectHolder;
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
public class ShipTest {

    public ShipTest() {
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
    public void testKonstruktoriToimii() {
        Ship s = new TestedShip(50, 51, 52, 53, 54, 55, 56, 57,0);
        assertEquals("Konstruktori antaa vaaran posX arvon", s.getPos().getX(), 50, 0.001);
        assertEquals("Konstruktori antaa vaaran posY arvon", s.getPos().getY(), 51, 0.001);
        assertEquals("Konstruktori antaa vaaran speedX arvon", s.getSpeedVec().getSpeedX(), 52, 0.001);
        assertEquals("Konstruktori antaa vaaran speedY arvon", s.getSpeedVec().getSpeedY(), 53, 0.001);
        assertEquals("Konstruktori antaa vaaran hp arvon", 54,s.getHp());
        assertEquals("Konstruktori antaa vaaran maxHp arvon", 55, s.getMaxHp());
        assertEquals("Konstruktori antaa vaaran width arvon",56,s.getSize().getWidth(),0.001);
        assertEquals("Konstruktori antaa vaaran height arvon", 57,s.getSize().getHeight(),0.001);
    }

    @Test
    public void testChangeHpToimiiPositiivisellaMuutoksella() {
        Ship s = new TestedShip(50, 50, 50, 50, 50, 101, 56, 57,0);
        s.changeHp(50);
        assertEquals("Hp arvo pitaisi olla 100 mutta olikin" + s.getHp() +" , kun lisättiin 50hp arvoon 50", 100, s.getHp());
        s.changeHp(50);
        assertEquals("Hp arvo pitaisi olla 101 mutta olikin " + s.getHp() +" , kun lisättiin 100hp arvoon 50", 101, s.getHp());
    }

    @Test
    public void testChangeHpToimiiNegatiivisellaMuutoksella() {
        Ship s = new TestedShip(50, 50, 50, 50, 50, 101, 56, 57,0);
        s.changeHp(-49);
        assertEquals("Hp arvo pitaisi olla 1 mutta olikin" + s.getHp(), 1, s.getHp());
        assertTrue("Alive pitaisi olla true mutta olikin false , kun lisättiin 50hp arvoon -49", s.isAlive());
        s.changeHp(-1);
        assertEquals("Hp arvo pitaisi olla 0 mutta olikin" + s.getHp(), 0, s.getHp());
        assertFalse("Alive pitaisi olla false mutta olikin true , kun lisättiin 1hp arvoon -1", s.isAlive());

        s.changeHp(-50);
        assertEquals("Hp arvo pitaisi olla -50 mutta olikin" + s.getHp(), -50, s.getHp());
        assertFalse("Alive pitaisi olla false mutta olikin true , kun lisättiin 0hp arvoon -50", s.isAlive());
    }
}