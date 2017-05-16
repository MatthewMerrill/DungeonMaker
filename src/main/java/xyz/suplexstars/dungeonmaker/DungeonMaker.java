package xyz.suplexstars.dungeonmaker;

import xyz.suplexstars.dungeonmaker.view.RoomView;
import xyz.suplexstars.dungeonmaker.view.View;

/**
 * Created by merrillm on 5/12/17.
 */
public class DungeonMaker {
    
    private View view = new RoomView();
    
    public void tick() {
        
    }
    
    public void render() {
        if (view != null)
            view.render();
    }
    
}
