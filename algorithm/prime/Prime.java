package prime;

public class Prime {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                sb.append(i).append(", ");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
