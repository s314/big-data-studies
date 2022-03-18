import java.util.Objects;

public class Rose {
  Bud bud;
  FlowerState state = FlowerState.GROWING;

  public Rose(String color) {
    bud = new Bud(color);
  }

  public void Bloom() {
    state = FlowerState.BLOOM;
  }

  public void Wither() {
    state = FlowerState.WITHER;
  }

  public void PrintBudColor() {
    System.out.println(bud.color);
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rose rose = (Rose) o;
        return bud.equals(rose.bud) && state == rose.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bud, state);
    }

    @Override
    public String toString() {
        return "Rose{" +
                "bud=" + bud +
                ", state=" + state +
                '}';
    }
}
