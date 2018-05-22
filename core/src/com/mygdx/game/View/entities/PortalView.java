package com.mygdx.game.View.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

/**
 * Created by catam on 22/05/2018.
 */

public class PortalView extends EntityView {
    private static final float FRAME_TIME = 0.05f;
    private Animation<TextureRegion> Animation;
    private TextureRegion stoopingAnimation;
    private Animation<TextureRegion> jumpingAnimation;
    private float stateTime = 0;
    private boolean running;

    public PortalView(AliensGame game) {
        super(game);
    }

    @Override
    public Sprite createSprite(AliensGame game) {
        //runningAnimation= createRunningAnimation(game);
        //jumpingAnimation=createJumpingAnimation(game);
        Animation= createAnimation(game);
        stoopingAnimation = createStoopingAnimation(game);
        return new Sprite(stoopingAnimation);
    }

    private Animation<TextureRegion> createAnimation(AliensGame game) {
        Texture thrustTexture = game.getAssetManager().get("Portal.png");
        TextureRegion[][] thrustRegion = TextureRegion.split(thrustTexture, thrustTexture.getWidth() / 5, thrustTexture.getHeight()/2);

        TextureRegion[] frames = new TextureRegion[9];

        System.arraycopy(thrustRegion[0], 0, frames, 0, 5);
        System.arraycopy(thrustRegion[1], 0, frames, 5, 4);
        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }


    private TextureRegion createStoopingAnimation(AliensGame game) {

        Texture d = game.getAssetManager().get("output7.png");
        return new TextureRegion(d, d.getWidth(), d.getHeight());
    }

    @Override// nÃ£o estÃ¡ completo
    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        sprite.setScale(3, 3);

       sprite.setRegion(Animation.getKeyFrame(stateTime, true));
        sprite.draw(batch);
    }

    @Override// nÃ£o estÃ¡ completo
    public void update(EntityModel model) {
        super.update(model);
    }
}