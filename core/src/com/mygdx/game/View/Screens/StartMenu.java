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
import com.mygdx.game.View.GameView;


public class StartMenu extends Screens {

    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BOTTOM_EDGE = VIEWPORT_WIDTH / 75;
    private Music music;


    public StartMenu (final AliensGame game) {
        super(game);
        music = game.getAssetManager().get("Game_Background.wav", Music.class);
        music.setLooping(true);
        music.play();

   }
   //buttons
    TextButton exitButton=createTextButton("Exit");
    TextButton playButton=createTextButton("Play");
    TextButton scoreButton=createTextButton("Settings");
    TextButton optionButton=createTextButton("Score");

    protected void addOptionsButton(Table table) {

        optionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new SettingsMenu(game));
            }
        });
        table.add(optionButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }
    protected void addScoreButton(Table table) {

        scoreButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new ScoreMenu(game));
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

    private TextButton createTextButton(String text)
    {
       Texture buttonTexture =game.getAssetManager().get("button.png");
       TextureRegion[][] arrayTextures=TextureRegion.split(buttonTexture, buttonTexture.getWidth()/3,buttonTexture.getHeight());
       TextureRegionDrawable playBtnUp=new TextureRegionDrawable(arrayTextures[0][0]);
       TextureRegionDrawable playBtnPress=new TextureRegionDrawable(arrayTextures[0][1]);
       TextureRegionDrawable playBtnChecked=new TextureRegionDrawable(arrayTextures[0][2]);
       BitmapFont font =new BitmapFont();
       font.getData().setScale(2,2);
       TextButton.TextButtonStyle button=new TextButton.TextButtonStyle(playBtnUp,playBtnPress,playBtnChecked,font);
       return new TextButton(text,button);
    }
}