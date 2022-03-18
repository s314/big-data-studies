import java.util.Objects;

public class Petal {
  public String shape;

  public Petal() {
    this.shape = "Basic";
  }

  public Petal(String shape) {
    this.shape = shape;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Petal petal = (Petal) o;
        return shape.equals(petal.shape);
    }

  @Override
  public int hashCode() {
      return Objects.hash(shape);
  }

  @Override
  public String toString() {
      return "Petal{" +
              "shape='" + shape + '\'' +
              '}';
  }
}
