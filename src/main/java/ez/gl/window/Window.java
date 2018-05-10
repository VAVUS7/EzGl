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
package ez.gl.window;

import ez.gl.Context;
import ez.gl.ContextBindMap;
import ez.image.Image;
import java.util.LinkedList;
import java.util.List;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWImage;
/**
 *
 * @author vlad
 */
public class Window extends Context{
    
    
    final long glfwContext;
    
    public Window(int width, int height, String title){
        this(width, height, title, 0, 0);
    }
    
    public Window(int width, int height, String title, Window share){
        this(width, height, title, 0, share.glfwContext);
    }
    
    Window(int width, int height, String title, long monitor, long share){
        glfwContext = glfwCreateWindow(width, height, title, monitor, share);
        bindMap = new ContextBindMap();
    }
    
    public boolean shouldClose(){
        return glfwWindowShouldClose(glfwContext);
    }
    
    public void show(){
        glfwShowWindow(glfwContext);
    }
    
    public void hide(){
        glfwHideWindow(glfwContext);
    }

    @Override
    public void makeCurrent() {
        glfwMakeContextCurrent(glfwContext);
        super.makeCurrent();
    }
    
    
    
    private final ContextBindMap bindMap;
    @Override
    public ContextBindMap getContextBindMap() {
        return bindMap;
    }
    
    
    
}
