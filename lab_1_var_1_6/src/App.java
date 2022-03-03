import java.util.Calendar;
import java.util.Formatter;

// Из варианта 1 -- задачи 5 и 6
// Это задача 6

public class App {
    public static void main(String[] args) throws Exception {
        Formatter f = new Formatter();
        Calendar c = Calendar.getInstance();

        System.out.println(f.format(
                "Усманов%nВремя получения задания: 18 февраля 2022 5:25 pm%nВремя сдачи задания: %te %tB %tY %tl:%tM %tp",
                c, c, c, c, c, c
            )
        );
    }
}
