package com.mygdx.game.Model.Entities;

/**
 * A model representing an alien
 */
public class AlienModel extends EntityModel {

    private int Life;
    private float Speed;
    private boolean direction;

    /**
     *
     * @param x
     * @param y
     * @param life
     * @param Speed
     */
    private boolean inPlataform;
    private  float xPlatform;
    public AlienModel( float x, float y, int life, float Speed){
        super(x,y);
        this.Life=life;
        this.Speed=Speed;
        this.inPlataform=false;
        this.direction=false;
        this.xPlatform=0;
    }
    public void setInPlataform(boolean b){
        this.inPlataform=b;}
    public boolean getInPlatform(){ return inPlataform;}
    public void setDirection(boolean b){
        this.direction=b;}
    public boolean getDirection(){ return direction;}
    public void setxPlatform(float x){ this.xPlatform=x;}
    public float getxPlatform(){ return xPlatform;}
    @Override
    public ModelType getType() {
        return ModelType.Alien;
    }
}
