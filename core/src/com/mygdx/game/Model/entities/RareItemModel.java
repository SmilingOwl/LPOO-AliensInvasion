package com.mygdx.game.Model.Entities;

/**
 * A model representing a rare item
 */
public class RareItemModel extends EntityModel {

    /**
     * Constructs a rare item belonging to a game model.
     *
     * @param x the x-coordinate of this rare item
     * @param y the y-coordinate of this rare item
     */
    public RareItemModel(float x, float y) {
        super(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.rareItem;
    }
}
