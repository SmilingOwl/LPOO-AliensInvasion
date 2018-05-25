package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.HeroModel;

/**
 * A concrete representation of hero body
 */
public class HeroBody extends EntityBody {
    /**
     * Constructs an hero body according to hero model
     *
     * @param world the physical world this hero belongs to
     * @param model the model representing the hero
     */
    public HeroBody(World world, HeroModel model) {
        super(world, model);

        float density = 0.5f, friction = 0.4f, restitution = 0;
        int width = 164, height = 170;

        // hero fixture
        createFixture(body, new float[]{74 * 0.5f + 35, 10 * 0.5f + 40, 24 * 0.5f + 35, 74 * 0.5f + 40, 7 * 0.5f + 35, 139 * 0.5f + 40, 34 * 0.5f + 35, 161 * 0.5f + 40, 164 * 0.5f + 35, 159 * 0.5f + 40, 167 * 0.5f + 35, 9 * 0.5f + 40},
                width, height, density, friction, restitution,
                HERO_BODY, (short) (PLATFORMS_BODY | CONSUMABLE_BODY |
                        ALIEN_BODY | ALIEN_ATTACK_BODY | PORTAL_BODY | RARE_ITEM_BODY));
    }
}

