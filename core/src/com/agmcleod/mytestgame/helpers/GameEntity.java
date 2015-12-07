package com.agmcleod.mytestgame.helpers;

import com.agmcleod.mytestgame.components.ComponentMappers;
import com.agmcleod.mytestgame.components.TransformComponent;
import com.badlogic.ashley.core.Entity;

/**
 * Created by aaronmcleod on 2015-12-06.
 */
public abstract class GameEntity extends Entity {
    private boolean dirty = false;
    public TransformComponent getTransform() {
        return ComponentMappers.transform.get(this);
    }

    public boolean isDirty() {
        return dirty;
    }
}
