import java.util.ArrayList;

public class Helpdesk {
  ArrayList<Route> routes = new ArrayList<>();

  public void addRoute(String time, String destination, int cost) {
    routes.add(
      new Route(time, destination, cost)
    );
  }

  class Route {
    String time;
    String destination;
    int cost;

    public Route(String time, String destination, int cost) {
      this.time = time;
      this.destination = destination;
      this.cost = cost;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public void setDestination(String destination) {
      this.destination = destination;
    }

    public void setCost(int cost) {
      this.cost = cost;
    }

    public String getTime() {
      return time;
    }

    public String getDestination() {
      return destination;
    }

    public int getCost() {
      return cost;
    }

    @Override
    public String toString() {
        return "Route{" +
                "time='" + time + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                '}';
    }
  }
}
