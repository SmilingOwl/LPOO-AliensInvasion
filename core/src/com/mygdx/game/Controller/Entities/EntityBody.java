package com.mygdx.game.Controller.Entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Model.Entities.EntityModel;
import static com.mygdx.game.View.Screens.GameView.PIXEL_TO_METER;

public class EntityBody {
    final static short HERO_BODY=0x0001;
    final static short ALIEN_BODY=0x0002;
    final static short ALIENATTACK_BODY=0x0004;
    final static short CONSUMABLE_BODY=0x0005;
    final static short HERO_WEAPONS_BODY=0x0006;
    final static short PLATAFORMS_BODY=0x0007;

    final Body body;
    EntityBody(World world, EntityModel model){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type= BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(model.getX(),model.getY());
        bodyDef.linearVelocity.set(0,0);// retirar
        body= world.createBody(bodyDef);
        body.setUserData(model);

    }
    final void createFixture(Body body, float[] vertexes, int width, int height, float density,float friction, float restitution, short category, short mask){
        for (int i=0; i < vertexes.length; i++){
            if( i% 2 ==0) vertexes[i] -= width/2;
            if( i% 2 !=0) vertexes[i] -= height/2;
            if( i% 2 !=0) vertexes[i] *= -1;
            vertexes[i]*= PIXEL_TO_METER;
        }

        PolygonShape polygon = new PolygonShape();
        polygon.set(vertexes);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape=polygon;
        fixtureDef.density= density;
        fixtureDef.friction=friction;
        fixtureDef.restitution=restitution;
        fixtureDef.filter.categoryBits=category;
        fixtureDef.filter.maskBits=mask;
        body.createFixture(fixtureDef);
        polygon.dispose();
    }

    public float getX(){
        return body.getPosition().x;
    }
    public float getY(){
        return body.getPosition().y;
    }
    public void setTransform(float x, float y){
        body.setTransform(x,y,0);
    }
    public void setLinearVelocity(float velocity) {
        body.setLinearVelocity((float)(velocity * -Math.sin(0)), (float) (velocity * Math.cos(0)));
    }

    public void setAngularVelocity(float omega){
        body.setAngularVelocity(omega);
    }
    public void applyForceToCenter(float forceX, float forceY, boolean awake){
        body.applyForceToCenter(forceX, forceY, awake);
    }
    public Object getUserDate(){
        return body.getUserData();
    }

}
