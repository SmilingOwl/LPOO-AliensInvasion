package com.mygdx.game.View.Screens;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AliensGame;

/**
 * Class used to represent the GameOver pop up Menu
 */
public class GameOverMenu extends OptionsMenu {


    GameOverMenu(Viewport viewport, AliensGame game, HudMenu hud) {
        super(viewport, game, hud,"GameOverTitle.png");
    }


    @Override
    protected void confStage() {
        initStage();
        addRestartBtn();
        finishStage();
    }

    @Override
    protected void setMessage() {
        message.setText("GAME OVER");
    }
}