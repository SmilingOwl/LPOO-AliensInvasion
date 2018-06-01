package com.mygdx.game.View.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AliensGame;
import com.mygdx.game.View.Screens.GameView;

/**
 * Class used to represent the pop up Start Menu
 */
public class StartMenu extends Screens {

    /**
     *  represents the button edge
     */
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;

    /**
     * game´s music
     */
    private Music music;

    /**
     * start menu constructor
     *
     * @param game the current Game session
     */
    public StartMenu (final AliensGame game) {
        super(game,"Aliens_title.png");
        soundOn=true;
        music = game.getAssetManager().get("Game_Background.wav", Music.class);
        music.setLooping(true);
        music.play();
   }

    /**
     * exit text button
     */
    TextButton exitButton=createTextButton("Exit");

    /**
     * play text button
     */
    TextButton playButton=createTextButton("Play");

    /**
     * score text button
     */
    TextButton scoreButton=createTextButton("Score");

    /**
     * Add a score button
     * @param table where the buttons will be organized
     */
    protected void addScoreButton(Table table) {

        scoreButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ScoreMenu(game));
            }
        });
        table.add(scoreButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Add a exit button
     * @param table where the buttons will be organized
     */
    protected void addExitButton(Table table) {
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        table.add(exitButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Add a play button
     * @param table where the buttons will be organized
     */
    protected void addPlayButton(Table table) {

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameView(game));
            }
        });
        table.add(playButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Create this menu buttons
     * @param table where the buttons will be organized
     */
    protected void createMenuButtons(Table table) {

        table.center();
        addPlayButton(table);
        addScoreButton(table);
        addExitButton(table);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        super.show();

        Table table = new Table();
        table.setFillParent(true);

        createMenuButtons(table);

        stage.addActor(table);
    }

}