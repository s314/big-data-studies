import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        LineSegment a = new LineSegment(
            new Point(1, 1), 
            new Point(3, 2)
        );

        LineSegment b = new LineSegment(
            new Point(1, 2), 
            new Point(3, 1)
        );

        LineSegment c = new LineSegment(
            new Point(4, 1), 
            new Point(5, 3)
        );

        LineSegment d = new LineSegment(
            new Point(4, 5), 
            new Point(5, 1)
        );

        TreeMap<Float, Float> tree = new TreeMap<>();
        
        AddToTree(tree, c.FindIntersection(d));
        AddToTree(tree, a.FindIntersection(b));
        AddToTree(tree, a.FindIntersection(d));
        AddToTree(tree, b.FindIntersection(c));

        System.out.format("X: %f Y: %f", tree.firstEntry().getKey(), tree.firstEntry().getValue());
    }


    public static void AddToTree(TreeMap<Float, Float> tree, Point p) {
        if (p != null) {
            tree.put(p.getX(), p.getY());
        }
    }
    
}
