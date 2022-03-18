public class Cargo implements Ship {
  
  String destination;
  public int payload = 10;

  @Override
  public void travelTo(String destination) {
    this.destination = destination;
  }

}
