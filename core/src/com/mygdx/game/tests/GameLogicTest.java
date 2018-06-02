package com.mygdx.game.tests;

/**
 * Unit Tests
 */

import org.junit.Test;

import static org.junit.Assert.*;

import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.*;
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


public class GameLogicTest {
    /*
    * Hero tests
    *
    * */
    @Test
    public void testeCreateHero() {
        //GameModel.getInstance();
        HeroModel h = new HeroModel(2, 2);
        assertTrue(h.getX() == 2);
        assertTrue(h.getY() == 2);
        h.setPosition(3, 3);
        assertTrue(h.getX() == 3);
        assertTrue(h.getY() == 3);
        assertTrue(h.getLife() == 5);
        h.setLife(4);
        assertTrue(h.getLife() == 4);
        assertTrue(h.getWin() == false);
        assertTrue(h.getLose() == false);
        assertTrue(h.getIsArmed() == false);
        assertTrue(h.getPaused() == false);
        h.setWin(true);
        h.setPaused(true);
        h.setLose(true);
        h.setIsArmed(true);
        assertTrue(h.getWin() == true);
        assertTrue(h.getLose() == true);
        assertTrue(h.getIsArmed() == true);
        assertTrue(h.getPaused() == true);
        h.setDeltaX(2);
        assertTrue(h.getDeltaX() == 2);
        assertTrue(h.getJumping() == false);
        h.setJumping(true);
        assertTrue(h.getJumping() == true);
        assertTrue(h.getType() == EntityModel.ModelType.Hero);

    }

    /*
    * Alien Attack tests
    *
    * */
    @Test
    public void testeCreateAlienAttack() {
        AlienAttackModel attack = new AlienAttackModel(2, 2);
        assertTrue(attack.getX() == 2);
        assertTrue(attack.getY() == 2);
        attack.setPosition(3, 3);
        assertTrue(attack.getX() == 3);
        assertTrue(attack.getY() == 3);
        attack.setTimeToLive(2);
        assertFalse(attack.decreaseTimeToLive(2));
        assertTrue(attack.decreaseTimeToLive(1));


    }

    /*
    * Alien tests
    *
    * */
    @Test
    public void testeCreateAlien() {
        AlienModel alien = new AlienModel(2, 2);
        assertTrue(alien.getX() == 2);
        assertTrue(alien.getY() == 2);
        alien.setPosition(3, 3);
        assertTrue(alien.getX() == 3);
        assertTrue(alien.getY() == 3);
        alien.setDirection(true);
        assertTrue(alien.getDirection());

    }

    /*
    * Consumeble tests
    *
    * */
    @Test
    public void testeCreateConsumable() {
        ConsumableModel water = new ConsumableModel(2, 2);
        assertTrue(water.getX() == 2);
        assertTrue(water.getY() == 2);
        water.setPosition(3, 3);
        assertTrue(water.getX() == 3);
        assertTrue(water.getY() == 3);

    }

    /*
    * Platform with Blocks tests
    *
    * */
    @Test
    public void testeCreatePlatfBlocks() {
        PlatfBlocksModel platf = new PlatfBlocksModel(2, 2);
        assertTrue(platf.getX() == 2);
        assertTrue(platf.getY() == 2);
        platf.setPosition(3, 3);
        assertTrue(platf.getX() == 3);
        assertTrue(platf.getY() == 3);

    }

    /*
    *Platform Fast tests
    *
    * */
    @Test
    public void testeCreatePlatfFast() {
        PlatfFastModel platf = new PlatfFastModel(2, 2);
        assertTrue(platf.getX() == 2);
        assertTrue(platf.getY() == 2);
        platf.setPosition(3, 3);
        assertTrue(platf.getX() == 3);
        assertTrue(platf.getY() == 3);

    }

    /*
    * Normal Platform tests
    *
    * */
    @Test
    public void testeCreatePlatf() {
        PlatformsModel platf = new PlatformsModel(2, 2);
        assertTrue(platf.getX() == 2);
        assertTrue(platf.getY() == 2);
        platf.setPosition(3, 3);
        assertTrue(platf.getX() == 3);
        assertTrue(platf.getY() == 3);

    }

    /*
    * Slow Platforms tests
    *
    * */
    @Test
    public void testeCreatePlatfSlow() {
        PlatfSlowModel platf = new PlatfSlowModel(2, 2);
        assertTrue(platf.getX() == 2);
        assertTrue(platf.getY() == 2);
        platf.setPosition(3, 3);
        assertTrue(platf.getX() == 3);
        assertTrue(platf.getY() == 3);

    }

    /*
    * Platforms with Spikes tests
    *
    * */
    @Test
    public void testeCreatePlatfSpikes() {
        PlatfSpikesModel platf = new PlatfSpikesModel(2, 2);
        assertTrue(platf.getX() == 2);
        assertTrue(platf.getY() == 2);
        platf.setPosition(3, 3);
        assertTrue(platf.getX() == 3);
        assertTrue(platf.getY() == 3);

    }

    /*
    *Portal Tests
    *
    * */
    @Test
    public void testeCreatePortal() {
        PortalModel portal = new PortalModel(2, 2);
        assertTrue(portal.getX() == 2);
        assertTrue(portal.getY() == 2);
        portal.setPosition(3, 3);
        assertTrue(portal.getX() == 3);
        assertTrue(portal.getY() == 3);

    }

    /*
    * RareItem tests
    *
    * */
    @Test
    public void testeCreateRareItem() {
        RareItemModel rare = new RareItemModel(2, 2);
        assertTrue(rare.getX() == 2);
        assertTrue(rare.getY() == 2);
        rare.setPosition(3, 3);
        assertTrue(rare.getX() == 3);
        assertTrue(rare.getY() == 3);

    }

    /*
    * Game Model tests
    *
    * */
    @Test
    public void testeGameModel() {
        GameModel.getInstance();


    }


}
