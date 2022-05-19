import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        Collection<People> peoples = Arrays.asList(
            new People("Ivan", 16),
            new People("Petr", 23),
            new People("Maria", 42),
            new People("Slava", 12)
        );


        List<App.People> sortedList = peoples.stream()
			.sorted(Comparator.comparingInt(People::getAge))
			.collect(Collectors.toList());
 
        sortedList.forEach(System.out::println);



        Collection<String> strings = Arrays.asList(
            "da", "le", "ko", "ty", "hi"
        );

        Map<Character, Character> map = strings.stream()
            .collect(Collectors.toMap(a -> a.charAt(0), a -> a.charAt(1)));
        System.out.println("Map:" + map);
    }

    private static class People {
        public String name;
        public int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " " + age; 
        }
    }
}
