package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.PlatformsModel;

public class PlatformsBody extends EntityBody {
    public PlatformsBody(World world, PlatformsModel model) {
        super(world, model);
        setTypeToStatic();
        float density=1f, friction= 0.4f, restitution= 0f;
        int width=410, height=80;

        createFixture(body, new float[]{
                120*0.25f,160*0.25f, 120*0.25f,270*0.25f, 1480*0.25f,160*0.25f, 1480*0.25f,270*0.25f,
        }, width, height, density, friction, restitution,  PLATAFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY));
    }
}

