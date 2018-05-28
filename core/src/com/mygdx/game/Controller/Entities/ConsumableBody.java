package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.ConsumableModel;


/**
 * A concrete representation of consumable bodies (bottle of water)
 */
public class ConsumableBody extends EntityBody {

    /**
     * Constructs a consumable  body according to consumable model
     * @param world the physical world this consumable  belongs to
     * @param model the model representing the consumable
     */
    public ConsumableBody(World world, ConsumableModel model){
        super(world, model);
        float density=1f, friction= 0.4f, restitution= 0;
        int width=40, height=40;

        // consumable body fixture
        createFixture(body, new float[]{ 10,10,40,10,40,40,10,40,},
                width, height,density, friction,restitution,
                CONSUMABLE_BODY,(short)( PLATAFORMS_BODY|ALIEN_BODY|HERO_BODY));
    }
}