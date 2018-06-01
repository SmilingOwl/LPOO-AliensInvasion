package com.mygdx.game.Model.Entities;

/**
 * A model representing a victory portal
 */
public class PortalModel extends EntityModel{

    /**
     * Constructs a portal belonging to a game model.
     *
     * @param x the x-coordinate of this portal
     * @param y the y-coordinate of this portal
     */
    public PortalModel( float x, float y){
        super(x,y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.Portal;
    }

}
