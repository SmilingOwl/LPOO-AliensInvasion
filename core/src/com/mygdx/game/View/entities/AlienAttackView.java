package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * A class used to represent the Alien's attack entity view.
 */
public class AlienAttackView extends EntityView {

    /**
     * Constructs an alien attack view.
     *
     * @param game the game this view belongs to
     */
    public AlienAttackView(AliensGame game) {
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
        sprite.setScale(0.2f, 0.2f);
        super.draw(batch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("Fireball.png");
        return new Sprite(t, t.getWidth(), t.getHeight());
    }
}
