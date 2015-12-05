package com.agmcleod.mytestgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Created by aaron on 12/5/2015.
 */
public class TextureManager {
    ObjectMap<String, Texture> textures;

    public TextureManager() {
        textures = new ObjectMap<String, Texture>();
    }

    public void add(String key, String path) {
        textures.put(key, new Texture(Gdx.files.internal(path)));
    }

    public void dispose() {
        ObjectMap.Entries<String, Texture> entries = textures.iterator();
        while (entries.hasNext()) {
            ObjectMap.Entry<String, Texture> entry = entries.next();
            entry.value.dispose();
        }
        textures.clear();
    }

    public Texture get(String key) {
        return textures.get(key);
    }
}
