package xyz.suplexstars.dungeonmaker.render;

import xyz.suplexstars.dungeonmaker.api.IRenderable;
import xyz.suplexstars.dungeonmaker.util.Texture;

import static org.lwjgl.opengl.GL11.*;

public interface SimpleRenderable extends IRenderable {
    
    String getTextureName();
    default float[] getTextureCoords() {
        return new float[]{ 0f, 0f, 1f, 1f };
    }
    
    int getRow();
    int getColumn();
    int getWidth();
    int getHeight();
    
    @Override
    default void render() {
        Texture texture = Texture.loadTexture(getTextureName());
        float[] coords = getTextureCoords();
        
        glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texture.textureId);
        
        int scale = 10;
        int r = scale * getRow();
        int c = scale * getColumn();
        int w = scale * getWidth();
        int h = scale * getHeight();
        
        glBegin(GL_QUADS);
        {
            glTexCoord2d(coords[0], coords[3]);
            glVertex2d(c, r);
            glTexCoord2d(coords[2], coords[3]);
            glVertex2d(c + w, r);
            glTexCoord2d(coords[2], coords[1]);
            glVertex2d(c + w, r + h);
            glTexCoord2d(coords[0], coords[1]);
            glVertex2d(c, r + h);
        }
        glEnd();
        glDisable(GL_TEXTURE_2D);
    }
}
