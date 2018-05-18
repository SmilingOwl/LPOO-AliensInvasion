package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AliensGame;

public class SettingsMenu extends Screens {

    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;
    protected static final float BOTTOM_EDGE = VIEWPORT_WIDTH / 75;
    private Image soundButton;

    public SettingsMenu(final AliensGame game) {

        super(game, "SettingsTitle.png");
    }

    private void addSoundController(Table table)
    {

        TextureRegionDrawable BtnTexture = new TextureRegionDrawable(new TextureRegion((Texture) game.getAssetManager().get("sound.png")));
        Button soundButton = new Button(BtnTexture);

        soundButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                ConfigMusic();

            }
        });
        table.add(soundButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();

    }


    public void ConfigMusic(){
        setSoundOn(!isSoundOn());
    }

    @Override
    public void show() {
        super.show();

        Table table = new Table();
        table.setFillParent(true);

        table.bottom();

        addSoundController(table);

        table.padBottom(BOTTOM_EDGE);

        stage.addActor(table);

    }
}
