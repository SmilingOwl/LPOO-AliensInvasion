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
import com.mygdx.game.Model.Entities.PlatTilojosModel;
import com.mygdx.game.Model.Entities.PlatfFastModel;
import com.mygdx.game.Model.Entities.PlatfLentaModel;
import com.mygdx.game.Model.Entities.PlatfPicosModel;
import com.mygdx.game.Model.Entities.PlatformsModel;


import java.util.ArrayList;
import java.util.List;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 * main class for logic
 */
public class GameModel implements Disposable {

    private static GameModel instance;
    protected ModelState currentState;
    private HeroModel hero;

    private PlatformsModel plat3;
    private PlatformsModel plat4;
    private PlatformsModel plat5;
    private PlatformsModel plat6;
    private PlatformsModel plat7;
    private PlatformsModel plat8;
    private PlatformsModel plat9;
    private PlatformsModel plat10;
    private PlatformsModel plat11;
    private PlatformsModel plat12;
    private PlatformsModel plat1;
    private PlatformsModel plat2;


    private PlatfFastModel platFast1;
    private PlatfFastModel platFast2;
    private PlatfFastModel platFast3;
    private PlatfFastModel platFast4;




    private PlatfPicosModel platPicos1;
    private PlatfPicosModel platPicos2;
    private PlatfPicosModel platPicos3;
    private PlatfPicosModel platPicos4;
    private PlatfPicosModel platPicos5;
    private PlatfPicosModel platPicos6;
    private PlatfPicosModel platPicos7;


    private PlatfLentaModel platLenta1;
    private PlatfLentaModel platLenta2;
    private PlatfLentaModel platLenta3;
    private PlatfLentaModel platLenta4;
    private PlatfLentaModel platLenta5;
    private PlatfLentaModel platLenta6;

    private PlatTilojosModel platTijolo1;
    private PlatTilojosModel platTijolo2;
    private PlatTilojosModel platTijolo3;
    private PlatTilojosModel platTijolo4;
    private PlatTilojosModel platTijolo5;
    private PlatTilojosModel platTijolo6;
    private PlatTilojosModel platTijolo7;
  //  private List<PlatformsModel> platNivel1;
    private List<AlienModel> aliens;
    private List<AlienAttackModel> AlienAttack;
    private List<ComsumableModel> waters;
    private static final int ALIEN_COUNT = 1;
    private static final int WATERS_COUNT = 1;

    //private GameState State;
    private Vector2 gravity = new Vector2(0f, -9.8f);


    public enum ModelState {
        PAUSED, LIVE, WON, LOST
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
        hero = new HeroModel(4, 12);
        plat1= new PlatformsModel(3, 10);
        plat2 = new PlatformsModel(17 , 14);
        plat3= new PlatformsModel(56, 25);
        plat4 = new PlatformsModel(95 , 35);
        plat5= new PlatformsModel(115, 25);

        plat6 = new PlatformsModel(160 , 24);
        plat7= new PlatformsModel(200, 44);
        plat8 = new PlatformsModel(17 , 14);
        plat9= new PlatformsModel(180, 35);
        plat10 = new PlatformsModel(240, 30);

        plat11= new PlatformsModel(3, 10);
        plat12 = new PlatformsModel(17 , 14);




        platFast1= new PlatfFastModel(80 , 30);
        platFast2= new PlatfFastModel(220, 35);
        platFast3= new PlatfFastModel(80 , 30);
        platFast4= new PlatfFastModel(80 , 30);

        platPicos1= new PlatfPicosModel(43, 21);
        platPicos2= new PlatfPicosModel(0 , 0);
        platPicos3= new PlatfPicosModel(0 , 0);
        platPicos4= new PlatfPicosModel(0 , 0);
        platPicos5= new PlatfPicosModel(0 , 0);
        platPicos6= new PlatfPicosModel(0 , 0);
        platPicos7= new PlatfPicosModel(0 , 0);

        platLenta1= new PlatfLentaModel(140 , 26 );
        platLenta2= new PlatfLentaModel(175 , 28 );
        platLenta3= new PlatfLentaModel(1 , 6 );
        platLenta4= new PlatfLentaModel(1 , 6 );
        platLenta5= new PlatfLentaModel(1 , 6 );
        platLenta6= new PlatfLentaModel(1 , 6 );


        platTijolo1= new PlatTilojosModel(28, 18);
        platTijolo2= new PlatTilojosModel(69, 18);
        platTijolo3= new PlatTilojosModel(125, 30);
        platTijolo4= new PlatTilojosModel(28, 18);
        platTijolo5= new PlatTilojosModel(28, 18);
        platTijolo6= new PlatTilojosModel(28, 18);
        platTijolo7= new PlatTilojosModel(28, 18);



        for (int i = 0; i < ALIEN_COUNT; i++) {
            // aliens.add(new AlienModel(random.nextFloat()* GameController.PANEL_WIDTH,random.nextFloat()* GameController.PANEL_HEIGHT,1,1));
            aliens.add(new AlienModel(GameController.PANEL_HEIGHT / 2 - 100, GameController.PANEL_WIDTH / 2-45, 1, 0));


        }
        for (int i = 0; i < WATERS_COUNT; i++) {
            waters.add(new ComsumableModel(GameController.PANEL_HEIGHT / 2, GameController.PANEL_WIDTH / 2));

        }
    }
    public PlatfFastModel getPlatFast1(){return platFast1;}
    public PlatfFastModel getPlatFast2(){return platFast2;}
    public PlatfFastModel getPlatFast3(){return platFast3;}
    public PlatfFastModel getPlatFast4(){return platFast4;}

    public HeroModel getHero()
    {
        return hero;
    }

    public PlatfPicosModel getPlatPicos1(){ return platPicos1;}
    public PlatfPicosModel getPlatPicos2(){ return platPicos2;}
    public PlatfPicosModel getPlatPicos3(){ return platPicos3;}
    public PlatfPicosModel getPlatPicos4(){ return platPicos4;}
    public PlatfPicosModel getPlatPicos5(){ return platPicos5;}
    public PlatfPicosModel getPlatPicos6(){ return platPicos6;}
    public PlatfPicosModel getPlatPicos7(){ return platPicos7;}

    public PlatformsModel getPlat1()
    {
        return plat1;
    }
    public PlatformsModel getPlat2()
    {
        return plat2;
    }
    public PlatformsModel getPlat3()
    {
        return plat3;
    }
    public PlatformsModel getPlat4()
    {
        return plat4;
    }
    public PlatformsModel getPlat5()
    {
        return plat5;
    }
    public PlatformsModel getPlat6()
    {
        return plat6;
    }
    public PlatformsModel getPlat7()
    {
        return plat7;
    }
    public PlatformsModel getPlat8()
    {
        return plat8;
    }
    public PlatformsModel getPlat9()
    {
        return plat9;
    }
    public PlatformsModel getPlat10()
    {
        return plat10;
    }
    public PlatformsModel getPlat11()
    {
        return plat11;
    }
    public PlatformsModel getPlat12()
    {
        return plat12;
    }

    public PlatTilojosModel getPlatTijolo1(){ return platTijolo1;}
    public PlatTilojosModel getPlatTijolo2(){ return platTijolo2;}
    public PlatTilojosModel getPlatTijolo3(){ return platTijolo3;}
    public PlatTilojosModel getPlatTijolo4(){ return platTijolo4;}
    public PlatTilojosModel getPlatTijolo5(){ return platTijolo5;}
    public PlatTilojosModel getPlatTijolo6(){ return platTijolo6;}
    public PlatTilojosModel getPlatTijolo7(){ return platTijolo7;}

    public PlatfLentaModel getPlatLenta1(){ return platLenta1;}
    public PlatfLentaModel getPlatLenta2(){ return platLenta2;}
    public PlatfLentaModel getPlatLenta3(){ return platLenta3;}
    public PlatfLentaModel getPlatLenta4(){ return platLenta4;}
    public PlatfLentaModel getPlatLenta5(){ return platLenta5;}
    public PlatfLentaModel getPlatLenta6(){ return platLenta6;}





  public List<AlienModel> getAliens(){
        return aliens;
    }
/*public List<PlatformsModel> getPlatNivel1(){return platNivel1;}*/
    public List<ComsumableModel> getWaters()
    { return waters;}

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

    public void PauseController() {
        if (currentState == ModelState.PAUSED)
            currentState = ModelState.LIVE;
        else
            currentState = ModelState.PAUSED;
    }

}
