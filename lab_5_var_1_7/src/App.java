import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите k:");

        Scanner console = new Scanner(System.in);

        try {

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

            

        } catch (InputMismatchException e) {

            System.out.println("Неверный формат введенных данных: допустимы только целые числа");

        } catch (NegativeArraySizeException e) {

            System.out.println("Попытка создать массив отрицательной размерности");
            

        } catch (OutOfMemoryError e) {

            System.out.println("Не хватает памяти для массива");

        } catch (ArithmeticException e) {

            System.out.println(e);

        } catch (Exception e) {

            System.out.println("Что-то пошло не так");

        } finally {

            console.close();

        }
        
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
