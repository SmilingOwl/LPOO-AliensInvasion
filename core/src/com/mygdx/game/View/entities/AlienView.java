package com.mygdx.game.View.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;
import com.mygdx.game.Model.GameModel;

public class AlienView extends EntityView {
    private TextureRegion Esquerda;
    private TextureRegion Direita;

    public AlienView( AliensGame game){
        super(game);
    }
    @Override
    public void update(EntityModel model) {
        super.update(model);
    }

@Override
    public void draw(SpriteBatch batch) {

        if (direction) {
            sprite.setRegion(Direita);
            //return new Sprite(t1,t1.getWidth(),t1.getHeight());
        } else {
            sprite.setRegion(Esquerda);
        }
            super.draw(batch);

    }
    @Override
    public Sprite createSprite(AliensGame game) {

        Esquerda = createEsquerda(game);
        Direita= createDireita(game);

        return new Sprite(Esquerda);
    }

    private TextureRegion createEsquerda(AliensGame game) {
        Texture t = game.getAssetManager().get("aliens.png");
        return new TextureRegion(t,t.getWidth(),t.getHeight());
    }
    private TextureRegion createDireita(AliensGame game) {
        Texture t1 = game.getAssetManager().get("alien2.png");
        return new TextureRegion(t1,t1.getWidth(),t1.getHeight());
    }
}
