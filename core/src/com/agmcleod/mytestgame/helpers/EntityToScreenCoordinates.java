package com.agmcleod.mytestgame.helpers;

import com.agmcleod.mytestgame.components.TransformComponent;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by aaronmcleod on 2015-12-06.
 */
public class EntityToScreenCoordinates {
    private static Vector2 cache = new Vector2();

    public static Vector2 transform(GameEntity entity) {
        TransformComponent transformComponent = entity.getTransform();
        cache.set(transformComponent.position.x - transformComponent.width / 2, transformComponent.position.y - transformComponent.height / 2);
        return cache;
    }
}
