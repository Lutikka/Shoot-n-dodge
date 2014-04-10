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
            
    /**
     * Käytetään kun tiedetään vektorin x ja y komponentit.
     * @param speedX
     * @param speedY
     */
    public SpeedVector(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;

    }
    
    /**
     * Käytetään kun halutaan vektori pisteestä from pisteeseen at pituudella speed.
     * @param from
     * @param at
     * @param speed
     */
    public SpeedVector(Position from, Position at,float speed){
        float deltaX = at.getX()-from.getX();
        float deltaY = at.getY()-from.getY();
        double hyp = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        speedX=(float)(deltaX/hyp)*speed;
        speedY=(float)(deltaY/hyp)*speed;
    }

    /**
     *
     * @return
     */
    public float getSpeedX() {
        return speedX;
    }

    /**
     *
     * @return
     */
    public float getSpeedY() {
        return speedY;
    }

    /**
     *
     * @param speedX
     */
    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    /**
     *
     * @param speedY
     */
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
