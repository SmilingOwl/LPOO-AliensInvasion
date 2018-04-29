package com.mygdx.game.View.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;

import static com.badlogic.gdx.Gdx.graphics;

public class StartMenu extends Screens {

    protected static final float BOTTOM = VIEWPORT_WIDTH / 75;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;


    public StartMenu (final AliensGame game) {
        super(game);

   }
/*
    protected void createMenuButtons(Table table) {

        table.bottom();

        addPlayButton(table);
        addOptionsButton(table);
        addExitButton(table);

        table.padBottom(BOTTOM);
    }

    private void addOptionsButton(Table table) {
        TextButton optionsButton = new TextButton("Options", skin);
        optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SettingsMenu(game));
            }
        });
        table.add(optionsButton).size(BUTTON_WIDTH, BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }
    private void addExitButton(Table table) {
        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        table.add(exitButton).size(BUTTON_WIDTH, BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    private void addPlayButton(Table table) {
        TextButton exitButton = new TextButton("Play", skin);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelMenu(game));
            }
        });
        table.add(exitButton).size(BUTTON_WIDTH, BUTTON_SIZE).pad(BUTTON_EDGE).row();
    } */


    @Override
    public void show() {
        super.show();
       /* Table table = new Table();
        table.setFillParent(true);
        createMenuButtons(table);
        stage.addActor(table);*/
    }
}