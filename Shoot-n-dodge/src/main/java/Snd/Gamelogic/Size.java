/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 * Sisältää tiedon pelissä olevan kappaleen koosta
 * @author Lutikka
 */
public class Size {
    
    private float width;
    private float height;

    /**
     *
     * @param width
     * @param height
     */
    public Size(float width, float height) {
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public float getHeight() {
        return height;
    }

    /**
     *
     * @param width
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public float getWidth() {
        return width;
    }
    
    
    
}
