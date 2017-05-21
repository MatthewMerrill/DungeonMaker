package xyz.suplexstars.dungeonmaker.api;

import xyz.suplexstars.dungeonmaker.util.Location;

import java.util.Vector;

public abstract class Entity extends EventNode {
    
    private Location location;
    private Vector rotation;
    
    public Entity(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    
}
