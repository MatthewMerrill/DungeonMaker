package xyz.suplexstars.dungeonmaker.view;

import xyz.suplexstars.dungeonmaker.api.DungeonObject;
import xyz.suplexstars.dungeonmaker.api.Entity;
import xyz.suplexstars.dungeonmaker.api.Room;
import xyz.suplexstars.dungeonmaker.impl.*;
import xyz.suplexstars.dungeonmaker.util.Location;

import static org.lwjgl.opengl.GL11.*;

/**
 * It's like a room with a view, but rather a view with a room.
 */
public class RoomView extends View {
    
    private Room room;
    
    public RoomView() {
        room = new Room(10, 10);
        room.addObject(new Tree(), 0, 0);
        room.addObject(new Tree(), 2, 1);
        room.addObject(new Tree(), 6, 6);
        room.addObject(new Door(), 0, 3);
        
        Door doorA = new Door(), doorB = new Door(), doorC = new Door();
        room.addObject(doorA, 1, 4);
        room.addObject(doorB, 1, 5);
        room.addObject(doorC, 1, 6);
        doorA.addListener(doorB);
        doorB.addListener(doorC);
        doorA.setActive(true);
    
        room.entities.add(new EntityBrute(new Location(4, 4)));
        room.entities.add(new EntityPlayer(new Location(5, 3)));
    }
    
    @Override
    public void tick(long delta) {
        room.tick(delta);
    }
    
    @Override
    public void render() {
        glPushMatrix();
        glScaled(2d, 2d, 1d);
    
        for (int r = 0; r < room.height; r++)
            for (int c = 0; c < room.width; c++)
                room.tiles[r][c].render();
        
        for (int r = 0; r < room.height; r++) {
            for (int c = 0; c < room.width; c++) {
                for (DungeonObject obj : room.objects[r][c]) {
                    obj.render();
                }
            }
        }
        
        for (Entity entity : room.entities)
            entity.render();
        
        glPopMatrix();
    }
    
}
