package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * Created by catam on 20/05/2018.
 */

public class PlatfPicosView extends EntityView {
    public PlatfPicosView ( AliensGame game){
        super(game);
    }

    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

    @Override
    public void draw(SpriteBatch batch) {
        //sprite.setScale(0.25f,0.25f);
        super.draw(batch);
    }

    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("platfpicos.png");
        return new Sprite(t,t.getWidth(),t.getHeight());
    }
}