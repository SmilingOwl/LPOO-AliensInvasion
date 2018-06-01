package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.Entities.AlienAttackBody;
import com.mygdx.game.Controller.Entities.AlienBody;
import com.mygdx.game.Controller.Entities.ConsumableBody;
import com.mygdx.game.Controller.Entities.HeroBody;
import com.mygdx.game.Controller.Entities.PlatfBlocksBody;
import com.mygdx.game.Controller.Entities.PlatfFastBody;
import com.mygdx.game.Controller.Entities.PlatfSlowBody;
import com.mygdx.game.Controller.Entities.PlatfSpikesBody;
import com.mygdx.game.Controller.Entities.PlatformsBody;
import com.mygdx.game.Controller.Entities.PortalBody;
import com.mygdx.game.Controller.Entities.RareItemBody;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ConsumableModel;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.Entities.HeroModel;
import com.mygdx.game.Model.Entities.PlatfBlocksModel;
import com.mygdx.game.Model.Entities.PlatfFastModel;
import com.mygdx.game.Model.Entities.PlatfSlowModel;
import com.mygdx.game.Model.Entities.PlatfSpikesModel;
import com.mygdx.game.Model.Entities.PlatformsModel;
import com.mygdx.game.Model.Entities.PortalModel;
import com.mygdx.game.Model.Entities.RareItemModel;
import com.mygdx.game.Model.GameModel;

import java.util.List;

public class GameController implements ContactListener {

    /**
     * The singleton instance of this controller
     */
    private static GameController instance;

    /**
     * the current game
     */
    protected AliensGame game;

    /**
     * file to save the scores
     */
    private Preferences prefs;

    /**
     * The time between aliens shots
     */
    private static final float TIME_BETWEEN_SHOTS = .8f;

    /**
     *the time the hero is protected
     */
    private static final float PROTECTION_TIME = 5f;

    /**
     * The physics world controlled by this controller.
     */
    private final World world;

    /**
     * the hero body
     */
    private final HeroBody herobody;

    /**
     * variable that determines if a by is on the platform
     */
    private boolean onTheGround = false;

    /**
     * variable thar determines if the body is going backwards
     */
    private boolean back = false;

    /**
     * accumulator used to calculate the simulation step.
     */
    private float accumulator = 0;

    /**
     * score counter
     */
    private int Score = 0;

    /**
     * time to the next shot
     */
    private float timeToNextShoot;

    /**
     *time hero is protected
     */
    private float protectionTime;

    /**
     * Game Controller constructor
     */
    private GameController() {
        timeToNextShoot = -1;
        protectionTime = PROTECTION_TIME;
        world = new World(new Vector2(0, -9.8f), true);
        prefs = Gdx.app.getPreferences("My Preferences");
        herobody = new HeroBody(world, GameModel.getInstance().getHero());

        new PortalBody(world, GameModel.getInstance().getPortal1());

        List<RareItemModel> rareItems = GameModel.getInstance().getRareItems();
        for (RareItemModel rare : rareItems)
            new RareItemBody(world, rare);


        List<PlatformsModel> normalPlatf = GameModel.getInstance().getNormalPlatf();
        for (PlatformsModel normal : normalPlatf)
            new PlatformsBody(world, normal);

        List<PlatfFastModel> fastPlatf = GameModel.getInstance().getFastPlatf();
        for (PlatfFastModel fast : fastPlatf)
            new PlatfFastBody(world, fast);

        List<PlatfSlowModel> lentaPlatf = GameModel.getInstance().getLentaPlatf();
        for (PlatfSlowModel lenta : lentaPlatf)
            new PlatfSlowBody(world, lenta);

        List<PlatfSpikesModel> picosPlatf = GameModel.getInstance().getPicosPlatf();
        for (PlatfSpikesModel picos : picosPlatf)
            new PlatfSpikesBody(world, picos);

        List<PlatfBlocksModel> tijolosPlatf = GameModel.getInstance().getTijoloPlatf();
        for (PlatfBlocksModel tijolos : tijolosPlatf)
            new PlatfBlocksBody(world, tijolos);

        List<AlienModel> aliens = GameModel.getInstance().getAliens();
        for (AlienModel alien : aliens)
            new AlienBody(world, alien);

        List<ConsumableModel> waters = GameModel.getInstance().getWaters();
        for (ConsumableModel water : waters)
            new ConsumableBody(world, water);

        world.setContactListener(this);
    }

    /**
     * Gets the prefs
     * @return prefs
     */
    public Preferences getPrefs() {
        return prefs;
    }

    /**
     * This function saves the score
     */
    public void saveScore() {
        int x1= prefs.getInteger("score");
        int x2= prefs.getInteger("score2");
        if (!prefs.contains("score") ||!prefs.contains("score2") ||!prefs.contains("score3") ) {
            prefs.putInteger("score", Score);
            prefs.putInteger("score2" ,Score);
            prefs.putInteger("score3",Score);
            prefs.flush();
        } else if (prefs.getInteger("score") < Score) {
            prefs.putInteger("score", Score);
            prefs.putInteger("score2",x1);
            prefs.putInteger("score3",x2);
            prefs.flush();
        }

        if(Score < prefs.getInteger("score2") && Score > prefs.getInteger("score3")){
            prefs.putInteger("score3",Score);
           prefs.flush();

        }
        if(Score > prefs.getInteger("score2") && Score < prefs.getInteger("score")){
            prefs.putInteger("score2",Score);
            prefs.putInteger("score3",x2);
            prefs.flush();
        }

    }

    /**
     * gets the score
     * @return score
     */
    public int getScore() {
        return Score;
    }

    /**
     * gets the game instance
     * @return the game instance
     */
    public static GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }

    /**
     * reset the game instance
     */
    public void resetInstance(){
        if(instance!=null)
          instance=new GameController();
    }

    /**
     * Calculates the next physics step of duration delta (in seconds).
     *
     * @param delta The size of this physics step in seconds.
     */
    public void update(float delta) {
        GameModel.getInstance().update(delta);
        timeToNextShoot -= delta;
        if (GameModel.getInstance().getHero().getIsArmed()) {
            protectionTime -= delta;

        }
        if (protectionTime <= 0) {
            GameModel.getInstance().getHero().setIsArmed(false);
            protectionTime = PROTECTION_TIME;
        }
        float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        Score += 1;
        while (accumulator >= 1 / 60f) {
            world.step(1 / 60f, 6, 2);
            accumulator -= 1 / 60f;
        }
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            ((EntityModel) body.getUserData()).setPosition(body.getPosition().x, body.getPosition().y);
        }
    }

    /**
     * Gets the world
     * @return world
     */
    public World getWorld() {
        return world;
    }

    /**
     * deals with the contact between hero and platforms
     * @param contact
     */
    @Override
    public void endContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();

        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatfBlocksModel || bodyA.getUserData() instanceof PlatfSlowModel || bodyA.getUserData() instanceof PlatfSpikesModel) && bodyB.getUserData() instanceof HeroModel) {
            onTheGround = false;
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatfBlocksModel || bodyB.getUserData() instanceof PlatfSlowModel || bodyB.getUserData() instanceof PlatfSpikesModel) && bodyA.getUserData() instanceof HeroModel) {
            onTheGround = false;
        }
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatfBlocksModel || bodyA.getUserData() instanceof PlatfSlowModel || bodyA.getUserData() instanceof PlatfSpikesModel) && bodyB.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyB.getUserData()).setInPlatform(false);
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatfBlocksModel || bodyB.getUserData() instanceof PlatfSlowModel || bodyB.getUserData() instanceof PlatfSpikesModel) && bodyA.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyA.getUserData()).setInPlatform(false);

        }

    }

    /**
     * Decrease hero´s life when hero collides with spikes or alien´s bullets
     * @param bodyB
     */
    public void decreaseLife(Body bodyB) {
        if (((HeroModel) bodyB.getUserData()).getLife() == 0) {
            GameModel.getInstance().getHero().setLose(true);
        } else if (((HeroModel) bodyB.getUserData()).getLife() > 0)
            ((HeroModel) bodyB.getUserData()).setLife(((HeroModel) bodyB.getUserData()).getLife() - 1);
    }

    /***
     * Increase hero´s life when hero collides with water bottle
     * @param bodyB
     */
    public void addLife(Body bodyB) {
        if (((HeroModel) bodyB.getUserData()).getLife() < 5)
            ((HeroModel) bodyB.getUserData()).setLife(((HeroModel) bodyB.getUserData()).getLife() + 1);
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

        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatfBlocksModel || bodyA.getUserData() instanceof PlatfSlowModel || bodyA.getUserData() instanceof PlatfSpikesModel) && bodyB.getUserData() instanceof HeroModel) {
            if (bodyA.getUserData() instanceof PlatformsModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.1f);
            if (bodyA.getUserData() instanceof PlatfFastModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.3f);
            if (bodyA.getUserData() instanceof PlatfBlocksModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.2f);
            if (bodyA.getUserData() instanceof PlatfSlowModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.08f);
            if (bodyA.getUserData() instanceof PlatfSpikesModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.1f);
            onTheGround = true;
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatfBlocksModel || bodyB.getUserData() instanceof PlatfSlowModel || bodyB.getUserData() instanceof PlatfSpikesModel) && bodyA.getUserData() instanceof HeroModel) {
            if (bodyB.getUserData() instanceof PlatformsModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.1f);
            if (bodyB.getUserData() instanceof PlatfFastModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.3f);
            if (bodyB.getUserData() instanceof PlatfBlocksModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.2f);
            if (bodyB.getUserData() instanceof PlatfSlowModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.08f);
            if (bodyB.getUserData() instanceof PlatfSpikesModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.1f);
            onTheGround = true;
        }
        if (bodyA.getUserData() instanceof PlatfSpikesModel && bodyB.getUserData() instanceof HeroModel) {
            decreaseLife(bodyB);
        }
        if (bodyB.getUserData() instanceof PlatfSpikesModel && bodyA.getUserData() instanceof HeroModel) {
            decreaseLife(bodyA);
        }

        if (bodyA.getUserData() instanceof HeroModel && bodyB.getUserData() instanceof ConsumableModel) {
            ((ConsumableModel) bodyB.getUserData()).setFlaggedForRemoval(true);
            Score += 30;
            addLife(bodyA);

        }
        if (bodyB.getUserData() instanceof HeroModel && bodyA.getUserData() instanceof ConsumableModel) {
            ((ConsumableModel) bodyA.getUserData()).setFlaggedForRemoval(true);
            Score += 30;
            addLife(bodyB);

        }

        if (bodyA.getUserData() instanceof HeroModel && bodyB.getUserData() instanceof RareItemModel) {
            ((RareItemModel) bodyB.getUserData()).setFlaggedForRemoval(true);
            Score += 40;
            ((HeroModel) bodyA.getUserData()).setIsArmed(true);
        }

        if (bodyB.getUserData() instanceof HeroModel && bodyA.getUserData() instanceof RareItemModel) {
            ((RareItemModel) bodyA.getUserData()).setFlaggedForRemoval(true);
            Score += 40;
            ((HeroModel) bodyB.getUserData()).setIsArmed(true);

        }

        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatfBlocksModel || bodyA.getUserData() instanceof PlatfSlowModel || bodyA.getUserData() instanceof PlatfSpikesModel) && bodyB.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyB.getUserData()).setInPlatform(true);
            ((AlienModel) bodyB.getUserData()).setXPlatform(((EntityModel) bodyA.getUserData()).getX());
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatfBlocksModel || bodyB.getUserData() instanceof PlatfSlowModel || bodyB.getUserData() instanceof PlatfSpikesModel) && bodyA.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyA.getUserData()).setInPlatform(true);
            ((AlienModel) bodyA.getUserData()).setXPlatform(((EntityModel) bodyB.getUserData()).getX());
        }

        if (bodyA.getUserData() instanceof PortalModel && bodyB.getUserData() instanceof HeroModel) {
            Score += 50;
            ((HeroModel) bodyB.getUserData()).setWin(true);
        }

        if (bodyB.getUserData() instanceof PortalModel && bodyA.getUserData() instanceof HeroModel) {
            Score += 50;
            ((HeroModel) bodyA.getUserData()).setWin(true);

        }

        if (bodyA.getUserData() instanceof AlienModel && bodyB.getUserData() instanceof HeroModel) {
            Score += 30;
            ((AlienModel) bodyA.getUserData()).setFlaggedForRemoval(true);

        }
        if (bodyB.getUserData() instanceof AlienModel && bodyA.getUserData() instanceof HeroModel) {
            Score += 30;
            ((AlienModel) bodyB.getUserData()).setFlaggedForRemoval(true);

        }

        if (bodyA.getUserData() instanceof AlienAttackModel && bodyB.getUserData() instanceof HeroModel) {
            decreaseLife(bodyB);
            Score -= 300;
            ((AlienAttackModel) bodyA.getUserData()).setFlaggedForRemoval(true);

        }
        if (bodyB.getUserData() instanceof AlienAttackModel && bodyA.getUserData() instanceof HeroModel) {
            decreaseLife(bodyA);
            Score -= 300;
            ((AlienAttackModel) bodyB.getUserData()).setFlaggedForRemoval(true);
        }

    }

    /**
     * Deletes the bodies
     */
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

    /**
     * This function deals with aliens movement
     */
    public void AlienMovement() {

        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            if (body.getUserData() instanceof AlienModel) {
                if (((AlienModel) body.getUserData()).getInPlatform()) {
                    if ((((AlienModel) body.getUserData()).getX() < (((AlienModel) body.getUserData()).getXPlatform()) + 6)) {
                        if (((AlienModel) body.getUserData()).getX() - 0.1f <= (((AlienModel) body.getUserData()).getXPlatform()) - 6)
                            ((AlienModel) body.getUserData()).setDirection(false);
                        if (((AlienModel) body.getUserData()).getX() + 0.1f >= (((AlienModel) body.getUserData()).getXPlatform() + 6))
                            ((AlienModel) body.getUserData()).setDirection(true);

                        if (((AlienModel) body.getUserData()).getDirection() == true)
                            body.setTransform(((AlienModel) body.getUserData()).getX() - 0.1f, ((AlienModel) body.getUserData()).getY(), 0);
                        else
                            body.setTransform(((AlienModel) body.getUserData()).getX() + 0.1f, ((AlienModel) body.getUserData()).getY(), 0);
                    }
                }
            }
        }

    }

    /**
     * This function deals with aliens attack
     */
    public void shoot() {
        for (int i = 0; i < GameModel.getInstance().getAliens().size(); i++) {

            AlienAttackModel bullet = GameModel.getInstance().createAlienAttack(GameModel.getInstance().getAliens().get(i));
            AlienAttackBody body = new AlienAttackBody(world, bullet);
            if (GameModel.getInstance().getAliens().get(i).getDirection())
                body.setLinearVelocity(-15, 10);
            else
                body.setLinearVelocity(15, 10);
        }
    }

    /**
     * Sets the timeToNextShoot
     */
    public void setTime() {
        timeToNextShoot = TIME_BETWEEN_SHOTS;
    }

    /**
     * Gets the timeToNextShoot
     * @return timeToNextShoot
     */
    public float getTimeToShoot() {
        return timeToNextShoot;
    }

    /**
     * Gets hero body
     * @return hero body
     */
    public HeroBody getHeroBody() {
        return herobody;
    }

    /**
     * Gets onTheGround attribute
     * @return onTheGround
     */
    public boolean isPlayerOnTheGournd() {
        return onTheGround;
    }

    /**
     * Sets back
     * @param t value to update
     */
    public void setCommingBack(boolean t) {
        back = t;
    }
}
