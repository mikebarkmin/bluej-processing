import eu.barkmin.processing.scratch.ScratchAnimatedSprite;

public class GhostSprite extends ScratchAnimatedSprite {
    
    private int speed = 8;
    
    public GhostSprite() {
        this.addAnimation("idle", "sprites/ghost/ghost_%02d.png", 10);
        this.addSound("laugh", "sounds/ghost.mp3");
        this.setSize(70);
    }
    
    public void run() {
        if(isKeyPressed(37)) { 
            this.changeX(-speed);
        } else if (isKeyPressed(39)) {
            this.changeX(speed);
        }
        if(isKeyPressed(38)) {
            this.changeY(-speed);
        } else if(isKeyPressed(40)) {
            this.changeY(speed);
        }
        if(isTouchingMousePointer()) {
            this.playSound("laugh");
        }
        this.playAnimation("idle");
    }
}