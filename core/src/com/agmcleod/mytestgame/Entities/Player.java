package com.agmcleod.mytestgame.Entities;

import com.agmcleod.mytestgame.components.ComponentMappers;
import com.agmcleod.mytestgame.components.Transform;
import com.agmcleod.mytestgame.helpers.GameEntity;
import com.badlogic.gdx.Gdx;

/**
 * Created by aaron on 12/5/2015.
 */
public class Player extends GameEntity {
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
