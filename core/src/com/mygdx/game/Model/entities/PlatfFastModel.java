package com.mygdx.game.Model.Entities;

/**
 * A model representing a fast platform
 */
public class PlatfFastModel extends EntityModel{


    /**
     * Constructs a fast platform belonging to a game model.
     *
     * @param x the x-coordinate of this fast platform
     * @param y the y-coordinate of this fast platform
     */
        public PlatfFastModel( float x, float y){
            super(x,y);
        }

    /**
     * {@inheritDoc}
     */
        @Override
        public ModelType getType() {
            return ModelType.platFast;
        }

}
