package com.mygdx.game.Model.Entities;

/**
 * A model representing an alien
 */
public class AlienModel extends EntityModel {

    private int Life;
    private float Speed;

    /**
     *
     * @param x
     * @param y
     * @param life
     * @param Speed
     */
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
