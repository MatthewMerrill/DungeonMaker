package xyz.suplexstars.dungeonmaker.api;

import java.util.*;

/**
 * Created by merrillm on 5/21/17.
 */
public class EventNode {
    
    private Map<EventType, Collection<EventNode>> eventSpecificListeners = new HashMap<>();
    private Map<EventType, Collection<EventNode>> eventSpecificTriggers = new HashMap<>();
    private HashSet<EventType> active = new HashSet<>();
    
    public void addListener(EventNode object) {
        addListener(EventType.ACTIVATED, object);
    }
    public void addListener(EventType eventType, EventNode object) {
        object.eventSpecificListeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(this);
        
        eventSpecificListeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(object);
    }
    
    public void setActive(boolean active) {
        setActive(EventType.ACTIVATED, active);
    }
    public void setActive(EventType eventType, boolean active) {
        if (this.active.contains(eventType) != active) {
            if (active)
                this.active.add(eventType);
            else
                this.active.remove(eventType);
            triggered(eventType);
        }
    }
    
    public boolean isActive() {
        return isActive(EventType.ACTIVATED);
    }
    public boolean isActive(EventType type) {
        return active.contains(type);
    }
    
    public void triggered(EventType type) {
        eventSpecificListeners
                .getOrDefault(type, Collections.emptyList())
                .forEach(EventNode::update);
    }
    
    protected void update() {
        if (eventSpecificListeners.entrySet().stream()
                    .allMatch(entry -> entry.getValue().stream()
                            .allMatch(t -> t.isActive(entry.getKey())))) {
             setActive(true);
        } else {
            setActive(EventType.ACTIVATED, false);
        }
    }
}
