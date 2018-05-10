/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl.enums;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author vlad
 */
public enum TextureType implements GLenum{
    
    TEXTURE_2D(GL_TEXTURE_2D)
    
    ;
    
    private final int type;
    
    TextureType(int texType){
        type = texType;
    }
    
    @Override
    public int asGLenum() {return type;}
    
}
