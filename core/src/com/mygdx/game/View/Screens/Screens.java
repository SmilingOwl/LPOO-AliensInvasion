package com.mygdx.game.View.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.AliensGame;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Classe abstrata que representa todos os menus
 */
public abstract class Screens extends ScreenAdapter{

    protected AliensGame game;
    protected Stage stage;
    private Viewport viewport;
    private SpriteBatch spriteBatch;
    private Image background;
    private Image title;
    protected Skin skin;
    protected static float VIEWPORT_WIDTH = 650;
    private static final float VIEWPORT_HEIGHT = VIEWPORT_WIDTH * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
    protected static final float BUTTON_SIZE = VIEWPORT_WIDTH / 15;

/**
 * Constructor
 */
protected Screens (final AliensGame game)
{
    this.game=game;
    spriteBatch=game.getBatch();

    viewport=new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    viewport.apply();

    stage = new Stage(viewport, spriteBatch);
    title = new Image(game.getAssetManager().get("Aliens_title.png", Texture.class));
    title.setSize(0.8f * title.getWidth(), 0.8f * title.getHeight());
    title.setPosition(VIEWPORT_WIDTH / 2 - title.getWidth() / 2, VIEWPORT_HEIGHT * 0.9f - title.getHeight());

    background = new Image(game.getAssetManager().get("Level1.png", Texture.class));
    background.setScale(VIEWPORT_WIDTH / background.getWidth(), VIEWPORT_HEIGHT / background.getHeight());

}

    @Override
    public void show() {
        //Displaying the background and the Image
        stage.addActor(background);
        stage.addActor(title);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}

