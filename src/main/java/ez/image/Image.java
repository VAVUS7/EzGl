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
package ez.image;

import java.nio.ByteBuffer;
import static org.lwjgl.stb.STBImage.*;
import org.lwjgl.system.NativeResource;

/**
 *
 * @author vlad
 */
public class Image implements NativeResource{
    
    int components;
    int width, height;
    ByteBuffer pixels;
    
    public Image(ByteBuffer pixels, int width, int height, int components){
        if(components <=0 || components >4)
            throw new IllegalArgumentException
        ("The image can contain from 1 to 4 color components.");
        if(pixels.capacity() < imageBufSize(width, height, components))
            throw new IllegalArgumentException
        ("The buffer is too small to store an image of " + width + "x" + height + " pixels.");
        this.pixels = pixels; this.width = width; this.height = height; 
        this.components = components;
    }
    
    static int imageBufSize(int width, int height, int components){
        return width*height*components;
    }
    
    public int getWidth(){
        return width;
    }        
    
    public int getHeight(){
        return height;
    }
    
    public int getComponents(){
        return components;
    }
    
    public ByteBuffer getPixels(){
        return pixels;
    }
    
    public boolean isRGB(){
        return components == STBI_rgb || components == STBI_rgb_alpha;
    }
    
    public boolean isHasAlpha(){
        return components == STBI_grey_alpha || components == STBI_rgb_alpha;
    }
    
    @Override
    public void free(){
        if(pixels != null){
            stbi_image_free(pixels);
            pixels = null;
        }
    }
}
