package com.mygdx.game.Model.Entities;

public class AlienModel extends EntityModel {

    private int Life;
    private float Speed;
    private boolean inPlataform;
    private  float xPlatform;
    public AlienModel( float x, float y, int life, float Speed){
        super(x,y);
        this.Life=life;
        this.Speed=Speed;
        this.inPlataform=false;
        this.xPlatform=0;
    }
    public void setInPlataform(boolean b){
        this.inPlataform=b;}
    public boolean getInPlatform(){ return inPlataform;}
    public void setxPlatform(float x){ this.xPlatform=x;}
    public float getxPlatform(){ return xPlatform;}
    @Override
    public ModelType getType() {
        return ModelType.Alien;
    }
}
