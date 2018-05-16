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

import static org.lwjgl.opengl.GL13.*;

/**
 *
 * @author vlad
 */
public final class TextureUnit {
    
    private final int unit;

    private TextureUnit(int unit){
        this.unit = unit;
    }
    
    public void active(){
        BindMap map;
        if((map = Context.currentContext().getBindMap()).getTextureUnit() != this){
            glActiveTexture(GL_TEXTURE0 + unit);
            map.setTextureUnit(this);
        }
    }
    
    public static TextureUnit unitOf(int unit){
        return new TextureUnit(unit);
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.unit;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TextureUnit other = (TextureUnit) obj;
        return this.unit == other.unit;
    }
}
