package com.mygdx.game.View.Screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;

/**
 * Class used to represent the pop up Score Menu
 */
public class ScoreMenu extends Screens {

    /**
     * first score text button
     */
    TextButton ScoreButton = createTextButton(Integer.toString(GameController.getInstance().getPrefs().getInteger("score", 30)));

    /**
     * second score text button
     */
    TextButton Score2Button = createTextButton(Integer.toString(GameController.getInstance().getPrefs().getInteger("score2", 30)));

    /**
     * third score text button
     */
    TextButton Score3Button = createTextButton(Integer.toString(GameController.getInstance().getPrefs().getInteger("score3", 30)));

    /**
     * back to main menu text button
     */
    TextButton BackToStartMenu = createTextButton("Main Menu");


    /**
     * ScoreMenu constructor
     *
     * @param game the current Game session
     */
    public ScoreMenu(final AliensGame game) {
        super(game, "ScoreTitle.png");

    }

    /**
     * Add the main menu button
     *
     * @param table where the buttons will be organized
     */
    protected void addStartMenuButton(Table table) {

        BackToStartMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartMenu(game));
            }
        });
        table.add(BackToStartMenu).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    /**
     * Add scores button
     *
     * @param table where the buttons will be organized
     */
    protected void addScoresButton(Table table) {

        table.add(ScoreButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
        table.add(Score2Button).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
        table.add(Score3Button).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
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
        addScoresButton(table);
        addStartMenuButton(table);
        stage.addActor(table);
    }

}