import eu.barkmin.processing.scratch.*;
import processing.core.*;


public class CatSprite extends ScratchSprite implements PObject
{
    
    public CatSprite()
    {
       super("cat", "sprites/cat.png");
       this.setOnEdgeBounce(true);
    }

    public void draw(PApplet pApplet)
    {
        super.draw();
        this.move(2);
    }
}
