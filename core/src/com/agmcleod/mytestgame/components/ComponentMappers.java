package com.agmcleod.mytestgame.components;

import com.badlogic.ashley.core.ComponentMapper;

/**
 * Created by aaron on 12/5/2015.
 */
public class ComponentMappers {
    public static final ComponentMapper<Transform> transform = ComponentMapper.getFor(Transform.class);
}
