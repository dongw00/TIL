package graph.floyd;

/**
 * 배달
 * https://programmers.co.kr/learn/courses/30/lessons/12978
 */
public class Pro12978 {

    static final int MAX = 500001;

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }

    public static int solution(int N, int[][] road, int K) {
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    arr[i][j] = MAX;
                }
            }
        }

        for (int[] el : road) {
            int a = el[0];
            int b = el[1];
            int cost = el[2];

            if (arr[a][b] < cost) {
                continue;
            }

            arr[a][b] = arr[b][a] = cost;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j)
                        continue;
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[1][i] <= K) {
                ans++;
            }
        }

        return ans;
    }
}
