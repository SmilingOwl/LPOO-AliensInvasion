package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * A class used to represent the spikes platform entity view.
 */
public class PlatfSpikesView extends EntityView {

    /**
     * Constructs an spikes platform view.
     *
     * @param game the game this view belongs to
     */
    public PlatfSpikesView(AliensGame game) {
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
        super.draw(batch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("platfpicos.png");
        return new Sprite(t, t.getWidth(), t.getHeight());
    }
}