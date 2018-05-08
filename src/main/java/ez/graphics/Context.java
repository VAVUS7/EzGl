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
import static org.lwjgl.glfw.GLFW.*;

/**
 *
 * @author vlad
 */
public class Context{
    
    private final ContextBindMap bindMap;    
    private final long context;
    
    Context(long window){
        context = window;
        bindMap = new ContextBindMap();
    }
    
    private static final ThreadLocal<Context> CURRENT_CONTEXT = new ThreadLocal<>();
    public static Context currentContext(){return CURRENT_CONTEXT.get();}
    
    public void makeCurrent(){
        if(!isCurrent()){
            glfwMakeContextCurrent(context);
            CURRENT_CONTEXT.set(this);
        }
    };
    
    long getGlfwContext(){return context;}
    
    public ContextBindMap getContextBindMap(){return bindMap;};
    
    public boolean isCurrent(){return this == currentContext();}
}