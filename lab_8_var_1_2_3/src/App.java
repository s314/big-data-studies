import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {


        // === ROBOT LEGS (2) ===
        
        Runnable rightStep = () -> {
            while (true) {
                System.out.println("Make Right Step");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable leftStep = () -> {
            while (true) {
                System.out.println("Make Left Step");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread rightLeg = new Thread(rightStep);
        Thread leftLeg = new Thread(leftStep);

	    // rightLeg.start();

        // TimeUnit.SECONDS.sleep(5);

        // leftLeg.start();


        // === WAREHOUSE (3) ===

        Store storage = new Store();

        System.out.println("Initial amount: " + storage.get());

        Runnable stock = () -> {
            while (true) {
                System.out.println("Manufacturer sent items to stock...");
                storage.addRandom();
                int inStorage = storage.get();
                System.out.println("Current amount: " + inStorage);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable buy = () -> {
            while (true) {
                System.out.println("Buyer tries to buy some items...");
                storage.retrieveItems();
                int inStorage = storage.get();
                System.out.println("Current amount: " + inStorage);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread manufacturerThread = new Thread(stock);
        Thread buyerThread = new Thread(buy);

        manufacturerThread.start();

        TimeUnit.SECONDS.sleep(2);

        buyerThread.start();

    }


    private static class Store {
        private int amount = 0;

        public synchronized void addRandom() {
            Random random = new Random();
            int randomInt = random.nextInt(10 - 2) + 2;

            amount += randomInt;
        }


        public synchronized void retrieveItems() {

            if (amount >= 5) {
                amount -= 5;
            } else {
                System.out.println("Items can't be retrieved. Not enough amount.");
            }

        }

        public synchronized int get() {
            return amount;
        }
    }
}
