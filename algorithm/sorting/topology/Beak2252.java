package sorting.topology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Beak2252 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int target = queue.remove();
            res.add(target);

            for (int el : list.get(target)) {
                indegree[el]--;

                if (indegree[el] == 0) {
                    queue.add(el);
                }
            }
        }

        while (!res.isEmpty()) {
            System.out.println(res.remove());
        }
    }
}
