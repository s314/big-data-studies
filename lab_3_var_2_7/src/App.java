import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Phone phones[] = new Phone[3];

        // Client 1
        phones[0] = new Phone();
        phones[0].setId(1);
        phones[0].setFirstName("Vadim");
        phones[0].setLastName("Santalov");
        phones[0].setPatronymic("Evgenyevich");
        phones[0].setAddress("Balashikha");
        phones[0].setCardNumber(4276000011110000L);
        phones[0].setDebit(300);
        phones[0].setCredit(100);
        phones[0].setIntercityCalls(10);
        phones[0].setIntracityCalls(135);


        // Client 2
        phones[1] = new Phone();
        phones[1].setId(2);
        phones[1].setFirstName("Octoslav");
        phones[1].setLastName("Eliseev");
        phones[1].setPatronymic("Alekseevich");
        phones[1].setAddress("Moscow, Ptichnoe");
        phones[1].setCardNumber(4276222211110000L);
        phones[1].setDebit(500);
        phones[1].setCredit(300);
        phones[1].setIntercityCalls(0);
        phones[1].setIntracityCalls(267);

        // Client 2
        phones[2] = new Phone();
        phones[2].setId(3);
        phones[2].setFirstName("Maxim");
        phones[2].setLastName("Usmanov");
        phones[2].setPatronymic("Oybekovich");
        phones[2].setAddress("Belorechensk");
        phones[2].setCardNumber(4276222211113333L);
        phones[2].setDebit(500);
        phones[2].setCredit(300);
        phones[2].setIntercityCalls(10);
        phones[2].setIntracityCalls(109);

        System.out.println("Превысившие лимиты по внутренней связи:");
        IntracityCallsExceeding(phones, 120);
        System.out.println("=================================");
        System.out.println("Пользователи межгорода:");
        IntercityCallsUsers(phones);
        System.out.println("=================================");
        System.out.println("Сведения в алфавитном порядке:");
        AllUsersAlphabetical(phones);
    }

    
    private static void IntracityCallsExceeding(Phone[] phones, int limit) {
        Arrays.stream(phones)
            .filter(c -> c.getIntracityCalls() > limit)
            .forEach(c -> System.out.println(c.toString()));
    }

    private static void IntercityCallsUsers(Phone[] phones) {
        Arrays.stream(phones)
            .filter(c -> c.getIntercityCalls() > 0)
            .forEach(c -> System.out.println(c.toString()));
    }

    private static void AllUsersAlphabetical(Phone[] phones) {
        Arrays.sort(phones, (a,b) -> a.last_name.compareTo(b.last_name));
        Arrays.stream(phones)
            .forEach(c -> System.out.println(c.toString()));
    }
}
