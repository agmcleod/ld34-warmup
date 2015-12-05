package com.agmcleod.mytestgame.actors;

import com.agmcleod.mytestgame.Entities.Player;
import com.agmcleod.mytestgame.components.Transform;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by aaron on 12/5/2015.
 */
public class PlayerActor extends Actor {
    private Texture texture;
    private Player player;

    public PlayerActor(Texture texture, Player player) {
        this.texture = texture;
        this.player = player;
        Transform transform = player.getTransform();
        this.setBounds(transform.position.x, transform.position.y, transform.width, transform.height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0,
                texture.getWidth(), texture.getHeight(), false, false);
    }
}
