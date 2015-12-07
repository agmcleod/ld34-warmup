package com.agmcleod.mytestgame.components;

import com.badlogic.ashley.core.ComponentMapper;

/**
 * Created by aaron on 12/5/2015.
 */
public class ComponentMappers {
    public static final ComponentMapper<TransformComponent> transform = ComponentMapper.getFor(TransformComponent.class);
    public static final ComponentMapper<PhysicsComponent> physics = ComponentMapper.getFor(PhysicsComponent.class);
}
