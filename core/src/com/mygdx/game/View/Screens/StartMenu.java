package com.mygdx.game.View.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AliensGame;

public class StartMenu extends Screens {

    protected static final float BOTTOM = VIEWPORT_WIDTH / 75;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 2;
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 75;

    public StartMenu (final AliensGame game) {
        super(game);
    }

    protected void addPlayButton(Table table)
    {
        TextButton playButton = new TextButton("Play", skinButton);
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new LevelMenu(game));

            }
        });
        table.add(playButton).size(BUTTON_WIDTH, BUTTON_SIZE).pad(BUTTON_EDGE).row();

    }

    protected void addScoreButton(Table table)
    {

    }
    protected void addOptionsButton(Table table)
    {

    }
    protected void addExitButton(Table table)
    {
        TextButton exitButton = new TextButton("Exit", skinButton);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        table.add(exitButton).size(BUTTON_WIDTH, BUTTON_SIZE).pad(BUTTON_EDGE).row();

    }
    protected void createButtons(Table table)
    {
        table.bottom();
        addPlayButton(table);
        addScoreButton(table);
        addOptionsButton(table);
        addExitButton(table);
        table.padBottom(BOTTOM);
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();
        table.setFillParent(true);
        createButtons(table);
        stage.addActor(table);
    }
}