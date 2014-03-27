/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic.GameObjects;

import Snd.Gamelogic.ObjectHolder;

/**
 * Used for jUnit test
 * @author Lutikka
 */
public class TestedShip extends Ship{

    public TestedShip(float x, float y, float dx, float dy, int hp, int maxHp, float width, float height, ObjectHolder oh, int team){           
        super(x, y, dx, dy, hp, maxHp, width, height, oh, team);
    }
    
    
}
