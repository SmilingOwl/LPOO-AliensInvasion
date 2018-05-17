package com.mygdx.game.Controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
//import com.mygdx.game.Controller.Entities.AlienBody;
import com.badlogic.gdx.physics.box2d.Body;
//import com.mygdx.game.Controller.Entities.HeroBody;
import com.mygdx.game.Controller.Entities.AlienAttackBody;
import com.mygdx.game.Controller.Entities.AlienBody;
import com.mygdx.game.Controller.Entities.ComsumableBody;
import com.mygdx.game.Controller.Entities.HeroBody;
import com.mygdx.game.Controller.Entities.PlatformsBody;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ComsumableModel;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.Entities.HeroModel;
import com.mygdx.game.Model.GameModel;
//import com.mygdx.game.Model.entities.AlienModel;
//import com.mygdx.game.Model.entities.EntityModel;

import java.util.ArrayList;
import java.util.List;

public class GameController implements ContactListener {
    private static GameController instance;
    public static final int PANEL_WIDTH=100;
    public static final int PANEL_HEIGHT=40;
    private static final float ACCELERATION_FORCE= 1000f;
    private static final float ALIENATTACK_SPEED= 30f;
    private static final float HEROATTACK_SPEED= 30f;
    private static final float TIME_BETWEEN_SHOTS= .1f;
    private final World world;
    private final HeroModel heroModel;
   // private final PlatformsBody plat1Body;
   // private final PlatformsBody plat2Body;
    private float accumulator = 0;
    private List<ComsumableModel> watersToadd= new ArrayList<ComsumableModel>();
    private List<AlienModel> aliensToadd = new ArrayList<AlienModel>();// acho que tenho que mudar
    private float timeToNextShoot;
    private GameController(){
       timeToNextShoot=-1;
        world = new World(new Vector2(0,-9.8f),true);
        heroModel= GameModel.getInstance().getHero();
        new HeroBody(world,heroModel);

        /*heroB= new HeroBody(world, GameModel.getInstance().getHero());
        plat1Body= new PlatformsBody(world,GameModel.getInstance().getPlat1());
        plat2Body= new PlatformsBody(world,GameModel.getInstance().getPlat2());*/
        new PlatformsBody(world,GameModel.getInstance().getPlat1());
         new PlatformsBody(world,GameModel.getInstance().getPlat2());
         List<AlienModel> aliens= GameModel.getInstance().getAliens();
        for( AlienModel alien:aliens)
        new AlienBody(world,alien);
        List<ComsumableModel> waters= GameModel.getInstance().getWaters();
       for(ComsumableModel water: waters)
           new ComsumableBody(world,water);
        world.setContactListener(this);
    }
    public static GameController getInstance(){
        if(instance==null)
            instance = new GameController();
        return instance;
    }
    public void update (float delta){
        GameModel.getInstance().update(delta);
        timeToNextShoot -=delta;
        float frameTime = Math.min(delta, 0.25f);
        accumulator +=frameTime;
        while(accumulator >= 1/60f){
            world.step(1/60f,6,2);
            accumulator -= 1/60f;
        }
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for(Body body : bodies){
            verifyBounds(body);
            ((EntityModel) body.getUserData()).setPosition(body.getPosition().x, body.getPosition().y);
        }
    }
    private void verifyBounds(Body body) {
        if (body.getPosition().x < 0)
            body.setTransform(PANEL_WIDTH, body.getPosition().y, body.getAngle());

        if (body.getPosition().y < 0)
            body.setTransform(body.getPosition().x, PANEL_HEIGHT, body.getAngle());

        if (body.getPosition().x > PANEL_WIDTH)
            body.setTransform(0, body.getPosition().y, body.getAngle());

        if (body.getPosition().y > PANEL_HEIGHT)
            body.setTransform(body.getPosition().x, 0, body.getAngle());
    }
    public World getWorld(){
        return world;
    }
    @Override
    public void endContact(Contact contact){}
    @Override
    public void preSolve(Contact contact , Manifold oldManifold){

    }
    @Override
    public void postSolve(Contact contact , ContactImpulse contactImpulse) {
    }


    @Override
    public void beginContact(Contact contact){
        Body bodyA= contact.getFixtureA().getBody();
        Body bodyB= contact.getFixtureB().getBody();

    }
    public void removeFlagged(){
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for(Body body: bodies){
            if(((EntityModel)body.getUserData()).isFlaggedForRemoval()){
                ((EntityModel)body.getUserData()).setFlaggedForRemoval(false);
                GameModel.getInstance().remove((EntityModel)body.getUserData());
                world.destroyBody(body);
            }
        }
    }
    public void shoot() {
        if (timeToNextShoot < 0) {
            AlienAttackModel bullet = GameModel.getInstance().createAlienAttack(GameModel.getInstance().getAliens().get(0));
            AlienAttackBody body = new AlienAttackBody(world, bullet);
            body.setLinearVelocity(4);
            timeToNextShoot = TIME_BETWEEN_SHOTS;
        }
    }




}
