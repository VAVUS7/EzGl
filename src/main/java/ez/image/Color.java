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

import static java.lang.Math.*;

/**
 *
 * @author vlad
 */
public interface Color {
    
    
    public static byte toByteComponent(short c){
        return (byte)(c>>8);
    }
    
    public static byte toByteComponent(float c){
        c = min(max(c, 0.0f), 1.0f);
        return (byte)(c*255);
    }
    
    public static short toShortComponent(byte c){
        return (short)(c<<8);
    }
    
    public static short toShortComponent(float c){
        c = min(max(c, 0.0f), 1.0f);
        return (short)(c*65535);
    }
    /*TODO
    public static float toFloatComponent(byte c){
        return ();
    }
    
    public static float toFloatComponent(short c){
        c = min(max(c, 0.0f), 1.0f);
        return (c*255);
    }*/
}
