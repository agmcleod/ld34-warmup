package com.agmcleod.mytestgame.Entities;

import com.agmcleod.mytestgame.components.ComponentMappers;
import com.agmcleod.mytestgame.components.PhysicsComponent;
import com.agmcleod.mytestgame.components.TransformComponent;
import com.agmcleod.mytestgame.helpers.GameEntity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by aaron on 12/5/2015.
 */
public class Player extends GameEntity {
    public Player(World world) {
        TransformComponent transformComponent = new TransformComponent();
        transformComponent.position.x = Gdx.graphics.getWidth() / 2;
        transformComponent.position.y = Gdx.graphics.getHeight() / 2;
        transformComponent.width = 64;
        transformComponent.height = 64;
        this.add(transformComponent);
        this.add(new PhysicsComponent(world, this, BodyDef.BodyType.DynamicBody));
    }

    public TransformComponent getTransform() {
        return ComponentMappers.transform.get(this);
    }
}
