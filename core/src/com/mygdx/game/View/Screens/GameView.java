package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import java.util.List;

import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ConsumableModel;
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
import com.mygdx.game.View.Entities.ViewFactory;


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
       // camera.zoom = camera.zoom + 5f;
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
        GameController.getInstance().AlienMovement();
        handleInputs(delta);

        GameController.getInstance().update(delta);
        float x = GameModel.getInstance().getHero().getX() / PIXEL_TO_METER;
        float y = GameModel.getInstance().getHero().getY() / PIXEL_TO_METER;
        //camera.position.set(GameModel.getInstance().getRare1().getX()/ PIXEL_TO_METER, GameModel.getInstance().getRare1().getY()/ PIXEL_TO_METER, 0);
       //camera.position.set(GameModel.getInstance().getAliens().get(0).getX()/ PIXEL_TO_METER, GameModel.getInstance().getAliens().get(0).getY()/ PIXEL_TO_METER, 0);
        /*
        if (y < (VIEWPORT_WIDTH / PIXEL_TO_METER * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth())) / 2)
            y = (VIEWPORT_WIDTH / PIXEL_TO_METER * ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth())) / 2;
        camera.position.set(x, y, 0);*/

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

        List<ConsumableModel> waters = GameModel.getInstance().getWaters();
        for (ConsumableModel water : waters) {
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

        List<PlatformsModel> normalPlatf=GameModel.getInstance().getNormalPlatf();
        for(PlatformsModel normal:normalPlatf)
        {
            EntityView view = ViewFactory.makeView(game, normal);
            view.update(normal);
            view.draw(game.getBatch());
        }

        List<PlatfFastModel> fastPlatf=GameModel.getInstance().getFastPlatf();
        for(PlatfFastModel fast:fastPlatf)
        {
            EntityView view = ViewFactory.makeView(game, fast);
            view.update(fast);
            view.draw(game.getBatch());
        }

        List<PlatfLentaModel> lentaPlatf=GameModel.getInstance().getLentaPlatf();
        for(PlatfLentaModel lenta:lentaPlatf)
        {
            EntityView view = ViewFactory.makeView(game, lenta);
            view.update(lenta);
            view.draw(game.getBatch());
        }

        List<PlatfPicosModel> picosPlatf=GameModel.getInstance().getPicosPlatf();
        for(PlatfPicosModel picos:picosPlatf)
        {
            EntityView view = ViewFactory.makeView(game, picos);
            view.update(picos);
            view.draw(game.getBatch());
        }

        List<PlatTilojosModel> tijolosPlatf=GameModel.getInstance().getTijoloPlatf();
        for(PlatTilojosModel tijolos:tijolosPlatf)
        {
            EntityView view = ViewFactory.makeView(game, tijolos);
            view.update(tijolos);
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
