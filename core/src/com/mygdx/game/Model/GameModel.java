package com.mygdx.game.Model;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;
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

import java.util.ArrayList;
import java.util.List;


/**
 * main class for game´s logic
 */
public class GameModel implements Disposable {

    /**
     * games´s instance
     */
    private static GameModel instance;

    /**
     * The world´s hero
     */
    private HeroModel hero;

    /**
     * the world is backwards
     */
    private boolean back;

    /**
     * The world´s basic platforms
     */
    private List<PlatformsModel> normalPlatf;

    /**
     * The world´s fast platforms
     */
    private List<PlatfFastModel> fastPlatf;

    /**
     * The world´s slow platforms
     */
    private List<PlatfSlowModel> lentaPlatf;

    /**
     * The world´s spikes platforms
     */
    private List<PlatfSpikesModel> picosPlatf;

    /**
     * The world´s blocks platforms
     */
    private List<PlatfBlocksModel> tijoloPlatf;


    /**
     * All basic platforms
     */
    private PlatformsModel plat1;
    private PlatformsModel plat2;
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
    private PlatformsModel plat13;
    private PlatformsModel plat14;
    private PlatformsModel plat15;
    private PlatformsModel plat16;
    private PlatformsModel plat17;


    /**
     * All fast platforms
     */
    private PlatfFastModel platFast1;
    private PlatfFastModel platFast2;
    private PlatfFastModel platFast3;
    private PlatfFastModel platFast4;

    /**
     * All spikes platforms
     */
    private PlatfSpikesModel platPicos1;
    private PlatfSpikesModel platPicos2;
    private PlatfSpikesModel platPicos3;

    /**
     * All slow platforms
     */
    private PlatfSlowModel platLenta1;
    private PlatfSlowModel platLenta2;
    private PlatfSlowModel platLenta3;
    private PlatfSlowModel platLenta4;
    private PlatfSlowModel platLenta5;
    private PlatfSlowModel platLenta6;

    /**
     * All blocks platforms
     */
    private PlatfBlocksModel platTijolo1;
    private PlatfBlocksModel platTijolo2;
    private PlatfBlocksModel platTijolo3;
    private PlatfBlocksModel platTijolo4;
    private PlatfBlocksModel platTijolo5;
    private PlatfBlocksModel platTijolo6;
    private PlatfBlocksModel platTijolo7;

    /**
     * All rare items
     */
    private RareItemModel rare1;
    private RareItemModel rare2;
    private RareItemModel rare3;

    /**
     * The victory portal
     */
    private PortalModel portal1;

    /**
     * aliens
     */
    private List<AlienModel> aliens;

    /**
     * basic platforms
     */
    private List<PlatformsModel> platforms;

    /**
     * aliens attack
     */
    private List<AlienAttackModel> AlienAttack;

    /**
     * bottles of water
     */
    private List<ConsumableModel> waters;

    /**
     * rare items
     */
    private List<RareItemModel> rareItems;

    /**
     * aliens counter
     */
    private static final int ALIEN_COUNT = 6;

    /**
     * water counter
     */
    private static final int WATERS_COUNT = 7;


    /**
     * A pool of alien bullets
     */
    Pool<AlienAttackModel> alienAttackPool = new Pool<AlienAttackModel>() {
        @Override
        protected AlienAttackModel newObject() {
            return new AlienAttackModel(0, 0);
        }
    };

    /**
     * Gets the instance
     * @return instance
     */
    public static GameModel getInstance() {
        if (instance == null)
            instance = new GameModel();
        return instance;
    }


    /**
     * Sets back attribute
     * @param t value to update
     */
    public void setCommingBack(boolean t) {
        back = t;
        hero.setBack(t);
    }

    /**
     * GameModel constructor
     */
    private GameModel() {

        aliens = new ArrayList<AlienModel>();
        AlienAttack = new ArrayList<AlienAttackModel>();
        waters = new ArrayList<ConsumableModel>();

        hero = new HeroModel(4, 12);
        portal1 = new PortalModel(585, 28);


        rare1 = new RareItemModel(485, 50);
        rare2 = new RareItemModel(95, 50);
        rare3 = new RareItemModel(240, 50);

        rareItems = new ArrayList<RareItemModel>();
        rareItems.add(rare1);
        rareItems.add(rare2);
        rareItems.add(rare3);


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

        normalPlatf = new ArrayList<PlatformsModel>();
        normalPlatf.add(plat1);
        normalPlatf.add(plat2);
        normalPlatf.add(plat3);
        normalPlatf.add(plat4);
        normalPlatf.add(plat5);
        normalPlatf.add(plat6);
        normalPlatf.add(plat7);
        normalPlatf.add(plat8);
        normalPlatf.add(plat9);
        normalPlatf.add(plat10);
        normalPlatf.add(plat11);
        normalPlatf.add(plat12);
        normalPlatf.add(plat13);
        normalPlatf.add(plat14);
        normalPlatf.add(plat15);
        normalPlatf.add(plat16);
        normalPlatf.add(plat17);

        platFast1 = new PlatfFastModel(80, 30);
        platFast2 = new PlatfFastModel(220, 35);
        platFast3 = new PlatfFastModel(260, 20);
        platFast4 = new PlatfFastModel(300, 30);

        fastPlatf = new ArrayList<PlatfFastModel>();
        fastPlatf.add(platFast1);
        fastPlatf.add(platFast2);
        fastPlatf.add(platFast3);
        fastPlatf.add(platFast4);

        platPicos1 = new PlatfSpikesModel(43, 21);
        platPicos2 = new PlatfSpikesModel(315, 25);
        platPicos3 = new PlatfSpikesModel(540, 20);

        picosPlatf = new ArrayList<PlatfSpikesModel>();
        picosPlatf.add(platPicos1);
        picosPlatf.add(platPicos2);
        picosPlatf.add(platPicos3);

        platLenta1 = new PlatfSlowModel(140, 26);
        platLenta2 = new PlatfSlowModel(175, 28);
        platLenta3 = new PlatfSlowModel(324, 35);
        platLenta4 = new PlatfSlowModel(370, 26);
        platLenta5 = new PlatfSlowModel(390, 30);
        platLenta6 = new PlatfSlowModel(525, 28);

        lentaPlatf = new ArrayList<PlatfSlowModel>();
        lentaPlatf.add(platLenta1);
        lentaPlatf.add(platLenta2);
        lentaPlatf.add(platLenta3);
        lentaPlatf.add(platLenta4);
        lentaPlatf.add(platLenta5);
        lentaPlatf.add(platLenta6);

        platTijolo1 = new PlatfBlocksModel(28, 18);
        platTijolo2 = new PlatfBlocksModel(69, 18);
        platTijolo3 = new PlatfBlocksModel(125, 30);
        platTijolo4 = new PlatfBlocksModel(280, 25);
        platTijolo5 = new PlatfBlocksModel(410, 18);
        platTijolo6 = new PlatfBlocksModel(568, 18);
        platTijolo7 = new PlatfBlocksModel(545, 34);

        tijoloPlatf = new ArrayList<PlatfBlocksModel>();
        tijoloPlatf.add(platTijolo1);
        tijoloPlatf.add(platTijolo2);
        tijoloPlatf.add(platTijolo3);
        tijoloPlatf.add(platTijolo4);
        tijoloPlatf.add(platTijolo5);
        tijoloPlatf.add(platTijolo6);
        tijoloPlatf.add(platTijolo7);

        for (int i = 0; i <= ALIEN_COUNT; i++) {

            if (i == 0)
                aliens.add(new AlienModel(65, 50));
            if (i == 1)
                aliens.add(new AlienModel(105, 50));
            if (i == 2)
                aliens.add(new AlienModel(205, 50));
            if (i == 3)
                aliens.add(new AlienModel(345, 50));
            if (i == 4)
                aliens.add(new AlienModel(435, 50));
            if (i == 5)
                aliens.add(new AlienModel(525, 50));
            if (i == 6)
                aliens.add(new AlienModel(570, 50));


        }
        for (int i = 0; i < WATERS_COUNT; i++) {
            if (i == 0)
                waters.add(new ConsumableModel(355, 30));
            if (i == 1)
                waters.add(new ConsumableModel(410, 30));
            if (i == 2)
                waters.add(new ConsumableModel(505, 40));
            if (i == 3)
                waters.add(new ConsumableModel(155, 45));
            if (i == 4)
                waters.add(new ConsumableModel(55, 40));

        }
    }


    /**
     * Gets the hero model
     * @return hero
     */
    public HeroModel getHero() {
        return hero;
    }

    /**
     * gets the portal model
     * @return portal
     */
    public PortalModel getPortal1() {
        return portal1;
    }

    /**
     * Gets the aliens model
     * @return aliens
     */
    public List<AlienModel> getAliens() {
        return aliens;
    }

    /**
     * Gets the ConsumableModel model
     * @return waters
     */
    public List<ConsumableModel> getWaters() {
        return waters;
    }

    /**
     * Gets the rare item model
     * @return rareItems
     */
    public List<RareItemModel> getRareItems() {
        return rareItems;
    }

    /**
     * Gets the aliens attack model
     * @return aliens attack
     */
    public List<AlienAttackModel> getAlienAttack() {
        return AlienAttack;
    }

    /**
     * Gets the basic platforms model
     * @return normalPlatf
     */
    public List<PlatformsModel> getNormalPlatf() {
        return normalPlatf;
    }

    /**
     * Gets the fast platforms model
     * @return fastPlatf
     */
    public List<PlatfFastModel> getFastPlatf() {
        return fastPlatf;
    }

    /**
     * Gets the slow platforms model
     * @return lentaPlatf
     */
    public List<PlatfSlowModel> getLentaPlatf() {
        return lentaPlatf;
    }

    /**
     * Gets the platfSpikes model
     * @return picosPlatf
     */
    public List<PlatfSpikesModel> getPicosPlatf() {
        return picosPlatf;
    }

    /**
     * Gets the PlatfBlocks model
     * @return tijoloPlatf
     */
    public List<PlatfBlocksModel> getTijoloPlatf() {
        return tijoloPlatf;
    }

    /**
     * This function creates the aliens attacks
     * @param alien alien model
     * @return the aliens attacks
     */
    public AlienAttackModel createAlienAttack(AlienModel alien) {
        AlienAttackModel attack = alienAttackPool.obtain();

        attack.setPosition(alien.getX(), alien.getY());
        attack.setTimeToLive(3f);
        AlienAttack.add(attack);
        return attack;
    }

    /**
     * Removes the entity model
     * @param model entity model
     */
    public void remove(EntityModel model) {
        if (model instanceof AlienAttackModel) {
            AlienAttack.remove(model);
            alienAttackPool.free((AlienAttackModel) model);
        }
        if (model instanceof AlienModel) {
            aliens.remove(model);
        }
        if (model instanceof ConsumableModel) {
            waters.remove(model);
        }
        if (model instanceof RareItemModel) {
            rareItems.remove(model);
        }
    }

    /**
     * resets the gameModel instance
     */
    public void resetInstance() {
        instance = new GameModel();
    }

    /**
     * Updates the game Model
     * @param delta
     */
    public void update(float delta) {

        for (AlienAttackModel attack : AlienAttack)
            if (attack.decreaseTimeToLive(delta))
                attack.setFlaggedForRemoval(true);

    }

    @Override
    public void dispose() {

    }

}
