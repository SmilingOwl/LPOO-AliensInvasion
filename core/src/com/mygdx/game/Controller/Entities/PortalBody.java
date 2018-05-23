package com.mygdx.game.Controller.Entities;

/**
 * Created by catam on 22/05/2018.
 */
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PortalModel;

public class PortalBody extends EntityBody {

    public PortalBody(World world, PortalModel model){
        super(world, model);

        setTypeToStatic();
        //setLinearVelocity(1,1);
        float density = 0.5f, friction = 0.4f, restitution = 0;
        // int width = 164, height = 170;
        int width = 300, height = 300;
        createFixture(body, new float[]{ 50,50,50,300,300,300,300,0},width,height,density,friction,restitution,PORTAL_BODY,(short)( PLATAFORMS_BODY|HERO_BODY));
    }
}