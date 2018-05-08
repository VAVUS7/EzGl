/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.image.color;

/**
 *
 * @author vlad
 */
public enum Colors implements Color{
    RED(1.0f, 0.0f, 0.0f),
    GREEN(0.0f, 1.0f, 0.0f),
    BLUE(0.0f, 0.0f, 1.0f);
    
    
    private final float red, green, blue;
    
    Colors(float red, float green, float blue) {
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
}