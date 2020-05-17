package com.yhr.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.yhr.game.Constants;

public class Paddle {

    private Vector3 position;

    private Texture paddle;

    private Rectangle paddleBounds;

    public Paddle(int x, int y){
        position = new Vector3(x, y, 0);
        paddle = new Texture("paddle.png");

        paddleBounds = new Rectangle(position.x, position.y, paddle.getWidth(), paddle.getHeight());
    }

    public void move(float x){
        position.x += x;

        if (position.x < 0){
            position.x = 0;
        }
        if (position.x + 92 > Constants.WIDTH / 2f){
            position.x = (Constants.WIDTH / 2f) - 92;
        }

        paddleBounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPaddle() {
        return paddle;
    }

    public boolean collides(Rectangle player){
        return player.overlaps(paddleBounds);
    }

    public void dispose(){
        paddle.dispose();
    }
}
