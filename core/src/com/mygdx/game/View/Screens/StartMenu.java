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


public class StartMenu extends Screens {

    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BOTTOM_EDGE = VIEWPORT_WIDTH / 75;
    private Music music;


    public StartMenu (final AliensGame game) {
        super(game,"Aliens_title.png");
        soundOn=true;
        music = game.getAssetManager().get("Game_Background.wav", Music.class);
        music.setLooping(true);
        music.play();

   }
   //buttons

    TextButton exitButton=createTextButton("Exit");
    TextButton playButton=createTextButton("Play");
    TextButton scoreButton=createTextButton("Score");
    TextButton optionButton=createTextButton("Settings");

    protected void addOptionsButton(Table table) {

        optionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SettingsMenu(game));
            }
        });
        table.add(optionButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void addScoreButton(Table table) {

        scoreButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ScoreMenu(game));
            }
        });
        table.add(scoreButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void addExitButton(Table table) {
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        table.add(exitButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void addPlayButton(Table table) {

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameView(game));
            }
        });
        table.add(playButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void createMenuButtons(Table table) {
        table.bottom();

        addPlayButton(table);
        addOptionsButton(table);
        addScoreButton(table);
        addExitButton(table);

        table.padBottom(BOTTOM_EDGE);
    }


    @Override
    public void show() {
        super.show();

        Table table = new Table();
        table.setFillParent(true);

        createMenuButtons(table);

        stage.addActor(table);
    }


}