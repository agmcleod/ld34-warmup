package com.agmcleod.mytestgame.systems;

import com.agmcleod.mytestgame.Entities.Player;
import com.agmcleod.mytestgame.MyTestGame;
import com.agmcleod.mytestgame.components.ComponentMappers;
import com.agmcleod.mytestgame.components.PhysicsComponent;
import com.agmcleod.mytestgame.components.TransformComponent;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by aaronmcleod on 2015-12-06.
 */
public class MovementSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    public MovementSystem() {

    }

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(TransformComponent.class, PhysicsComponent.class).get());
    }

    public boolean handlePlayerInput(Player player) {
        boolean moved = false;
        PhysicsComponent physicsComponent = ComponentMappers.physics.get(player);
        Vector2 currentVel = physicsComponent.body.getLinearVelocity();
        if (player.isMoveLeft()) {
            physicsComponent.body.setLinearVelocity(-Player.VELOCITY, currentVel.y);
            moved = true;
        }
        if (player.isMoveRight()) {
            physicsComponent.body.setLinearVelocity(Player.VELOCITY, currentVel.y);
            moved = true;
        }
        if (player.isMoveUp()) {
            physicsComponent.body.setLinearVelocity(currentVel.x, Player.VELOCITY);
            moved = true;
        }
        if (player.isMoveDown()) {
            physicsComponent.body.setLinearVelocity(currentVel.x, -Player.VELOCITY);
            moved = true;
        }
        if (!moved) {
            physicsComponent.body.setLinearVelocity(0, 0);
        }

        return moved;
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);

            if (entity instanceof Player) {
                Player player = (Player) entity;
                if (handlePlayerInput(player)) {
                    player.setDirty(true);
                }
            }

            TransformComponent transformComponent = ComponentMappers.transform.get(entity);
            PhysicsComponent physicsComponent = ComponentMappers.physics.get(entity);

            Body body = physicsComponent.body;
            transformComponent.position.x = body.getPosition().x * MyTestGame.BOX_TO_WORLD;
            transformComponent.position.y = body.getPosition().y * MyTestGame.BOX_TO_WORLD;
        }
    }
}
