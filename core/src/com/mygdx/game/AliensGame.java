package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Gui.StartMenu;

public class AliensGame implements ApplicationListener {

	public static final String TITLE="Aliens Invasion";
	public static final int V_WIDTH=320;
	public static final int V_HEIGHT=240;
	public static final int SCALE=2;


	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		img = new Texture("2D_Village.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resize(int width, int height) {

	}
}
