import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите k:");

        Scanner console = new Scanner(System.in);
        int k = console.nextInt();

        Fraction[] fractions = new Fraction[k];

        for (int i = 0; i < k; i++) {
            System.out.println("Введите m для дроби " + (i + 1) + ":");
            int m = console.nextInt();
            System.out.println("Введите n для дроби " + (i + 1) + ":");
            int n = console.nextInt();

            fractions[i] = new Fraction(m, n);
        }

        PrintArray(fractions);

        for (int i = 0; i < k - 1; i += 2) {
            fractions[i] = fractions[i].Add(fractions[i + 1]);
        }

        PrintArray(fractions);

        console.close();
    }


    private static void PrintArray(Fraction[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {            
            System.out.print(array[i].toString());
            if (i != array.length - 1) System.out.print(", ");
        }
        System.out.print("]\n");
    }
}
