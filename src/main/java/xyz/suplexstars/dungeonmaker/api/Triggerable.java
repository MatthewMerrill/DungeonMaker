package xyz.suplexstars.dungeonmaker.api;

import java.util.Collection;

@Deprecated
public interface Triggerable {
    
    Collection<Trigger> getTriggerCollection();
    
    default void addTrigger(Trigger triggerable) {
        getTriggerCollection().add(triggerable);
    }
    
    void update();
    
}
