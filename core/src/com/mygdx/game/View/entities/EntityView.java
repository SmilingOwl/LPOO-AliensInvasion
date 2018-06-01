package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

import static com.mygdx.game.View.Screens.GameView.PIXEL_TO_METER;

/**
 * An abstract view capable of holding a sprite with a certain position.
 * This view is able to update its data based on a entity model.
 */
public abstract class EntityView {

    /**
     * The sprite representing this entity view.
     */
    Sprite sprite;

    /**
     * represents the sprite direction (left or right)
     */
    protected boolean direction;

    /**
     * Sets direction
     * @param di value to update
     */
    public void setDirection(boolean di) {
        this.direction = di;
    }

    /**
     * Creates a view belonging to a game.
     * @param game the game this view belongs to
     */
    EntityView(AliensGame game) {
        sprite = createSprite(game);
    }

    /**
     * Draws the sprite from this view using a sprite batch
     * @param batch to be used for drawing
     */
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    /**
     *Abstract method that creates the view sprite
     * @param game the game this view belongs to
     * @return the sprite representing this view
     */
    public abstract Sprite createSprite(AliensGame game);

    /**
     * Updates this view based on a certain model
     *
     * @param model the model used to update this view
     */
    public void update(EntityModel model) {

        sprite.setCenter(model.getX() / PIXEL_TO_METER, model.getY() / PIXEL_TO_METER);

    }


}
