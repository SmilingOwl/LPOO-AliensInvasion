package com.mygdx.game.Model.Entities;

/**
 * A model representing an alien attack
 */
public class AlienAttackModel extends EntityModel {

    private float speed;
    private boolean failed;
    private float timeToLive;

    /**
     * Constructs a alien attack model belonging to a game model.
     * @param x the x-coordinate of this alien attack
     * @param y the y-coordinate of this alien attack
     */
    public AlienAttackModel( float x, float y){
        super(x,y);
        this.speed=1;
        this.failed=true;
    }

    @Override
    public ModelType getType() {
        return ModelType.AlienAttack;
    }

    public boolean decreaseTimeTolive(float delta){
        timeToLive -=delta;
        return timeToLive <0;
    }
    public void setTimeToLive(float timeToLive) {
        this.timeToLive = timeToLive;
    }
}
