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
import com.mygdx.game.Model.Entities.PortalModel;
import com.mygdx.game.Model.Entities.RareItemModel;


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
    private boolean back;

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
    private PlatformsModel plat13;
    private PlatformsModel plat14;
    private PlatformsModel plat15;
    private PlatformsModel plat16;
    private PlatformsModel plat17;


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


    private RareItemModel rare1;
    private RareItemModel rare2;
    private RareItemModel rare3;


    private PortalModel portal1;
    private List<AlienModel> aliens;
    private List<AlienAttackModel> AlienAttack;
    private List<ComsumableModel> waters;
    private List<RareItemModel> rareItems;
    //plataformas
    private List<PlatformsModel> normalPlatf;
    private List<PlatfFastModel> fastPlatf;
    private List<PlatfLentaModel> lentaPlatf;
    private List<PlatfPicosModel> picosPlatf;
    private List<PlatTilojosModel> tijoloPlatf;

    private static final int RAREITEMS_COUNT = 3;
    private static final int ALIEN_COUNT = 1;
    private static final int WATERS_COUNT = 7;
    private static final int picosPlatf_COUNT = 7;
    private static final int tijoloPlatf_COUNT = 7;
    private static final int lentaPlatf_COUNT = 6;
    private static final int normalPlatf_COUNT = 17;
    private static final int fastPlatf_COUNT= 4;

    //private GameState State;
    private Vector2 gravity = new Vector2(0f, -9.8f);


    public enum ModelState {
        PAUSED, LIVE, WON, LOST
    }

    Pool<AlienAttackModel> alienAttackPool = new Pool<AlienAttackModel>() {
        @Override
        protected AlienAttackModel newObject() {
            return new AlienAttackModel(0, 0);
        }
    };

    public static GameModel getInstance() {
        if (instance == null)
            instance = new GameModel();
        return instance;
    }

    public boolean isCommingBack() {
        return back;
    }

    public void setCommingBack(boolean t) {
        back = t;
        hero.setCommingBack(t);
    }

    private GameModel() {
        rare1 = new RareItemModel(485, 50);
        rare2 = new RareItemModel(95, 50);
        rare3 = new RareItemModel(240, 50);

        aliens = new ArrayList<AlienModel>();
        AlienAttack = new ArrayList<AlienAttackModel>();
        waters = new ArrayList<ComsumableModel>();
        rareItems = new ArrayList<RareItemModel>();
        rareItems.add(rare1);
        rareItems.add(rare2);
        rareItems.add(rare3);

        hero = new HeroModel(4, 12);
        portal1 = new PortalModel(585, 28);

        plat1 = new PlatformsModel(3, 10);
        plat2 = new PlatformsModel(17, 14);
        plat3 = new PlatformsModel(56, 25);
        plat4 = new PlatformsModel(95, 35);
        plat5 = new PlatformsModel(115, 25);
        plat6 = new PlatformsModel(160, 24);
        plat7 = new PlatformsModel(200, 40);
        plat8 = new PlatformsModel(17, 14);
        plat9 = new PlatformsModel(180, 35);
        plat10 = new PlatformsModel(240, 30);
        plat11 = new PlatformsModel(340, 30);
        plat12 = new PlatformsModel(357, 20);
        plat13 = new PlatformsModel(431, 24);
        plat14 = new PlatformsModel(450, 30);
        plat15 = new PlatformsModel(467, 20);
        plat16 = new PlatformsModel(487, 27);
        plat17 = new PlatformsModel(508, 33);


        platFast1 = new PlatfFastModel(80, 30);
        platFast2 = new PlatfFastModel(220, 35);
        platFast3 = new PlatfFastModel(260, 20);
        platFast4 = new PlatfFastModel(300, 30);

        platPicos1 = new PlatfPicosModel(43, 21);
        platPicos2 = new PlatfPicosModel(315, 25);
        platPicos3 = new PlatfPicosModel(540, 20);
        platPicos4 = new PlatfPicosModel(0, 0);
        platPicos5 = new PlatfPicosModel(0, 0);
        platPicos6 = new PlatfPicosModel(0, 0);
        platPicos7 = new PlatfPicosModel(0, 0);

        platLenta1 = new PlatfLentaModel(140, 26);
        platLenta2 = new PlatfLentaModel(175, 28);
        platLenta3 = new PlatfLentaModel(324, 35);
        platLenta4 = new PlatfLentaModel(370, 26);
        platLenta5 = new PlatfLentaModel(390, 30);
        platLenta6 = new PlatfLentaModel(525, 28);


        platTijolo1 = new PlatTilojosModel(28, 18);
        platTijolo2 = new PlatTilojosModel(69, 18);
        platTijolo3 = new PlatTilojosModel(125, 30);
        platTijolo4 = new PlatTilojosModel(280, 25);
        platTijolo5 = new PlatTilojosModel(410, 18);
        platTijolo6 = new PlatTilojosModel(568, 18);
        platTijolo7 = new PlatTilojosModel(550, 34);


        for (int i = 0; i < ALIEN_COUNT; i++) {
            // aliens.add(new AlienModel(random.nextFloat()* GameController.PANEL_WIDTH,random.nextFloat()* GameController.PANEL_HEIGHT,1,1));
            if (i == 0)
                aliens.add(new AlienModel(65, 50, 1, 0));


        }
        for (int i = 0; i < WATERS_COUNT; i++) {
            if (i == 0)
                waters.add(new ComsumableModel(355, 30));
            if (i == 1)
                waters.add(new ComsumableModel(410, 30));
            if (i == 2)
                waters.add(new ComsumableModel(505, 40));
            if (i == 3)
                waters.add(new ComsumableModel(155, 45));
            if (i == 4)
                waters.add(new ComsumableModel(55, 40));
            /*if(i==5)
                waters.add(new ComsumableModel(55, 30));
            if(i==5)
                waters.add(new ComsumableModel(55, 30));
            if(i==7)
                waters.add(new ComsumableModel(55, 30));*/

        }
    }

    public PlatfFastModel getPlatFast1() {
        return platFast1;
    }

    public PlatfFastModel getPlatFast2() {
        return platFast2;
    }

    public PlatfFastModel getPlatFast3() {
        return platFast3;
    }

    public PlatfFastModel getPlatFast4() {
        return platFast4;
    }

    public HeroModel getHero() {
        return hero;
    }

    public PortalModel getPortal1() {
        return portal1;
    }

    public RareItemModel getRare1() {
        return rare1;
    }

    public RareItemModel getRare2() {
        return rare2;
    }

    public RareItemModel getRare3() {
        return rare3;
    }

    public PlatfPicosModel getPlatPicos1() {
        return platPicos1;
    }

    public PlatfPicosModel getPlatPicos2() {
        return platPicos2;
    }

    public PlatfPicosModel getPlatPicos3() {
        return platPicos3;
    }

    public PlatfPicosModel getPlatPicos4() {
        return platPicos4;
    }

    public PlatfPicosModel getPlatPicos5() {
        return platPicos5;
    }

    public PlatfPicosModel getPlatPicos6() {
        return platPicos6;
    }

    public PlatfPicosModel getPlatPicos7() {
        return platPicos7;
    }

    public PlatformsModel getPlat1() {
        return plat1;
    }

    public PlatformsModel getPlat2() {
        return plat2;
    }

    public PlatformsModel getPlat3() {
        return plat3;
    }

    public PlatformsModel getPlat4() {
        return plat4;
    }

    public PlatformsModel getPlat5() {
        return plat5;
    }

    public PlatformsModel getPlat6() {
        return plat6;
    }

    public PlatformsModel getPlat7() {
        return plat7;
    }

    public PlatformsModel getPlat8() {
        return plat8;
    }

    public PlatformsModel getPlat9() {
        return plat9;
    }

    public PlatformsModel getPlat10() {
        return plat10;
    }

    public PlatformsModel getPlat11() {
        return plat11;
    }

    public PlatformsModel getPlat12() {
        return plat12;
    }

    public PlatformsModel getPlat13() {
        return plat13;
    }

    public PlatformsModel getPlat14() {
        return plat14;
    }

    public PlatformsModel getPlat15() {
        return plat15;
    }

    public PlatformsModel getPlat16() {
        return plat16;
    }

    public PlatformsModel getPlat17() {
        return plat17;
    }


    public PlatTilojosModel getPlatTijolo1() {
        return platTijolo1;
    }

    public PlatTilojosModel getPlatTijolo2() {
        return platTijolo2;
    }

    public PlatTilojosModel getPlatTijolo3() {
        return platTijolo3;
    }

    public PlatTilojosModel getPlatTijolo4() {
        return platTijolo4;
    }

    public PlatTilojosModel getPlatTijolo5() {
        return platTijolo5;
    }

    public PlatTilojosModel getPlatTijolo6() {
        return platTijolo6;
    }

    public PlatTilojosModel getPlatTijolo7() {
        return platTijolo7;
    }

    public PlatfLentaModel getPlatLenta1() {
        return platLenta1;
    }

    public PlatfLentaModel getPlatLenta2() {
        return platLenta2;
    }

    public PlatfLentaModel getPlatLenta3() {
        return platLenta3;
    }

    public PlatfLentaModel getPlatLenta4() {
        return platLenta4;
    }

    public PlatfLentaModel getPlatLenta5() {
        return platLenta5;
    }

    public PlatfLentaModel getPlatLenta6() {
        return platLenta6;
    }


    public List<AlienModel> getAliens() {
        return aliens;
    }

    /*public List<PlatformsModel> getPlatNivel1(){return platNivel1;}*/
    public List<ComsumableModel> getWaters() {
        return waters;
    }

    public List<RareItemModel> getRareItems() {
        return rareItems;
    }

    public List<AlienAttackModel> getAlienAttack() {
        return AlienAttack;
    }

    public AlienAttackModel createAlienAttack(AlienModel alien) {
        AlienAttackModel attack = alienAttackPool.obtain();

        attack.setPosition(alien.getX(), alien.getY());
        attack.setTimeToLive(3f);
        AlienAttack.add(attack);
        return attack;
    }

    public void remove(EntityModel model) {
        if (model instanceof AlienAttackModel) {
            AlienAttack.remove(model);
            alienAttackPool.free((AlienAttackModel) model);
        }
        if (model instanceof AlienModel) {
            aliens.remove(model);
        }
        if (model instanceof ComsumableModel) {
            waters.remove(model);
        }
        if (model instanceof RareItemModel) {
            rareItems.remove(model);
        }
    }

    public void addAlien(AlienModel alienModel) {
        aliens.add(alienModel);
    }

    public void addWater(ComsumableModel consumableModel) {
        waters.add(consumableModel);

    }

    public void update(float delta) {

        for (AlienAttackModel attack : AlienAttack)
            if (attack.decreaseTimeTolive(delta))
                attack.setFlaggedForRemoval(true);

        //for(ComsumableModel water:waters)
        //  water.setFlaggedForRemoval(true);


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
