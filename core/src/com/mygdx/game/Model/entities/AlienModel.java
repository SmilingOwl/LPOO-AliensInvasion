package com.mygdx.game.Model.Entities;

/**
 * A model representing an alien
 */
public class AlienModel extends EntityModel {

    /**
     * represents the alien direction (left or right)
     */
    private boolean direction;
    /**
     * represents if the alien whether the alien is on the platform or not
     */
    private boolean inPlatform;
    /**
     * represents the x-coordinate of the platform the alien is on
     */
    private float xPlatform;

    /**
     * Constructs a alien model belonging to a game model.
     *
     * @param x the x-coordinate of this alien
     * @param y the y-coordinate of this alien
     */
    public AlienModel(float x, float y) {

        super(x, y);
        this.inPlatform = false;
        this.direction = false;
        this.xPlatform = 0;
    }

    /**
     * Sets the inPlatform attribute
     *
     * @param b new inPlatform value to update
     */
    public void setInPlatform(boolean b) {
        this.inPlatform = b;
    }

    /**
     * Gets the inPlatform attribute
     *
     * @return inPlatform
     */
    public boolean getInPlatform() {
        return inPlatform;
    }

    /**
     * Sets the direction attribute
     *
     * @param b new direction value to update
     */
    public void setDirection(boolean b) {
        this.direction = b;
    }

    /**
     * Gets the direction attribute
     *
     * @return direction
     */
    public boolean getDirection() {
        return direction;
    }

    /**
     * Sets the xPlatform attribute
     *
     * @param x new x-coordinate of platform to update
     */
    public void setXPlatform(float x) {
        this.xPlatform = x;
    }

    /**
     * Gets the xPlatform attribute
     *
     * @return xPlatform
     */
    public float getXPlatform() {
        return xPlatform;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.Alien;
    }
}
