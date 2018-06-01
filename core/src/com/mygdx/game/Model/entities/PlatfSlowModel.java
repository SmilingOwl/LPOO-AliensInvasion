package com.mygdx.game.Model.Entities;

/**
 * A model representing a basic platform
 */
public class PlatfSlowModel extends EntityModel {

    /**
     * Constructs a slow platform belonging to a game model.
     *
     * @param x the x-coordinate of this slow platform
     * @param y the y-coordinate of this slow platform
     */
    public PlatfSlowModel(float x, float y) {
        super(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.platSlow;
    }
}
