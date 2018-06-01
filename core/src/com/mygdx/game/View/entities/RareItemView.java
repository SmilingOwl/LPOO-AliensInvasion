package com.mygdx.game.View.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * A class used to represent the rare item entity view.
 */
public class RareItemView extends EntityView {

    /**
     * Time between frames
     */
    private static final float FRAME_TIME = 0.05f;

    /**
     * represents the portal animation
     */
    private Animation<TextureRegion> Animation;

    /**
     * represents the texture region to create the animation
     */
    private TextureRegion spriteToanimation;

    /**
     * for actualizing the state time
     */
    private float stateTime = 0;


    /**
     * Constructs a rare item view.
     *
     * @param game the game this view belongs to
     */
    public RareItemView(AliensGame game) {
        super(game);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {
        Animation = createAnimation(game);
        spriteToanimation = createTextureAnimation(game);
        return new Sprite(spriteToanimation);
    }

    /**
     * Creates the rare itm animation
     * @param game this view belongs to
     * @return animation
     */
    private Animation<TextureRegion> createAnimation(AliensGame game) {
        Texture thrustTexture = game.getAssetManager().get("RareItem.png");
        TextureRegion[][] thrustRegion = TextureRegion.split(thrustTexture, thrustTexture.getWidth() / 5, thrustTexture.getHeight() / 12);

        TextureRegion[] frames = new TextureRegion[60];

        System.arraycopy(thrustRegion[0], 0, frames, 0, 5);
        System.arraycopy(thrustRegion[1], 0, frames, 5, 5);
        System.arraycopy(thrustRegion[2], 0, frames, 10, 5);
        System.arraycopy(thrustRegion[3], 0, frames, 15, 5);
        System.arraycopy(thrustRegion[4], 0, frames, 20, 5);
        System.arraycopy(thrustRegion[5], 0, frames, 25, 5);
        System.arraycopy(thrustRegion[6], 0, frames, 30, 5);
        System.arraycopy(thrustRegion[7], 0, frames, 35, 5);
        System.arraycopy(thrustRegion[8], 0, frames, 40, 5);
        System.arraycopy(thrustRegion[9], 0, frames, 45, 5);
        System.arraycopy(thrustRegion[10], 0, frames, 50, 5);
        System.arraycopy(thrustRegion[11], 0, frames, 55, 5);
        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }

    /**
     * Create the texture region
     * @param game the game this view belongs to
     * @return texture
     */
    private TextureRegion createTextureAnimation(AliensGame game) {

        Texture d = game.getAssetManager().get("output-0.png");
        return new TextureRegion(d, d.getWidth(), d.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        sprite.setScale(0.4f, 0.4f);

        sprite.setRegion(Animation.getKeyFrame(stateTime, true));
        sprite.draw(batch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

}
