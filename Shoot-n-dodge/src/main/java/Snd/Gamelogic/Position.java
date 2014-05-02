/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;


/**
 * Pitää sisällään tiedon Objektin positiosta pelissä
 * @author Lutikka
 */
public class Position{
    /**
     * paikan x koordinaatti
     */
    private float x;
    /**
     * paikan y koordinaatti
     */
    private float y;
    /**
     * Nopeusvektori liikkumiseen
     */
    private SpeedVector speedVec;

    /**
     * Konstruktori
     * 
     * @param x X koordinaatti
     * @param y Y koordinaatti
     * @param speedVec NopeusVektori liikkumiseen
     */
    public Position(float x, float y, SpeedVector speedVec) {
        this.x = x;
        this.y = y;
        this.speedVec = speedVec;
    }
    
    /**
     * Konstruktori
     * @param x
     * @param y
     */
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
        this.speedVec = null;
    }

    /**
     * Päivittää position käyttäen SpeedVectoria, jos sellainen on lisätty
     */
    public void update() {
        if(speedVec!=null){
        setX(this.x + speedVec.getSpeedX());
        setY(this.y + speedVec.getSpeedY());
        }
    }

    /**
     *
     * @return
     */
    public float getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public float getY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setPos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return speedVec
     */
    public SpeedVector getSpeedVec() {
        return speedVec;
    }
    
}
