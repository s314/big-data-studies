public class Point2D {
  
  int x, y;

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    // Если сравниваем с самим собой
    if (obj == this) {
      return true;
    }

    // Если это не тот класс
    if (obj == null || getClass() != obj.getClass()) return false;

    // Теперь можем сравнить поля
    Point2D p = (Point2D) obj;

    return this.x == p.x && this.y == p.y;
  }

  @Override
  public int hashCode() {
    return 2*x + 3*y;
  }

}
