package com.mygdx.game.Model.Entities;

/**
 * A model representing a consumable item
 */
public class ConsumableModel extends EntityModel {

    /**
     * Constructs a consumable model belonging to a game model.
     *
     * @param x the x-coordinate of this consumable
     * @param y the y-coordinate of this consumable
     */
    public ConsumableModel(float x, float y) {
        super(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.Consumable;
    }
}
