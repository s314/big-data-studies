import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        // Своеобразная "БД" услуг
        HashMap<Integer, Service> services = new HashMap<>();

        services.put(
            0, new Service("Какая-то платная рекламная подписка ниочем", 300)
        );

        services.put(
            1, new Service("Безлимитный интернет", 1500)
        );

        services.put(
            2, new Service("SMS-бомбинг", 100)
        );

        // Несколько тестовых пользователей
        Client client_1 = new Client(111);
        Client client_2 = new Client(222);

        // Клиенты при подключении выбирают услуги
        client_1.bill.AddService(0, services.get(0));
        client_1.bill.AddService(2, services.get(2));

        client_2.bill.AddService(1, services.get(1));
        client_2.bill.AddService(2, services.get(2));

        // Клиенты пополняют счет
        client_1.Pay(400);
        client_2.Pay(1000);

        // Проходит месяц
        System.out.println(client_1.CheckPayment());
        System.out.println(client_2.CheckPayment());

        // Команды администратора
        RemoveClientService(client_1, 2);
        ChangeNumber(client_2, 314);
    }

    public static void ChangeNumber(Client client, int number) {
        client.SetNumber(number);
    }

    public static void RemoveClientService(Client client, int id) {
        client.bill.RemoveService(id);
    }
}
