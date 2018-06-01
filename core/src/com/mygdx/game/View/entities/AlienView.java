package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * A class used to represent the Alien's entity view.
 */
public class AlienView extends EntityView {

    /**
     * represents the left texture of alien
     */
    private TextureRegion left;

    /**
     * represents the right texture of alien
     */
    private TextureRegion right;

    /**
     * Constructs an alien view.
     *
     * @param game the game this view belongs to
     */
    public AlienView(AliensGame game) {
        super(game);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(SpriteBatch batch) {

        if (direction) {
            sprite.setRegion(right);
        } else {
            sprite.setRegion(left);
        }
        super.draw(batch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {

        left = createLeft(game);
        right = createRight(game);

        return new Sprite(left);
    }

    /**
     * Creates the left texture of the alien
     * @param game this view belongs to
     * @return the left aliens texture
     */
    private TextureRegion createLeft(AliensGame game) {
        Texture t = game.getAssetManager().get("aliens.png");
        return new TextureRegion(t, t.getWidth(), t.getHeight());
    }

    /**
     * Creates the right texture of the alien
     * @param game this view belongs to
     * @return the right aliens texture
     */
    private TextureRegion createRight(AliensGame game) {
        Texture t1 = game.getAssetManager().get("alien2.png");
        return new TextureRegion(t1, t1.getWidth(), t1.getHeight());
    }
}
