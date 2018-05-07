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
package ez.graphics;

import ez.graphics.gl.ContextBindMap;
import ez.image.Image;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWImage;
/**
 *
 * @author vlad
 */
public class Window {
    
    public Context context;
    
    List<Scene> scenes = new LinkedList<>();
    
    public Window(int width, int height, String title, long monitor, long share, boolean supportOpenGl){
        long window = glfwCreateWindow(width, height, title, monitor, share);
        context = new GlContext(window);
    }
    
    public void addScene(Scene scene){
        scenes.add(scene);
    }
    
    public void addSceneBack(Scene scene){
        scenes.add(scenes.size()-1, scene);
    }
    
    
    public void draw(){
        context.makeCurrent();
        for(Scene sc : scenes)
            sc.draw();
        glfwSwapBuffers(context.getGlfwContext());
    }
    
    public boolean shouldClose(){
        return glfwWindowShouldClose(context.getGlfwContext());
    }
    
    public void setIcon(Image im){
        glfwSetWindowIcon(context.getGlfwContext(), new GLFWImage.Buffer(im.getPixels()));
    }
    
    public void show(){
        glfwShowWindow(context.getGlfwContext());
    }
    
    public void hide(){
        glfwHideWindow(context.getGlfwContext());
    }
    
    
    
}

class GlContext extends Context{
    
    private final ContextBindMap bindMap;
    
    GlContext(long window){
        super(window);
        bindMap = new ContextBindMap();
    }
    
    @Override
    public ContextBindMap getContextBindMap() {return bindMap;}
    
}