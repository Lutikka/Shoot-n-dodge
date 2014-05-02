/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 * Tuhottavissa oleva pelin kappale
 * @author Lutikka
 */
public interface Destroyable {
    
    /**
     * Kutsutaan kun kappale poistetaan
     */
    public void destroyed();
    /**
     *
     * @return alive
     */
    public boolean isAlive();
    
    /**
     * kutsutaan kun kappale tuhoutuu
     */
    public void destroy();
}
