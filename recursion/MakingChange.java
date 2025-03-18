package recursion;

public class MakingChange {
    public static void main(String[] args) {
        System.out.println(ways(100));
    }

    public static int ways(int cents) {
        return comb(cents, 25);
    }

    public static int comb(int cents, int max) {
        if (cents == 0) {
            return 1;
        }
        int ans = 0;
        if (cents >= 25 && max >= 25) {
            ans += comb(cents - 25, 25);
        }
        if (cents >= 10 && max >= 10) {
            ans += comb(cents - 10, 10);
        }
        if (cents >= 5 && max >= 5) {
            ans += comb(cents - 5, 5);
        }
        if (cents >= 1 && max >= 1) {
            ans += comb(cents - 1, 1);
        }
        return ans;
    }
}
