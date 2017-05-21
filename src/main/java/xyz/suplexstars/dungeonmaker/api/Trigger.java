package xyz.suplexstars.dungeonmaker.api;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
public interface Trigger {
    
    Collection<Triggerable> getTriggerableCollection();
    AtomicBoolean getTriggeredBoolean();
    
    default void addTriggerable(Triggerable triggerable) {
        getTriggerableCollection().add(triggerable);
    }
    
    default void setTriggered(boolean triggered) {
        if (triggered != isTriggered()) {
            getTriggeredBoolean().set(triggered);
            updateTriggerables();
        }
    }
    default boolean isTriggered() {
        return getTriggeredBoolean().get();
    }
    
    default void updateTriggerables() {
        for (Triggerable triggerable : getTriggerableCollection()) {
            triggerable.update();
        }
    }
    
}
