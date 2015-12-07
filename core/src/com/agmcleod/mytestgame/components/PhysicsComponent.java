package com.agmcleod.mytestgame.components;

import com.agmcleod.mytestgame.MyTestGame;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by aaronmcleod on 2015-12-06.
 */
public class PhysicsComponent implements Component {
    public Body body;

    public PhysicsComponent(Entity entity, BodyDef.BodyType bodyType) {
        Transform transform = ComponentMappers.transform.get(entity);

        PolygonShape playerShape = new PolygonShape();
        playerShape.setAsBox(transform.width / 2 * MyTestGame.WORLD_TO_BOX, transform.height / 2 * MyTestGame.WORLD_TO_BOX);

        BodyDef def = new BodyDef();

        def.type = bodyType;
        def.position.set(transform.position.x * MyTestGame.WORLD_TO_BOX, transform.position.y * MyTestGame.WORLD_TO_BOX);

        playerShape.dispose();
    }
}
