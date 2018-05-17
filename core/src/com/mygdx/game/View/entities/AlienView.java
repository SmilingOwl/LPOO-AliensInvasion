package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

public class AlienView extends EntityView {
    public AlienView( AliensGame game){
        super(game);
    }
    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

    @Override
    public void draw(SpriteBatch batch) {
       // sprite.setScale(0.5f,0.5f);
        super.draw(batch);
    }

    @Override
    public Sprite createSprite(AliensGame game) {
        Texture t = game.getAssetManager().get("aliens.png");

        return new Sprite(t,t.getWidth(),t.getHeight());
    }
}
