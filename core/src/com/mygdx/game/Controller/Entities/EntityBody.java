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

    final static short HERO_BODY = 0x0001;
    final static short ALIEN_BODY = 0x0002;
    final static short ALIENATTACK_BODY = 0x0004;
    final static short CONSUMABLE_BODY = 0x0005;
    final static short PORTAL_BODY = 0x0006;
    final static short PLATAFORMS_BODY = 0x0007;
    final static short RAREITEM_BODY = 0x0008;
    final static short FAST_PLATFORMS = 0x0009;
    final static short LENTA_PLATFORMS = 0x00010;
    final static short TIJOLO_PLATFORMS = 0x0011;
    final static short PICOS_PLATFORMS = 0x00012;

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
     * @param body The body the fixture is to be attached to.
     * @param vertexes The vertexes defining the fixture in pixels
     * @param width The width of the bitmap the vertexes where extracted from.
     * @param height The height of the bitmap the vertexes where extracted from.
     * @param density The density of the fixture. How heavy it is in relation to its area.
     * @param friction The friction of the fixture. How slippery it is.
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
     *getX method from the Box2D body class
     * @return the x-coordinate of this body
     */
    public float getX() {
        return body.getPosition().x;
    }

    /**
     * getY method from the Box2D body class
     * @return the y-coordinate of this body
     */
    public float getY() {
        return body.getPosition().y;
    }

    public void setTransform(float x, float y) {
        body.setTransform(x, y, 0);
    }


    public void setLinearVelocity(float velocity) {
        body.setLinearVelocity((float) (velocity * -Math.sin(0)), (float) (velocity * Math.cos(0)));
    }

    public void setLinearVelocity(float x, float y) {
        body.setLinearVelocity(x, y);
    }

    public void setTypeToStatic() {
        body.setType(BodyDef.BodyType.StaticBody);
    }

    public void setAngularVelocity(float omega) {
        body.setAngularVelocity(omega);
    }

    public void applyForceToCenter(float forceX, float forceY, boolean awake) {
        body.applyForceToCenter(forceX, forceY, awake);
    }

    /**
     * the getUserData method from the Box2D body class.
     * @return the user data
     */
    public Object getUserDate() {
        return body.getUserData();
    }

}
