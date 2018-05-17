package com.mygdx.game.Model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.Entities.AlienAttackModel;
import com.mygdx.game.Model.Entities.AlienModel;
import com.mygdx.game.Model.Entities.ComsumableModel;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.Entities.HeroModel;
import com.mygdx.game.Model.Entities.PlatformsModel;
import java.util.ArrayList;
import java.util.List;


/**
 * main class for logic
 */
public class GameModel implements Disposable {

    private static GameModel instance;
    private HeroModel hero;
    private PlatformsModel plat1;
    private PlatformsModel plat2;
    private List<AlienModel> aliens;
    private List<AlienAttackModel> AlienAttack;
    private List<ComsumableModel> waters;
    private static final int ALIEN_COUNT = 1;
    private static final int WATERS_COUNT = 1;

    //private GameState State;
    private Vector2 gravity = new Vector2(0f, -9.8f);

    public enum ModelState {
        WON,LOST, PAUSED, LIVE,
    }

   Pool<AlienAttackModel> alienAttackPool = new Pool<AlienAttackModel>(){
        @Override
        protected AlienAttackModel newObject(){
            return new AlienAttackModel(0,0);
        }
    };

    public static GameModel getInstance(){
        if( instance==null)
            instance= new GameModel();
        return instance;
    }
    private GameModel() {
        aliens = new ArrayList<AlienModel>();
        AlienAttack = new ArrayList<AlienAttackModel>();
        waters = new ArrayList<ComsumableModel>();
        hero = new HeroModel(GameController.PANEL_HEIGHT / 2 , GameController.PANEL_WIDTH / 2);
        plat1= new PlatformsModel(GameController.PANEL_HEIGHT / 2 , GameController.PANEL_WIDTH / 2);
        plat2 = new PlatformsModel(GameController.PANEL_HEIGHT / 2 , GameController.PANEL_WIDTH/2 +1);
        for (int i = 0; i < ALIEN_COUNT; i++) {
            // aliens.add(new AlienModel(random.nextFloat()* GameController.PANEL_WIDTH,random.nextFloat()* GameController.PANEL_HEIGHT,1,1));
            aliens.add(new AlienModel(GameController.PANEL_HEIGHT / 2 , GameController.PANEL_WIDTH / 2, 1, 0));


        }
        for (int i = 0; i < WATERS_COUNT; i++) {
            //waters.add(new ComsumableModel(GameController.PANEL_HEIGHT / 2, GameController.PANEL_WIDTH / 2));
            waters.add(new ComsumableModel(GameController.PANEL_HEIGHT / 2, GameController.PANEL_WIDTH / 2));

        }
    }
    public HeroModel getHero(){
        return hero;
    }
    public PlatformsModel getPlat1(){
        return plat1;
    }
    public PlatformsModel getPlat2(){
        return plat2;
    }
  public List<AlienModel> getAliens(){
        return aliens;
    }

    public List<ComsumableModel> getWaters(){ return waters;}
    public List<AlienAttackModel> getAlienAttack(){
        return AlienAttack;
    }
    public AlienAttackModel createAlienAttack(AlienModel alien ){
        AlienAttackModel attack = alienAttackPool.obtain();

         attack.setPosition( alien.getX(), alien.getY());
         attack.setTimeToLive(3f);
         AlienAttack.add(attack);
         return attack;
    }
    public void remove(EntityModel model){
        if(model instanceof AlienAttackModel){
            AlienAttack.remove(model);
            alienAttackPool.free((AlienAttackModel)model);
        }
        if(model instanceof AlienModel){
            aliens.remove(model);
        }
    }
    public void addAlien( AlienModel alienModel){
        aliens.add(alienModel);
    }
    public void addWater( ComsumableModel consumableModel){
        waters.add(consumableModel);

    }
    public void update(float delta){
        for(AlienAttackModel attack : AlienAttack)
            if(attack.decreaseTimeTolive(delta))
                attack.setFlaggedForRemoval(true);



    }
    @Override
    public void dispose() {

    }
}

