class Daisy extends Enemy {

    private int distance = Math.round(this.pickRandom(40, 80));
    private int currentDistance = 0;
    private boolean up = false;

    Daisy(int x, int y) {
        super("daisy");
        this.setPosition(x, y);
    }

    Daisy() {
        super("daisy");
    }

    public void run() {
        super.run();
        if (currentDistance >= distance) {
            up = true;
        } else if (currentDistance <= -distance) {
            up = false;
        }

        if (!up) {
            this.changeY(+1);
            currentDistance++;
        } else {
            this.changeY(-1);
            currentDistance--;
        }
    }
}
