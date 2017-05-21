package xyz.suplexstars.dungeonmaker.api;

import xyz.suplexstars.dungeonmaker.render.SimpleRenderable;

public abstract class FloorTile extends EventNode implements SimpleRenderable {
    
    private final int row;
    private final int column;
    
    public FloorTile(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    @Override
    public int getRow() {
        return row;
    }
    @Override
    public int getColumn() {
        return column;
    }
    
    @Override
    public final int getWidth() {
        return 1;
    }
    @Override
    public final int getHeight() {
        return 1;
    }
}