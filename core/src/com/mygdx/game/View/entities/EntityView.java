package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

import static com.mygdx.game.View.GameView.PIXEL_TO_METER;

public abstract class EntityView {
    Sprite sprite;
    EntityView(AliensGame game){
        sprite= createSprite(game);
    }
    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }
    public abstract Sprite createSprite(AliensGame game);
    public void update(EntityModel model){

        sprite.setCenter(model.getX()/PIXEL_TO_METER,model.getY()/PIXEL_TO_METER);

    }
}
