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
 * A class used to represent the victory portal entity view.
 */
public class PortalView extends EntityView {

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
    private TextureRegion spriteToAnimation;

    /**
     * for actualizing the state time
     */
    private float stateTime = 0;


    /**
     * Constructs an victory portal view.
     *
     * @param game the game this view belongs to
     */
    public PortalView(AliensGame game) {
        super(game);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {
        Animation = createAnimation(game);
        spriteToAnimation= createTextureRegion(game);
        return new Sprite(spriteToAnimation);
    }

    /**
     * Creates the portal animation
     * @param game the game this view belongs to
     * @return animation
     */
    private Animation<TextureRegion> createAnimation(AliensGame game) {
        Texture thrustTexture = game.getAssetManager().get("Portal.png");
        TextureRegion[][] thrustRegion = TextureRegion.split(thrustTexture, thrustTexture.getWidth() / 5, thrustTexture.getHeight() / 2);

        TextureRegion[] frames = new TextureRegion[9];

        System.arraycopy(thrustRegion[0], 0, frames, 0, 5);
        System.arraycopy(thrustRegion[1], 0, frames, 5, 4);
        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }

    /**
     * Create the texture region
     * @param game the game this view belongs to
     * @return texture
     */
    private TextureRegion createTextureRegion(AliensGame game) {

        Texture d = game.getAssetManager().get("output7.png");
        return new TextureRegion(d, d.getWidth(), d.getHeight());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        sprite.setScale(3, 3);

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