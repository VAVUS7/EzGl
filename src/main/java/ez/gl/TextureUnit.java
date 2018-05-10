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

import static org.lwjgl.opengl.GL11.glGetInteger;
import org.lwjgl.opengl.GL20;
import static org.lwjgl.opengl.GL20.GL_MAX_TEXTURE_IMAGE_UNITS;
import org.lwjgl.opengl.GL32;

/**
 *
 * @author vlad
 */
public final class TextureUnit {
    
    static final ThreadLocal<TextureUnit> ACTIVE_UNIT = new ThreadLocal<>();
    static int maxUnits = 0;
    static TextureUnit[] units = null;
    
    int unit;
    final ThreadLocal<Texture> usedTexture;
    
    TextureUnit(int unit){
        this.unit = unit;
        usedTexture = new ThreadLocal<>();
    }
    
    public static TextureUnit active(){
        return ACTIVE_UNIT.get();
    }
    
    public static TextureUnit get(int unit){
        if(units == null){
            units = new TextureUnit[getMaxTexUnits()];
            for(int i=0; i<units.length; i++){
                units[i] = new TextureUnit(unit);
            }
        }
        if(unit < 0 || unit > maxUnits)
            throw new IllegalArgumentException("unit must be from 0 to " + maxUnits);
        return units[unit];
    }
    
    public static int getMaxTexUnits(){
        if(maxUnits == 0)
            maxUnits = glGetInteger(GL_MAX_TEXTURE_IMAGE_UNITS);
        return maxUnits;
    }
}
