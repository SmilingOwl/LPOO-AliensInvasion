package com.mygdx.game.Gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AliensGame;


public class StartMenu extends Screens {

    private Image playButton;
    private Image exitButton;
    private Image optionsButton;
    private Image scoresButton;
    private Texture backgroundMenu;
    private Texture geralButton;
    private AliensGame game;
    private Stage stage;
    private Viewport gamePort;

    public StartMenu(AliensGame game){

        this.game = game;
        gamePort=new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gamePort.apply();
        backgroundMenu = new Texture("StarMenu.png");
        geralButton=new Texture ("GeralButton.png");

       }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}