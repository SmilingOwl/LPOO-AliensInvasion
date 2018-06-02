package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.GameModel;

/**
 * Class used to represent the pop up Paused Menu
 */
public class PauseMenu extends Screens {

    /**
     * PauseMenu constructor
     *
     * @param game the current Game session
     */
    PauseMenu(AliensGame game) {
        super(game,"Paused.png");
    }

    /**
     * main menu text button
     */
    TextButton menuButton=createTextButton("Main Menu");

    /**
     * play menu text button
     */
    TextButton playButton=createTextButton("Resume");

    /**
     * play exit text button
     */
    TextButton exitButton=createTextButton("Exit");


    /**
     * Add main menu button
     * @param table  where the buttons will be organized
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
     * Add exit button
     * @param table  where the buttons will be organized
     */
    protected void addExitButton(Table table) {

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartMenu(game));
            }
        });
        table.add(exitButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Add the play button
     *
     * @param table where the buttons will be organized
     */
    protected void addPlayButton(Table table) {

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameModel.getInstance().getHero().setPaused(false);
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

        addPlayButton(table);
        addMainMenuButton(table);
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
        table.center();
        createMenuButtons(table);

        stage.addActor(table);
    }

}