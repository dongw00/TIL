package codingTest.elevenstreet;

public class T1 {

    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.solution(28));
        System.out.println(t1.solution(734));
        System.out.println(t1.solution(1990));
        System.out.println(t1.solution(1000));
        System.out.println(t1.solution(50000));
        System.out.println(t1.solution(1));
        System.out.println(t1.solution(49999));
        System.out.println(t1.solution(10001));
        System.out.println(t1.solution(10));
    }

    public int solution(int n) {
        int target = getNum(n);

        while (true) {
            n++;
            int tmp = getNum(n);

            if (tmp == target) {
                return n;
            }
        }
    }

    public int getNum(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

}
