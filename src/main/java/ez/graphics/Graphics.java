/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.graphics;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.glfwInit;

/**
 *
 * @author vlad
 */
public class Graphics {
    
    private static boolean isInit = false;
    
    private static int majorOpenGlVersion = 3;
    private static int minorOpenGlVersion = 3;
    
    public static void setGlVersion(int major, int minor){
        //if(isInit)throw new RuntimeException("OpenGL was");
        majorOpenGlVersion = major;
        minorOpenGlVersion = major;
    }
    
    public static boolean isInit(){return isInit;}
    
    public static void init(){
        if(isInit()) return;
        if(!glfwInit())
            throw new RuntimeException("Error init glfw");
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, majorOpenGlVersion);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, minorOpenGlVersion);
    }
}
