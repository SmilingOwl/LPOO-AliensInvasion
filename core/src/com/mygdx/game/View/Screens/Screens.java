package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.AliensGame;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Classe abstrata que representa todos os menus
 */
public abstract class Screens extends ScreenAdapter {

    /**
     * the current game session
     */
    protected AliensGame game;

    /**
     *The Stage where the menu elements will be organized.
     */
    protected Stage stage;

    /**
     *The viewport associated to the Menu's stage.
     */
    private Viewport viewport;

    /**
     *The SpriteBatch used in the Menu's screen.
     */
    private SpriteBatch spriteBatch;

    /**
     * background image
     */
    private Image background;

    /**
     * menu title
     */
    private Image title;

    /**
     *
     */
    protected boolean soundOn;


    /**
     * The width of the viewport in pixels
     */
    protected static float VIEWPORT_WIDTH = 550;

    /**
     * The height of the viewport in meters, the height is
     * automatically calculated using the screen ratio.
     */
    private static final float VIEWPORT_HEIGHT = VIEWPORT_WIDTH * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());

    /**
     * Default's Button Side Size
     */
    protected static final float DEFAULT_BUTTON_SIZE = VIEWPORT_WIDTH / 20;

    /**
     * represents the button edge
     */
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 155;

    /**
     * represents the button width
     */
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;

    /**
     * Screens constructor
     * @param game The current game session
     * @param string menu´s title
     */
    protected Screens(final AliensGame game, String string) {

        this.game = game;
        spriteBatch = game.getBatch();

        viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        viewport.apply();

        stage = new Stage(viewport, spriteBatch);
        title = new Image(game.getAssetManager().get(string, Texture.class));
        title.setSize(0.8f * title.getWidth(), 0.8f * title.getHeight());
        title.setPosition(VIEWPORT_WIDTH / 2 - title.getWidth() / 2, VIEWPORT_HEIGHT * 0.9f - title.getHeight());

        background = new Image(game.getAssetManager().get("Level1.png", Texture.class));
        background.setScale(VIEWPORT_WIDTH / background.getWidth(), VIEWPORT_HEIGHT / background.getHeight());

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        stage.addActor(background);
        stage.addActor(title);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        Gdx.input.setInputProcessor(stage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    /**
     * Creates the text buttons
     * @param text for the text button
     * @return text button
     */
    public TextButton createTextButton(String text) {
        Texture buttonTexture = game.getAssetManager().get("button.png");
        TextureRegion[][] arrayTextures = TextureRegion.split(buttonTexture, buttonTexture.getWidth() / 3, buttonTexture.getHeight());
        TextureRegionDrawable playBtnUp = new TextureRegionDrawable(arrayTextures[0][0]);
        TextureRegionDrawable playBtnPress = new TextureRegionDrawable(arrayTextures[0][1]);
        TextureRegionDrawable playBtnChecked = new TextureRegionDrawable(arrayTextures[0][2]);
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2, 2);
        TextButton.TextButtonStyle button = new TextButton.TextButtonStyle(playBtnUp, playBtnPress, playBtnChecked, font);
        return new TextButton(text, button);
    }


}

