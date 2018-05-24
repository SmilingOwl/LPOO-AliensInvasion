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
import com.mygdx.game.Controller.Entities.PlatTijolosBody;
import com.mygdx.game.Controller.Entities.PlatfFastBody;
import com.mygdx.game.Controller.Entities.PlatfLentaBody;
import com.mygdx.game.Controller.Entities.PlatfPicosBody;
import com.mygdx.game.Controller.Entities.PlatformsBody;
import com.mygdx.game.Controller.Entities.PortalBody;
import com.mygdx.game.Controller.Entities.RareItemBody;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ComsumableModel;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.Entities.HeroModel;
import com.mygdx.game.Model.Entities.PlatTilojosModel;
import com.mygdx.game.Model.Entities.PlatfFastModel;
import com.mygdx.game.Model.Entities.PlatfLentaModel;
import com.mygdx.game.Model.Entities.PlatfPicosModel;
import com.mygdx.game.Model.Entities.PlatformsModel;
import com.mygdx.game.Model.Entities.RareItemModel;
import com.mygdx.game.Model.GameModel;
//import com.mygdx.game.Model.entities.AlienModel;
//import com.mygdx.game.Model.entities.EntityModel;

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
    private boolean direction=false;
    private boolean back = false;
    // private final PlatformsBody plat1Body;
    // private final PlatformsBody plat2Body;
    private float accumulator = 0;
    //  private List<PlatformsModel> PlatNivel1= new ArrayList<PlatformsModel>();
    private List<ComsumableModel> watersToadd = new ArrayList<ComsumableModel>();
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
       /* new RareItemBody(world,GameModel.getInstance().getRare1());
        new RareItemBody(world,GameModel.getInstance().getRare2());
        new RareItemBody(world,GameModel.getInstance().getRare3());*/
        /*heroB= new HeroBody(world, GameModel.getInstance().getHero());
        plat1Body= new PlatformsBody(world,GameModel.getInstance().getPlat1());
        plat2Body= new PlatformsBody(world,GameModel.getInstance().getPlat2());*/

       /* new PlatformsBody(world,GameModel.getInstance().getPortal1());
        List<RareItemModel> rareItems= GameModel.getInstance().getRareItems();
        for(RareItemModel rare: rareItems)
            new RareItemBody(world,rare);

        new PortalBody(world,GameModel.getInstance().getPortal1());
        List<RareItemModel> rareItems= GameModel.getInstance().getRareItems();
        for(RareItemModel rare: rareItems)
            new RareItemBody(world,rare);

        new PortalBody(world,GameModel.getInstance().getPortal1());
        List<RareItemModel> rareItems= GameModel.getInstance().getRareItems();
        for(RareItemModel rare: rareItems)
            new RareItemBody(world,rare);*/

        new PlatformsBody(world, GameModel.getInstance().getPlat1());
        new PlatformsBody(world, GameModel.getInstance().getPlat2());
        new PlatformsBody(world, GameModel.getInstance().getPlat3());
        new PlatformsBody(world, GameModel.getInstance().getPlat4());
        new PlatformsBody(world, GameModel.getInstance().getPlat5());
        new PlatformsBody(world, GameModel.getInstance().getPlat6());
        new PlatformsBody(world, GameModel.getInstance().getPlat7());
        new PlatformsBody(world, GameModel.getInstance().getPlat8());
        new PlatformsBody(world, GameModel.getInstance().getPlat9());
        new PlatformsBody(world, GameModel.getInstance().getPlat10());
        new PlatformsBody(world, GameModel.getInstance().getPlat11());
        new PlatformsBody(world, GameModel.getInstance().getPlat12());
        new PlatformsBody(world, GameModel.getInstance().getPlat13());
        new PlatformsBody(world, GameModel.getInstance().getPlat14());
        new PlatformsBody(world, GameModel.getInstance().getPlat15());
        new PlatformsBody(world, GameModel.getInstance().getPlat16());
        new PlatformsBody(world, GameModel.getInstance().getPlat17());

        new PlatfFastBody(world, GameModel.getInstance().getPlatFast1());
        new PlatfFastBody(world, GameModel.getInstance().getPlatFast2());
        new PlatfFastBody(world, GameModel.getInstance().getPlatFast3());
        new PlatfFastBody(world, GameModel.getInstance().getPlatFast4());

        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos1());
        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos2());
        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos3());
        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos4());
        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos5());
        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos6());
        new PlatfPicosBody(world, GameModel.getInstance().getPlatPicos7());

        new PlatfLentaBody(world, GameModel.getInstance().getPlatLenta1());
        new PlatfLentaBody(world, GameModel.getInstance().getPlatLenta2());
        new PlatfLentaBody(world, GameModel.getInstance().getPlatLenta3());
        new PlatfLentaBody(world, GameModel.getInstance().getPlatLenta4());
        new PlatfLentaBody(world, GameModel.getInstance().getPlatLenta5());
        new PlatfLentaBody(world, GameModel.getInstance().getPlatLenta6());

        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo1());
        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo2());
        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo3());
        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo4());
        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo5());
        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo6());
        new PlatTijolosBody(world, GameModel.getInstance().getPlatTijolo7());

        List<AlienModel> aliens = GameModel.getInstance().getAliens();
        for (AlienModel alien : aliens)
            new AlienBody(world, alien);
        List<ComsumableModel> waters = GameModel.getInstance().getWaters();
        for (ComsumableModel water : waters)
            new ComsumableBody(world, water);
      /* List<PlatformsModel> plats= GameModel.getInstance().getPlatNivel1();
        for(PlatformsModel plat: plats)
            new PlatformsBody(world,plat);*/
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
