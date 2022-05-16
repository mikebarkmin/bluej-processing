public class Frank extends Enemy {

  int distance = Math.round(pickRandom(20, 40));
  int currentDistance = 0;
  boolean back = false;
  
  public Frank(int x, int y) {
    super("frank");
    this.setPosition(x, y);
  }

  public Frank() {
    super("frank");
  }
  
  public void run() {
    super.run();
    if (currentDistance >= distance) {
      back = true;
    } else if (currentDistance <= -distance) {
      back = false;
    }
    
    if(!back) {
      this.move(1);
      currentDistance++;
    } else {
      this.move(-1);
      currentDistance--;
    }
  }
}
