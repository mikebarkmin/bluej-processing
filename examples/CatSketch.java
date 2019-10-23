import eu.barkmin.processing.scratch.*;

public class CatSketch extends BlueJPApplet
{    
    public void settings() {
        size(800, 600);
    }
    
    public ScratchStage getStage() {
        return ScratchStage.getInstance();
    }
    
    public void setup() {
        ScratchStage.init(this);
    }
}
