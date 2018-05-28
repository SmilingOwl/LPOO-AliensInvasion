package com.mygdx.game.Model.Entities;

/**
 * A model representing a hero
 */
public class HeroModel extends EntityModel{

    private int Life;
    private float Speed;
    private boolean back;
    private boolean jumping;
    private boolean isArmed;
    private boolean win;
    private boolean lose;
    private boolean paused;

    private int Vulnerability;

    public enum HeroState{
        running, falling , jumping, stop
    }
    // private List<ConsumableModel> Itens;
    public HeroState heroState;
    public HeroModel( float x, float y){
        super(x,y);
        this.Life=1;
        this.win=false;
        this.lose=false;
        this.paused=false;
        this.Speed=0;
        this.back=false;
        this.isArmed= false;
        this.jumping = false;
        this.Vulnerability=0;
        this.heroState= HeroState.stop;
    }
    public void setCommingBack( boolean b){
        back=b;
    }
    public void setJumping( boolean b){
        jumping=b;
    }
    public boolean getBack(){ return back;}
    public boolean getWin(){return win;}
    public boolean getLose(){ return lose;}
    public boolean getPaused(){return paused;}

    public void setWin(boolean b){
        this.win=b;
}
    public boolean getJumping(){ return jumping;}

    @Override
    public ModelType getType() {
        return ModelType.Hero;
    }
}

