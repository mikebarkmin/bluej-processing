import eu.barkmin.processing.scratch.*;

public class Jumpy extends BlueJPApplet
{
    private Player player;
    private ScratchStage stage;
    private int level;

    public void settings() {
        size(800, 1000);
    }

    public void setup() {
        ScratchStage.init(this);
        stage = ScratchStage.getInstance();
        
        play();
    }

    private void play() {
        level = 1;
        
        player = new Player();
        player.setPosition(width / 2, height - 40);
        stage.addSprite(player);

        generatePlatforms();
        generateEnemies();
    }

    private void generatePlatforms() {

        // platform below player
        stage.removeSprites(Platform.class);
        stage.addSprite(new Platform(width / 2, height - 10));

        int neededPlatforms = Math.round(height / player.JUMP_HEIGHT);
        int numberOfPlatforms = Math.round(neededPlatforms + random(5));
        for (int i = 0; i < numberOfPlatforms; i++) {
            if (neededPlatforms > 0) {
                float y = constrain(height - i*player.JUMP_HEIGHT - random(5), 40, height - 40);
                float x = random(60, width - 60);
                stage.addSprite(new Platform(x, y));
                neededPlatforms--;
            } else {
                stage.addSprite(new Platform(random(60, width - 60), random(20, height - 20)));
            }
        }
    }

    private void generateEnemies() {
        stage.removeSprites(Enemy.class);
        for (int i = 0; i < level; i++) {
            int e = Math.round(random(0, 2));
            Enemy enemy = null;
            switch (e) {
                case 0:
                    enemy = new Daisy();
                    break;
                default:
                    enemy = new Bernd();
                    break;
            }
            float x = random(60, width - 60);
            float y = random(60, height - 60);

            while(x > player.getX() - player.getWidth() && x < player.getX() + player.getWidth()) {
                x = random(60, width - 60);
            }
            enemy.setPosition(x, y);

            stage.addSprite(enemy);
        }
    }

    public void keyPressed() {
        if (keyCode == 82) {
            play();
        }
    }

    public void draw() {
        if (stage.findSprites(Enemy.class).size() == 0) {
            level++;
            generateEnemies();
        }

        fill(0);
        textAlign(CENTER);
        text("Level: " + level, width / 2, 20);
    }
}
