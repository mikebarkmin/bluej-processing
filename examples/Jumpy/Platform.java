import eu.barkmin.processing.scratch.ScratchSprite;

public class Platform extends ScratchSprite {
    public Platform(float x, float y) {
        super("platform", "assets/platform.png");

        this.setPosition(x, y);
    }
}
