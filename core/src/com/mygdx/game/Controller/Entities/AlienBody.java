package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.AlienModel;

/**
 * A concrete representation of alien body
 */
public class AlienBody extends EntityBody {
    /**
     * Constructs an alien  body according to alien model
     * @param world the physical world this alien  belongs to
     * @param model the model representing the alien
     */
    public AlienBody(World world, AlienModel model){
        super(world, model);
        float density = 0.5f, friction = 0.4f, restitution = 0f;
        int width = 80, height = 60;

        // Alien fixture
        createFixture(body, new float[]{ 37,7,29,23,17,39,10,48,12,60,67,60,67,40,47,7},
                width,height,density,friction,restitution,
                ALIEN_BODY,(short)(HERO_BODY| PLATAFORMS_BODY));
    }
}
