package sorting.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {

    static int n, e;

    public static void main(String[] args) {
        n = 7;  // 정점 갯수
        e = 9;  // 간선 갯수

        int[] indegree = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 간선 목록 v1 -> v2
        int[][] v = {{1, 2}, {1, 3}, {2, 5}, {4, 6}, {3, 4}, {3, 7}, {5, 6}, {2, 4}, {5, 4}};

        for (int[] el : v) {
            list.get(el[0]).add(el[1]);
            indegree[el[1]]++;
        }

        topologySort(indegree, list);
    }

    public static void topologySort(int[] indegree, List<List<Integer>> list) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.remove();
            res.add(num);

            for (int el : list.get(num)) {
                indegree[el]--;

                if (indegree[el] == 0) {
                    queue.add(el);
                }
            }
        }

        System.out.println(res);
    }
}
