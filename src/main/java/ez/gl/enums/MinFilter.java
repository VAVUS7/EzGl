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
package ez.gl.enums;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_LINEAR_MIPMAP_LINEAR;
import static org.lwjgl.opengl.GL11.GL_LINEAR_MIPMAP_NEAREST;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_NEAREST_MIPMAP_LINEAR;
import static org.lwjgl.opengl.GL11.GL_NEAREST_MIPMAP_NEAREST;

/**
 *
 * @author vlad
 */
public enum MinFilter implements GLenum{
        
    NEAREST(GL_NEAREST), LINEAR(GL_LINEAR),
    NEAREST_MIPMAP_NEAREST(GL_NEAREST_MIPMAP_NEAREST),
    LINEAR_MIPMAP_NEAREST(GL_LINEAR_MIPMAP_NEAREST),
    NEAREST_MIPMAP_LINEAR(GL_NEAREST_MIPMAP_LINEAR),
    LINEAR_MIPMAP_LINEAR(GL_LINEAR_MIPMAP_LINEAR);
    
    private final int filter;
    
    MinFilter(int filter){
        this.filter = filter;
    }

    @Override
    public int asGLenum() {return filter;}
}
