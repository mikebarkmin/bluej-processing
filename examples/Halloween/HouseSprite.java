import eu.barkmin.processing.scratch.ScratchSprite;

public class HouseSprite extends ScratchSprite
{
    public HouseSprite() {
        this.addCostume("on", "sprites/castle_on.png");
        this.addCostume("off", "sprites/castle_off.png");
        this.addSound("door", "sounds/door.mp3");
        this.setSize(70);
    }
    
    public void run() {
        if (this.isTouchingMousePointer()) {
            this.switchCostume("on");
        } else {
            this.switchCostume("off");
        }
        if(isTouchingMousePointer()) {
            this.playSound("door");
        }
    }
}
