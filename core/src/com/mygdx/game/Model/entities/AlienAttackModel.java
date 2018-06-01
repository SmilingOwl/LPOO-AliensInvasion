package com.mygdx.game.Model.Entities;

/**
 * A model representing an alien attack
 */
public class AlienAttackModel extends EntityModel {

    /**
     * this attribute represents the time that bullets lasts in game
     */
    private float timeToLive;

    /**
     * Constructs a alien attack model belonging to a game model.
     *
     * @param x the x-coordinate of this alien attack
     * @param y the y-coordinate of this alien attack
     */
    public AlienAttackModel(float x, float y) {
        super(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.AlienAttack;
    }

    /**
     * This function decreases timeToLive in delta
     *
     * @param delta time decrement
     * @return true if TimeToLive<0 and false otherwise
     */
    public boolean decreaseTimeToLive(float delta) {
        timeToLive -= delta;
        return timeToLive < 0;
    }

    /**
     * Set the timeToLive
     *
     * @param timeToLive time that alien attack lasts in game
     */
    public void setTimeToLive(float timeToLive) {
        this.timeToLive = timeToLive;
    }
}
