package xyz.suplexstars.dungeonmaker.render;

import xyz.suplexstars.dungeonmaker.api.IRenderable;
import xyz.suplexstars.dungeonmaker.util.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;

public interface DirectionalRenderable extends IRenderable {
    
    String getTextureName();
    int getSpriteCount();
    
    double getRow();
    double getColumn();
    double getWidth();
    double getHeight();
    double getRotation();
    
    /**
     * Should the first region be centered about 0 or start at 0?
     * true: center region around 0, false: start at 0
     * @return true/false
     */
    default boolean centerOriginRegion() {
        return true;
    }
    
    default float[] getTextureCoords() {
        double rotation = getRotation();
        
        int L = getSpriteCount();
        int N;
        
        rotation %= 2 * Math.PI;
        rotation += 2 * Math.PI;
        rotation %= 2 * Math.PI;
        
        rotation /= 2*Math.PI;
        
        if (centerOriginRegion())
            rotation += 1/(2f*L);
        N = (int) (L * rotation);
        N %= L;
        N += L;
        N %= L;
        
        return new float[]{ (N+0f)/L, 0, (N+1f)/L, 1};
    }
    
    @Override
    default void render() {
        Texture texture = Texture.loadTexture(getTextureName());
        float[] coords = getTextureCoords();
        
        glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texture.textureId);
        
        int scale = 10;
        double r = scale * getRow();
        double c = scale * getColumn();
        double w = scale * getWidth();
        double h = scale * getHeight();
        
        glBegin(GL_QUADS);
        //noinspection Duplicates
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
