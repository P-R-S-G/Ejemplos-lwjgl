/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import static org.lwjgl.opengl.GL11.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

/**
 *
 * @author writkas
 */
public class LWJGL_Example3 {
    
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
            Logger.getLogger(LWJGL_Example1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       glMatrixMode(GL_PROJECTION);
       glLoadIdentity();
       glOrtho(0, 800, 600, 0, 1, -1);
       glMatrixMode(GL_MODELVIEW);
       
       float blue = 1;
       float red = 1;
       float green = 1;
       
        // Game Loop
        
        while (!Display.isCloseRequested()) {
            
            if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                Display.destroy();
                System.exit(0);
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                blue -= 0.05;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                red -= 0.05;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                green -= 0.05;
            }
            
            /*
             *  Render
             */ 

            glColor3f(blue, red, green);
            
            // Line
            
            glBegin(GL_LINES);
                glVertex2i(50, 50); // x, y
                glVertex2i(100, 100);
                
                glVertex2i(100, 100);
                glVertex2i(150, 210);
            glEnd();

            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
}
