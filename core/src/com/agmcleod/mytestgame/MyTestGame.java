package com.agmcleod.mytestgame;

import com.agmcleod.mytestgame.Entities.Player;
import com.agmcleod.mytestgame.actors.PlayerActor;
import com.agmcleod.mytestgame.systems.MovementSystem;
import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class MyTestGame extends ApplicationAdapter {
    public static final float WORLD_TO_BOX = 0.01f;
    public static final float BOX_TO_WORLD = 100f;

    private Matrix4 cameraCpy;
    private Box2DDebugRenderer debugRenderer;
    private Engine engine;
    Texture img;
    private Stage stage;
    private TextureManager textureManager;
    private World world;

    @Override
    public void create () {
        engine = new Engine();
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        stage = new Stage(new ScalingViewport(Scaling.stretch, width, height));
        cameraCpy = new Matrix4();
        world = new World(new Vector2(0, 0), true);
        Gdx.input.setInputProcessor(stage);
        textureManager = new TextureManager();
        textureManager.add("player", "player.png");
        Player player = new Player(world);

        PlayerActor playerActor = new PlayerActor(textureManager.get("player"), player);
        stage.addActor(playerActor);
        stage.setKeyboardFocus(playerActor);

        engine.addEntity(player);

        engine.addSystem(new MovementSystem());
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void dispose() {
        stage.dispose();
        textureManager.dispose();
        debugRenderer.dispose();
    }

    @Override
    public void render () {
        float dt = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0.15f, 0.22f, 0.47f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        engine.update(dt);

        stage.act(dt);
        stage.draw();
        cameraCpy.set(stage.getCamera().combined);

        debugRenderer.render(world, cameraCpy.scl(BOX_TO_WORLD));

        world.step(1/60f, 6, 2);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
