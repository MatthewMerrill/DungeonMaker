package xyz.suplexstars.dungeonmaker.impl;

import xyz.suplexstars.dungeonmaker.api.DungeonObject;
import xyz.suplexstars.dungeonmaker.api.ObjectBounds;
import xyz.suplexstars.dungeonmaker.api.Trigger;
import xyz.suplexstars.dungeonmaker.api.Triggerable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.lwjgl.opengl.GL11.*;

public class Door extends DungeonObject {
    
    private static final ObjectBounds DOOR_BOUNDS = ObjectBounds.rectangle(2, 1);
    
    @Override
    public void render() {
        if (isActive())
            glColor3f(0x48/255f, 0xff/255f, 0xcc/255f);
        else
            glColor3f(0xcc/255f, 0x66/255f, 0x66/255f);

        int r = getRow();
        int c = getColumn();

        glBegin(GL_QUADS);
        {
            glVertex2d(c * 10, r * 10);
            glVertex2d(c * 10 + 10, r * 10);
            glVertex2d(c * 10 + 10, r * 10 + 10);
            glVertex2d(c * 10, r * 10 + 10);
        }
        glEnd();

    }
    
    @Override
    public ObjectBounds getBounds() {
        return DOOR_BOUNDS;
    }
    
}
