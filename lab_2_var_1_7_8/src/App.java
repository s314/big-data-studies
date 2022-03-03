import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Calendar;

// Лабораторная №2
// Вариант 1, задачи 7 и 8

public class App {
    public static void main(String[] args) throws Exception {
        Formatter f = new Formatter();
        Calendar c = Calendar.getInstance();

        System.out.println(f.format(
                "Усманов%nВремя получения задания: 18 февраля 2022 5:25 pm%nВремя сдачи задания: %te %tB %tY %tl:%tM %tp",
                c, c, c, c, c, c
            )
        );

        System.out.println("Введите n:");

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        System.out.println("Введите " + n + " строк");

        String[] arr = new String[n];

        ArrayList<String> different_symbols = new ArrayList<>();
        ArrayList<String> numbers_palyndromes = new ArrayList<>();

        for (int i=0; i<n; i++){
            String line = console.next();
            arr[i] = line;

            if (GetSymbolsDiff(line)) different_symbols.add(line);
            if (line.matches("[0-9]+")) {
                if(IsPalyndrome(line)) numbers_palyndromes.add(line);
            }
        }

        console.close();

        if (!different_symbols.isEmpty()) System.out.println("Первое слово из разных символов: " + different_symbols.get(0));
        if (!different_symbols.isEmpty()) {
            if (different_symbols.size() < 2) {
                System.out.println("Слово из цифр палиндром: " + numbers_palyndromes.get(0));
            } else {
                System.out.println("Второе слово из цифр палиндром: " + numbers_palyndromes.get(1));
            }
        }
    }


    private static boolean GetSymbolsDiff(String input) {
        boolean is_different = false;

        HashSet<Character> symbols = new HashSet<>();

        for (char ch: input.toCharArray()) {
            symbols.add(ch);
        }

        if (symbols.size() == input.length()) is_different = true;

        return is_different;
    }


    private static boolean IsPalyndrome(String input) {
        boolean is_palyndrome = true;

        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                is_palyndrome = false;
            i++;
            j--;
        }

        return is_palyndrome;
    }
}
