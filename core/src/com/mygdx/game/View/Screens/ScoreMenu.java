package com.mygdx.game.View.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Controller.GameController;

import java.awt.Button;

public class ScoreMenu extends Screens {
    TextButton ScoreButton = createTextButton(Integer.toString(GameController.getInstance().getPrefs().getInteger("score", 30)));
    TextButton Score2Button = createTextButton(Integer.toString(GameController.getInstance().getPrefs().getInteger("score2", 30)));
    TextButton Score3Button = createTextButton(Integer.toString(GameController.getInstance().getPrefs().getInteger("score3", 30)));
    TextButton BackTOStartMenu= createTextButton("Start Menu");
    protected static final float BUTTON_EDGE = VIEWPORT_WIDTH / 165;
    protected static final float BUTTON_WIDTH = VIEWPORT_WIDTH / 3;

    public ScoreMenu(final AliensGame game) {
        super(game, "ScoreTitle.png");

    }
    protected void addStartMenuButton(Table table) {

        BackTOStartMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartMenu(game));
            }
        });
        table.add(BackTOStartMenu).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }
    protected void addMainScoreButton(Table table) {

        ScoreButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
            }
        });
        table.add(ScoreButton).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void addMainScore2Button(Table table) {

        Score2Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
            }
        });
        table.add(Score2Button).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    protected void addMainScore3Button(Table table) {

        Score3Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new StartMenu(game));
            }
        });
        table.add(Score3Button).size(BUTTON_WIDTH, DEFAULT_BUTTON_SIZE).pad(BUTTON_EDGE).row();
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();
        table.setFillParent(true);

        table.center();
        addMainScoreButton(table);
        addMainScore2Button(table);
        addMainScore3Button(table);
        addStartMenuButton(table);
        stage.addActor(table);
    }

}