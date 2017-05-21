package xyz.suplexstars;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by merrillm on 5/13/17.
 * It's like a room with a view, but rather a view with a room.
 */
public class RoomView extends View {
    
    private Room room;
    private Texture texture;
    
    public RoomView() {
        room = new Room(10, 10);
        room.add(new Tree(), 0, 0);
        room.add(new Tree(), 2, 1);
        room.add(new Tree(), 6, 6);
        this.texture = Texture.loadTexture("/tiles.png");
    }
    
    @Override
    public void render() {
        glPushMatrix();
////        glTranslated(20, 0, 0);
        glScaled(2d, 2d, 1d);
        
        glBindTexture(GL_TEXTURE_2D, this.texture.textureId);
//        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
    
    
        glBindTexture(GL_TEXTURE_2D, this.texture.textureId);
        glBegin(GL_QUADS);
        glTexCoord2d(.0625 * 0, .0625 * 0); glVertex2d(0, 0);
        glTexCoord2d(.0625 * 1, .0625 * 0); glVertex2d(10, 0);
        glTexCoord2d(.0625 * 1, .0625 * 1); glVertex2d(10, 10);
        glTexCoord2d(.0625 * 0, .0625 * 1); glVertex2d(0, 10);
        
        glTexCoord2d(.0625 * 0, .0625 * 0); glVertex2d(10, 10);
        glTexCoord2d(.0625 * 1, .0625 * 0); glVertex2d(20, 20);
        glTexCoord2d(.0625 * 1, .0625 * 1); glVertex2d(20, 20);
        glTexCoord2d(.0625 * 0, .0625 * 1); glVertex2d(10, 20);
        glEnd();
        
        for (int r = 0; r < room.height; r++) {
            for (int c = 0; c < room.width; c++) {
    
                glBegin(GL_QUADS);
                glBindTexture(GL_TEXTURE_2D, this.texture.textureId);
                if (room.occupyingTile[r][c] > 0) {
                    glTexCoord2d(.0625 * 0, .0625 * 0); glVertex2d(c*10, r*10);
                    glTexCoord2d(.0625 * 1, .0625 * 0); glVertex2d(c*10+10, r*10);
                    glTexCoord2d(.0625 * 1, .0625 * 1); glVertex2d(c*10+10, r*10+10);
                    glTexCoord2d(.0625 * 0, .0625 * 1); glVertex2d(c*10, r*10+10);
                }
                else {
                    glTexCoord2d(.0625 * 8, .0625 * 8); glVertex2d(c*10, r*10);
                    glTexCoord2d(.0625 * 9, .0625 * 8); glVertex2d(c*10+10, r*10);
                    glTexCoord2d(.0625 * 9, .0625 * 9); glVertex2d(c*10+10, r*10+10);
                    glTexCoord2d(.0625 * 8, .0625 * 9); glVertex2d(c*10, r*10+10);
                }
                glEnd();
            }
        }
        
        glPopMatrix();
    }
    
}
