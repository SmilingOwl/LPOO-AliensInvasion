package com.mygdx.game.Model.Entities;

public class ComsumableModel extends EntityModel{
    private int LifeQuantity;
    private int Type;
    private boolean WasCatched;
    public ComsumableModel( float x, float y){
        super(x,y);
        this.Type=1;
        this.WasCatched=false;
        this.LifeQuantity=1;
    }
    @Override
    public ModelType getType() {
        return ModelType.Consumable;
    }
}
