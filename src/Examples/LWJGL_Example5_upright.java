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
public class LWJGL_Example5_upright {
    
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
       
       int p1x = 150, p1y = 150;
       int p2x = 200, p2y = 150;
       int p3x = 200, p3y = 200;
       int p4x = 150, p4y = 200;
       
        // Game Loop
        
        while (!Display.isCloseRequested()) {
            // Borra la pantalla 
            glClear(GL_COLOR_BUFFER_BIT);
            
            
            if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                Display.destroy();
                System.exit(0);
            }
            
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_UP)&&(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
                p1y += -20;
                p2y += -20;
                p3y += -20;
                p4y += -20;
                
                p1x += 20;
                p2x += 20;
                p3x += 20;
                p4x += 20;
            }
            
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)&&(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
                p1y += 20;
                p2y += 20;
                p3y += 20;
                p4y += 20;
                
                p1x += 20;
                p2x += 20;
                p3x += 20;
                p4x += 20;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)&&(Keyboard.isKeyDown(Keyboard.KEY_UP))) {
                p1x += -20;
                p2x += -20;
                p3x += -20;
                p4x += -20;
                
                p1y += -20;
                p2y += -20;
                p3y += -20;
                p4y += -20;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)&&(Keyboard.isKeyDown(Keyboard.KEY_DOWN))) {
                p1x += -20;
                p2x += -20;
                p3x += -20;
                p4x += -20;
                
                p1y += 20;
                p2y += 20;
                p3y += 20;
                p4y += 20;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_UP)){
            
                p1y += -20;
                p2y += -20;
                p3y += -20;
                p4y += -20;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                p1y += 20;
                p2y += 20;
                p3y += 20;
                p4y += 20;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
                p1x += 20;
                p2x += 20;
                p3x += 20;
                p4x += 20;
            }
            
            else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                p1x += -20;
                p2x += -20;
                p3x += -20;
                p4x += -20;
            }
            
            /*
             *  Render
             */ 

            glColor3f(1f, 1f, 0f);
            
            // Line
            
            glBegin(GL_QUADS);
                glVertex2i(p1x, p1y); // upper-left
                glVertex2i(p2x, p2y); // upper-right
                glVertex2i(p3x, p3y); // bottom-rigth
                glVertex2i(p4x, p4y); // bottom-left
            glEnd();  

            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
}

