package com.mygdx.game.Model.Entities;

/**
 * A model representing a spikes platform
 */
public class PlatfSpikesModel extends EntityModel {

    /**
     * Constructs a spikes platform belonging to a game model.
     *
     * @param x the x-coordinate of this spikes platform
     * @param y the y-coordinate of this spikes platform
     */
    public PlatfSpikesModel( float x, float y){
        super(x,y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.platSpikes;
    }
}
