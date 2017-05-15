import xyz.suplexstars.Room;
import xyz.suplexstars.RoomView;
import xyz.suplexstars.View;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

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
