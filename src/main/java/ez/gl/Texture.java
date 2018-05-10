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

import ez.image.Image;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

/**
 *
 * @author vlad
 */
public class Texture implements GLObject{
    
    int texture;
    int sampler;
    
    private Texture(int texture) {
        this.texture = texture;
    }
    
    public Texture(Image im){
        texture = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texture);
        glTexImage2D(
                GL_TEXTURE_2D, 0, asGlPixelFormat(im.getComponents()), 
                im.getWidth(), im.getHeight(), 0, asGlPixelFormat(im.getComponents()), 
                GL_UNSIGNED_BYTE, im.getPixels());
    }
    
    public Texture(Image im, int samplerBinding){
        texture = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texture);
        glTexImage2D(
                GL_TEXTURE_2D, 0, asGlPixelFormat(im.getComponents()), 
                im.getWidth(), im.getHeight(), 0, asGlPixelFormat(im.getComponents()), 
                GL_UNSIGNED_BYTE, im.getPixels());
    }
    
    private static int asGlPixelFormat(int comp){
        switch(comp){
            case 1: return GL_LUMINANCE;
            case 2: return GL_LUMINANCE_ALPHA;
            case 3: return GL_RGB;
            case 4: return GL_RGBA;
            default: throw new IllegalArgumentException();
        }
    }
    
    public void genMipmap(){
        glBindTexture(GL_TEXTURE_2D, texture);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    
    public void bind(){
        glBindTexture(GL_TEXTURE_2D, texture);
    }
    
    public void setWrapping(WrapMode s, WrapMode t){
        glBindTexture(GL_TEXTURE_2D, texture);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, s.WRAP_MODE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, t.WRAP_MODE);
    }
    
    public void setFilters(MinFilter min, MagFilter mag){
        glBindTexture(GL_TEXTURE_2D, texture);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, min.MIN_FILTER);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, mag.MAG_FILTER);
    }
    
    @Override
    public boolean isExist(){
        return texture != NULLOBJ && glIsTexture(texture);
    }

    @Override
    public void delete(){
        if(isExist()){
            glDeleteTextures(texture);
            texture = NULLOBJ;
        }
    }

    public int asGL(){return texture;}
    
    
    public boolean isBind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
