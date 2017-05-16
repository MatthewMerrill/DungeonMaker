package xyz.suplexstars.dungeonmaker.api;

import xyz.suplexstars.dungeonmaker.util.Texture;

/**
 * Created by merrillm on 5/12/17.
 */
public abstract class DungeonObject {
    
    private int r;
    private int c;
    private int rotation;
    
    private final Texture texture;
    
    public DungeonObject() {
        this.texture = Texture.loadTexture(textureName());
    }
    
    public abstract ObjectBounds getBounds();
    protected abstract String textureName();
    
    public Texture getTexture() {
        return texture;
    }
    public float[] getTextureCoords() {
        return new float[]{ 0f, 0f, 1f, 1f };
    }
    
    public int getRotation() {
        return rotation;
    }
    public int getRow() {
        return r;
    }
    public int getColumn() {
        return c;
    }
    
    public void setRow(int r) {
        this.r = r;
    }
    public void setColumn(int c) {
        this.c = c;
    }
    public void setRowColumn(int r, int c) {
        setRow(r);
        setColumn(c);
    }
}
