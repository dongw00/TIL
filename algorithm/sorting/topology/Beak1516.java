package sorting.topology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Beak1516 {

    static int n;
    static int[] indegree, time;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        indegree = new int[n + 1];
        time = new int[n + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) {
                    break;
                }
                indegree[i]++;
                list.get(num).add(i);
            }
        }

        topologySort();
    }

    public static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                res[i] = time[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.remove();

            for (int el : list.get(num)) {
                indegree[el]--;
                res[el] = Math.max(res[el], res[num] + time[el]);

                if (indegree[el] == 0) {
                    queue.add(el);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(res[i]);
        }
    }
}
