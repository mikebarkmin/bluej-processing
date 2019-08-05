import eu.barkmin.processing.scratch.*;

public class CatSketch extends BlueJPApplet
{
    
    CatSprite myCat;
    ScratchStage stage;
    
    public void settings() {
        size(800, 600);
    }
    
    public ScratchStage getStage() {
        return stage;
    }
    
    public void setup() {
        ScratchStage.init(this);
        stage = ScratchStage.getInstance();
        stage.setColor(0, 255, 100);
        myCat = new CatSprite();
        this.addObject(myCat);
    }
}
