package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PlatTilojosModel;
import com.mygdx.game.Model.Entities.PlatformsModel;

/**
 * Created by catam on 20/05/2018.
 */

public class PlatTijolosBody extends EntityBody {
    public PlatTijolosBody(World world, PlatTilojosModel model) {
        super(world, model);
        setTypeToStatic();
        float density=1f, friction= 0.4f, restitution= 0f;
        int width=374, height=57;

        createFixture(body, new float[]{
           7,11,6,33,17,40,358,40,367,33,366,10,       }, width, height, density, friction, restitution,  PLATAFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY| CONSUMABLE_BODY|RAREITEM_BODY));
}
}
