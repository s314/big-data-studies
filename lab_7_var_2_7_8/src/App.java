import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        String line = "Lorem ipsum dolor sit amet, consectetur adipiscing mit elit Phasellus vitae";
        PrintMaxMin(line);

        String telegram = "Ichi ni    san yon  go roku   shichi";
        System.out.println(CalculateCost(telegram, 10));
    }


    public static int CalculateCost(String input, int price) {
        int cost = 0;

        String[] str = input.split(" +");
        cost = str.length * price;

        return cost;
    }


    public static void PrintMaxMin(String input) {
        String[] max = maxWords(input);
        String[] min = minWords(input);

        for (String w : max) {
            System.out.println(w);
        }

        for (String w : min) {
            System.out.println(w);
        }
    }


    private static String[] maxWords(String input) {
        String[] str = input.split(" ");
        if (str.length==0) return null;

        ArrayList<String> longest = new ArrayList<>();
        int longest_length = 0;
        for (String word : str){

            if (word.length() > longest_length) {
                longest.clear();
                longest_length = word.length();
                longest.add(word);
            } else if (word.length() == longest_length) {
                longest.add(word);
            }
        }

        String[] result = new String[longest.size()];
        result = longest.toArray(result);
        return result;
    }

    private static String[] minWords(String input) {
        String[] str = input.split(" ");
        if (str.length==0) return null;

        ArrayList<String> least = new ArrayList<>();
        int least_length = Integer.MAX_VALUE;
        for (String word : str){

            if (word.length() < least_length) {
                least.clear();
                least_length = word.length();
                least.add(word);
            } else if (word.length() == least_length) {
                least.add(word);
            }
        }

        String[] result = new String[least.size()];
        result = least.toArray(result);
        return result;
    }
}
