package com.mygdx.game.Logic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Hero extends Sprite {

    protected enum State {Running, Jumping, Standing, ArmedArrow, ArmedGun, Dead, Restoring};

    private Animation runningAnimation;
    private Animation standingAnimation;
    private Animation jumpingAnimation;
    private Animation deadAnimation;
    private Animation armedAnimation;

}
