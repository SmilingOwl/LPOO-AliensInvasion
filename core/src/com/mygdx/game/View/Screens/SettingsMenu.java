package com.mygdx.game.View.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.AliensGame;

public class SettingsMenu extends Screens {

    public SettingsMenu(final AliensGame game) {
        super(game, "SettingsTitle.png");
    }

    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;
    protected static final float BOTTOM_EDGE = VIEWPORT_WIDTH / 75;
    protected TextButton back = addBackBtn();
}
