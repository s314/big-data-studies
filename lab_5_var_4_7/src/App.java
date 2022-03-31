import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        try {
            
            // Получаем путь файла
            Path inputPath = Paths.get("data\\Hello.java");
            
            // Читаем все строки файла с кодом программы
            List<String> strings = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
            ArrayList<String> outList = new ArrayList<String>();

            // Обрабатываем строки
            for (String s : strings) {
                String changed = s.trim().replaceAll(" +", " ");
                outList.add(changed);
            }

            // Создаем новую директорию, если не существует
            Files.createDirectories(Paths.get("output"));

            // Задаем путь для нового файла для вывода
            Path outPath = Paths.get("output\\Hello_linted.java"); 

            // Записываем в новый файл получившийся код
            Files.write(outPath, outList, StandardCharsets.UTF_8);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Произошла ошибка I/O");
            e.printStackTrace();
        }
        
    }
}
