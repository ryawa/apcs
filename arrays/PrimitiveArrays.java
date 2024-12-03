public class PrimitiveArrays {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }
        System.out.println();
        modifyArray(arr);
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
        System.out.println();
        reallocateArray(arr);
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
    }

    private static void modifyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }

    private static void reallocateArray(int[] arr) {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
}
