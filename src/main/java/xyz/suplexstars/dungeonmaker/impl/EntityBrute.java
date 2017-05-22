package xyz.suplexstars.dungeonmaker.impl;

import xyz.suplexstars.dungeonmaker.api.Entity;
import xyz.suplexstars.dungeonmaker.render.DirectionalRenderable;
import xyz.suplexstars.dungeonmaker.util.Location;

public class EntityBrute extends Entity implements DirectionalRenderable {
    
    public EntityBrute(Location location) {
        super(location);
    }
    
    @Override
    public String getTextureName() {
        return "/brute.png";
    }
    @Override
    public int getSpriteCount() {
        return 4;
    }
    
    public void tick(long delta) {
        setRotation(getRotation() + .01);
        System.out.println(Math.toDegrees(getRotation()));
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
