
package Examples;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Oskar
 */
public class LWJGL_Example8_cube_timer {

    private static long lastFrame;

    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private static double getDelta() {
        long currentTime = getTime();
        double delta = (double) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }

    public static void main(String[] args) {
        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle("Timer Demo");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }

        int x = 100;
        int y = 100;
        int dx = 1;
        int dy = 1;

        // Initialization code OpenGL
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);

        lastFrame = getTime();
        
        Box2D miBox = new Box2D (50.0f, 50.0f, 20.0f);
        
        float bColor = 0.0f;
        long actualTime, futureTime = 0;
        boolean wait = false;

        while (!Display.isCloseRequested()) {
            // Render

            glClear(GL_COLOR_BUFFER_BIT);            
            glRecti(200, 200, 300, 300);
           
            if (wait == false) {
                actualTime = getTime();
                futureTime = actualTime + 1000;
                wait = true;
            }
            
            if (futureTime <= getTime()) {
                System.out.println(getTime() + " - " + bColor);
                bColor += 0.1f;
                glColor3f(0.1f, 0.1f, bColor);
                wait = false;
            }           

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
        System.exit(0);
    }
}