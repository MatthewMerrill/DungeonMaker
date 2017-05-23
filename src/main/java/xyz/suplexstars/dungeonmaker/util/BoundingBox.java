package xyz.suplexstars.dungeonmaker.util;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BoundingBox {
    
    private final double x0;
    private final double y0;
    private final double x1;
    private final double y1;
    
    public BoundingBox(double x0, double y0, double x1, double y1) {
        this.x0 = min(x0, x1);
        this.y0 = min(y0, y1);
        this.x1 = max(x0, x1);
        this.y1 = max(y0, y1);
    }
    
    public boolean collidesWith(BoundingBox other) {
        return overlapInDimension(x0, x1, other.x0, other.x1)
                && overlapInDimension(y0, y1, other.y0, other.y1);
    }
    public boolean containsPoint(double x, double y) {
        return x0 <= x && x <= x1
                && y0 <= y && y <= y1;
    }
    // http://stackoverflow.com/a/31022629/3188059
    boolean overlapInDimension(double i0, double i1, double j0, double j1)
    {
        double highest0 = Math.max(i0, j0);
        double lowest1 = Math.min(i1, j1);
        
        return highest0 < lowest1;
    }
    
    
    public BoundingBox translate(double dx, double dy) {
        return new BoundingBox(x0 + dx, y0 + dy, x1 + dx, y1 + dy);
    }
}
