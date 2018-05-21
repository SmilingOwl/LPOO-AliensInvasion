package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * Created by catam on 20/05/2018.
 */

public class PlatTijolosView extends EntityView {
    public PlatTijolosView( AliensGame game){

        super(game);
    }

    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("platfmuro1.png");
        return new Sprite(t,t.getWidth(),t.getHeight());
    }
}
