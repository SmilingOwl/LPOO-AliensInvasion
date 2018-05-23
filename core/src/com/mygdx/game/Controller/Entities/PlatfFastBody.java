package com.mygdx.game.Controller.Entities;

/**
 * Created by catam on 20/05/2018.
 */

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.PlatfFastModel;
import com.mygdx.game.Model.Entities.PlatformsModel;

public class PlatfFastBody extends EntityBody {
    public PlatfFastBody(World world, PlatfFastModel model) {
        super(world, model);
        setTypeToStatic();
        float density=1f, friction= 0.4f, restitution= 0f;
        int width=426, height=65;

        createFixture(body, new float[]{
              8,11,9,39,23,45,416,44,416,11,
        }, width, height, density, friction, restitution,  PLATAFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY| CONSUMABLE_BODY|RAREITEM_BODY));
    }
}
