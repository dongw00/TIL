public class H01 {

    public static void main(String[] args) {
        System.out.println(solve(10));
        System.out.println(solve(15));
    }

    private static int solve(int n) {
        int i = 1;
        int tmp = n;
        while (true) {
            if (isBinaryNumber(tmp))
                return tmp;

            tmp = n * i++;
        }
    }

    private static boolean isBinaryNumber(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        while (n != 0) {
            if (n % 10 > 1)
                return false;
            n /= 10;
        }
        return true;
    }
}
