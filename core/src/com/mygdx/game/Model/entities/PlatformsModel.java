package com.mygdx.game.Model.Entities;

public class PlatformsModel extends EntityModel {
    private int Type;
    public PlatformsModel( float x, float y){
        super(x,y);
        this.Type=0;
    }
    @Override
    public ModelType getType() {
        return ModelType.plataform;
    }
}
