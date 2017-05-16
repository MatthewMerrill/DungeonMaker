package xyz.suplexstars;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by merrillm on 5/12/17.
 */
public class ObjectBounds implements Iterable<int[]> {
    
    private final int[][] bounds;
    private final int width;
    private final int height;
    
    public ObjectBounds(int[][] bounds) {
        if (bounds.length < 1) throw new IllegalArgumentException("Bounds cannot be empty!");
        
        this.bounds = bounds;
        
        int minR = bounds[0][0], maxR = bounds[0][0];
        int minC = bounds[0][1], maxC = bounds[0][1];
        
        for (int[] pos : bounds) {
            minR = Math.min(minR, pos[0]);
            maxR = Math.max(maxR, pos[0]);
            minC = Math.min(minC, pos[1]);
            maxC = Math.max(maxC, pos[1]);
        }
    
        width = maxC - minC + 1;
        height = maxR - minR + 1;
    }
    
    @Override
    public Iterator<int[]> iterator() {
        return Arrays.stream(bounds)
                .iterator();
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public static ObjectBounds rectangle(int width, int height) {
        int[][] arr = new int[width * height][2];
        
        int i = 0;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                arr[i++] = new int[]{r, c};
            }
        }
        
        return new ObjectBounds(arr);
    }
}
