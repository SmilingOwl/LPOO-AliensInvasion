package com.mygdx.game.Controller.Entities;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.EntityModel;

import static com.mygdx.game.View.Screens.GameView.PIXEL_TO_METER;

/**
 * Class that represents an abstract physical body supported by a Box2D body.
 */
public class EntityBody {

    /**
     * Constant for collision mask, for hero.
     */
    final static short HERO_BODY = 0x0001;

    /**
     * Constant for collision mask, for alien.
     */
    final static short ALIEN_BODY = 0x0002;

    /**
     * Constant for collision mask, for alien attack.
     */
    final static short ALIEN_ATTACK_BODY = 0x0004;

    /**
     * Constant for collision mask, for consumable.
     */
    final static short CONSUMABLE_BODY = 0x0005;

    /**
     * Constant for collision mask, for portal.
     */
    final static short PORTAL_BODY = 0x0006;

    /**
     * Constant for collision mask, for basic platform.
     */
    final static short PLATFORMS_BODY = 0x0007;

    /**
     * Constant for collision mask, for rare item.
     */
    final static short RARE_ITEM_BODY = 0x0008;

    /**
     * Constant for collision mask, for fast platform.
     */
    final static short FAST_PLATFORMS = 0x0009;

    /**
     * Constant for collision mask, for slow platform.
     */
    final static short SLOW_PLATFORMS = 0x00010;

    /**
     * Constant for collision mask, for blocks platform.
     */
    final static short BLOCKS_PLATFORMS = 0x0011;

    /**
     * Constant for collision mask, for spikes platform.
     */
    final static short SPIKES_PLATFORMS = 0x00012;

    /**
     * the BOX2D body that supports this body
     */
    final Body body;

    /**
     * Constructs a body representing a model in a world.
     *
     * @param world The world this body belongs to.
     * @param model The model representing the body.
     */
    EntityBody(World world, EntityModel model) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(model.getX(), model.getY());
        bodyDef.linearVelocity.set(0, 0);// retirar

        body = world.createBody(bodyDef);
        body.setUserData(model);
    }

    /**
     * Method to create a polygon fixture represented by a set of vertexes.
     *
     * @param body        The body the fixture is to be attached to.
     * @param vertexes    The vertexes defining the fixture in pixels
     * @param width       The width of the bitmap the vertexes where extracted from.
     * @param height      The height of the bitmap the vertexes where extracted from.
     * @param density     The density of the fixture. How heavy it is in relation to its area.
     * @param friction    The friction of the fixture. How slippery it is.
     * @param restitution The restitution of the fixture. How much it bounces.
     * @param category
     * @param mask
     */
    final void createFixture(Body body, float[] vertexes, int width, int height, float density, float friction, float restitution, short category, short mask) {
        for (int i = 0; i < vertexes.length; i++) {
            if (i % 2 == 0) vertexes[i] -= width / 2;
            if (i % 2 != 0) vertexes[i] -= height / 2;
            if (i % 2 != 0) vertexes[i] *= -1;
            vertexes[i] *= PIXEL_TO_METER;
        }

        PolygonShape polygon = new PolygonShape();
        polygon.set(vertexes);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygon;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.filter.categoryBits = category;
        fixtureDef.filter.maskBits = mask;

        body.createFixture(fixtureDef);
        polygon.dispose();
    }

    /**
     * getX method from the Box2D body class
     *
     * @return the x-coordinate of this body
     */
    public float getX() {
        return body.getPosition().x;
    }

    /**
     * getY method from the Box2D body class
     *
     * @return the y-coordinate of this body
     */
    public float getY() {
        return body.getPosition().y;
    }

    /**
     * Moves the body to another position
     * @param x x-coordintae
     * @param y y-coordinate
     */
    public void setTransform(float x, float y) {
        body.setTransform(x, y, 0);
    }

    /**
     * Sets linear velocity
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void setLinearVelocity(float x, float y) {
        body.setLinearVelocity(x, y);
    }

    /**
     * Sets the body to a static body
     */
    public void setTypeToStatic() {
        body.setType(BodyDef.BodyType.StaticBody);
    }

    /**
     * apply a force to body center
     * @param forceX the x-component of the force to be applied
     * @param forceY the y-component of the force to be applied
     * @param awake should the body be awaken
     */
    public void applyForceToCenter(float forceX, float forceY, boolean awake) {
        body.applyForceToCenter(forceX, forceY, awake);
    }

}
