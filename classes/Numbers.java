public class Numbers {
    public static void main(String[] args) {
        // Doesn't work because Number is abstract
        // Number n = new Number();

        Number[] nums = new Number[10000];
        for (int i = 0; i < nums.length; i++) {
            double val = Math.random() * 18 + 2;
            if (Math.random() < 0.5) {
                nums[i] = (int) val;
            } else {
                nums[i] = val;
            }
        }

        for (int left = nums.length - 1; left > 0; left--) {
            for (int i = 0; i < left; i++) {
                double a = nums[i].doubleValue();
                double b = nums[i + 1].doubleValue();
                if (a > b) {
                    nums[i] = b;
                    nums[i + 1] = a;
                }
            }
        }

        int intCount = 0;
        int doubleCount = 0;
        int[] distribution = new int[20];
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
            if (nums[i].doubleValue() == nums[i].intValue()) {
                intCount++;
            } else {
                doubleCount++;
            }
            distribution[nums[i].intValue()]++;
        }
        System.out.println();
        System.out.println("# of integers: " + intCount);
        System.out.println("# of doubles: " + doubleCount);

        for (int i = 2; i < distribution.length; i++) {
            System.out.println("# of " + i + "'s: " + distribution[i]);
        }
    }
}
