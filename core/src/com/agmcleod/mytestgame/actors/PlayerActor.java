package com.agmcleod.mytestgame.actors;

import com.agmcleod.mytestgame.Entities.Player;
import com.agmcleod.mytestgame.components.TransformComponent;
import com.agmcleod.mytestgame.helpers.EntityToScreenCoordinates;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
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
        TransformComponent transformComponent = player.getTransform();
        Vector2 position = EntityToScreenCoordinates.transform(player);
        this.setBounds(position.x, position.y, transformComponent.width, transformComponent.height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (player.isDirty()) {
            Vector2 position = EntityToScreenCoordinates.transform(player);
            this.setPosition(position.x, position.y);
        }

        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0,
                texture.getWidth(), texture.getHeight(), false, false);
    }
}
