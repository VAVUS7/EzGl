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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import static org.lwjgl.stb.STBImage.*;
import org.lwjgl.system.MemoryStack;
import static org.lwjgl.system.MemoryStack.*;
import org.lwjgl.system.MemoryUtil;

/**
 *
 * @author vlad
 */
public class ImageLoader {
    
    public static Image load(String file){
       try(MemoryStack s = stackPush()){
            IntBuffer width = s.mallocInt(1);
            IntBuffer height = s.mallocInt(1);
            IntBuffer components = s.mallocInt(1);
            ByteBuffer pixels = stbi_load
                    (file, width, height, components, STBI_default);            
            return new Image(pixels, width.get(0), height.get(0), components.get(0));
        }
    }
    
    public static Image load(File file){
       return load(file.getAbsolutePath());
    }
        
    public static Image load(InputStream in) throws IOException{
        ByteBuffer data = MemoryUtil.memAlloc(in.available());
        for(int i = 0; i<in.available(); i++){
            data.put((byte)in.read());
        }
        
        try(MemoryStack s = stackPush()){
            IntBuffer width = s.mallocInt(1);
            IntBuffer height = s.mallocInt(1);
            IntBuffer components = s.mallocInt(1);
            ByteBuffer pixels = stbi_load_from_memory
                    (data, width, height, components, STBI_default);            
            
            return new Image(pixels, width.get(0), height.get(0), components.get(0));
        }
    }
}
