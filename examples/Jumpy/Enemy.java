import eu.barkmin.processing.scratch.*;

public class Enemy extends ScratchAnimatedSprite {
  public Enemy(String name) {
    this.addAnimation("default", "assets/" + name + "_%1d.png", 2);
  }
  
  public void run() {
    this.playAnimation("default");
  }
}
