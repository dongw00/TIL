package codingTest.elevenstreet;

public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();

        System.out.println(t2.solution(new int[]{1, 1, 2, 3, 3}, 3));
    }

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1]) {
                return false;
            }
        }
        return A[0] == 1 || A[n - 1] == K;
    }

}
