package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.PortalModel;

/**
 * A concrete representation of victory portal body
 */
public class PortalBody extends EntityBody {

    /**
     * Constructs an portal body according to portal model
     *
     * @param world the physical world this portal belongs to
     * @param model the model representing the portal
     */
    public PortalBody(World world, PortalModel model) {
        super(world, model);

        setTypeToStatic();
        float density = 0.5f, friction = 0.4f, restitution = 0;
        int width = 300, height = 300;

        createFixture(body, new float[]{50, 50, 50, 300, 300, 300, 300, 0},
                width, height, density, friction, restitution,
                PORTAL_BODY, (short) (PLATFORMS_BODY | HERO_BODY));
    }
}