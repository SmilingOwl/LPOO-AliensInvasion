package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienModel;

public class AlienBody extends EntityBody {
    public AlienBody(World world, AlienModel model){
        super(world, model);
        float density = 0.5f, friction = 0.4f, restitution = 0.5f;
        int width = 75, height = 75;
        createFixture(body, new float[]{ 12,28,15,28,32,19,42,13,43},width,height,density,friction,restitution,ALIEN_BODY,(short)(HERO_BODY| ALIEN_BODY| ALIENATTACK_BODY));
    }
}
