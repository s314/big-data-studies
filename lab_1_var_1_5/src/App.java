// Из варианта 1 -- задачи 5 и 6
// Это задача 5

public class App {
    public static void main(String[] args) throws Exception {
        // Создаем переменную для хранения результата
        int result_sum = 0;
        int result_mul = 1;

        // Обрабатываем аргументы командной строки
        for(int i = 0; i < args.length; i++) {
            result_sum += Integer.parseInt(args[i]);
            result_mul *= Integer.parseInt(args[i]);
        }

        // Выводим результаты суммы и произведения
        System.out.println("Сумма: " + result_sum);
        System.out.println("Произведение: " + result_mul);
    }
}
