package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PlatfPicosModel;

/**
 * A concrete representation of spikes platform body
 */
public class PlatfPicosBody extends EntityBody {
    /**
     * Constructs an spikes platform body according to spike platform model
     *
     * @param world the physical world this spikes platform belongs to
     * @param model the model representing the spikes platform
     */
    public PlatfPicosBody(World world, PlatfPicosModel model) {
        super(world, model);
        setTypeToStatic();
        float density = 1f, friction = 0.4f, restitution = 0f;
        int width = 383, height = 144;

        //spikes platform fixture
        createFixture(body, new float[]{
                        29, 35, 24, 56, 24, 83, 365, 84, 364, 53, 347, 36},
                width, height, density, friction, restitution,
                PLATFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY | CONSUMABLE_BODY | RARE_ITEM_BODY));
    }
}
