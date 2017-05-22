package xyz.suplexstars.dungeonmaker.view;

import xyz.suplexstars.dungeonmaker.api.ITickable;

/**
 * Created by merrillm on 5/13/17.
 */
public abstract class View implements ITickable {
    
    public abstract void render();
    
    @Override
    public void tick(long delta) {
        // nop
    }
    
}
