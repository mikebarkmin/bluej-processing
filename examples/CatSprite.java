import eu.barkmin.processing.scratch.*;

public class CatSprite extends ScratchSprite
{
    
    public CatSprite()
    {
       this.addCostume("cat", "sprites/cat.png");
       this.setOnEdgeBounce(true);
    }

    public void run() {
        this.move(2);
    }
}
