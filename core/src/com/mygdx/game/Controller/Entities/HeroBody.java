package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.HeroModel;

public class HeroBody extends EntityBody {

    public HeroBody(World world, HeroModel model){
        super(world, model);
        //setLinearVelocity(1,1);
        float density = 0.5f, friction = 0.4f, restitution = 0;
       // int width = 164, height = 170;
        int width = 164, height = 170;
        createFixture(body, new float[]{ 74*0.5f +35,10*0.5f+40,24*0.5f+35,74*0.5f+40,7*0.5f+35,139*0.5f+40,34*0.5f+35,161*0.5f+40,164*0.5f+35,159*0.5f+40,167*0.5f+35,9*0.5f+40},width,height,density,friction,restitution,HERO_BODY,(short)( PLATAFORMS_BODY|HERO_WEAPONS_BODY|CONSUMABLE_BODY|HERO_BODY| ALIEN_BODY| ALIENATTACK_BODY));
    }
}

