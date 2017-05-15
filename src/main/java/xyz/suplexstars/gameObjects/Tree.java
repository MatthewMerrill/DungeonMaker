package xyz.suplexstars.gameObject;

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
        return "tree.png";
    }
}
