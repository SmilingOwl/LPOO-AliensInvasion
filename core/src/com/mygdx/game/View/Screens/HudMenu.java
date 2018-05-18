package com.mygdx.game.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AliensGame;
import com.mygdx.game.Model.GameModel;
    /**
     * Class responsible for the HUD during the Game.
     */
    class HudMenu extends Stage {

        public enum Options {
            LOAD, START, NONE
        }


         // A Class used to represent the Menu that appears when the game is paused / over / won
        private OptionsMenu optionsMenu;

        private boolean options_flag = false;

       // private float score;

         //Represents the last game's state.
        private GameModel.ModelState lastState;

        private HudMenu.Options currentRequest = Options.NONE;

        //MEDIDAS
        private static final float HUD_VIEWPORT_WIDTH = 1000;
        private static final float HUD_VIEWPORT_HEIGHT = HUD_VIEWPORT_WIDTH *
                ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());

        /**
         * The Font rescaling factor, for the score representation.
         */
        private static final float FONT_SCALE = HUD_VIEWPORT_WIDTH / 400;
        /**
         * The Side Size of the HUD elements.
         */
        private static final float HUD_ELEMENTS_SIZE = HUD_VIEWPORT_WIDTH / 15;
        /**
         * The HUD elements distance to the horizontal screen limits.
         */
        private static final float HORIZONTAL_PAD = HUD_VIEWPORT_WIDTH / 20;
        /**
         * The HUD elements distance to the vertical screen limits.
         */
        private static final float VERTICAL_PAD = HUD_VIEWPORT_HEIGHT / 25;

        /**
         * Current Level Number (Level1, Level2, etc)
         */
        private int currentLevel;
        private Viewport viewport;

        /**
         * Label containing the string referencing the current score.
         */
        private Label scoreText;
        private GameModel model;
        private AliensGame game;
        private InputMultiplexer inputMultiplexer;

        HudMenu(AliensGame game, GameModel model) {
            super(new FitViewport(HUD_VIEWPORT_WIDTH, HUD_VIEWPORT_HEIGHT), game.getBatch());

            inputMultiplexer = new InputMultiplexer(this);
            Gdx.input.setInputProcessor(inputMultiplexer);

            this.game = game;
            this.model = model;

            viewport = this.getViewport();

            initHUD();
        }

        /**
         * Function used to initialize all the elements of the HUD and add the respective Listeners.
         */
        private void initHUD() {
            Table hudTable = new Table();
            hudTable.setFillParent(true);

            Button pauseButton = new Button(new TextureRegionDrawable(
                    new TextureRegion(game.getAssetManager().get("pause.png", Texture.class))));


            pauseButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    model.PauseController();
                }
            });

            hudTable.top();

            hudTable.add(pauseButton).size(HUD_ELEMENTS_SIZE, HUD_ELEMENTS_SIZE).fill()
                    .padRight(HORIZONTAL_PAD).padTop(VERTICAL_PAD);

            this.addActor(hudTable);
        }



        HudMenu.Options update(GameModel.ModelState state, int level) {
            this.act();

            currentLevel = level;

            if (state != lastState) {
                lastState = state;

                switch (state) {
                    case LOST:
                        optionsMenu = new GameOverMenu(viewport, game, this);
                        break;
                    case WON:
                       // game.getGameServices().submitScore(level - 1, (int) (score * 1000));
                        optionsMenu = new VictoryMenu(viewport, game, this);
                        break;
                    case PAUSED:
                        optionsMenu = new PauseMenu(viewport, game, this);
                        break;
                }
            }

            if (state == GameModel.ModelState.LIVE) {
                options_flag = false;
                Gdx.input.setInputProcessor(inputMultiplexer);
            } else if (! options_flag) {
                options_flag = true;
            }

            return currentRequest;
        }


        @Override
        public void draw() {
            if (options_flag && optionsMenu != null) {
                optionsMenu.draw();
            } else {
                super.draw();
            }
        }


         //Function responsible for pausing the current game model.
         void PauseController() {
            currentRequest = Options.NONE;
            model.PauseController();
        }

        int getCurrentLevel() {
            return currentLevel;
        }

        void loadNextLevel() {
            currentRequest = Options.LOAD;
        }

        void startLevel() {
            currentRequest = Options.START;
        }

        void resetRequest() {
            currentRequest = Options.NONE;
        }

        public InputMultiplexer getInputMultiplexer() {
            return inputMultiplexer;
        }
    }

