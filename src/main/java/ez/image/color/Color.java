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
package ez.image.color;

/**
 *
 * @author vlad
 */
public interface Color {
    
    public static final Color
            RED = of(1.0f, 0.0f, 0.0f),
            GREEN = of(0.0f, 1.0f, 0.0f),
            BLUE = of(0.0f, 0.0f, 1.0f);
    
    
    public float red();
    public float green();
    public float blue();
    public float alpha();
    
    public static Color of(float red, float green, float blue){
        return new RGBColor(red, green, blue);
    }
    
}

class RGBColor implements Color{
    
    private final float red, green, blue;
    
    RGBColor(float red, float green, float blue) {
        this.red = red; this.green = green; this.blue = blue;
    }
    
    @Override
    public float red() {return red;}

    @Override
    public float green() {return green;}

    @Override
    public float blue() {return blue;}

    @Override
    public float alpha() {return 1.0f;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final RGBColor other = (RGBColor) obj;
        if (Float.floatToIntBits(this.red)  != Float.floatToIntBits(other.red) &&
            Float.floatToIntBits(this.green)!= Float.floatToIntBits(other.green) &&
            Float.floatToIntBits(this.blue) != Float.floatToIntBits(other.blue)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Float.floatToIntBits(this.red);
        hash = 97 * hash + Float.floatToIntBits(this.green);
        hash = 97 * hash + Float.floatToIntBits(this.blue);
        return hash;
    }
    
    
    
}
