package devmatching.p2022;

/**
 * 시험점수가 감소하는 방향으로 되어함
 * <p>
 * 최소로 바꾸면서 감소하는 방향으로 만드는 수 반환
 */
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        System.out.println(test1.solution(new int[]{3, 2, 3, 6, 4, 5}));
        System.out.println(test1.solution(new int[]{2, 1, 3}));
        System.out.println(test1.solution(new int[]{1, 2, 3}));
    }

    public int solution(int[] grade) {
        int n = grade.length;

        int cnt = 0;
        int idx = 0;
        while (idx < n) {
            int min = grade[idx];
            int minIdx = idx;
            for (int i = idx + 1; i < n; i++) {
                if (min > grade[i]) {
                    min = grade[i];
                    minIdx = i;
                }
            }

            if (minIdx == idx) {
                idx++;
                continue;
            }
            for (int j = idx; j < minIdx; j++) {
                cnt += grade[j] - min;
            }
            idx = minIdx;
        }
        return cnt;
    }

}
