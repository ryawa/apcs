public class PtoZ {
    public static void main(String[] args) {
        int size = (int) (Math.random() * 20) + 1;
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            int len = (int) (Math.random() * 20) + 1;
            String str = "";
            for (int j = 0; j < len; j++) {
                int num = (int) (Math.random() * 52);
                char c;
                if (num < 26) {
                    c = (char) (num + 'A');
                } else {
                    c = (char) (num + 'a' - 26);
                }
                str += c;
            }
            arr[i] = str;
            System.out.println(arr[i]);
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            arr[i] = changePtoZ(arr[i]);
            System.out.println(arr[i]);
        }
    }

    public static String changePtoZ(String str) {
        char first = str.charAt(0);
        if (first >= 'P' && first <= 'Z') {
            return "Z" + str.substring(1);
        } else if (first >= 'p' && first <= 'z') {
            return "z" + str.substring(1);
        }
        return str;
    }
}
