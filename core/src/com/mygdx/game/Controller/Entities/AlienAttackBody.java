package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienAttackModel;

/**
 * A concrete representation of alien attack (special bullet)
 */
public class AlienAttackBody extends EntityBody {

    /**
     * Constructs an alien attack body according to alien attack model
     *
     * @param world the physical world this alien attack belongs to
     * @param model the model representing the alien attack
     */
    public AlienAttackBody(World world, AlienAttackModel model) {
        super(world, model);
        float density = 1f, friction = 0.4f, restitution = 0.5f;
        int width = 12, height = 12;

        createFixture(body, new float[]{
                5, 5, 5, 10, 10, 10, 10, 5,
        }, width, height, density, friction, restitution,
                ALIEN_ATTACK_BODY, (short) (HERO_BODY));
    }
}
