import java.util.Objects;

public class Bud {
  public String color;

  public Petal[] petals;

  public Bud(String color) {
    petals = new Petal[10];

    for (int i = 0; i < 10; i++) {
      petals[i] = new Petal();
    }

    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Bud bud = (Bud) o;
      return color.equals(bud.color);
  }

  @Override
  public int hashCode() {
      return Objects.hash(color);
  }

  @Override
  public String toString() {
      return "Bud{" +
              "color='" + color + '\'' +
              '}';
  }
}
