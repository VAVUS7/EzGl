/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl.texture;

import ez.image.Image;
import static ez.gl.Context.*;
import ez.gl.enums.WrapMode;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;

/**
 *
 * @author vlad
 */
public abstract class AbstractTexture2D extends AbstractTexture{
    
    public void texImage(Image im){
        check(currentContext());
        glTexImage2D(
                getType().asGLenum(), 0, asGlPixelFormat(im.getComponents()), 
                im.getWidth(), im.getHeight(), 0, asGlPixelFormat(im.getComponents()), 
                GL_UNSIGNED_BYTE, im.getPixels());
    }
    
        
    public final void setWrapping(WrapMode s, WrapMode t){
        check(currentContext());
        glTexParameteri(getType().asGLenum(), GL_TEXTURE_WRAP_S, s.asGLenum());
        glTexParameteri(getType().asGLenum(), GL_TEXTURE_WRAP_T, t.asGLenum());
    }
}
