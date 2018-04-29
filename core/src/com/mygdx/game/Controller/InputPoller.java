package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Model.GameModel;

/**
 * para o acelarometro
 */
public class InputPoller {

    private GameModel model;


    private void pollAccelerometer(float delta) {
        float y = Gdx.input.getAccelerometerY();
        float z = Gdx.input.getAccelerometerZ();


    }
}
