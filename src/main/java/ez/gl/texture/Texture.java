/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl.texture;

import ez.gl.Context;
import ez.gl.ObjectGL;
import static ez.gl.ObjectGL.NULLOBJ;
import ez.gl.enums.TextureType;
import static ez.gl.Context.*;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author vlad
 */
public abstract class Texture implements ObjectGL{
    
    protected int texture;
    
    public static final Texture NO_TEXTURE = new Texture(){
        
        @Override
        public TextureType getType() {
            Texture tex = currentContext().getBindMap().getTexture();
            if(tex != this) return tex.getType();
            return null;
        }
    };
    private Texture(int texture){this.texture = texture;}
    
    public Texture(){
        texture = glGenTextures();
    }
    
    protected void check(Context context){
        if(context.getBindMap().getTexture() != this)
            throw new RuntimeException("Texture must be bind.");
    }
    
    public final void bind(){
        Context context = currentContext();
        check(context);
        glBindTexture(getType().asGLenum(), this.texture);
        context.getBindMap().setTexture(this);
    }
    
    @Override
    public void delete(){
        if(texture != NULLOBJ){
            glDeleteTextures(texture);
            texture = NULLOBJ;
        }
    }
    
    public abstract TextureType getType();
    
    @Deprecated
    protected static int asGlPixelFormat(int comp){
        switch(comp){
            case 1: return GL_LUMINANCE;
            case 2: return GL_LUMINANCE_ALPHA;
            case 3: return GL_RGB;
            case 4: return GL_RGBA;
            default: throw new IllegalArgumentException();
        }
    }
}
