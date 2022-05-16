class Bernd extends Enemy {

    private boolean scaled = false;

    public Bernd(int x, int y) {
        super("bernd");
        this.setPosition(x, y);
    }

    public Bernd() {
        super("bernd");
    }

    public void run() {
        super.run();
        if (this.getTimer().everyMillis(1000)) {
            scaled = !scaled;
        }
        if (scaled) {
            this.setSize(150);
        } else {
            this.setSize(100);
        }
    }
}