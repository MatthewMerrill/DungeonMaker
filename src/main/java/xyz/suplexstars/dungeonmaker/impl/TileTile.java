package xyz.suplexstars.dungeonmaker.impl;

import xyz.suplexstars.dungeonmaker.api.FloorTile;

/**
 * Created by merrillm on 5/21/17.
 */
public class TileTile extends FloorTile {
    
    public TileTile(int row, int column) {
        super(row, column);
    }
    
    @Override
    public String getTextureName() {
        return "/tiles.png";
    }
    @Override
    public float[] getTextureCoords() {
        return new float[]{ .0625f, 0, 2*.0625f, .0625f };
    }
    
}
