package com.yhr.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yhr.game.Constants;

public class MenuState extends State {

    private Texture background;

    private Texture playAIButton;
    private Texture playTwoButton;

    public MenuState(GameStateManager gsm){
        super(gsm);
        cam.setToOrtho(false, Constants.WIDTH / 2f, Constants.HEIGHT /2f);
        background = new Texture("sampleTestBack.png");
        playAIButton = new Texture("playAIButtonInactive.png");
        playTwoButton = new Texture("twoPlayerButtonInactive.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayStateOffMul(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, Constants.WIDTH / 2f, Constants.HEIGHT / 2f);
        if (Gdx.input.getX() < Constants.WIDTH / 4f - 45 && Gdx.input.getX() > Constants.WIDTH / 4f )
        //sb.draw(playAIButton, Constants.WIDTH / 4f - 45, Constants.HEIGHT / 4f - 50, Constants.WIDTH / 5f, Constants.HEIGHT / 12f);
        //sb.draw(playTwoButton, Constants.WIDTH / 4f - 45, Constants.HEIGHT / 4f - 150, Constants.WIDTH / 5f, Constants.HEIGHT / 12f);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
