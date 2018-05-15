/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import ez.gl.Program;
import ez.gl.Shader;
import ez.gl.enums.ShaderType;
import ez.gl.texture.Texture2D;
import ez.gl.window.Graphics;
import ez.gl.window.Window;
import java.io.IOException;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL12.GL_TEXTURE_3D;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

/**
 *
 * @author vlad
 */
public class WindowSystemTest {
    
    
    public static void main(String[] args) throws IOException{
        System.out.println("RUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUN");
        Graphics.init();
        Window w = new Window(500, 500, "window");
        w.show();
        w.makeCurrent();
        GL.createCapabilities();
        
        Program prog;
        Shader v = new Shader(ShaderType.VERTEX, "src/test/resources/shaders/v-_-pt-t.glsl");
        Shader f = new Shader(ShaderType.FRAGMENT, "src/test/resources/shaders/f-s-t.glsl"); 
        
        Texture2D tex = new Texture2D();
        
        
        while (!w.shouldClose()) {
            
            
            w.swapBuffers();
            Window.pollEvents();
        }
    }
}
