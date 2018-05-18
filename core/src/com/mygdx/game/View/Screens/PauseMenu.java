package com.mygdx.game.View.Screens;

import com.mygdx.game.AliensGame;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Class used to represent the pop up Paused Menu
 */
public class PauseMenu extends OptionsMenu {

    PauseMenu(Viewport viewport, AliensGame game, HudMenu hud) {
        super(viewport, game, hud,"PausedTitle.png");
    }

    @Override
    protected void confStage() {
        initStage();
        addResumeBtn();
        addRestartBtn();
        finishStage();
    }

    @Override
    protected void setMessage() {
        message.setText("GAME PAUSED");
    }
}