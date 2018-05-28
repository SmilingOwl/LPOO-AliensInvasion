package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PlatfLentaModel;

/**
 * A concrete representation of hero body
 */
public class PlatfLentaBody extends EntityBody {
    /**
     * Constructs an fast platform body according to slow platform   model
     *
     * @param world the physical world this slow platform  belongs to
     * @param model the model representing the slow platform
     */
    public PlatfLentaBody(World world, PlatfLentaModel model) {
        super(world, model);
        setTypeToStatic();
        float density = 1f, friction = 0.4f, restitution = 0f;
        int width = 410, height = 80;

        //slow platform sfixture
        createFixture(body, new float[]{
                        120 * 0.25f, 160 * 0.25f, 120 * 0.25f, 270 * 0.25f, 1480 * 0.25f, 160 * 0.25f, 1480 * 0.25f, 270 * 0.25f,},
                width, height, density, friction, restitution,
                PLATFORMS_BODY, (short) (ALIEN_BODY | HERO_BODY | RARE_ITEM_BODY));
    }
}
