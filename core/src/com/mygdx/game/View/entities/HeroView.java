package com.mygdx.game.View.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.GameModel;


/**
 * A class used to represent the hero's entity view.
 */
public class HeroView extends EntityView {

    /**
     * represents the time between frames
     */
    private static final float FRAME_TIME = 0.05f;

    /**
     * represents the hero running animation
     */
    private Animation<TextureRegion> runningAnimation;

    /**
     * represents the hero running backwards animation
     */
    private Animation<TextureRegion> runningBackAnimation;

    /**
     * represents if hero is going back or not
     */
    private boolean back;

    /**
     * represents the hero stooped animation
     */
    private TextureRegion stoopingAnimation;

    /**
     * represents the hero jumping animation
     */
    private Animation<TextureRegion> jumpingAnimation;

    /**
     *
     */
    private float stateTime = 0;


    /**
     * Constructs an alien attack view.
     *
     * @param game the game this view belongs to
     */
    public HeroView(AliensGame game) {
        super(game);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {
        runningAnimation = createRunningAnimation(game);
        jumpingAnimation = createJumpingAnimation(game);
        runningBackAnimation = createRunningBackAnimation(game);
        stoopingAnimation = createStoopingAnimation(game);
        back = false;

        return new Sprite(stoopingAnimation);
    }

    /**
     * creates the hero´s running backwards animation
     *
     * @param game the game this view belongs to
     * @return animation
     */
    private Animation<TextureRegion> createRunningBackAnimation(AliensGame game) {
        Texture thrustTexture = game.getAssetManager().get("allHeroB.png");

        TextureRegion[][] thrustRegion = TextureRegion.split(thrustTexture, thrustTexture.getWidth() / 8, thrustTexture.getHeight());

        TextureRegion[] frames = new TextureRegion[8];
        System.arraycopy(thrustRegion[0], 0, frames, 0, 8);

        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }

    /**
     * creates the hero´s running animation
     *
     * @param game the game this view belongs to
     * @return animation
     */
    private Animation<TextureRegion> createRunningAnimation(AliensGame game) {
        Texture thrustTexture = game.getAssetManager().get("allHero.png");
        TextureRegion[][] thrustRegion = TextureRegion.split(thrustTexture, thrustTexture.getWidth() / 8, thrustTexture.getHeight());

        TextureRegion[] frames = new TextureRegion[8];
        System.arraycopy(thrustRegion[0], 0, frames, 0, 8);

        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }

    /**
     * creates the hero´s jumping animation
     *
     * @param game the game this view belongs to
     * @return animation
     */
    private Animation<TextureRegion> createJumpingAnimation(AliensGame game) {
        Texture thrustTexture = game.getAssetManager().get("allHero.png");
        TextureRegion[][] thrustRegion = TextureRegion.split(thrustTexture, thrustTexture.getWidth() / 8, thrustTexture.getHeight());

        TextureRegion[] frames = new TextureRegion[8];
        System.arraycopy(thrustRegion[0], 0, frames, 0, 8);

        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }

    /**
     * creates the hero´s stopped animation
     *
     * @param game the game this view belongs to
     * @return animation
     */
    private TextureRegion createStoopingAnimation(AliensGame game) {

        Texture d = game.getAssetManager().get("output7.png");
        return new TextureRegion(d, d.getWidth(), d.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        sprite.setScale(0.5f, 0.5f);
        back = GameModel.getInstance().getHero().getBack();

        if (GameModel.getInstance().getHero().getJumping()) {
            if (back)
                sprite.setRegion(runningBackAnimation.getKeyFrame(stateTime, false));
            else
                sprite.setRegion(runningAnimation.getKeyFrame(stateTime, false));
        } else if (back) {
            sprite.setRegion(runningBackAnimation.getKeyFrame(stateTime, true));
        } else {
            sprite.setRegion(runningAnimation.getKeyFrame(stateTime, true));
        }

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

