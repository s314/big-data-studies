import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> numbers = new ArrayList<>(
            Arrays.asList(
                1, 3, 5, 7, 10, 12, 16, 44, 37
            )
        );

        Predicate<Integer> isOdd = arg -> arg % 2 == 1;
        Predicate<Integer> isEven = arg -> arg % 2 == 0;

        ArrayList<Integer> oddNumbers = new ArrayList<>(numbers.stream().filter(isOdd).toList());

        ArrayList<Integer> evenNumbers = new ArrayList<>(numbers.stream().filter(isEven).toList());

        System.out.println("Odd:");
        oddNumbers.stream().forEach(System.out::println);

        System.out.println("Even:");
        evenNumbers.stream().forEach(System.out::println);

        System.out.println("Odd Sum:");
        Integer sum = oddNumbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
