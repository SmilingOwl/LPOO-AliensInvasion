package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.GameModel;

/**
 * Class used to represent the GameOver pop up Menu
 */
public class GameOverMenu extends Screens {

    /**
     * HighScore textButton
     */
    TextButton HighScoreButton = createTextButton("HighScore: " + Integer.toString(GameController.getInstance().getPrefs().getInteger("score", 30)));

    /**
     * CurrentScore textButton
     */
    TextButton CurrentScore = createTextButton("Score: " + Integer.toString(GameController.getInstance().getScore()));

    /**
     * Main menu textButton
     */
    TextButton menuButton = createTextButton("Main Menu");

    /**
     * PlayAgain textButton
     */
    TextButton PlayAgain = createTextButton("Play Again");

    /**
     * Game over constructor
     *
     * @param game the current Game session
     */
    GameOverMenu(AliensGame game) {
        super(game, "GameOver.png");
    }

    /**
     * Adds more buttons to the table
     *
     * @param table where the buttons will be organized
     */
    protected void addMoreButton(Table table) {

        table.add(HighScoreButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
        table.add(CurrentScore).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Add the main menu button
     *
     * @param table where the buttons will be organized
     */
    protected void addMainMenuButton(Table table) {

        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               GameModel.getInstance().resetInstance();
               GameController.getInstance().resetInstance();
                game.setScreen(new StartMenu(game));
            }
        });
        table.add(menuButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Add the play again button
     *
     * @param table where the buttons will be organized
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        super.show();
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        addMoreButton(table);
        addPlayAgainButton(table);
        addMainMenuButton(table);

        stage.addActor(table);
    }
}