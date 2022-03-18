public class Trip {
  String destination;
  Car car;
  boolean finished = false;
  CarState carState;

  public Trip(String destination) {
    this.destination = destination;
  }

  public void SetCar(Car car) {
    this.car = car;
  }

  public void MarkTripFinish(CarState state) {
    carState = state;
    finished = true;
  }
}
