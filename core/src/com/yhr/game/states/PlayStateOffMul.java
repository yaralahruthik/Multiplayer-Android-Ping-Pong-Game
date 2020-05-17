package com.yhr.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.yhr.game.Constants;
import com.yhr.game.sprites.Ball;
import com.yhr.game.sprites.Paddle;

public class PlayStateOffMul extends State {

    private Paddle playerPaddle;
    private Paddle opponentPaddle;
    private Ball ball;
    private Texture bg;
    private BitmapFont font;

    public int playerScore = 0;
    public int opponentScore = 0;

    public PlayStateOffMul(GameStateManager gsm) {
        super(gsm);
        ball = new Ball(50, 50);
        playerPaddle = new Paddle(0, 20);
        opponentPaddle = new Paddle(0, (Constants.HEIGHT / 2) - 20);
        font = new BitmapFont();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Alien-Encounters-Regular.ttf"));
        final FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        font = generator.generateFont(parameter);
        generator.dispose();
        cam.setToOrtho(false, Constants.WIDTH / 2f, Constants.HEIGHT /2f);
        bg = new Texture("gameBG.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() < Constants.WIDTH / 2f && (Gdx.input.getY() > 200 && Gdx.input.getY() > (Constants.HEIGHT / 2) - 200)) {
                playerPaddle.move(-10);
            }
            if (Gdx.input.getX() > Constants.WIDTH / 2f && (Gdx.input.getY() > 200 && Gdx.input.getY() > (Constants.HEIGHT / 2) - 200)) {
                playerPaddle.move(10);
            }
            if (Gdx.input.getX() < Constants.WIDTH / 2f && (Gdx.input.getY() < (Constants.HEIGHT / 2) - 200)) {
                opponentPaddle.move(-10);
            }
            if (Gdx.input.getX() > Constants.WIDTH / 2f && (Gdx.input.getY() < (Constants.HEIGHT / 2) - 200)) {
                opponentPaddle.move(10);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if (playerPaddle.collides(ball.getBallBounds())){
            ball.getVelocity().y = -ball.getVelocity().y;
        }
        if (opponentPaddle.collides(ball.getBallBounds())){
            ball.getVelocity().y = -ball.getVelocity().y;
        }
        if (ball.getPosition().y > Constants.HEIGHT / 2f){
            ball.getPosition().x = Constants.WIDTH / 4f;
            ball.getPosition().y = Constants.HEIGHT / 4f;
            ball.getVelocity().x = Constants.WIDTH / 5f;
            ball.getVelocity().y = Constants.WIDTH / 5f;
            playerScore = playerScore + 1;
        }
        if (ball.getPosition().y < 0){
            ball.getPosition().x = Constants.WIDTH / 4f;
            ball.getPosition().y = Constants.HEIGHT / 4f;
            ball.getVelocity().x = Constants.WIDTH / 5f;
            ball.getVelocity().y = Constants.WIDTH / 5f;
            opponentScore = opponentScore + 1;
        }
        ball.update(dt);
        ball.updateVelocity(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, -5, 0, 10 + Constants.WIDTH / 2f, Constants.HEIGHT / 2f);
        font.draw(sb, "Score " + playerScore + ":" + opponentScore,20, (Constants.HEIGHT / 2f) - 50);
        sb.draw(ball.getBall(), ball.getPosition().x, ball.getPosition().y);
        sb.draw(playerPaddle.getPaddle(), playerPaddle.getPosition().x, playerPaddle.getPosition().y);
        sb.draw(opponentPaddle.getPaddle(), opponentPaddle.getPosition().x, opponentPaddle.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        ball.dispose();
        playerPaddle.dispose();
        opponentPaddle.dispose();
    }
}
