package com.mygdx.game.Controller.Entities;


import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PlatfFastModel;

/**
 * A concrete representation of fast platform body
 */
public class PlatfFastBody extends EntityBody {

    /**
     * Constructs an fast platform body according to fast platform  model
     *
     * @param world the physical world this fast platform belongs to
     * @param model the model representing the fast platform
     */
    public PlatfFastBody(World world, PlatfFastModel model) {
        super(world, model);
        setTypeToStatic();
        float density = 1f, friction = 0.4f, restitution = 0f;
        int width = 426, height = 65;

        createFixture(body, new float[]{
                        8, 11, 9, 39, 23, 45, 416, 44, 416, 11,},
                width, height, density, friction, restitution,
                PLATFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY | CONSUMABLE_BODY | RARE_ITEM_BODY));
    }
}
