package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienModel;

public class AlienBody extends EntityBody {
    public AlienBody(World world, AlienModel model){
        super(world, model);
        setTypeToStatic();
        float density = 0.5f, friction = 0.4f, restitution = 0f;
        int width = 80, height = 60;
        createFixture(body, new float[]{ 37,7,29,23,17,39,10,48,12,60,67,60,67,40,47,7},width,height,density,friction,restitution,ALIEN_BODY,(short)(HERO_BODY| ALIEN_BODY| ALIENATTACK_BODY| PLATAFORMS_BODY));
    }
}
