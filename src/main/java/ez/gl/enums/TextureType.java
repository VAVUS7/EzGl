/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl.enums;

import ez.gl.GLenum;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_TEXTURE_CUBE_MAP;
import static org.lwjgl.opengl.GL30.GL_TEXTURE_1D_ARRAY;
import static org.lwjgl.opengl.GL31.GL_TEXTURE_RECTANGLE;

/**
 *
 * @author vlad
 */
public enum TextureType implements GLenum{
    
    TEXTURE_2D(GL_TEXTURE_2D),
    
    TEXTURE_1D_ARRAY(GL_TEXTURE_1D_ARRAY),
    
    TEXTURE_RECTANGLE(GL_TEXTURE_RECTANGLE),
    
    TEXTURE_CUBE_MAP(GL_TEXTURE_CUBE_MAP);
    
    private final int type;
    
    TextureType(int texType){
        type = texType;
    }
    
    @Override
    public int asGLenum() {return type;}
    
}
