/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import ez.graphics.Graphics;
import ez.graphics.Window;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author vlad
 */
public class WindowSystemTest {
    
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("RUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUNRUN");
        Graphics.init();
        Window w = new Window(500, 500, "window", 0, 0, true);
        w.show();
        Thread.sleep(1000);
    }
}
