package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.ComsumableModel;

public class ComsumableBody extends EntityBody {

    public ComsumableBody(World world, ComsumableModel model){
        super(world, model);
        float density=1f, friction= 0.4f, restitution= 0.5f;
        int width=12, height=12;
        createFixture(body, new float[]{ 5,5,5,10,10,10,5,}, width, height,density, friction,restitution,CONSUMABLE_BODY,(short)( ALIEN_BODY|HERO_BODY));
    }
}
