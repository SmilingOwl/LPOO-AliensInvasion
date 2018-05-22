package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.ComsumableModel;


public class ComsumableBody extends EntityBody {
    public ComsumableBody(World world, ComsumableModel model){
        super(world, model);
       //setTypeToStatic();
        float density=1f, friction= 0.4f, restitution= 0;
        int width=40, height=40;
        createFixture(body, new float[]{ 10,10,40,10,40,40,10,40,}, width, height,density, friction,restitution,CONSUMABLE_BODY,(short)( ALIEN_BODY|HERO_BODY));
    }
}
