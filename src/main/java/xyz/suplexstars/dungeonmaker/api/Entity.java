package xyz.suplexstars.dungeonmaker.api;

import xyz.suplexstars.dungeonmaker.util.Location;

import java.util.Vector;

public abstract class Entity extends EventNode implements IRenderable, ITickable {
    
    private Location location;
    private double rotation;
    
    public Entity(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public double getRow() {
        return getLocation().row;
    }
    public double getColumn() {
        return getLocation().column;
    }
    public double getWidth() {
        return 1;
    }
    public double getHeight() {
        return 1;
    }
    
    public double getRotation() {
        return rotation;
    }
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
    
}
