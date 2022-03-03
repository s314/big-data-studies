import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

// Из варианта 2 -- задачи 2 и 3

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        // Определяем условие окончания цикла ввода
        boolean continueInput = true;

        System.out.println("Для окончания ввода введите что угодно, кроме числа.");

        // Заводим динамический массив для чисел
        ArrayList<Integer> numbers = new ArrayList<>();

        // Крутимся в цикле ввода пока не поймаем исключение
        do {
            try{
                // Вводим число из консоли
                System.out.print("Введите число: ");
                int number = in.nextInt();
    
                // Добавляем число в динамический массив
                numbers.add(number);
            }
            catch (InputMismatchException ex) {
                // Выводим минимумы и максимумы
                System.out.println("Минимум: " + Collections.min(numbers));
                System.out.println("Максимум: " + Collections.max(numbers));

                // Удаляем все, что не делится на 3 или на 9
                numbers.removeIf(n -> (n % 3 != 0) && (n % 9 != 0));

                // Выводим то, что осталось
                System.out.println("Числа, которые делятся на 3 или 9: " + numbers.toString());

                // Заканчиваем цикл ввода
                continueInput = false;
                }
        } while (continueInput); 

        in.close();
    }
}
