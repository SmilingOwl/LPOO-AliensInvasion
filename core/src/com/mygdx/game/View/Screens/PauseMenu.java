package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Model.GameModel;

/**
 * Class used to represent the pop up Paused Menu
 */
public class PauseMenu extends Screens {
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BOTTOM_EDGE = VIEWPORT_WIDTH / 75;
    PauseMenu(AliensGame game) {
        super(game,"Paused.png");
    }
    TextButton exitButton=createTextButton("Exit");
    TextButton playButton=createTextButton("Resume");






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
                GameModel.getInstance().getHero().setPaused(false);
                game.setScreen(new GameView(game));

            }
        });
        table.add(playButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void createMenuButtons(Table table) {
        table.bottom();

        addPlayButton(table);

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