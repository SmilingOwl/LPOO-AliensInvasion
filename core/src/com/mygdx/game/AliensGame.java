package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.View.Screens.StartMenu;

/**
 * Main class
 */
public class AliensGame extends Game{

	private SpriteBatch batch;
	private AssetManager manager;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manager=new AssetManager();
		loadAssets();
		startGame();
	}

	@Override
	public void dispose () {
		batch.dispose();
		manager.dispose();
		super.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width,height);

	}
	private void startGame(){

		setScreen(new StartMenu(this));
	}
	public AssetManager getAssetManager() {
		return manager;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	private void loadAssets() {
		manager.load("Aliens_title.png", Texture.class);
		manager.load("Level1.png", Texture.class);
		manager.load("pause.png", Texture.class);

		manager.finishLoading();
	}


}
