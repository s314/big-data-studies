import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /**
         * Задание 6 из варианта 1
         */
        ArrayList<Integer> list = new ArrayList<>(
            Arrays.asList(
                1, -2, 3, -8, 2, 4, -4, 0
            )
        ); 

        System.out.println("Before sort: " + list);

        list.sort(Collections.reverseOrder());

        System.out.println("After sort: " + list);



        /**
         * Задание 7 из варианта 1
         */

        // Получаем путь файла
        Path inputPath = Paths.get("data\\in.txt");

        // Читаем все строки файла с кодом программы
        List<String> strings = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
        ArrayList<String> outList = new ArrayList<String>(strings);

        // Сортируем
        outList.sort(Comparator.naturalOrder());

        System.out.println("After sort: " + outList);
    }
}
