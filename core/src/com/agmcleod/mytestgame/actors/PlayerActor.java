package com.agmcleod.mytestgame.actors;

import com.agmcleod.mytestgame.Entities.Player;
import com.agmcleod.mytestgame.components.TransformComponent;
import com.agmcleod.mytestgame.helpers.EntityToScreenCoordinates;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by aaron on 12/5/2015.
 */
public class PlayerActor extends Actor {
    private Texture texture;
    private Player player;

    public PlayerActor(Texture texture, final Player player) {
        this.texture = texture;
        this.player = player;
        TransformComponent transformComponent = player.getTransform();
        Vector2 position = EntityToScreenCoordinates.transform(player);
        this.setBounds(position.x, position.y, transformComponent.width, transformComponent.height);

        this.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (Player.InputKeys.contains(keycode, false)) {
                    player.setInputState(keycode);
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                player.setInputState(-1);
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (player.isDirty()) {
            Vector2 position = EntityToScreenCoordinates.transform(player);
            this.setPosition(position.x, position.y);
            player.setDirty(false);
        }

        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0,
                texture.getWidth(), texture.getHeight(), false, false);
    }
}
