package com.mygdx.game.Model.Entities;

/**
 * Created by catam on 22/05/2018.
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
