package xyz.suplexstars.dungeonmaker;

import xyz.suplexstars.dungeonmaker.api.ITickable;
import xyz.suplexstars.dungeonmaker.view.RoomView;
import xyz.suplexstars.dungeonmaker.view.View;

/**
 * Created by merrillm on 5/12/17.
 */
public class DungeonMaker implements ITickable {
    
    private View view = new RoomView();
    
    @Override
    public void tick(long delta) {
        view.tick(delta);
    }
    
    public void render() {
        if (view != null)
            view.render();
    }
    
}
