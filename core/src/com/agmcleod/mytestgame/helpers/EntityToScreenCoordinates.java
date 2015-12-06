package com.agmcleod.mytestgame.helpers;

import com.agmcleod.mytestgame.components.Transform;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by aaronmcleod on 2015-12-06.
 */
public class EntityToScreenCoordinates {
    private static Vector2 cache = new Vector2();

    public static Vector2 transform(GameEntity entity) {
        Transform transform = entity.getTransform();
        cache.set(transform.position.x - transform.width / 2, transform.position.y - transform.height / 2);
        return cache;
    }
}
