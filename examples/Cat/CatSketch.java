import eu.barkmin.processing.scratch.*;

public class CatSketch extends BlueJPApplet
{    
    public ScratchStage stage;
    
    public void settings() {
        size(800, 600);
    }
    
    public void setup() {
        ScratchStage.init(this);
        stage = ScratchStage.getInstance();
    }
}
