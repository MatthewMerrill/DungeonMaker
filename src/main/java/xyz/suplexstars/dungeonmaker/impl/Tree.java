package xyz.suplexstars.dungeonmaker.impl;

import xyz.suplexstars.dungeonmaker.api.DungeonObject;
import xyz.suplexstars.dungeonmaker.api.ObjectBounds;

/**
 * Created by merrillm on 5/12/17.
 */
public class Tree extends DungeonObject {
    
    @Override
    public ObjectBounds getBounds() {
        return ObjectBounds.rectangle(2, 2);
    }
    
    @Override
    protected String textureName() {
        return "/tiles.png";
    }
}
