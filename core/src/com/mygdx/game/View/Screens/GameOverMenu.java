package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.GameModel;

/**
 * Class used to represent the GameOver pop up Menu
 */
public class GameOverMenu extends Screens{

    TextButton ScoreButton = createTextButton("Highscore: "+Integer.toString(GameController.getInstance().getPrefs().getInteger("score",30)));
    TextButton AtualScore= createTextButton("Score: " + Integer.toString(GameController.getInstance().getScore()));
    TextButton HighScore= createTextButton("Highscore");
    TextButton YourScore= createTextButton("Your Score");
    TextButton exitButton=createTextButton("Exit");
    TextButton PlayAgain = createTextButton("Play Again ");
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 155;

    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    GameOverMenu(AliensGame game) {
        super(game,"GameOver.png");
    }
    protected void addMainScoreButton(Table table) {

        ScoreButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
            }
        });
        table.add(ScoreButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }
    protected void addAtualScoreButton(Table table) {

        AtualScore.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
            }
        });
        table.add(AtualScore).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
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
    protected void addHightScoreButton(Table table) {

        HighScore.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
            }
        });
        table.add(HighScore).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void addPlayAgainButton(Table table) {

        PlayAgain.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameModel.getInstance().resetInstance();
                GameController.getInstance().resetInstance();

                game.setScreen(new GameView(game));
            }
        });
        table.add(PlayAgain).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }
    @Override
    public void show() {
        super.show();
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        //addHightScoreButton(table);
        addMainScoreButton(table);
        addAtualScoreButton(table);
        addPlayAgainButton(table);
        addExitButton(table);

        stage.addActor(table);
    }
}