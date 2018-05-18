package com.mygdx.game.View.Screens;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AliensGame;


/**
 * Class used to represent the pop up Victory Menu
 */
public class VictoryMenu extends OptionsMenu {


    VictoryMenu(Viewport viewport, AliensGame game, HudMenu hud) {
        super(viewport, game, hud,"PausedTitle.png");
    }


    @Override
    protected void confStage() {
        initStage();
        addRestartBtn();
        finishStage();
    }


    @Override
    protected void setMessage() {
        message.setText("LEVEL FINISHED");
    }
}