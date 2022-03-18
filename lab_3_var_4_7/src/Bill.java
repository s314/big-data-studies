import java.util.HashMap;

public class Bill {
  HashMap<Integer, Service> activeServices = new HashMap<>();
  int sum;

  public void AddService(int id, Service service) {
    activeServices.put(id, service);
    sum += service.price;
  }

  public void RemoveService(int id) {
    sum -= activeServices.get(id).price;
    activeServices.remove(id);
  }

  public int GetSum() {
    return sum;
  }
}
