package com.mygdx.game.Model.Entities;

import java.util.List;

public class HeroModel extends EntityModel{
    private int Life;
    private float Speed;
    private Boolean isArmed;
    //private List<HeroWeaponsModel> Backpack;
    private int Vulnerability;
    public enum HeroState{
        running, falling , jumping, stop
    }
    // private List<ConsumableModel> Itens;
    public HeroState heroState;
    public HeroModel( float x, float y){
        super(x,y);
        this.Life=1;
        this.Speed=0;
        this.isArmed= false;
        // this.Backpack=null;
        //this.Itens=null;
        this.Vulnerability=0;
        this.heroState= HeroState.stop;
    }
    @Override
    public ModelType getType() {
        return ModelType.Hero;
    }
}

