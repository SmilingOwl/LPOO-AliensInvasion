package com.mygdx.game.tests;

/**
 * Created by catam on 01/06/2018.
 */

import org.junit.Test;

import static org.junit.Assert.*;

import com.mygdx.game.Controller.GameController;
import com.mygdx.game.Model.*;


public class GameLogicTest {
    @Test
    public void testeCreateGame() {
        GameModel.getInstance();
        assertEquals(GameModel.getInstance().getHero().getLife(),5);
    }

}
