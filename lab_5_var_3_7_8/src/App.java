import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner; // Import the Scanner class to read text files

public class App {
    public static void main(String[] args) throws Exception {

        // Открываем файл стихотворение Заболоцкого
        try {
            System.out.println("Отрабатываем стихотворение Н. Заболоцкого");

            File poem = new File("data\\poem_orig.txt");

            String output_poem = "data\\poem_new.txt";

            File new_file = new File(output_poem);
            if (new_file.createNewFile()) {
                System.out.println("Файл создан: " + new_file.getName());
            } else {
                System.out.println("Файл уже существует");
            }

            FileWriter writer = new FileWriter(output_poem, StandardCharsets.UTF_8);

            Scanner reader = new Scanner(poem, "UTF-8");
            
            while (reader.hasNextLine()) {
                System.out.print(".");
                String data = reader.nextLine();
                writer.write(capitalizeWords(data));
                writer.write("\n");
            }
            System.out.print("\n");

            System.out.println("Стихотворение Заболоцкого успешно обработано");
            
            writer.close();
            reader.close();


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Произошла ошибка I/O");
            e.printStackTrace();
        }


        // Работаем с Пушкиным
        try {
            System.out.println("Отрабатываем стихотворение А. Пушкина");

            File poem = new File("data\\poem_pushkin.txt");

            HashMap<String, Integer> words = new HashMap<>();
            HashMap<Character, Integer> characters = new HashMap<>();

            Scanner reader = new Scanner(poem, "UTF-8");
            
            while (reader.hasNextLine()) {
                System.out.print(".");
                String data = removeAllNonAlphaNumeric(reader.nextLine());

                String[] splitted = data.split("\\s");
                
                for (String w:splitted) {
                    if (w.equals("")) continue;

                    int count = words.containsKey(w) ? words.get(w) : 0;
                    words.put(w, count + 1);

                    for (Character c:w.toCharArray()) {
                        int c_count = characters.containsKey(c) ? characters.get(c) : 0;
                        characters.put(c, c_count + 1);
                    }
                }
            }
            System.out.print("\n");

            System.out.println("Стихотворение Пушкина успешно обработано");

            System.out.println("Подсчет слов:");
            words.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            System.out.println("Подсчет символов:");
            characters.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        }
    }


    static String capitalizeWords(String str) {
        if (str.equals("")) return "";

        String[] words = str.split("\\s");
        String capitalizeWord = "";  

        for(String w:words){  
            String first = w.substring(0,1);  
            String afterfirst = w.substring(1);  
            capitalizeWord += first.toUpperCase() + afterfirst + " ";  
        }  

        return capitalizeWord.trim();  
    }

    static String removeAllNonAlphaNumeric(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("[^\\wА-Яа-я\\s]", "");
    }
}
