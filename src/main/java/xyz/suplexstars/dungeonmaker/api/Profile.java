package xyz.suplexstars.dungeonmaker.api;

import java.util.UUID;

/**
 * Created by merrillm on 5/12/17.
 */
public class Profile {
    
    private String name;
    public final UUID uuid;
    
    public Profile(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
