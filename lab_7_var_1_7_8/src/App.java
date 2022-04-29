public class App {
    public static void main(String[] args) throws Exception {
        String test = "Hello, World!";
        System.out.println(SymbolOps(test, 'l', 0, 0));
        System.out.println(SymbolOps(test, 'l', 1, 2));

        String line = "Helloworld11@ whi1tespa1ces$  owari";
        System.out.println(PurgeNonLetters(line));
    }


    public static String SymbolOps(String input, Character symbol, int sign, int k) {
        if (sign == 0) {
            return input.replaceAll(symbol.toString(), "");
        } else if (sign == 1) {
            return input.substring(0, k) + symbol + input.substring(k);
        }
        return "";
    }

    public static String PurgeNonLetters(String input) {
        return input.replaceAll("[^a-zA-Z ]", "");
    }
}
