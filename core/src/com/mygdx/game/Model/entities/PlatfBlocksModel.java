package com.mygdx.game.Model.Entities;

/**
 * A model representing a blocks platform
 */
public class PlatfBlocksModel extends EntityModel {

    /**
     * Constructs a blocks platform belonging to a game model.
     *
     * @param x the x-coordinate of this blocks platform
     * @param y the y-coordinate of this blocks platform
     */
    public PlatfBlocksModel(float x, float y) {
        super(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.platBlocks;
    }
}

