/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplos;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 *
 * @author writkas
 */
public class LWJGL_Example2{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // Create Display
        
        try {
            Display.setDisplayMode (new DisplayMode(800, 600));
            Display.create ();
            Display.setTitle("Hello!!");
        } catch (LWJGLException ex) {
            Logger.getLogger(LWJGL_Example2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       glMatrixMode(GL_PROJECTION);
       glLoadIdentity();
       glOrtho(0, 640, 480, 0, 1, -1);
       glMatrixMode(GL_MODELVIEW);
        
        // Game Loop
        
        while (!Display.isCloseRequested()) {
            
            if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                Display.destroy();
                System.exit(0);
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                System.out.println ("up!");
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                System.out.println ("left!");
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                System.out.println ("right!");
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                System.out.println ("down!");
            }
            
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
}
