public class RandomInts {
    public static void main(String[] args) {
        int size = (int) (Math.random() * 20) + 1;
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = (int) (Math.random() * 20) + 1;
            System.out.println(nums[i]);
        }

        int skip = (int) (Math.random() * 3) + 1;
        System.out.println("Skip: " + skip);
        for (int i = 0; i < size; i += skip) {
            if (skip == 1) {
                nums[i] = 999;
            } else if (skip == 2) {
                nums[i] = 555;
            } else {
                nums[i] = 444;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }
}
