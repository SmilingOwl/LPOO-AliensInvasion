package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * A class used to represent the blocks platform entity view.
 */
public class PlatfBlocksView extends EntityView {

    /**
     * Constructs an blocks platform view.
     *
     * @param game the game this view belongs to
     */
    public PlatfBlocksView(AliensGame game) {

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
        Texture t = game.getAssetManager().get("platfmuro1.png");
        return new Sprite(t, t.getWidth(), t.getHeight());
    }
}
