package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.HeroModel;

public class HeroBody extends EntityBody {

    public HeroBody(World world, HeroModel model){
        super(world, model);
        float density = 0.5f, friction = 0.4f, restitution = 0.5f;
        int width = 75, height = 75;
        createFixture(body, new float[]{ 12,28,15,28,32,19,42,13,43},width,height,density,friction,restitution,HERO_BODY,(short)( PLATAFORMS_BODY|HERO_WEAPONS_BODY|CONSUMABLE_BODY|HERO_BODY| ALIEN_BODY| ALIENATTACK_BODY));
    }
}

