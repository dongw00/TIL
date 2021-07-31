package contest.hcard;

public class B2 {

    static int ans = 0;
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        System.out.println(solution(5, 1));
        System.out.println(solution(3, 2));
        System.out.println(solution(4, 77));
    }

    public static int solution(int k, int m) {
        ans = 0;
        dfs(0, k, m);
        return ans;
    }

    public static void dfs(int cnt, int k, int m) {
        if (cnt == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(arr[i]);
            }
            int val = Integer.parseInt(sb.toString());

            if (val % m == 0) {
                ans++;
            }
        }

        for (int i = 1; i <= k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt + 1, k, m);
                visited[i] = false;
            }
        }
    }
}
