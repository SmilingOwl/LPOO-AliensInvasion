package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.PlatformsModel;

/**
 * A concrete representation of basic platform body
 */
public class PlatformsBody extends EntityBody {

    /**
     * Constructs an basic platform body according to basic platform model
     *
     * @param world the physical world this basic platform belongs to
     * @param model the model representing the basic platform
     */
    public PlatformsBody(World world, PlatformsModel model) {
        super(world, model);
        setTypeToStatic();
        float density = 1f, friction = 40f, restitution = 0f;
        int width = 410, height = 80;

        // basic platform fixture
        createFixture(body, new float[]{
                        120 * 0.25f, 160 * 0.25f, 120 * 0.25f, 270 * 0.25f, 1480 * 0.25f, 160 * 0.25f, 1480 * 0.25f, 270 * 0.25f,},
                width, height, density, friction, restitution,
                PLATFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY | CONSUMABLE_BODY | RARE_ITEM_BODY));
    }
}

