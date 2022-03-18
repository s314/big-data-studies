import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Car cars[] = new Car[4];

        // Car 1
        cars[0] = new Car();
        cars[0].setId(1);
        cars[0].setBrand("Volkswagen");
        cars[0].setModel("Passat");
        cars[0].setYear(2008);
        cars[0].setColor("Metallic");
        cars[0].setPrice(450000);
        cars[0].setNumber("н312ае");

        // Car 2
        cars[1] = new Car();
        cars[1].setId(2);
        cars[1].setBrand("Volkswagen");
        cars[1].setModel("Polo");
        cars[1].setYear(2008);
        cars[1].setColor("Black");
        cars[1].setPrice(350000);
        cars[1].setNumber("н154бг");

        // Car 3
        cars[2] = new Car();
        cars[2].setId(3);
        cars[2].setBrand("Mitsubishi");
        cars[2].setModel("Lancer");
        cars[2].setYear(2010);
        cars[2].setColor("Red");
        cars[2].setPrice(1350000);
        cars[2].setNumber("а102пе");

        // Car 4
        cars[3] = new Car();
        cars[3].setId(4);
        cars[3].setBrand("Hyundai");
        cars[3].setModel("Accent");
        cars[3].setYear(2010);
        cars[3].setColor("Red");
        cars[3].setPrice(400000);
        cars[3].setNumber("н252см");

        System.out.println("Автомобили по марке:");
        PickBrand(cars, "Volkswagen");
        System.out.println("=================================");
        System.out.println("Автомобили по модели и эксплуатации:");
        PickModel(cars, "Accent", 2022, 10);
        System.out.println("=================================");
        System.out.println("По году выпуска с превышением заданной цены:");
        PickYearPrice(cars, 2010, 1000000);
    }

    private static void PickBrand(Car[] cars, String brand) {
        Arrays.stream(cars)
            .filter(c -> c.getBrand() == brand)
            .forEach(c -> System.out.println(c.toString()));
    }

    private static void PickModel(Car[] cars, String model, int currentYear, int n) {
        Arrays.stream(cars)
            .filter(c -> c.getModel() == model)
            .filter(c -> currentYear - c.getYear() > n)
            .forEach(c -> System.out.println(c.toString()));
    }

    private static void PickYearPrice(Car[] cars, int year, int priceLimit) {
        Arrays.stream(cars)
            .filter(c -> c.getYear() == year)
            .filter(c -> c.getPrice() > priceLimit)
            .forEach(c -> System.out.println(c.toString()));
    }
}
