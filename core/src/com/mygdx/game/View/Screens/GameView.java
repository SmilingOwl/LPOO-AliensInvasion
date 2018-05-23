package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import java.util.List;

/*import com.aor.arena.AsteroidArena;
import com.aor.arena.controller.GameController;
import com.aor.arena.model.entities.AsteroidModel;
import com.aor.arena.model.GameModel;
import com.aor.arena.model.entities.BulletModel;
import com.aor.arena.model.entities.ShipModel;
import com.aor.arena.view.entities.BigAsteroidView;
import com.aor.arena.view.entities.BulletView;
import com.aor.arena.view.entities.EntityView;
import com.aor.arena.view.entities.MediumAsteroidView;
import com.aor.arena.view.entities.ShipView;
import com.aor.arena.view.entities.ViewFactory;*/
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ComsumableModel;
import com.mygdx.game.Model.Entities.HeroModel;
import com.mygdx.game.Model.Entities.PlatTilojosModel;
import com.mygdx.game.Model.Entities.PlatfFastModel;
import com.mygdx.game.Model.Entities.PlatfLentaModel;
import com.mygdx.game.Model.Entities.PlatfPicosModel;
import com.mygdx.game.Model.Entities.PlatformsModel;
import com.mygdx.game.Model.Entities.PortalModel;
import com.mygdx.game.Model.Entities.RareItemModel;
import com.mygdx.game.Model.GameModel;
import com.mygdx.game.View.Entities.EntityView;
import com.mygdx.game.View.Entities.HeroView;
import com.mygdx.game.View.Entities.ViewFactory;

import java.util.List;

//import static com.aor.arena.controller.GameController.ARENA_HEIGHT;
//import static com.aor.arena.controller.GameController.ARENA_WIDTH;

/**
 * A view representing the game screen. Draws all the other views and
 * controls the camera.
 */
public class GameView extends ScreenAdapter {
    public static final int PANEL_WIDTH = 660;
    public static final int PANEL_HEIGHT = 55;
    /**
     * Used to debug the position of the physics fixtures
     */
    private static final boolean DEBUG_PHYSICS = true;

    /**
     * How much meters does a pixel represent.
     */
    public final static float PIXEL_TO_METER = 0.04f;

    /**
     * The width of the viewport in meters. The height is
     * automatically calculated using the screen ratio.
     */
    private static final float VIEWPORT_WIDTH = 50;

    /**
     * The game this screen belongs to.
     */
    private final AliensGame game;

    /**
     * The camera used to show the viewport.
     */
    private final OrthographicCamera camera;

    /**
     * A renderer used to debug the physical fixtures.
     */
    private Box2DDebugRenderer debugRenderer;

    /**
     * The transformation matrix used to transform meters into
     * pixels in order to show fixtures in their correct places.
     */
    private Matrix4 debugCamera;

    /**
     * Creates this screen.
     *
     * @param game The game this screen belongs to
     */
    public GameView(AliensGame game) {
        this.game = game;

        loadAssets();

        camera = createCamera();
    }

    boolean gyroscopeAvail = Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope);

    /**
     * Creates the camera used to show the viewport.
     *
     * @return the camera
     */
    private OrthographicCamera createCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH / PIXEL_TO_METER, VIEWPORT_WIDTH / PIXEL_TO_METER * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth()));

        camera.position.set(camera.viewportWidth + 10000, camera.viewportHeight, 0);
        camera.zoom = camera.zoom + 5f;
        camera.update();

        if (DEBUG_PHYSICS) {
            debugRenderer = new Box2DDebugRenderer();
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PIXEL_TO_METER);
        }

        return camera;
    }

    /**
     * Loads the assets needed by this screen.
     */
    private void loadAssets() {

        this.game.getAssetManager().load("aliens.png", Texture.class);
        this.game.getAssetManager().load("apple.png", Texture.class);
        this.game.getAssetManager().load("arrow.png", Texture.class);
        this.game.getAssetManager().load("gun.png", Texture.class);
        this.game.getAssetManager().load("Hp.png", Texture.class);
        this.game.getAssetManager().load("output-0.png", Texture.class);
        this.game.getAssetManager().load("output-1.png", Texture.class);
        this.game.getAssetManager().load("output-2.png", Texture.class);
        this.game.getAssetManager().load("output-3.png", Texture.class);
        this.game.getAssetManager().load("output-4.png", Texture.class);
        this.game.getAssetManager().load("output-5.png", Texture.class);
        this.game.getAssetManager().load("output-6.png", Texture.class);
        this.game.getAssetManager().load("plat1.png", Texture.class);
        this.game.getAssetManager().load("output7.png", Texture.class);
        this.game.getAssetManager().load("allHero.png", Texture.class);
        this.game.getAssetManager().load("allHeroB.png", Texture.class);
        this.game.getAssetManager().load("water.png", Texture.class);
        this.game.getAssetManager().load("Fireball.png", Texture.class);
        this.game.getAssetManager().load("background.png", Texture.class);
        this.game.getAssetManager().load("platfmuro1.png", Texture.class);
        this.game.getAssetManager().load("platfpicos.png", Texture.class);
        this.game.getAssetManager().load("platfrapida2.png", Texture.class);
        this.game.getAssetManager().load("platTerra-1.png", Texture.class);
        this.game.getAssetManager().load("Portal.png", Texture.class);
        this.game.getAssetManager().load("RareItem.png", Texture.class);
        this.game.getAssetManager().finishLoading();
    }

    /**
     * Renders this screen.
     *
     * @param delta time since last renders in seconds.
     */
    @Override
    public void render(float delta) {
        GameController.getInstance().removeFlagged();
        //GameController.getInstance().createNewAsteroids();

        handleInputs(delta);

        GameController.getInstance().update(delta);
        float x = GameModel.getInstance().getHero().getX() / PIXEL_TO_METER;
        float y = GameModel.getInstance().getHero().getY() / PIXEL_TO_METER;
        //camera.position.set(GameModel.getInstance().getRare1().getX()/ PIXEL_TO_METER, GameModel.getInstance().getRare1().getY()/ PIXEL_TO_METER, 0);
        //camera.position.set(GameModel.getInstance().getWaters().get(0).getX()/ PIXEL_TO_METER, GameModel.getInstance().getWaters().get(0).getY()/ PIXEL_TO_METER, 0);
        if (y < (VIEWPORT_WIDTH / PIXEL_TO_METER * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth())) / 2)
            y = (VIEWPORT_WIDTH / PIXEL_TO_METER * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth())) / 2;
        camera.position.set(x, y, 0);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(103 / 255f, 69 / 255f, 117 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        game.getBatch().begin();
        drawBackground();
        drawEntities();


        game.getBatch().end();

        if (DEBUG_PHYSICS) {
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PIXEL_TO_METER);
            debugRenderer.render(GameController.getInstance().getWorld(), debugCamera);
        }
    }

    /* /**
      * Handles any inputs and passes them to the controller.
      *
      * @param delta time since last time inputs where handled in seconds
      */
    private void handleInputs(float delta) {
        /*if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            GameController.getInstance().rotateLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            GameController.getInstance().rotateRight(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            GameController.getInstance().accelerate(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            GameController.getInstance().shoot();
        }
        if (Gdx.input.getGyroscopeX() > 0) {
            GameController.getInstance().rotateRight(delta * Gdx.input.getGyroscopeX());
        }
        if (Gdx.input.getGyroscopeX() < 0) {
            GameController.getInstance().rotateLeft(delta * -Gdx.input.getGyroscopeX());
        }
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2)
                GameController.getInstance().accelerate(delta);
            else
                GameController.getInstance().shoot();
        }*/
        if (Gdx.input.getAccelerometerY() > 0) {
            GameController.getInstance().getHerobody().setTransform(GameModel.getInstance().getHero().getX() + 0.1f, GameModel.getInstance().getHero().getY());
            GameController.getInstance().setCommingBack(false);
            GameModel.getInstance().setCommingBack(false);
            GameModel.getInstance().getHero().setCommingBack(false);


            //  GameController.getInstance().shoot();
            //  GameModel.getInstance().getHero().setPosition(3,3);
        } else if (Gdx.input.getAccelerometerY() < 0) {
            GameController.getInstance().getHerobody().setTransform(GameModel.getInstance().getHero().getX() - 0.1f, GameModel.getInstance().getHero().getY());
            GameController.getInstance().setCommingBack(true);
            GameModel.getInstance().setCommingBack(true);
            GameModel.getInstance().getHero().setCommingBack(true);
            //GameModel.getInstance().getHero().setPosition(0, GameModel.getInstance().getHero().getY()-1);
        }
        if (Gdx.input.isTouched()) {
            if (GameController.getInstance().isPlayerOnTheGournd()) {
                GameController.getInstance().getHerobody().applyForceToCenter(0, 1500, true);


            }
        }

        if (GameController.getInstance().isPlayerOnTheGournd()) {
            GameModel.getInstance().getHero().setJumping(false);
        } else
            GameModel.getInstance().getHero().setJumping(true);

    }


    /**
     * Draws the entities to the screen.
     */
    private void drawEntities() {
        List<AlienModel> aliens = GameModel.getInstance().getAliens();
        for (AlienModel alien : aliens) {
            EntityView view = ViewFactory.makeView(game, alien);
            view.update(alien);
            view.draw(game.getBatch());
        }
        List<ComsumableModel> waters = GameModel.getInstance().getWaters();
        for (ComsumableModel water : waters) {
            EntityView view = ViewFactory.makeView(game, water);
            view.update(water);
            view.draw(game.getBatch());
        }
        List<RareItemModel> rareItems = GameModel.getInstance().getRareItems();
        for (RareItemModel rare : rareItems) {
            EntityView view = ViewFactory.makeView(game, rare);
            view.update(rare);
            view.draw(game.getBatch());
        }


        List<AlienAttackModel> bullets = GameModel.getInstance().getAlienAttack();
        for (AlienAttackModel bullet : bullets) {
            EntityView view = ViewFactory.makeView(game, bullet);
            view.update(bullet);
            view.draw(game.getBatch());
        }

        HeroModel hero = GameModel.getInstance().getHero();
        EntityView view = ViewFactory.makeView(game, hero);
        view.update(hero);
        view.draw(game.getBatch());

        PortalModel portal1 = GameModel.getInstance().getPortal1();
        EntityView viewPortal1 = ViewFactory.makeView(game, portal1);
        viewPortal1.update(portal1);
        viewPortal1.draw(game.getBatch());


/* Plataformas normais*/
        PlatformsModel plat1 = GameModel.getInstance().getPlat1();
        EntityView view1 = ViewFactory.makeView(game, plat1);
        view1.update(plat1);
        view1.draw(game.getBatch());

        PlatformsModel plat2 = GameModel.getInstance().getPlat2();
        EntityView view2 = ViewFactory.makeView(game, plat2);
        view2.update(plat2);
        view2.draw(game.getBatch());

        PlatformsModel plat3 = GameModel.getInstance().getPlat3();
        EntityView view3 = ViewFactory.makeView(game, plat3);
        view3.update(plat3);
        view3.draw(game.getBatch());

        PlatformsModel plat4 = GameModel.getInstance().getPlat4();
        EntityView view4 = ViewFactory.makeView(game, plat4);
        view4.update(plat4);
        view4.draw(game.getBatch());

        PlatformsModel plat5 = GameModel.getInstance().getPlat5();
        EntityView view5 = ViewFactory.makeView(game, plat5);
        view5.update(plat5);
        view5.draw(game.getBatch());

        PlatformsModel plat6 = GameModel.getInstance().getPlat6();
        EntityView view6 = ViewFactory.makeView(game, plat4);
        view6.update(plat6);
        view6.draw(game.getBatch());

        PlatformsModel plat7 = GameModel.getInstance().getPlat7();
        EntityView view7 = ViewFactory.makeView(game, plat7);
        view7.update(plat7);
        view7.draw(game.getBatch());

        PlatformsModel plat8 = GameModel.getInstance().getPlat8();
        EntityView view8 = ViewFactory.makeView(game, plat8);
        view8.update(plat8);
        view8.draw(game.getBatch());

        PlatformsModel plat9 = GameModel.getInstance().getPlat9();
        EntityView view9 = ViewFactory.makeView(game, plat9);
        view9.update(plat9);
        view9.draw(game.getBatch());

        PlatformsModel plat10 = GameModel.getInstance().getPlat10();
        EntityView view10 = ViewFactory.makeView(game, plat10);
        view10.update(plat10);
        view10.draw(game.getBatch());


        PlatformsModel plat11 = GameModel.getInstance().getPlat11();
        EntityView view11 = ViewFactory.makeView(game, plat11);
        view11.update(plat11);
        view11.draw(game.getBatch());

        PlatformsModel plat12 = GameModel.getInstance().getPlat12();
        EntityView view12 = ViewFactory.makeView(game, plat12);
        view12.update(plat12);
        view12.draw(game.getBatch());


        PlatformsModel plat13 = GameModel.getInstance().getPlat13();
        EntityView view13 = ViewFactory.makeView(game, plat13);
        view13.update(plat13);
        view13.draw(game.getBatch());

        PlatformsModel plat14 = GameModel.getInstance().getPlat14();
        EntityView view14 = ViewFactory.makeView(game, plat14);
        view14.update(plat14);
        view14.draw(game.getBatch());

        PlatformsModel plat15 = GameModel.getInstance().getPlat15();
        EntityView view15 = ViewFactory.makeView(game, plat15);
        view15.update(plat15);
        view15.draw(game.getBatch());

        PlatformsModel plat16 = GameModel.getInstance().getPlat16();
        EntityView view16 = ViewFactory.makeView(game, plat16);
        view16.update(plat16);
        view16.draw(game.getBatch());

        PlatformsModel plat17 = GameModel.getInstance().getPlat17();
        EntityView view17 = ViewFactory.makeView(game, plat17);
        view17.update(plat17);
        view17.draw(game.getBatch());






        /* Plataformas Lentas*/
        PlatfLentaModel platLenta1 = GameModel.getInstance().getPlatLenta1();
        EntityView viewL1 = ViewFactory.makeView(game, platLenta1);
        viewL1.update(platLenta1);
        viewL1.draw(game.getBatch());

        PlatfLentaModel platLenta2 = GameModel.getInstance().getPlatLenta2();
        EntityView viewL2 = ViewFactory.makeView(game, platLenta2);
        viewL2.update(platLenta2);
        viewL2.draw(game.getBatch());


        PlatfLentaModel platLenta3 = GameModel.getInstance().getPlatLenta3();
        EntityView viewL3 = ViewFactory.makeView(game, platLenta3);
        viewL3.update(platLenta3);
        viewL3.draw(game.getBatch());

        PlatfLentaModel platLenta4 = GameModel.getInstance().getPlatLenta4();
        EntityView viewL4 = ViewFactory.makeView(game, platLenta4);
        viewL4.update(platLenta4);
        viewL4.draw(game.getBatch());

        PlatfLentaModel platLenta5 = GameModel.getInstance().getPlatLenta5();
        EntityView viewL5 = ViewFactory.makeView(game, platLenta5);
        viewL5.update(platLenta5);
        viewL5.draw(game.getBatch());

        PlatfLentaModel platLenta6 = GameModel.getInstance().getPlatLenta6();
        EntityView viewL6 = ViewFactory.makeView(game, platLenta6);
        viewL6.update(platLenta6);
        viewL6.draw(game.getBatch());



        /* Plataformas Tijolos Rapido 1*/

        PlatTilojosModel platTijolo1 = GameModel.getInstance().getPlatTijolo1();
        EntityView viewT1 = ViewFactory.makeView(game, platTijolo1);
        viewT1.update(platTijolo1);
        viewT1.draw(game.getBatch());

        PlatTilojosModel platTijolo2 = GameModel.getInstance().getPlatTijolo2();
        EntityView viewT2 = ViewFactory.makeView(game, platTijolo2);
        viewT2.update(platTijolo2);
        viewT2.draw(game.getBatch());

        PlatTilojosModel platTijolo3 = GameModel.getInstance().getPlatTijolo3();
        EntityView viewT3 = ViewFactory.makeView(game, platTijolo3);
        viewT3.update(platTijolo3);
        viewT3.draw(game.getBatch());

        PlatTilojosModel platTijolo4 = GameModel.getInstance().getPlatTijolo4();
        EntityView viewT4 = ViewFactory.makeView(game, platTijolo4);
        viewT4.update(platTijolo4);
        viewT4.draw(game.getBatch());

        PlatTilojosModel platTijolo5 = GameModel.getInstance().getPlatTijolo5();
        EntityView viewT5 = ViewFactory.makeView(game, platTijolo5);
        viewT5.update(platTijolo5);
        viewT5.draw(game.getBatch());
        PlatTilojosModel platTijolo6 = GameModel.getInstance().getPlatTijolo6();
        EntityView viewT6 = ViewFactory.makeView(game, platTijolo6);
        viewT6.update(platTijolo6);
        viewT6.draw(game.getBatch());
        PlatTilojosModel platTijolo7 = GameModel.getInstance().getPlatTijolo7();
        EntityView viewT7 = ViewFactory.makeView(game, platTijolo7);
        viewT7.update(platTijolo7);
        viewT7.draw(game.getBatch());



/* Plataformas Super rapidas 2*/

        PlatfFastModel platFast1 = GameModel.getInstance().getPlatFast1();
        EntityView viewf1 = ViewFactory.makeView(game, platFast1);
        viewf1.update(platFast1);
        viewf1.draw(game.getBatch());

        PlatfFastModel platFast2 = GameModel.getInstance().getPlatFast2();
        EntityView viewf2 = ViewFactory.makeView(game, platFast2);
        viewf2.update(platFast2);
        viewf2.draw(game.getBatch());

        PlatfFastModel platFast3 = GameModel.getInstance().getPlatFast3();
        EntityView viewf3 = ViewFactory.makeView(game, platFast3);
        viewf3.update(platFast3);
        viewf3.draw(game.getBatch());


        PlatfFastModel platFast4 = GameModel.getInstance().getPlatFast4();
        EntityView viewf4 = ViewFactory.makeView(game, platFast4);
        viewf4.update(platFast4);
        viewf4.draw(game.getBatch());

/* Plataformas Picos*/

        PlatfPicosModel platPicos1 = GameModel.getInstance().getPlatPicos1();
        EntityView viewP1 = ViewFactory.makeView(game, platPicos1);
        viewP1.update(platPicos1);
        viewP1.draw(game.getBatch());
        PlatfPicosModel platPicos2 = GameModel.getInstance().getPlatPicos2();
        EntityView viewP2 = ViewFactory.makeView(game, platPicos2);
        viewP2.update(platPicos2);
        viewP2.draw(game.getBatch());

        PlatfPicosModel platPicos3 = GameModel.getInstance().getPlatPicos3();
        EntityView viewP3 = ViewFactory.makeView(game, platPicos3);
        viewP3.update(platPicos3);
        viewP3.draw(game.getBatch());



        /*List<PlatformsModel> plats = GameModel.getInstance().getPlatNivel1();
        for (PlatformsModel plat : plats) {
            EntityView view3 = ViewFactory.makeView(game, plat);
            view3.update(plat);
            view3.draw(game.getBatch());
        }*/


    }

    /**
     * Draws the background
     */
    private void drawBackground() {
        Texture background = game.getAssetManager().get("background.png", Texture.class);
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.MirroredRepeat);
        game.getBatch().draw(background, 0 - camera.viewportWidth / 2 + 500, 100, 0, 0, (int) (PANEL_WIDTH / PIXEL_TO_METER), (int) (PANEL_HEIGHT / PIXEL_TO_METER));

        //Texture background1 = game.getAssetManager().get("background.png", Texture.class);
        // background1.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.MirroredRepeat);
        game.getBatch().draw(background, 0 - camera.viewportWidth / 2 + 1500, 100, 0, 0, (int) (PANEL_WIDTH / PIXEL_TO_METER), (int) (PANEL_HEIGHT / PIXEL_TO_METER));

    }
}
