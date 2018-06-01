package com.mygdx.game.View.Entities;

import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

import java.util.HashMap;
import java.util.Map;

import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Alien;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.AlienAttack;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Consumable;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Hero;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Portal;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.platFast;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.platSlow;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.platSpikes;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.platBlocks;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.platform;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.rareItem;

/**
 * A factory for EntityView objects with cache
 */
public class ViewFactory {

    private static Map<EntityModel.ModelType, EntityView> cache = new HashMap<EntityModel.ModelType, EntityView>();

    public static EntityView makeView(AliensGame game, EntityModel model) {
        if (!cache.containsKey(model.getType())) {

            if (model.getType() == Alien)
                cache.put(model.getType(), new AlienView(game));
            if (model.getType() == AlienAttack)
                cache.put(model.getType(), new AlienAttackView(game));
            if (model.getType() == Consumable)
                cache.put(model.getType(), new ConsumableView(game));
            if (model.getType() == platform)
                cache.put(model.getType(), new PlatformsView(game));
            if (model.getType() == Hero)
                cache.put(model.getType(), new HeroView(game));
            if (model.getType() == platFast)
                cache.put(model.getType(), new PlatfFastView(game));
            if (model.getType() == platSpikes)
                cache.put(model.getType(), new PlatfSpikesView(game));
            if (model.getType() == platSlow)
                cache.put(model.getType(), new PlatfSlowView(game));
            if (model.getType() == platBlocks)
                cache.put(model.getType(), new PlatfBlocksView(game));
            if (model.getType() == Portal)
                cache.put(model.getType(), new PortalView(game));
            if (model.getType() == rareItem)
                cache.put(model.getType(), new RareItemView(game));
        }
        return cache.get(model.getType());
    }
}

