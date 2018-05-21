package com.mygdx.game.Model.Entities;

/**
 * Created by catam on 20/05/2018.
 */

public class PlatfFastModel extends EntityModel{

        private int Type;
        public PlatfFastModel( float x, float y){
            super(x,y);
            this.Type=0;
        }
        @Override
        public ModelType getType() {
            return ModelType.platFast;
        }


}
