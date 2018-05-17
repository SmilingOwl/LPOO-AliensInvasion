package com.mygdx.game.Model.Entities;

public abstract class EntityModel {

    public enum ModelType {Alien,AlienAttack, Hero, Consumable, HeroWeapon,plataform};
    private float x;
    private float y;
    private boolean flaggedForRemoval =false;
    //private float rotation;
    EntityModel(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float getX(){ return x;}
    public float getY(){ return y;}
    public void setPosition( float x, float y){
        this.x=x;
        this.y=y;
    }
    public boolean isFlaggedForRemoval(){
        return flaggedForRemoval;
    }
    public void setFlaggedForRemoval(boolean flaggedForRemoval){
        this.flaggedForRemoval=flaggedForRemoval;
    }
    public abstract ModelType getType();
}


