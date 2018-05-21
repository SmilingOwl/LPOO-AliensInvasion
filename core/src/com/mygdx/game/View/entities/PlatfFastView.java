package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.View.Entities.EntityView;



/**
 * Created by catam on 20/05/2018.
 */

public class PlatfFastView extends EntityView  {
    public PlatfFastView( AliensGame game){
        super(game);
    }

    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

    @Override
    public void draw(SpriteBatch batch) {
         //sprite.setScale(0.4f,0.4f);
        super.draw(batch);
    }

    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("platfrapida2.png");
        return new Sprite(t,t.getWidth(),t.getHeight());
    }
}
