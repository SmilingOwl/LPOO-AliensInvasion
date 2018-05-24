package com.mygdx.game.Model.Entities;

/**
 * A model representing a victory portal
 */
public class PortalModel extends EntityModel{

    private int Type;
    public PortalModel( float x, float y){
        super(x,y);
        this.Type=0;
    }

    @Override
    public ModelType getType() {
        return ModelType.Portal;
    }

}
