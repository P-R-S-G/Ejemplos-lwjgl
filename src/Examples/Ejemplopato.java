/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import static org.lwjgl.opengl.GL11.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 *
 * @author writkas
 */
public class Ejemplopato {

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
        
        // Game Loop
        
        while (!Display.isCloseRequested()) {
            
            /*
             *  Render
             */  

            // Line
            
            glBegin(GL_LINES);
                glVertex2i(390,350 );
                glVertex2i(390, 380);
            glEnd();  
            
            // Quad
            
            glBegin(GL_QUADS);
                glVertex2i(400, 400); // upper-left
                glVertex2i(380, 400); // upper-right
                glVertex2i(310, 560); // bottom-rigth
                glVertex2i(480, 560); // bottom-left
            glEnd();  
              
            glBegin(GL_QUADS);
                glVertex2i(200,100 ); // upper-left
                glVertex2i(150, 300); // upper-right
                glVertex2i(400, 400); // bottom-rigth
                glVertex2i(150, 300); // bottom-left
            glEnd();  
            
            
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
}

