package com.mygdx.game.Model.Entities;

/**
 * Created by catam on 20/05/2018.
 */

public class PlatTilojosModel extends EntityModel {
    private int Type;
    public PlatTilojosModel( float x, float y){
        super(x,y);
        this.Type=0;
    }
    @Override
    public ModelType getType() {
        return ModelType.platTijolos;
    }
}

