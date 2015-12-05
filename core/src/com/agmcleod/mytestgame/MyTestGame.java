package com.agmcleod.mytestgame;

import com.agmcleod.mytestgame.Entities.Player;
import com.agmcleod.mytestgame.actors.PlayerActor;
import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyTestGame extends ApplicationAdapter {
    SpriteBatch batch;
    private Engine engine;
    Texture img;
    private Stage stage;
    private TextureManager textureManager;

    @Override
    public void create () {
        engine = new Engine();
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        textureManager = new TextureManager();
        textureManager.add("player", "player.png");
        Player player = new Player();

        stage.addActor(new PlayerActor(textureManager.get("player"), player));

        engine.addEntity(player);
    }

    @Override
    public void dispose() {
        stage.dispose();
        textureManager.dispose();
    }

    @Override
    public void render () {
        float dt = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0.15f, 0.22f, 0.47f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(dt);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
