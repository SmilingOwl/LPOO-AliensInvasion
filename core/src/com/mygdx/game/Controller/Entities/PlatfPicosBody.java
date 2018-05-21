package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PlatfPicosModel;
import com.mygdx.game.Model.Entities.PlatformsModel;

/**
 * Created by catam on 20/05/2018.
 */

public class PlatfPicosBody extends EntityBody {
    public PlatfPicosBody(World world, PlatfPicosModel model) {
        super(world, model);
        setTypeToStatic();
        float density=1f, friction= 0.4f, restitution= 0f;
        int width=383, height=144;

        createFixture(body, new float[]{
               29,35,24,56,24,83,365,84,364,53,347,36
        }, width, height, density, friction, restitution,  PLATAFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY));
    }
}
