package com.mygdx.game.Model.Entities;

/**
 * A model representing a consumable item
 */
public class ConsumableModel extends EntityModel{

    private int LifeQuantity;
    private int Type;
    private boolean WasCatched;

    public ConsumableModel( float x, float y){
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
