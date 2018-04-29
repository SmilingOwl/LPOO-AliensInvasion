package com.mygdx.game.Model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

/**
 * main class for logic
 */
public class GameModel implements Disposable {

    private Vector2 gravity = new Vector2(0, -9.81f);

    public enum ModelState {
        WON,LOST, PAUSED, LIVE,
    }

    @Override
    public void dispose() {

    }
}
