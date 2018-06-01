package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.View.Screens.StartMenu;

/**
 * The game´s main class
 */
public class AliensGame extends Game{

	/**
	 * The Game's Sprite Batch.
	 */
	private SpriteBatch batch;

	/**
	 * The Game's Asset Manager.
	 */
	private AssetManager manager;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager=new AssetManager();
		loadAssets();
		startGame();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose () {
		batch.dispose();
		manager.dispose();
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resize(int width, int height) {
		super.resize(width,height);

	}

	/**
	 * Start game function
	 */
	private void startGame(){

		setScreen(new StartMenu(this));

	}

	/**
	 * Get asset manager
	 * @return the asset manager
	 */
	public AssetManager getAssetManager() {
		return manager;
	}

	/**
	 * Get the sprite batch
	 * @return the sprite batch
	 */
	public SpriteBatch getBatch() {
		return batch;
	}

	/**
	 * load all assets
	 */
	private void loadAssets() {
		manager.load("Aliens_title.png", Texture.class);
		manager.load("ScoreTitle.png",Texture.class);
		manager.load("SettingsTitle.png",Texture.class);
		manager.load("button.png",Texture.class);
		manager.load("Game_Background.wav",Music.class);
		manager.load("Level1.png", Texture.class);
		manager.load("sound.png",Texture.class);
		manager.load("Victory.png",Texture.class);
		manager.load("Paused.png",Texture.class);
		manager.load("GameOver.png",Texture.class);


		manager.finishLoading();
	}


}
