import java.util.HashSet;

public class Figure {
  
  HashSet<Point2D> points = new HashSet<>();


  // Добавление точки
  public void AddPoint(int x, int y) {
    points.add(new Point2D(x, y));
  }
  

  // Сравнение фигур
  @Override
  public boolean equals(Object obj) {
    // Если сравниваем с самим собой
    if (obj == this) {
      return true;
    }

    // Если это не фигура
    if (obj == null || getClass() != obj.getClass()) return false;

    // Теперь можем сравнить поля
    Figure fig = (Figure) obj;

    // Сравнить со всеми возможными поворотами фигуры
    boolean equal = false;
    Figure normalized = this.Normalized();

    // Поворот на 90
    Figure fig90 = fig.Rotated90().Normalized();
    equal |= fig90.points.equals(normalized.points);

    // Поворот на 180
    Figure fig180 = fig90.Rotated90().Normalized();
    equal |= fig180.points.equals(normalized.points);

    // Поворот на 270
    Figure fig270 = fig180.Rotated90().Normalized();
    equal |= fig270.points.equals(normalized.points);
    
    return equal;
  }

  
  @Override
  public int hashCode() {
    return points.size();
  }


  // Красивый вывод фигуры
  @Override
  public String toString() {
    String result = "";

    BoundaryBox boundary = getBoundaryBox();

    for (int j = boundary.min.y - 1; j <= boundary.max.y + 1; j++) {
      for (int i = boundary.min.x - 1; i <= boundary.max.x + 1; i++) {
        if (points.contains(new Point2D(i, j))) {
          result += "\u25FC";
        } else {
          result += "\u25FB";
        }
      }

      result += "\n";
    }

    return result;
  }


  // Нормализация координат для сравнения
  public Figure Normalized() {
    // Создаем новую фигуру, которую потом вернем
    Figure normalizedFigure = new Figure();

    // Найдем boundary box для точек
    Point2D min = getBoundaryBox().min;

    // Сдвинем очерченную фигуру в начало координат
    for (Point2D p : points) {
      normalizedFigure.AddPoint(p.x - min.x, p.y - min.y);
    }

    // Вернем новую нормализованную фигуру
    return normalizedFigure;
  }


  // Повернем фигуру на 90 градусов вокруг (0,0)
  public Figure Rotated90() {
    // Создаем новую фигуру, которую потом вернем
    Figure rotatedFigure = new Figure();

    // Проходим по всем точкам и поворачиваем их как (-y, x)
    for (Point2D p : points) {
      rotatedFigure.AddPoint(-p.y, p.x);
    }

    // Вернем повернутую фигуру
    return rotatedFigure;
  }


  // Определение boundary box для фигуры
  private BoundaryBox getBoundaryBox() {
    int min_x = Integer.MAX_VALUE;
    int min_y = Integer.MAX_VALUE;

    int max_x = Integer.MIN_VALUE;
    int max_y = Integer.MIN_VALUE;

    for (Point2D p : points) {
      if (p.x < min_x) min_x = p.x;
      if (p.x > max_x) max_x = p.x;
      if (p.y < min_y) min_y = p.y;
      if (p.y > max_y) max_y = p.y;
    }

    Point2D min = new Point2D(min_x, min_y);
    Point2D max = new Point2D(max_x, max_y);

    return new BoundaryBox(min, max);
  }

}
