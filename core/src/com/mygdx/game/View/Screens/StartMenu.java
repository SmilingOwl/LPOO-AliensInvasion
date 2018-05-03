package com.mygdx.game.View.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AliensGame;

import static com.badlogic.gdx.Gdx.graphics;

public class StartMenu extends Screens {

    protected static final float BOTTOM = VIEWPORT_WIDTH / 75;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;


    public StartMenu (final AliensGame game) {
        super(game);

   }


    protected void addOptionsButton() {
        TextureRegionDrawable settingsBtnTexture = new TextureRegionDrawable(new TextureRegion((Texture) game.getAssetManager().get("settingsBtn.png")));
        Button settingsBtn = new Button(settingsBtnTexture);
        settingsBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SettingsMenu(game));
            }
        });
    }
    protected void addExitButton() {
        TextureRegionDrawable exitBtnTexture = new TextureRegionDrawable(new TextureRegion((Texture) game.getAssetManager().get("exitBtn.png")));
        Button exitBtn = new Button(exitBtnTexture);
        exitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

    protected void addPlayButton() {

        TextureRegionDrawable playBtnTexture = new TextureRegionDrawable(new TextureRegion((Texture) game.getAssetManager().get("playBtn.png")));
        Button playBtn = new Button(playBtnTexture);

        playBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelMenu(game));
            }
        });

    }

    protected void createMenuButtons(){
    addPlayButton();
    addOptionsButton();
    addExitButton();
    }
    @Override
    public void show() {
        super.show();
        createMenuButtons();
    }
}