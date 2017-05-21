package xyz.suplexstars.dungeonmaker.impl;

import xyz.suplexstars.dungeonmaker.api.DungeonObject;
import xyz.suplexstars.dungeonmaker.api.ObjectBounds;
import xyz.suplexstars.dungeonmaker.render.SimpleRenderable;

public class Tree extends DungeonObject implements SimpleRenderable {
    
    @Override
    public ObjectBounds getBounds() {
        return ObjectBounds.rectangle(2, 2);
    }
    
    @Override
    public String getTextureName() {
        return "/tree.png";
    }
    @Override
    public float[] getTextureCoords() {
        return new float[]{ 0f, 0f, 1f, 1f };
    }
}
