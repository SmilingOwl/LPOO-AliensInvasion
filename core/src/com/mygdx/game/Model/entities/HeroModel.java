package com.mygdx.game.Model.Entities;

/**
 * A model representing a hero
 */
public class HeroModel extends EntityModel {

    /**
     * represents the hero life
     */
    private int Life;

    /**
     * hero is walking backwards
     */
    private boolean back;

    /**
     * hero is jumping
     */
    private boolean jumping;

    /**
     * hero is armed
     */
    private boolean isArmed;

    /**
     * represents the victory
     */
    private boolean win;

    /**
     * represents the loss
     */
    private boolean lose;

    /**
     * represents the paused game
     */
    private boolean paused;

    /**
     * represents the hero steps
     */
    private float deltaX;


    /**
     * Sets the hero´s life
     *
     * @param life
     */
    public void setLife(int life) {
        this.Life = life;
    }

    /**
     * Sets the paused attribute
     *
     * @param p paused value to update
     */
    public void setPaused(boolean p) {
        this.paused = p;
    }

    /**
     * Constructs a hero model belonging to a game model.
     *
     * @param x the x-coordinate of this hero
     * @param y the y-coordinate of this hero
     */
    public HeroModel(float x, float y) {
        super(x, y);
        this.win = false;
        this.deltaX = 0;
        this.lose = false;
        this.paused = false;
        this.Life = 5;
        this.back = false;
        this.isArmed = false;
        this.jumping = false;
    }

    /**
     * Gets the deltaX attribute
     *
     * @return deltaX
     */
    public float getDeltaX() {
        return deltaX;
    }

    /**
     * Sets the deltaX attribute
     *
     * @param delta value to update deltaX
     */
    public void setDeltaX(float delta) {
        this.deltaX = delta;
    }

    /**
     * Sets the back attribute
     *
     * @param b value to update back
     */
    public void setBack(boolean b) {
        back = b;
    }

    /**
     * Sets the jumping attribute
     *
     * @param b value to update jumping
     */
    public void setJumping(boolean b) {
        jumping = b;
    }

    /**
     * Sets the lose attribute
     *
     * @param b value to update lose
     */
    public void setLose(boolean b) {
        this.lose = b;
    }

    /**
     * Gets the back attribute
     *
     * @return back
     */
    public boolean getBack() {
        return back;
    }

    /**
     * Gets the win attribute
     *
     * @return win
     */
    public boolean getWin() {
        return win;
    }

    /**
     * Gets the lose attribute
     *
     * @return lose
     */
    public boolean getLose() {
        return lose;
    }

    /**
     * gets the paused attribute
     *
     * @return paused
     */
    public boolean getPaused() {
        return paused;
    }

    /**
     * Gets the isArmed attribute
     *
     * @return isArmed
     */
    public boolean getIsArmed() {
        return isArmed;
    }

    /**
     * Sets isArmed attribute
     *
     * @param is value to update isArmed
     */
    public void setIsArmed(boolean is) {
        this.isArmed = is;
    }

    /**
     * Sets the win attribute
     *
     * @param b value to update win
     */
    public void setWin(boolean b) {
        this.win = b;
    }

    /**
     * Gets jumping attribute
     *
     * @return jumping
     */
    public boolean getJumping() {
        return jumping;
    }

    /**
     * Gets life attribute
     *
     * @return life
     */
    public int getLife() {
        return Life;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelType getType() {
        return ModelType.Hero;
    }
}

