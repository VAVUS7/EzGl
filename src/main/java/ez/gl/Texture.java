/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl;

import ez.gl.Context;
import ez.gl.ObjectGL;
import static ez.gl.ObjectGL.NULLOBJ;
import ez.gl.enums.TextureType;
import static ez.gl.Context.*;
import ez.gl.enums.MagFilter;
import ez.gl.enums.MinFilter;
import ez.gl.enums.WrapMode;
import ez.image.Image;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_TEXTURE_WRAP_R;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

/**
 *
 * @author vlad
 */
public abstract class Texture implements ObjectGL, Typable{
    
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
    
    public final void bind(){
        Context context = currentContext();
        if(context.getBindMap().getTexture() != this){
            glBindTexture(getType().asGLenum(), this.texture);
            context.getBindMap().setTexture(this);
        }
    }
    
    @Override
    public final void delete(){
        if(texture != NULLOBJ){
            glDeleteTextures(texture);
            texture = NULLOBJ;
        }
    }
    
    @Override
    public abstract TextureType getType();
    
    
    
    
    protected static void texImage1D(TextureType type, Image im){
        glTexImage1D(type.asGLenum(), 0, asGlPixelFormat(im.getComponents()), 
                im.getHeight()*im.getWidth(), 0, asGlPixelFormat(im.getComponents()), GL_UNSIGNED_BYTE, im.getPixels());
    }
    
    protected static void texImage2D(TextureType type, Image im){
        glTexImage2D(
                type.asGLenum(), 0, asGlPixelFormat(im.getComponents()), 
                im.getWidth(), im.getHeight(), 0, asGlPixelFormat(im.getComponents()), 
                GL_UNSIGNED_BYTE, im.getPixels());
    }
    
    
    
    
    protected static final void generateMipmap(TextureType type){
        glGenerateMipmap(type.asGLenum());
    }
    
    protected final static void setWrapping(TextureType type, WrapMode s){
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_S, s.asGLenum());
    }
    
    protected final static void setWrapping(TextureType type, WrapMode s, WrapMode t){
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_S, s.asGLenum());
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_T, t.asGLenum());
    }
    
    protected final static void setWrapping(TextureType type, WrapMode s, WrapMode t, WrapMode r){
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_S, s.asGLenum());
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_T, t.asGLenum());
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_R, r.asGLenum());
    }
    
    protected final static void setFilters(TextureType type, MinFilter min, MagFilter mag){
        glTexParameteri(type.asGLenum(), GL_TEXTURE_MIN_FILTER, min.asGLenum());
        glTexParameteri(type.asGLenum(), GL_TEXTURE_MAG_FILTER, mag.asGLenum());
    }
    
    
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
