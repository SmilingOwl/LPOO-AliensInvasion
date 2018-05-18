package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AliensGame;


/**
 * Abstract class used to represent all the Pop Up Menu's classes, containing several option actions.
 */
abstract class OptionsMenu extends Stage {

    protected AliensGame game;
    private HudMenu hud;
    private Table table;
    protected Label message;
    private Image background;
    private Image title;


    private static final float HUD_VIEWPORT_WIDTH = 1000;
    private static final float HUD_VIEWPORT_HEIGHT = HUD_VIEWPORT_WIDTH * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());

    private static final float MESSAGE_FONT_SCALE = HUD_VIEWPORT_WIDTH / 400;

    private static final float SCORE_FONT_SCALE = HUD_VIEWPORT_WIDTH / 600;

    private static final float LABEL_DISTANCE = HUD_VIEWPORT_HEIGHT / 40;

    private static final float BUTTON_WIDTH = HUD_VIEWPORT_WIDTH / 3;
    private static final float BUTTON_HEIGHT = HUD_VIEWPORT_HEIGHT / 8;
    private static final float BUTTON_DISTANCE = HUD_VIEWPORT_HEIGHT / 18;

    /**
     * Options Menu Constructor.
     * It initializes all the needed elements.
     */
    protected OptionsMenu(Viewport viewport, AliensGame game, HudMenu hud, String string) {
        super(viewport, game.getBatch());

        Gdx.input.setInputProcessor(this);

        this.game = game;
        this.hud = hud;

        table = new Table();


        title = new Image(game.getAssetManager().get(string, Texture.class));
        title.setSize(0.8f * title.getWidth(), 0.8f * title.getHeight());
        title.setPosition(HUD_VIEWPORT_WIDTH / 2 - title.getWidth() / 2, HUD_VIEWPORT_HEIGHT * 0.9f - title.getHeight());
        background = new Image(game.getAssetManager().get("Level1.png", Texture.class));
        background.setScale(HUD_VIEWPORT_WIDTH / background.getWidth(), HUD_VIEWPORT_HEIGHT / background.getHeight());

        confStage();
    }

    /**
     * Function used to draw the Pop Up Menu in the screen.
     */
    @Override
    public void draw() {
        super.draw();
        this.act();
    }



   //BUTTONS
    TextButton restartBtn = createTextButton("Restart");
    TextButton resumeBtn = createTextButton("Resume");
    TextButton exitBtn = createTextButton("Exit");

    protected void addExitBtn() {


        exitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartMenu(game));
            }
        });

        table.add(exitBtn).size(BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    protected void addRestartBtn() {


        restartBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                startLevel();
            }
        });

        table.add(restartBtn).size(BUTTON_WIDTH, BUTTON_HEIGHT).padBottom(BUTTON_DISTANCE).row();
    }

    protected void addResumeBtn() {


        resumeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseController();
            }
        });

        table.add(resumeBtn).size(BUTTON_WIDTH, BUTTON_HEIGHT).padBottom(BUTTON_DISTANCE).row();
    }

    private void PauseController() {
        hud.PauseController();
    }

    private void startLevel() {
        hud.startLevel();
    }

    /**
     * Function used by all the Pop Up Menus for starting the initial procedures of the stage configuration.
     */
    protected void initStage() {
        table.setFillParent(true);

        table.add(message).padBottom(LABEL_DISTANCE).row();
        message.setFontScale(MESSAGE_FONT_SCALE, MESSAGE_FONT_SCALE);

       /* Label score = new Label(hud.getScoreString(), skin);
        table.add(score).padBottom(LABEL_DISTANCE).row();
        score.setFontScale(SCORE_FONT_SCALE, SCORE_FONT_SCALE);*/
    }


    protected void finishStage() {
        addExitBtn();

        setMessage();
        this.addActor(table);
    }

    protected abstract void confStage();

    protected abstract void setMessage();

    /**
     * Create text buttons
     *
     */
    public TextButton createTextButton(String text)
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