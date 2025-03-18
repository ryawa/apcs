public class ReverseWord {
    public static void main(String[] args) {
        String s = "asdfasdf";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s) {
        if (s.length() == 1) {
            return s;
        }
        String first = s.substring(0, 1);
        String last = s.substring(1);
        return reverseString(last) + first;
    }
}
