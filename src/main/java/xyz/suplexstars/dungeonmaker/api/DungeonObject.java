package xyz.suplexstars.dungeonmaker.api;

public abstract class DungeonObject extends EventNode implements IRenderable {
    
    private int r;
    private int c;
    private int rotation;
    
    public abstract ObjectBounds getBounds();
    
    public int getRotation() {
        return rotation;
    }
    public int getRow() {
        return r;
    }
    public int getColumn() {
        return c;
    }
    
    public void setRotation(int rotation) {
        this.rotation = rotation;
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
    
    public int getWidth() {
        return getBounds().getWidth();
    }
    public int getHeight() {
        return getBounds().getHeight();
    }
    
    
}
