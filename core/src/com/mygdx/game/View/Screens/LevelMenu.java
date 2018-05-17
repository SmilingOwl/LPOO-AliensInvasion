package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.AliensGame;

public class LevelMenu extends Screens{

    private static final float BUTTON_SIDE = VIEWPORT_WIDTH / 9;
    private static final float BUTTON_EDGE = VIEWPORT_WIDTH / 25;
    private static final float TOP_EDGE = VIEWPORT_WIDTH / 7;
    private static final float SIDE_DISTANCE = VIEWPORT_WIDTH / 18;

    public LevelMenu (final AliensGame game)
    {
        super(game,"ScoreTitle.png");
    }

 /*   private void createStaticObjects(Table table, Table table2)
    {
        TextButton back =createTextButton("Back");
       // TextButton back = new TextButton("Back", (style ? skin2 : skin1));

        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StartMenu(game));
            }
        });


        table.add(back).top().size(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE).padLeft(SIDE_DISTANCE).padTop(TOP_EDGE / 3);

    }

    private TextButton createTextButton(String text)
    {
        Texture buttonTexture =game.getAssetManager().get("button.png");
        TextureRegion[][] arrayTextures=TextureRegion.split(buttonTexture, buttonTexture.getWidth()/3,buttonTexture.getHeight());
        TextureRegionDrawable playBtnUp=new TextureRegionDrawable(arrayTextures[0][0]);
        TextureRegionDrawable playBtnPress=new TextureRegionDrawable(arrayTextures[0][1]);
        TextureRegionDrawable playBtnChecked=new TextureRegionDrawable(arrayTextures[0][2]);
        BitmapFont font =new BitmapFont();
        font.getData().setScale(2,2);
        TextButton.TextButtonStyle button=new TextButton.TextButtonStyle(playBtnUp,playBtnPress,playBtnChecked,font);
        return new TextButton(text,button);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}*/
}
