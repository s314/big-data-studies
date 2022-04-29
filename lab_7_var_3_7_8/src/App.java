public class App {
    public static void main(String[] args) throws Exception {
        String test = "abcdefgh";
        String coded = EncodeString(test);
        String decoded = EncodeString(coded);
        System.out.println(coded);
        System.out.println(decoded);
    }


    public static String EncodeString(String input) {
        int len = input.length();
        String result = "";

        int offset = 0;
        while (result.length() < len) {
            int index = 0 + offset;

            while (index < input.length()) {
                result += input.charAt(index);
                index += 3;
            }

            offset++;
        }

        return result;
    }
}
