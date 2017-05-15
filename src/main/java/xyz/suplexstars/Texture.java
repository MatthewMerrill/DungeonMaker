package xyz.suplexstars;

import de.matthiasmann.twl.utils.PNGDecoder;

import java.nio.ByteBuffer;
import java.util.HashMap;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_CLAMP_TO_EDGE;

/**
 * Created by merrillm on 5/13/17.
 */
public class Texture {
    
    public final int textureId;
    public final int width;
    public final int height;
    
    private Texture(String fileName) {
        try {
            // https://lwjglgamedev.gitbooks.io/3d-game-development-with-lwjgl/content/chapter7/chapter7.html
            PNGDecoder decoder = new PNGDecoder(Texture.class.getResourceAsStream(fileName));
    
            ByteBuffer buf = ByteBuffer.allocateDirect(4 * decoder.getWidth() * decoder.getHeight());
            decoder.decode(buf, decoder.getWidth() * 4, PNGDecoder.Format.RGBA);
            buf.flip();
            
            glEnable(GL_TEXTURE_2D);
            
            this.textureId = glGenTextures();
            this.width = decoder.getWidth();
            this.height = decoder.getHeight();
            
            glBindTexture(GL_TEXTURE_2D, textureId);
            glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
            
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width,
                    this.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
            
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    private static HashMap<String, Texture> textureHashMap = new HashMap<>();
    
    public static Texture loadTexture(String fileName) {
        return textureHashMap.computeIfAbsent(fileName, Texture::new);
    }
}
