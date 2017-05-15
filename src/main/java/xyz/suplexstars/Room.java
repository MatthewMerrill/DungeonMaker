package xyz.suplexstars;

import java.util.ArrayList;

/**
 * Created by merrillm on 5/12/17.
 */
public class Room {
    
    public int width;
    public int height;
    
    public ArrayList<DungeonObject>[][] tiles;
    
    public int[][] occupyingTile;
    
    private static final int[][] rotationAccess = { { 1, 1 }, { 0, 1 }, { 1, -1}, { 0, -1 } };
    
    public Room(int width, int height) {
        this.width = width;
        this.height = height;
        
        occupyingTile = new int[height][width];
    }
    
    public boolean add(DungeonObject dObj, int r, int c) {
        
        int rotation = dObj.getRotation();
        int[] xRotationAccessor = rotationAccess[rotation];
        int[] yRotationAccessor = rotationAccess[(rotation+1)%4];
        
        boolean collision = false;
        
        for (int[] offset : dObj.getBounds()) {
            int[] rotated = {
                    r + xRotationAccessor[1] * offset[xRotationAccessor[0]],
                    c + yRotationAccessor[1] * offset[yRotationAccessor[0]],
            };
            
            if ((occupyingTile[rotated[0]][rotated[1]] += 1) >= 2)
                collision = true;
        }
        
        dObj.setRowColumn(r, c);
        return collision;
    }
    
    public void remove(int r, int c) {
        if (!tiles[r][c].isEmpty())
            remove(tiles[r][c].get(0));
    }
    
    public void remove(DungeonObject dObj) {
        int r = dObj.getRow(), c = dObj.getColumn();
        ObjectBounds bounds = dObj.getBounds();
    
        int rotation = dObj.getRotation();
        int[] xRotationAccessor = rotationAccess[rotation];
        int[] yRotationAccessor = rotationAccess[(rotation+1)%4];
        
        for (int[] offset : dObj.getBounds()) {
            int[] rotated = {
                    r + xRotationAccessor[1] * offset[xRotationAccessor[0]],
                    c + yRotationAccessor[1] * offset[yRotationAccessor[0]],
            };
            
            if ((occupyingTile[rotated[0]][rotated[1]] -= 1) < 0)
                System.err.println("Something's not right! A tile has decremented past 0!");
        }
    }
}