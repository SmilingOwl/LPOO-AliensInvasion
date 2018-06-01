package com.mygdx.game.Model.Entities;

public abstract class EntityModel {

    /**
     * Possible model types
     */
    public enum ModelType {
        Alien, AlienAttack, Hero, Consumable, platform, platFast, platSpikes,
        platBlocks, platSlow, Portal, rareItem
    }

    /**
     * x-coordinate
     */
    private float x;

    /**
     * y-coordinate
     */
    private float y;

    /**
     * flag for removing model types
     */
    private boolean flaggedForRemoval = false;

    /**
     * Constructs a entity model belonging to a game model.
     *
     * @param x the x-coordinate of this entity
     * @param y the y-coordinate of this entity
     */
    EntityModel(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate
     *
     * @return x-coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Gets the y-coordinate
     *
     * @return y-coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the entity position
     *
     * @param x x-coordinate to update
     * @param y y-coordinate to update
     */
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the flaggedForRemoval
     *
     * @return flaggedForRemoval
     */
    public boolean isFlaggedForRemoval() {
        return flaggedForRemoval;
    }

    /**
     * Sets the flaggedForRemoval
     *
     * @param flaggedForRemoval
     */
    public void setFlaggedForRemoval(boolean flaggedForRemoval) {
        this.flaggedForRemoval = flaggedForRemoval;
    }

    /**
     * Abstract method, gets the entity type
     *
     * @return entity type
     */
    public abstract ModelType getType();
}


