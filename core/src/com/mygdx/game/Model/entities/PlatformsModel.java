package com.mygdx.game.Model.Entities;

/**
 * A model representing a basic platform
 */
public class PlatformsModel extends EntityModel {

    /**
     * Constructs a basic platform belonging to a game model.
     *
     * @param x the x-coordinate of this basic platform
     * @param y the y-coordinate of this basic platform
     */
    public PlatformsModel( float x, float y){
        super(x,y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.platform;
    }
}
