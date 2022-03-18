public class Tanker extends Cargo {

  int fuel;

  public Tanker() {
    payload = 150;
    fuel = 0;
  }

  public void refuel(int amount) {
    fuel += amount;
  }

}
