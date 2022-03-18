import java.util.Scanner;
import java.util.Vector;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите n:");

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        Vector<Complex> complex_1 = new Vector<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите re для числа " + (i + 1) + "в векторе 1:");
            int re = console.nextInt();
            System.out.println("Введите im для числа " + (i + 1) + "в векторе 1:");
            int im = console.nextInt();

            complex_1.add(new Complex(re, im));
        }

        Vector<Complex> complex_2 = new Vector<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите re для числа " + (i + 1) + "в векторе 2:");
            int re = console.nextInt();
            System.out.println("Введите im для числа " + (i + 1) + "в векторе 2:");
            int im = console.nextInt();

            complex_2.add(new Complex(re, im));
        }

        PrintVector(complex_1);
        PrintVector(complex_2);

        Vector<Complex> result = SumVectors(complex_1, complex_2);

        PrintVector(result);

        console.close();
    }


    private static void PrintVector(Vector<Complex> vector) {
        System.out.print("[");
        for (int i = 0; i < vector.size(); i++) {            
            System.out.print(vector.get(i).toString());
            if (i != vector.size() - 1) System.out.print(", ");
        }
        System.out.print("]\n");
    }

    private static Vector<Complex> SumVectors(Vector<Complex> a, Vector<Complex> b) {
        Vector<Complex> result = new Vector<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i).Add(b.get(i)));
        }
        return result;
    }
}
