package com.yhr.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yhr.game.states.GameStateManager;
import com.yhr.game.states.LoadState;

public class PingPong extends ApplicationAdapter {

	private GameStateManager gsm;
	private SpriteBatch batch;
	private BitmapFont font;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		font = new BitmapFont();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new LoadState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
