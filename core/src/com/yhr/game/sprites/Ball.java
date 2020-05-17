package com.yhr.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.yhr.game.Constants;

public class Ball {

    private static final float SPEED_INCREMENT = 0.2f;
    private Vector3 position;
    private Vector3 velocity;

    private Texture ball;

    private Rectangle ballBounds;

    public Ball(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(Constants.WIDTH / 5f, Constants.HEIGHT / 5f, 0);
        ball = new Texture("ball.png");

        ballBounds = new Rectangle(position.x, position.y, ball.getWidth(), ball.getHeight());
    }

    public void update(float dt){
        position.x += velocity.x * dt;
        position.y += velocity.y * dt;

        if (position.x > Constants.WIDTH / 2f){
            velocity.x = -velocity.x;
        }
        else if (position.x < 0){
            velocity.x = -velocity.x;
        }
        ballBounds.setPosition(position.x, position.y);
    }

    public void updateVelocity(float dt) {
        if (velocity.x < 0) {
            velocity.x = velocity.x - SPEED_INCREMENT;
        } else if (velocity.x > 0) {
            velocity.x = velocity.x + SPEED_INCREMENT;
        }
        if (velocity.y < 0) {
            velocity.y = velocity.y - SPEED_INCREMENT;
        } else if (velocity.y > 0) {
            velocity.y = velocity.y + SPEED_INCREMENT;
        }
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public Texture getBall() {
        return ball;
    }

    public Rectangle getBallBounds(){
        return ballBounds;
    }

    public void dispose(){
        ball.dispose();
    }

}
