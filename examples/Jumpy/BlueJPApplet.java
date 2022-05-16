import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class BlueJPApplet extends PApplet
{
    private boolean isRunning = false;

    /**
     *
     * Use this method to call size().
     *
     * @see PApplet#fullScreen()
     * @see PApplet#setup()
     * @see PApplet#size(int,int)
     * @see PApplet#smooth()
     */
    public abstract void settings();

    /**
     * The <b>setup()</b> function is called once when the program starts. It's
     * used to define initial
     * enviroment properties such as screen size and background color and to
     * load media such as images
     * and fonts as the program starts. There can only be one <b>setup()</b>
     * function for each program and
     * it shouldn't be called again after its initial execution.
     */
    public abstract void setup();

    public void draw() {}
    
    /**
     * Pauses the sketch.
     */
    public void pauseSketch() {
        this.noLoop();
    }

    /**
     * Resumes the sketch.
     */
    public void resumeSketch() {
        this.loop();
    }

    /**
     * Forces a redraw, even if the sketch is paused.
     */
    public void redrawSketch() {
        this.redraw();
    }

    /**
     * Starts the sketch.
     */
    public void runSketch() {
        if (!isRunning) {
            super.runSketch();
            isRunning = true;
        }
    }
}
