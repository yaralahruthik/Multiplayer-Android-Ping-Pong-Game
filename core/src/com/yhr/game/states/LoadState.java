package com.yhr.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yhr.game.Constants;

public class LoadState extends State {

    private Texture background;

    public LoadState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, Constants.WIDTH / 2f, Constants.HEIGHT /2f);
        background = new Texture("loadingScreenBackground.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()){
            gsm.set(new MenuState(gsm));
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
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
