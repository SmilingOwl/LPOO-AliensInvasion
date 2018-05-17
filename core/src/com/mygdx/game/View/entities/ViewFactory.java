package com.mygdx.game.View.Entities;

import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.Entities.EntityModel;

import java.util.HashMap;
import java.util.Map;

import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Alien;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.AlienAttack;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Consumable;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.Hero;
import static com.mygdx.game.Model.Entities.EntityModel.ModelType.plataform;

public class ViewFactory {

    private static Map<EntityModel.ModelType, EntityView> cache= new HashMap<EntityModel.ModelType,EntityView>();
    public static EntityView makeView (AliensGame game, EntityModel model){
        if(!cache.containsKey(model.getType())){
           if(model.getType()== Alien)
                cache.put(model.getType(), new AlienView(game));
            if(model.getType()== AlienAttack)
                cache.put(model.getType(), new AlienAttackView(game));
            if(model.getType()== Consumable)
                cache.put(model.getType(), new ComsumableView(game));
            /*if(model.getType()== HeroWeapon)
                cache.put(model.getType(), new HeroWeaponsView(game));*/
            if(model.getType()== plataform)
                cache.put(model.getType(), new PlatformsView(game));
            if(model.getType()== Hero)
                cache.put(model.getType(), new HeroView(game));


        }
        return cache.get(model.getType());
    }
}

