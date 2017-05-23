package xyz.suplexstars.dungeonmaker.impl;

import xyz.suplexstars.dungeonmaker.api.Entity;
import xyz.suplexstars.dungeonmaker.main.DungeonMakerMain;
import xyz.suplexstars.dungeonmaker.render.DirectionalRenderable;
import xyz.suplexstars.dungeonmaker.util.Location;
import xyz.suplexstars.dungeonmaker.util.Vector;

import static org.lwjgl.glfw.GLFW.*;

public class EntityPlayer extends Entity implements DirectionalRenderable {
    
    public EntityPlayer(Location location) {
        super(location);
    }
    
    @Override
    public String getTextureName() {
        return "/brute.png";
    }
    @Override
    public int getSpriteCount() {
        return 8;
    }
    
    public void tick(long delta) {
        Vector controlVector = new Vector(0, 0);
        
        if (DungeonMakerMain.pressedKeys.contains(GLFW_KEY_A)) {
            controlVector = controlVector.add(Vector.WEST);
        }
        if (DungeonMakerMain.pressedKeys.contains(GLFW_KEY_D)) {
            controlVector = controlVector.add(Vector.EAST);
        }
        if (DungeonMakerMain.pressedKeys.contains(GLFW_KEY_W)) {
            controlVector = controlVector.add(Vector.NORTH);
        }
        if (DungeonMakerMain.pressedKeys.contains(GLFW_KEY_S)) {
            controlVector = controlVector.add(Vector.SOUTH);
        }
        if (controlVector.magnitude > 0) {
            if (getRotation() != controlVector.direction)
                System.out.println(Math.toDegrees(controlVector.direction));
            
            setRotation(controlVector.direction);
        }
        
        setLocation(getLocation().add(controlVector.scale(1/15f)));
    }
    
    @Override
    public double getWidth() {
        return 1d;
    }
    @Override
    public double getHeight() {
        return 1d;
    }
    
}
