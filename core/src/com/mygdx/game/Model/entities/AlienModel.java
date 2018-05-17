package com.mygdx.game.Model.Entities;

public class AlienModel extends EntityModel {

    private int Life;
    private float Speed;
    public AlienModel( float x, float y, int life, float Speed){
        super(x,y);
        this.Life=life;
        this.Speed=Speed;
    }
    @Override
    public ModelType getType() {
        return ModelType.Alien;
    }
}
