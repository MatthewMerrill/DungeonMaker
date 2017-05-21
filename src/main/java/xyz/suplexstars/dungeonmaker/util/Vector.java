package xyz.suplexstars.dungeonmaker.util;

/**
 * Created by merrillm on 5/17/17.
 */
public class Vector {
    
    public static final Vector NORTH = fromRowCol(+1, 0);
    public static final Vector SOUTH = fromRowCol(-1, 0);
    public static final Vector WEST = fromRowCol(0, -1);
    public static final Vector EAST = fromRowCol(0, +1);
    
    public final double magnitude;
    public final double direction;
    
    public Vector(double magnitude, double direction) {
        this.magnitude = magnitude;
        this.direction = direction;
    }
    
    public static Vector fromRowCol(double dr, double dc) {
        double mag = Math.sqrt(dr*dr + dc*dc);
        double dir = Math.atan2(dr, dc);
        
        return new Vector(mag, dir);
    }
    
    public double getRowComponent() {
        return magnitude * Math.sin(direction);
    }
    public double getColComponent() {
        return magnitude * Math.cos(direction);
    }
    
    public Vector normal() {
        return new Vector(1, direction);
    }
    
    
}
