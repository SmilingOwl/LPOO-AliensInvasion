package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.RareItemModel;

/**
 * A concrete representation of rare item body
 */
public class RareItemBody extends EntityBody {

    /**
     * Constructs an rare item body according to rare item model
     *
     * @param world the physical world this rare item belongs to
     * @param model the model representing the rare item
     */
    public RareItemBody(World world, RareItemModel model) {
        super(world, model);
        float density = 0.5f, friction = 0.4f, restitution = 0;
        int width = 164, height = 170;

        createFixture(body, new float[]{74 * 0.5f + 35, 10 * 0.5f + 40, 24 * 0.5f + 35, 74 * 0.5f + 40, 7 * 0.5f + 35, 139 * 0.5f + 40, 34 * 0.5f + 35, 161 * 0.5f + 40, 164 * 0.5f + 35, 159 * 0.5f + 40, 167 * 0.5f + 35, 9 * 0.5f + 40},
                width, height, density, friction, restitution,
                RARE_ITEM_BODY, (short) (PLATFORMS_BODY | HERO_BODY | FAST_PLATFORMS | SLOW_PLATFORMS | BLOCKS_PLATFORMS | SPIKES_PLATFORMS));
    }
}
