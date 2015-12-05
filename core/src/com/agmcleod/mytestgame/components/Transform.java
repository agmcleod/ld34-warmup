package com.agmcleod.mytestgame.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by aaron on 12/5/2015.
 */
public class Transform implements Component {
    public Vector2 position;
    public float rotation;
    public Vector2 scale;
    public float width;
    public float height;

    public Transform() {
        position = new Vector2();
        rotation = 0;
        scale = new Vector2(1, 1);
    }
}
