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
    public SpeedVector(Position from, Position at,float speed){
        float deltaX = at.getX()-from.getX();
        float deltaY = at.getY()-from.getY();
        double hyp = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        speedX=(float)(deltaX/hyp)*speed;
        speedY=(float)(deltaY/hyp)*speed;
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
