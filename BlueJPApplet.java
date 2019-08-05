import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class BlueJPApplet extends PApplet
{
    private List<PObject> objects = new ArrayList<>();
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

    /**
     * Called directly after <b>setup()</b> and continuously calls the draw methods of all 
     * objects added to the applet until the program is stopped or
     * <b>pauseSketch()</b> is called. The <b>draw()</b> function is called
     * automatically and should never be called explicitly. It should always be
     * controlled with <b>resumeSketch()</b>, <b>pauseSketch()</b> and <b>redrawSketch()</b>.
     */
    public void draw() {
        for(PObject object : objects) {
            object.draw(this);
        }
    }

    /**
     * Adds an object to the sketch.
     */
    public void addObject(PObject object) {
        objects.add(object);
    }

    /**
     * Removes an object from the sketch.
     */
    public void removeObject(PObject object) {
        objects.remove(object);
    }

    /**
     * Lowers an object.
     */
    public void lowerObject(PObject object) {
        int index = objects.indexOf(object);
        if (index > 0) { 
            Collections.swap(objects, index, index-1);
        }
    }

    /**
     * Raises an object.
     */
    public void raiseObject(PObject object) {
        int index = objects.indexOf(object);
        if (index > -1 && index < objects.size() - 1) { 
            Collections.swap(objects, index+1, index);
        }  
    }

    /**
     * Get all Objects in the sketch.
     */
    public List<PObject> getObjects() {
        return objects;
    }

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
