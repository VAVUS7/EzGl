/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import ez.gl.Shader;
import ez.gl.enums.ShaderType;
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
    
    
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("RUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUN");
        Graphics.init();
        Window w = new Window(500, 500, "window");
        w.show();
        w.makeCurrent();
        GL.createCapabilities();
        
        Shader vsh = new Shader(ShaderType.VERTEX, "src/main/resources/shaders/vertex-pos-col.glsl");
        
        int t = GL11.glGenTextures();
        int tN = 0;
        while (!w.shouldClose()) {
            GL11.glBindTexture(GL_TEXTURE_2D, t);
            tN++;
            glGenerateMipmap(GL_TEXTURE_3D);
            System.out.println(GL11.glGetError());
            w.swapBuffers();
            GLFW.glfwPollEvents();
        }
    }
}
