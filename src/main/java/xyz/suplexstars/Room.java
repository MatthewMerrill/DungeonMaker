package xyz.suplexstars;

/**
 * Created by merrillm on 5/12/17.
 */
public class Room {
    
    public int width;
    public int height;
    
    public DungeonObject[][] objects;
    public FloorObject[][] tiles
    public int[][] occupyingTile;
    
    private static final int[][] rotationAccess = { { 1, 1 }, { 0, 1 }, { 1, -1}, { 0, -1 } };
    
    public boolean addObject(DungeonObject dObj, int r, int c) {
        
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
        if (objects[r][c] != null)
            remove(objects[r][c]);
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