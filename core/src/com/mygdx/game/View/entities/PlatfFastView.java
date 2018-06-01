package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * A class used to represent the fast platform entity view.
 */
public class PlatfFastView extends EntityView {

    /**
     * Constructs an fast platform view.
     *
     * @param game the game this view belongs to
     */
    public PlatfFastView(AliensGame game) {
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
        //sprite.setScale(0.4f,0.4f);
        super.draw(batch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("platfrapida2.png");
        return new Sprite(t, t.getWidth(), t.getHeight());
    }
}
