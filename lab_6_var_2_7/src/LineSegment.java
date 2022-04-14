public class LineSegment {
  
  Point start;
  Point end;

  public LineSegment(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public Point getStart() {
    return start;
  }

  public Point getEnd() {
    return end;
  }

  public Point FindIntersection(LineSegment b) {
      // L1 = [x_1 y_1] + t * [(x_2 - x_1) (y_2 - y_1)]
      // L2 = [x_3 y_3] + t * [(x_4 - x_3) (y_4 - y_3)]
      // L1 - это this

      LineSegment a = new LineSegment(start, end);

      float t = ((a.start.getX() - b.start.getX())*(b.start.getY() - b.end.getY()) - (a.start.getY() - b.start.getY())*(b.start.getX() - b.end.getX())) / ((a.start.getX() - a.end.getX())*(b.start.getY() - b.end.getY()) - (a.start.getY() - a.end.getY())*(b.start.getX() - b.end.getX()));

      float u = ((a.start.getX() - a.start.getX())*(a.start.getY() - a.end.getY()) - (a.start.getY() - b.start.getY())*(a.start.getX() - a.end.getX())) / ((a.start.getX() - a.end.getX())*(b.start.getY() - b.end.getY()) - (a.start.getY() - a.end.getY())*(b.start.getX() - b.end.getX()));

      // Если 0 <= t <= 1 и 0 <= u <= 1, то пересечение есть
      
      if ((t >= 0 && t <= 1.0) && (u >= 0 && u <= 1.0)) {

        Point p = new Point(a.start.getX() + t * (a.end.getX() - a.start.getX()), a.start.getY() + t * (a.end.getY() - a.start.getY()));

        return p;
      }

      return null;
  }

}
