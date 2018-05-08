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
public class ColorRGBA implements Color{
    
    float red, green, blue, alpha;
    
    public ColorRGBA(float red, float green, float blue){
        this(red, green, blue, 1.0f);
    }
    
    public ColorRGBA(float red, float green, float blue, float alpha){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    
    
    @Override
    public float red() {return red;}
    
    public void red(float newRed) {red = newRed;}

    @Override
    public float green() {return green;}
    
    public void green(float newGreen) {green = newGreen;}
    
    @Override
    public float blue() {return blue;}
    
    public void blue(float newBlue) {blue = newBlue;}
    
    @Override
    public float alpha() {return alpha;}
    
    public void alpha(float newAlpha) {alpha = newAlpha;}
}
