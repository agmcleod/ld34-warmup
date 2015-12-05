package com.agmcleod.mytestgame.Entities;

import com.agmcleod.mytestgame.components.ComponentMappers;
import com.agmcleod.mytestgame.components.Transform;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by aaron on 12/5/2015.
 */
public class Player extends Entity {
    public Player() {
        Transform transform = new Transform();
        transform.position.x = Gdx.graphics.getWidth() / 2;
        transform.position.y = Gdx.graphics.getHeight() / 2;
        transform.width = 64;
        transform.height = 64;
        this.add(transform);
    }

    public Transform getTransform() {
        return ComponentMappers.transform.get(this);
    }
}
