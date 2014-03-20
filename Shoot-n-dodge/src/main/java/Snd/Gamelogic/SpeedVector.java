/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snd.Gamelogic;

/**
 * Pelissä olevan kappaleen nopeusvektori. Objektit liikkuu tämän avulla
 * @author Lutikka
 */
public class SpeedVector {

    float speedX;
    float speedY;

    public SpeedVector(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;

    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
