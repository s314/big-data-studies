import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {

        // Задаем поле из NxN клеток
        int[][] field = {
            {0, 0, 0, 0, 0, 0, 0, 0},   // ▢▢▢▢▢▢▢▢
            {0, 1, 1, 0, 1, 0, 1, 0},   // ▢▩▩▢▩▢▩▢
            {0, 1, 0, 0, 1, 0, 1, 0},   // ▢▩▢▢▩▢▩▢
            {0, 0, 0, 0, 1, 0, 1, 0},   // ▢▢▢▢▩▢▩▢
            {0, 0, 0, 0, 0, 0, 0, 0},   // ▢▢▢▢▢▢▢▢
            {0, 1, 0, 0, 1, 1, 1, 0},   // ▢▩▢▢▩▩▩▢
            {0, 1, 1, 0, 1, 1, 1, 0},   // ▢▩▩▢▩▩▩▢
            {0, 0, 0, 0, 0, 0, 0, 0}    // ▢▢▢▢▢▢▢▢
        };

        // Задаем множество фигур
        HashSet<Figure> figures = new HashSet<>();

        // Проходим по каждой клетке, ищем смежные 
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                // Если натыкаемся на закрашенную клетку, начинаем Flood Fill
                if (field[x][y] == 1) {
                    // Создаем новый объект `Фигура`, в который записываем точки
                    Figure figure = new Figure();

                    // Заводим очередь точек
                    Queue<Point2D> points = new LinkedList<>();
                    points.add(new Point2D(x, y));

                    // Пока очередь не опустеет, ищем смежные
                    while (!points.isEmpty()) {
                        Point2D p = points.remove();
                        figure.AddPoint(p.x, p.y);

                        Point2D n1 = new Point2D(p.x - 1, p.y);
                        if (field[n1.x][n1.y] == 1 && !figure.points.contains(n1)) points.add(new Point2D(n1.x, n1.y));

                        Point2D n2 = new Point2D(p.x + 1, p.y);
                        if (field[n2.x][n2.y] == 1 && !figure.points.contains(n2)) points.add(new Point2D(n2.x, n2.y));

                        Point2D n3 = new Point2D(p.x, p.y - 1);
                        if (field[n3.x][n3.y] == 1 && !figure.points.contains(n3)) points.add(new Point2D(n3.x, n3.y));

                        Point2D n4 = new Point2D(p.x, p.y + 1);
                        if (field[n4.x][n4.y] == 1 && !figure.points.contains(n4)) points.add(new Point2D(n4.x, n4.y));

                    }

                    figures.add(figure);

                    // Удаляем с поля найденную фигуру (нужно предусмотреть какой-то буфер клеток)
                    for (Point2D p : figure.points) {
                        field[p.x][p.y] = 0;
                    }
                }
            }
        }

        System.out.println("Total figures found: " + figures.size() + "\n");
        // Выводим найденные фигуры
        for (Figure f : figures) {
            System.out.println(f.toString());
        }

    }
}
