package xyz.suplexstars.dungeonmaker.view;

import xyz.suplexstars.dungeonmaker.api.DungeonObject;
import xyz.suplexstars.dungeonmaker.api.Room;
import xyz.suplexstars.dungeonmaker.impl.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by merrillm on 5/13/17.
 * It's like a room with a view, but rather a view with a room.
 */
public class RoomView extends View {
    
    private Room room;
    
    public RoomView() {
        room = new Room(10, 10);
        room.addObject(new Tree(), 0, 0);
        room.addObject(new Tree(), 2, 1);
        room.addObject(new Tree(), 6, 6);
    }
    
    @Override
    public void render() {
        glPushMatrix();
        glTranslated(20, 0, 0);
        glScaled(2d, 2d, 1d);
        
    
        glBegin(GL_QUADS);
        for (int r = 0; r < room.height; r++) {
            for (int c = 0; c < room.width; c++) {
    
                for (DungeonObject obj : room.objects[r][c]) {
                    glBindTexture(GL_TEXTURE_2D, obj.getTexture().textureId);
                    float[] texCoord = obj.getTextureCoords();
    
                    glTexCoord2d(texCoord[0], texCoord[1]);
                    glVertex2d(c * 10, r * 10);
                    glTexCoord2d(texCoord[2], texCoord[1]);
                    glVertex2d(c * 10 + 10, r * 10);
                    glTexCoord2d(texCoord[2], texCoord[3]);
                    glVertex2d(c * 10 + 10, r * 10 + 10);
                    glTexCoord2d(texCoord[0], texCoord[3]);
                    glVertex2d(c * 10, r * 10 + 10);
                }
            }
        }
        glEnd();
        
        glPopMatrix();
    }
    
}
