package xyz.suplexstars.dungeonmaker.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by merrillm on 5/12/17.
 */
public class Dungeon {
    
    private final Collection<Room> rooms;
//    private final Collection<Hallway> hallways;
//    private final Aesthetic aes;
    
    private String name;
    private Profile maker;
    private UUID uniqueId;
    
    public Dungeon() {
        rooms = new ArrayList<>();
//        hallways = new ArrayList<>();
    }
    
}
