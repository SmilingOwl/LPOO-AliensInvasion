package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PlatfBlocksModel;

/**
 * A concrete representation of blocks platform body
 */
public class PlatfBlocksBody extends EntityBody {

    /**
     * Constructs an blocks platform body according to blocks platform model
     *
     * @param world the physical world this blocks platform belongs to
     * @param model the model representing the blocks platform
     */
    public PlatfBlocksBody(World world, PlatfBlocksModel model) {
        super(world, model);
        setTypeToStatic();
        float density = 1f, friction = 0.4f, restitution = 0f;
        int width = 374, height = 57;

        createFixture(body, new float[]{
                7, 11, 6, 33, 17, 40, 358, 40, 367, 33, 366, 10,},
                width, height, density, friction, restitution,
                PLATFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY | CONSUMABLE_BODY | RARE_ITEM_BODY));
    }
}
