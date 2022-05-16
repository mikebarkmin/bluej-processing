import eu.barkmin.processing.scratch.*;

public class HalloweenSketch extends BlueJPApplet
{    
    int numberPumpkins = 10;
    ScratchStage stage;
    HouseSprite house;
    GhostSprite ghost;
    
    public void settings() {
        size(960, 540);
    }
    
    public void draw() {
        stage.playSound("bg");
    }
    
    public void setup() {
        ScratchStage.init(this, false);
        stage = ScratchStage.getInstance();
        stage.addBackdrop("bg", "sprites/background.jpg");
        stage.addSound("bg", "sounds/background.wav");
        house = new HouseSprite();
        stage.addSprite(house);
        stage.setColor(0);
        for (int i = 0; i < numberPumpkins; i++) {
            PumpkinSprite p = new PumpkinSprite();
            stage.addSprite(p);
        }
        ghost = new GhostSprite();
        stage.addSprite(ghost);
    }
}
