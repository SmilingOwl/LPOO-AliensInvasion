package com.mygdx.game.Controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Controller.Entities.AlienAttackBody;
import com.mygdx.game.Controller.Entities.AlienBody;
import com.mygdx.game.Controller.Entities.ConsumableBody;
import com.mygdx.game.Controller.Entities.HeroBody;
import com.mygdx.game.Controller.Entities.PlatTijolosBody;
import com.mygdx.game.Controller.Entities.PlatfFastBody;
import com.mygdx.game.Controller.Entities.PlatfLentaBody;
import com.mygdx.game.Controller.Entities.PlatfPicosBody;
import com.mygdx.game.Controller.Entities.PlatformsBody;
import com.mygdx.game.Controller.Entities.PortalBody;
import com.mygdx.game.Controller.Entities.RareItemBody;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ConsumableModel;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.Entities.HeroModel;
import com.mygdx.game.Model.Entities.PlatTilojosModel;
import com.mygdx.game.Model.Entities.PlatfFastModel;
import com.mygdx.game.Model.Entities.PlatfLentaModel;
import com.mygdx.game.Model.Entities.PlatfPicosModel;
import com.mygdx.game.Model.Entities.PlatformsModel;
import com.mygdx.game.Model.Entities.RareItemModel;
import com.mygdx.game.Model.GameModel;


import java.util.ArrayList;
import java.util.List;

public class GameController implements ContactListener {

    private static GameController instance;
    public static final int PANEL_WIDTH = 440;
    public static final int PANEL_HEIGHT = 70;
    private static final float ACCELERATION_FORCE = 1000f;
    private static final float ALIENATTACK_SPEED = 30f;
    private static final float HEROATTACK_SPEED = 30f;
    private static final float TIME_BETWEEN_SHOTS = .1f;
    private final World world;
    private final HeroBody herobody;
    private boolean onTheGround = false;
    private boolean back = false;
    private float accumulator = 0;
    private List<ConsumableModel> watersToadd = new ArrayList<ConsumableModel>();
    private List<AlienModel> aliensToadd = new ArrayList<AlienModel>();// acho que tenho que mudar
    private float timeToNextShoot;

    private GameController() {
        timeToNextShoot = -1;
        world = new World(new Vector2(0, -9.8f), true);

        herobody = new HeroBody(world, GameModel.getInstance().getHero());

        new PortalBody(world, GameModel.getInstance().getPortal1());

        List<RareItemModel> rareItems = GameModel.getInstance().getRareItems();
        for (RareItemModel rare : rareItems)
            new RareItemBody(world, rare);


        List<PlatformsModel> normalPlatf=GameModel.getInstance().getNormalPlatf();
        for (PlatformsModel normal:normalPlatf)
            new PlatformsBody(world,normal);

        List<PlatfFastModel> fastPlatf =GameModel.getInstance().getFastPlatf();
        for (PlatfFastModel fast:fastPlatf)
            new PlatfFastBody(world,fast);

        List<PlatfLentaModel> lentaPlatf=GameModel.getInstance().getLentaPlatf();
        for (PlatfLentaModel lenta:lentaPlatf)
            new PlatfLentaBody(world,lenta);

        List<PlatfPicosModel> picosPlatf=GameModel.getInstance().getPicosPlatf();
        for (PlatfPicosModel picos:picosPlatf)
            new PlatfPicosBody(world,picos);

        List<PlatTilojosModel> tijolosPlatf =GameModel.getInstance().getTijoloPlatf();
        for (PlatTilojosModel tijolos:tijolosPlatf)
            new PlatTijolosBody(world,tijolos);


        List<AlienModel> aliens = GameModel.getInstance().getAliens();
        for (AlienModel alien : aliens)
            new AlienBody(world, alien);

        List<ConsumableModel> waters = GameModel.getInstance().getWaters();
        for (ConsumableModel water : waters)
            new ConsumableBody(world, water);

        world.setContactListener(this);
    }

    public static GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }

    public void update(float delta) {
        GameModel.getInstance().update(delta);
        timeToNextShoot -= delta;

        float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1 / 60f) {
            world.step(1 / 60f, 6, 2);
            accumulator -= 1 / 60f;
        }
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            verifyBounds(body);
            ((EntityModel) body.getUserData()).setPosition(body.getPosition().x, body.getPosition().y);
        }
    }

    private void verifyBounds(Body body) {
        /*if (body.getPosition().x < 0)
            body.setTransform(PANEL_WIDTH, body.getPosition().y, body.getAngle());

        if (body.getPosition().y < 0)
            body.setTransform(body.getPosition().x, PANEL_HEIGHT, body.getAngle());

        if (body.getPosition().x > PANEL_WIDTH)
            body.setTransform(0, body.getPosition().y, body.getAngle());

        if (body.getPosition().y > PANEL_HEIGHT)
            body.setTransform(body.getPosition().x, 0, body.getAngle());*/
    }

    public World getWorld() {
        return world;
    }

    @Override
    public void endContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();
        //  onTheGround=false;
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatTilojosModel || bodyA.getUserData() instanceof PlatfLentaModel || bodyA.getUserData() instanceof PlatfPicosModel) && bodyB.getUserData() instanceof HeroModel) {
            onTheGround = false;
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatTilojosModel || bodyB.getUserData() instanceof PlatfLentaModel || bodyB.getUserData() instanceof PlatfPicosModel) && bodyA.getUserData() instanceof HeroModel) {
            onTheGround = false;
        }
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatTilojosModel || bodyA.getUserData() instanceof PlatfLentaModel || bodyA.getUserData() instanceof PlatfPicosModel) && bodyB.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyB.getUserData()).setInPlataform(false);
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatTilojosModel || bodyB.getUserData() instanceof PlatfLentaModel || bodyB.getUserData() instanceof PlatfPicosModel) && bodyA.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyA.getUserData()).setInPlataform(false);
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {
    }


    @Override
    public void beginContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();
        //onTheGround=false;
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatTilojosModel || bodyA.getUserData() instanceof PlatfLentaModel || bodyA.getUserData() instanceof PlatfPicosModel) && bodyB.getUserData() instanceof HeroModel) {
            onTheGround = true;
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatTilojosModel || bodyB.getUserData() instanceof PlatfLentaModel || bodyB.getUserData() instanceof PlatfPicosModel) && bodyA.getUserData() instanceof HeroModel) {
            onTheGround = true;
        }

        if (bodyA.getUserData() instanceof HeroModel && bodyB.getUserData() instanceof ComsumableModel) {
            //System.out.println("entrou!d1");
            ((ComsumableModel) bodyB.getUserData()).setFlaggedForRemoval(true);

        }
        if (bodyB.getUserData() instanceof HeroModel && bodyA.getUserData() instanceof ComsumableModel) {
            //System.out.println("entrou!d2");
            ((ComsumableModel) bodyA.getUserData()).setFlaggedForRemoval(true);

        }

        if (bodyA.getUserData() instanceof HeroModel && bodyB.getUserData() instanceof RareItemModel) {
            //System.out.println("entrou!d1");
            ((RareItemModel) bodyB.getUserData()).setFlaggedForRemoval(true);

        }
        if (bodyB.getUserData() instanceof HeroModel && bodyA.getUserData() instanceof RareItemModel) {
            //System.out.println("entrou!d2");
            ((RareItemModel) bodyA.getUserData()).setFlaggedForRemoval(true);

        }
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatTilojosModel || bodyA.getUserData() instanceof PlatfLentaModel || bodyA.getUserData() instanceof PlatfPicosModel) && bodyB.getUserData() instanceof AlienModel) {
            System.out.println("entrou!d1");
            ((AlienModel) bodyB.getUserData()).setInPlataform(true);
            ((AlienModel) bodyB.getUserData()).setxPlatform(((EntityModel) bodyA.getUserData()).getX());
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatTilojosModel || bodyB.getUserData() instanceof PlatfLentaModel || bodyB.getUserData() instanceof PlatfPicosModel) && bodyA.getUserData() instanceof AlienModel) {
            System.out.println("entrou!d1");
            ((AlienModel) bodyA.getUserData()).setInPlataform(true);
            ((AlienModel) bodyA.getUserData()).setxPlatform(((EntityModel) bodyB.getUserData()).getX());
        }


    }

    public void removeFlagged() {
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            if (((EntityModel) body.getUserData()).isFlaggedForRemoval()) {
                ((EntityModel) body.getUserData()).setFlaggedForRemoval(false);
                GameModel.getInstance().remove((EntityModel) body.getUserData());
                world.destroyBody(body);
            }
        }
    }

    public void AlienMovement() {

        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            if (body.getUserData() instanceof AlienModel) {
                if (((AlienModel) body.getUserData()).getInPlatform()) {
                    if ((((AlienModel) body.getUserData()).getX()  < (((AlienModel) body.getUserData()).getxPlatform()) + 6 )) {
                        if (((AlienModel) body.getUserData()).getX() - 0.1f <= (((AlienModel) body.getUserData()).getxPlatform())-6)
                            direction = false;
                        if (((AlienModel) body.getUserData()).getX() + 0.1f >= (((AlienModel) body.getUserData()).getxPlatform()+6))
                            direction = true;

                        if (direction)
                            body.setTransform(((AlienModel) body.getUserData()).getX() - 0.1f, ((AlienModel) body.getUserData()).getY(), 0);
                       else
                            body.setTransform(((AlienModel) body.getUserData()).getX() + 0.1f, ((AlienModel) body.getUserData()).getY(), 0);
                    }
                }
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

    public HeroBody getHerobody() {
        return herobody;
    }


    public boolean isPlayerOnTheGournd() {
        return onTheGround;
    }

    public boolean isCommingBack() {
        return back;
    }

    public void setCommingBack(boolean t) {
        back = t;
    }
}
