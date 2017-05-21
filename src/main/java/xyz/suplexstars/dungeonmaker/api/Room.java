package xyz.suplexstars.dungeonmaker.api;

import xyz.suplexstars.dungeonmaker.impl.GrassTile;

import java.util.ArrayList;

/**
 * @author matthewmerrill brandondsherman
 * Copyright 2017
 */
public class Room {
    
    public int width;
    public int height;
    
    public ArrayList<DungeonObject>[][] objects;
    public FloorTile[][] tiles;
    public int[][] occupyingTile;
    
    private static final int[][] rotationAccess = { { 1, 1 }, { 0, 1 }, { 1, -1}, { 0, -1 } };
    
    @SuppressWarnings("unchecked")
    public Room(int width, int height) {
        this.width = width;
        this.height = height;
        
        tiles = new FloorTile[height][width];
        objects = (ArrayList<DungeonObject>[][]) new ArrayList[height][width];
        
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                tiles[r][c] = new GrassTile(r, c);
                objects[r][c] = new ArrayList<>();
            }
        }
        
        occupyingTile = new int[height][width];
    }
    
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
            
            objects[rotated[0]][rotated[1]].add(dObj);
            if ((occupyingTile[rotated[0]][rotated[1]] += 1) >= 2)
                collision = true;
        }
        
        dObj.setRowColumn(r, c);
        return collision;
    }
    
    public void remove(int r, int c) {
        if (!objects[r][c].isEmpty())
            remove(objects[r][c].get(0));
    }
    
    public void remove(DungeonObject dObj) {
        int r = dObj.getRow(), c = dObj.getColumn();
        
        int rotation = dObj.getRotation();
        int[] xRotationAccessor = rotationAccess[rotation];
        int[] yRotationAccessor = rotationAccess[(rotation+1)%4];
        
        for (int[] offset : dObj.getBounds()) {
            int[] rotated = {
                    r + xRotationAccessor[1] * offset[xRotationAccessor[0]],
                    c + yRotationAccessor[1] * offset[yRotationAccessor[0]],
            };
            
            objects[rotated[0]][rotated[1]].remove(dObj);
            if ((occupyingTile[rotated[0]][rotated[1]] -= 1) < 0)
                System.err.println("Something's not right! A tile has decremented past 0!");
        }
    }
}