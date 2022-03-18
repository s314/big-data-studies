import java.util.Objects;

public class Driver {
  String name;
  Trip trip;
  DriverStatus status = DriverStatus.ON_HOLD;

  public Driver(String name) {
    this.name = name;
  }

  public void SetTrip(Trip trip) {
    this.trip = trip;
    status = DriverStatus.ON_TRIP;
  }

  public void TakeOffTrip() {
    this.trip = null;
    status = DriverStatus.ON_HOLD;
  }

  public void RequestRepair() {
    status = DriverStatus.ON_REPAIR;
  }

  public void DoRepair() {
    if (Objects.isNull(trip))
      status = DriverStatus.ON_HOLD;
    else
      status = DriverStatus.ON_TRIP;
  }
}
