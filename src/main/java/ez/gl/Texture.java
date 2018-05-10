/*
 * The MIT License
 *
 * Copyright 2018 vlad.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ez.gl;

import ez.gl.enums.MinFilter;
import ez.gl.enums.MagFilter;
import ez.gl.enums.TextureType;
import ez.gl.enums.WrapMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

/**
 *
 * @author vlad
 */
public abstract class Texture implements ObjectGLBind{
    
    int texture;
    
    protected Texture() {
        texture = glGenTextures();
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
    
    /**
     * Возвращает тип данного объекта текстуры.
     * @return тип текстуры.
     */
    public abstract TextureType getType();
    
    
    @Override
    public void delete(){
        if(texture != NULLOBJ){
            glDeleteTextures(texture);
            texture = NULLOBJ;
        }
    }
    
    protected final static void genMipmap(TextureType type){
        glGenerateMipmap(type.asGLenum());
    }
    
    protected final static void bindTexture(Texture tex, TextureType type){
        ContextBindMap map;
        if((map = Context.currentContext().getContextBindMap()).getTexture() != tex){
            glBindTexture(type.asGLenum(), tex.texture);
            map.setTexture(tex);
        }
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
        glTexParameteri(type.asGLenum(), GL_TEXTURE_WRAP_R, s.asGLenum());
    }
    
    protected final static void setFilters(TextureType type, MinFilter min, MagFilter mag){
        glTexParameteri(type.asGLenum(), GL_TEXTURE_MIN_FILTER, min.asGLenum());
        glTexParameteri(type.asGLenum(), GL_TEXTURE_MAG_FILTER, mag.asGLenum());
    }
}
