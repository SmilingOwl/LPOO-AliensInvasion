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
import com.mygdx.game.Model.Entities.PortalModel;
import com.mygdx.game.Model.Entities.RareItemModel;
import com.mygdx.game.Model.GameModel;
import com.mygdx.game.View.Screens.GameOverMenu;
import com.mygdx.game.View.Screens.GameView;
import com.mygdx.game.View.Screens.VictoryMenu;


import java.util.ArrayList;
import java.util.List;

public class GameController implements ContactListener {

    private static GameController instance;
    protected AliensGame game;
    public static final int PANEL_WIDTH = 440;
    public static final int PANEL_HEIGHT = 70;
    private static final float ACCELERATION_FORCE = 1000f;
    private static final float ALIENATTACK_SPEED = 30f;
    private static final float HEROATTACK_SPEED = 30f;
    private Preferences prefs;
    private static final float TIME_BETWEEN_SHOTS = .8f;
    private static final float PROTECTION_TIME = 5f;
    private final World world;
    private final HeroBody herobody;
    private boolean onTheGround = false;
    private boolean back = false;
    //private boolean direction=false;
    private float accumulator = 0;
    private int Score = 0;
    private List<ConsumableModel> watersToadd = new ArrayList<ConsumableModel>();
    private List<AlienModel> aliensToadd = new ArrayList<AlienModel>();// acho que tenho que mudar
    private float timeToNextShoot;
    private float protectionTime;


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

        List<PlatfLentaModel> lentaPlatf = GameModel.getInstance().getLentaPlatf();
        for (PlatfLentaModel lenta : lentaPlatf)
            new PlatfLentaBody(world, lenta);

        List<PlatfPicosModel> picosPlatf = GameModel.getInstance().getPicosPlatf();
        for (PlatfPicosModel picos : picosPlatf)
            new PlatfPicosBody(world, picos);

        List<PlatTilojosModel> tijolosPlatf = GameModel.getInstance().getTijoloPlatf();
        for (PlatTilojosModel tijolos : tijolosPlatf)
            new PlatTijolosBody(world, tijolos);

        List<AlienModel> aliens = GameModel.getInstance().getAliens();
        for (AlienModel alien : aliens)
            new AlienBody(world, alien);

        List<ConsumableModel> waters = GameModel.getInstance().getWaters();
        for (ConsumableModel water : waters)
            new ConsumableBody(world, water);

        world.setContactListener(this);
    }

    public Preferences getPrefs() {
        return prefs;
    }

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

    public int getScore() {
        return Score;
    }

    public static GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }
    public void resetInstance(){
        if(instance!=null)
          instance=new GameController();
    }

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

    public void decreaseLife(Body bodyB) {
        if (((HeroModel) bodyB.getUserData()).getLife() == 0) {
            GameModel.getInstance().getHero().setLose(true);
        } else if (((HeroModel) bodyB.getUserData()).getLife() > 0)
            ((HeroModel) bodyB.getUserData()).setLife(((HeroModel) bodyB.getUserData()).getLife() - 1);
    }

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
        //onTheGround=false;

        //collision between platforms and hero
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatTilojosModel || bodyA.getUserData() instanceof PlatfLentaModel || bodyA.getUserData() instanceof PlatfPicosModel) && bodyB.getUserData() instanceof HeroModel) {
            if (bodyA.getUserData() instanceof PlatformsModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.1f);
            if (bodyA.getUserData() instanceof PlatfFastModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.3f);
            if (bodyA.getUserData() instanceof PlatTilojosModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.2f);
            if (bodyA.getUserData() instanceof PlatfLentaModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.08f);
            if (bodyA.getUserData() instanceof PlatfPicosModel)
                ((HeroModel) bodyB.getUserData()).setDeltaX(0.1f);
            onTheGround = true;
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatTilojosModel || bodyB.getUserData() instanceof PlatfLentaModel || bodyB.getUserData() instanceof PlatfPicosModel) && bodyA.getUserData() instanceof HeroModel) {
            if (bodyB.getUserData() instanceof PlatformsModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.1f);
            if (bodyB.getUserData() instanceof PlatfFastModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.3f);
            if (bodyB.getUserData() instanceof PlatTilojosModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.2f);
            if (bodyB.getUserData() instanceof PlatfLentaModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.08f);
            if (bodyB.getUserData() instanceof PlatfPicosModel)
                ((HeroModel) bodyA.getUserData()).setDeltaX(0.1f);
            onTheGround = true;
        }
        if (bodyA.getUserData() instanceof PlatfPicosModel && bodyB.getUserData() instanceof HeroModel) {
            decreaseLife(bodyB);
        }
        if (bodyB.getUserData() instanceof PlatfPicosModel && bodyA.getUserData() instanceof HeroModel) {
            decreaseLife(bodyA);
        }

        //collision between hero and water
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

        //collision between hero and rare item
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

        //collision between alien and platforms
        if ((bodyA.getUserData() instanceof PlatformsModel || bodyA.getUserData() instanceof PlatfFastModel || bodyA.getUserData() instanceof PlatTilojosModel || bodyA.getUserData() instanceof PlatfLentaModel || bodyA.getUserData() instanceof PlatfPicosModel) && bodyB.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyB.getUserData()).setInPlataform(true);
            ((AlienModel) bodyB.getUserData()).setxPlatform(((EntityModel) bodyA.getUserData()).getX());
        }
        if ((bodyB.getUserData() instanceof PlatformsModel || bodyB.getUserData() instanceof PlatfFastModel || bodyB.getUserData() instanceof PlatTilojosModel || bodyB.getUserData() instanceof PlatfLentaModel || bodyB.getUserData() instanceof PlatfPicosModel) && bodyA.getUserData() instanceof AlienModel) {
            ((AlienModel) bodyA.getUserData()).setInPlataform(true);
            ((AlienModel) bodyA.getUserData()).setxPlatform(((EntityModel) bodyB.getUserData()).getX());
        }

        // collision between hero and portal
        if (bodyA.getUserData() instanceof PortalModel && bodyB.getUserData() instanceof HeroModel) {
            Score += 50;
            ((HeroModel) bodyB.getUserData()).setWin(true);


        }
        if (bodyB.getUserData() instanceof PortalModel && bodyA.getUserData() instanceof HeroModel) {
            Score += 50;
            ((HeroModel) bodyA.getUserData()).setWin(true);

        }

        //collision between hero and alien
        if (bodyA.getUserData() instanceof AlienModel && bodyB.getUserData() instanceof HeroModel) {
            Score += 30;
            ((AlienModel) bodyA.getUserData()).setFlaggedForRemoval(true);

        }
        if (bodyB.getUserData() instanceof AlienModel && bodyA.getUserData() instanceof HeroModel) {
            Score += 30;
            ((AlienModel) bodyB.getUserData()).setFlaggedForRemoval(true);

        }

        //collision between hero and aliens attack
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
                    if ((((AlienModel) body.getUserData()).getX() < (((AlienModel) body.getUserData()).getxPlatform()) + 6)) {
                        if (((AlienModel) body.getUserData()).getX() - 0.1f <= (((AlienModel) body.getUserData()).getxPlatform()) - 6)
                            ((AlienModel) body.getUserData()).setDirection(false);
                        if (((AlienModel) body.getUserData()).getX() + 0.1f >= (((AlienModel) body.getUserData()).getxPlatform() + 6))
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

    public void setTime() {
        timeToNextShoot = TIME_BETWEEN_SHOTS;
    }

    public float getTimeToShoot() {
        return timeToNextShoot;
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
