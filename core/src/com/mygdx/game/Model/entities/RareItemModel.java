package com.mygdx.game.Model.Entities;

/**
 * A model representing a rare item
 */
public class RareItemModel extends EntityModel {

    private int Type;

    public RareItemModel(float x, float y) {
        super(x, y);
        this.Type = 0;
    }

    @Override
    public ModelType getType() {
        return ModelType.rareItem;
    }
}
