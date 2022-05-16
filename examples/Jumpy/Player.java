import java.util.Iterator;
import eu.barkmin.processing.scratch.*;

public class Player extends ScratchAnimatedSprite {

    public enum PlayerState {
        IDLE, JUMP, FALL, DEAD
    }
    public final float FRICTION = 0.99f;
    public final float GRAVITY = 0.5f;
    public final float JUMP_STRENGTH = 20;
    public final float JUMP_HEIGHT = 280;
    public final float SPEED = 10;

    private float velocityX = 0;
    private float velocityY = 0;

    private PlayerState state = PlayerState.IDLE;

    // a sprite only for hit detection with plaforms
    private ScratchSprite platformHit;

    public Player() {
        this.addAnimation("default", "assets/player_%d.png", 2);
        this.setAnimationInterval(300);

        platformHit = new ScratchSprite("platform", "assets/player_hitbox.png");

        int[] xPoints = {0, 80, 80, 0};
        int[] yPoints = {0, 0, 35, 35};

        this.setHitbox(xPoints, yPoints);
        platformHit.setTransparency(0);
    }

    public void accelerate(float accelerationX, float accelerationY) {
        velocityX += accelerationX;
        velocityY += accelerationY;
        if (velocityY < 0) {
            state = PlayerState.FALL;
        } else if (velocityY > 0) {
            state = PlayerState.JUMP;
        } else {
            state = PlayerState.IDLE;
        }
    }

    public void move(float xDelta, float yDelta) {
        this.changeX(xDelta);
        this.changeY(yDelta);

        ScratchStage stage = ScratchStage.getInstance();
        if(this.getX() < 0) {
            this.setX(stage.getWidth());
        }

        if(this.getX() > stage.getWidth()) {
            this.setX(0);
        }
    }

    public void moveRight() {
        move(SPEED, 0);
    }

    public void moveLeft() {
        move(-SPEED, 0);
    }

    public void jump() {
        accelerate(0, JUMP_STRENGTH);
        state = PlayerState.JUMP;
    }

    public void run() {
        this.playAnimation("default");

        if(state == PlayerState.DEAD) {
            velocityY += -GRAVITY;
            setTint(255);
            move(-velocityX, -velocityY);
            return;
        }

        if(state != PlayerState.IDLE && isKeyPressed(37)) {
            moveLeft();
        }
        if(state != PlayerState.IDLE && isKeyPressed(39)) {
            moveRight();
        }
        move(-velocityX, -velocityY);
        velocityX *= FRICTION;
        velocityY *= FRICTION;

        accelerate(0, -GRAVITY);

        platformHit.setPosition(this.getX(), this.getY());
        platformHit.draw();

        ScratchStage stage = ScratchStage.getInstance();

        // collesion detection
        if (state != PlayerState.JUMP) {
            for(ScratchSprite s : stage.findSprites(Platform.class)) {
                Platform platform = (Platform) s;
                if (platform.isTouchingSprite(platformHit)) {
                    velocityY = 0;
                    state = PlayerState.IDLE;
                    this.setY(platform.getY() - 20);
                    jump();
                }
            }
        }

        // collision detection with enemy
        for(ScratchSprite s : stage.findSprites(Enemy.class)) {
            if(s.isTouchingSprite(platformHit)) {
                stage.removeSprite(s);
                velocityY = 0;
                state = PlayerState.IDLE;
                jump();
            } else if(s.isTouchingSprite(this)) {
                state = PlayerState.DEAD;
            }
        }
    }
}
