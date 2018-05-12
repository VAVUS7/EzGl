/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl;

import ez.gl.enums.TextureType;
import static ez.gl.enums.TextureType.*;
import ez.image.Image;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glTexImage2D;

/**
 *
 * @author vlad
 */
public class Texture2D extends Texture{
    
    public Texture2D(Image im) {
        super();
    }
    
    public void texImage(Image im){
        bind();
        glTexImage2D(
                GL_TEXTURE_2D, 0, asGlPixelFormat(im.getComponents()), 
                im.getWidth(), im.getHeight(), 0, asGlPixelFormat(im.getComponents()), 
                GL_UNSIGNED_BYTE, im.getPixels());
    }

    @Override
    public TextureType getType() {return TEXTURE_2D;}
}
