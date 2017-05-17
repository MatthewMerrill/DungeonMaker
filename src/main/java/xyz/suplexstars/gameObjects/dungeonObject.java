package xyz.suplexstars.gameObject;

/**
 * Created by merrillm on 5/12/17.
 */
public abstract class DungeonObject {
    
    private int r;
    private int c;
    private int rotation;
    
    public int texture;
    
    DungeonObject() {
        
    }
    
    public abstract ObjectBounds getBounds();
    protected abstract String textureName();
    
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
