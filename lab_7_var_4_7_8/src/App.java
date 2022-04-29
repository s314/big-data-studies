public class App {
    public static void main(String[] args) throws Exception {
        String input = "Lorem ipsum dolor sit amet Consectetur adipiscing elit Praesent blandit amet";
        String[] str = input.split(" +");

        int capitaled = 0;
        for (String w : str) {
            if (w.length() > 0) {
                if (Character.isUpperCase(w.charAt(0)) == true) capitaled++;
            }
        }
        System.out.println(capitaled);


        String word = "amet";
        int count = 0;
        for (String w : str) {
            if (w.toLowerCase().equals(word.toLowerCase())) count++;
        }
        System.out.println(count);

    }
}
