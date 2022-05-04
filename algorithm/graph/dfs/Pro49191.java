package graph.dfs;

public class Pro49191 {

    public static void main(String[] args) {
        Pro49191 p = new Pro49191();
        System.out.println(p.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                arr[i][j] = 10000;
            }
        }

        for (int[] res : results) {
            int x = res[0];
            int y = res[1];

            arr[x][y] = 1;
        }

        // 거쳐가는 정점
        for (int k = 1; k < arr.length; k++) {
            // 시작 정점
            for (int i = 1; i < arr.length; i++) {
                // 끝 정점
                for (int j = 1; j < arr.length; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            int cnt = 0;

            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] < 10000 || arr[j][i] < 10000) {
                    cnt++;
                }
            }

            if (cnt == n - 1) {
                ans++;
            }
        }

        return ans;
    }
}
