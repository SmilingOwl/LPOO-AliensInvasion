package com.mygdx.game.View.Screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;


/**
 * Class used to represent the pop up Victory Menu
 */
public class VictoryMenu extends Screens {


    TextButton menuButton=createTextButton("Main Menu");
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 65;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;


    VictoryMenu(AliensGame game) {
        super(game, "Victory.png");
    }

    protected void addMainMenuButton(Table table) {

        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartMenu(game));
            }
        });
        table.add(menuButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();
        table.setFillParent(true);

        addMainMenuButton(table);

        stage.addActor(table);
    }


}

