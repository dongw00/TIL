package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak1068 {

    static List<Integer>[] tree;
    static boolean[] visited;
    static int target;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) {
                root = i;
            } else {
                tree[num].add(i);
                tree[i].add(num);
            }
        }

        target = Integer.parseInt(br.readLine());

        if (target == root) {
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(ans);
    }

    public static void dfs(int idx) {
        visited[idx] = true;

        int cnt = 0;
        for (int el : tree[idx]) {
            if (!visited[el] && el != target) {
                cnt++;
                dfs(el);
            }
        }

        if (cnt == 0) {
            ans++;
        }
    }
}
