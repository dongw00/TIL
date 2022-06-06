package graph.unionFind;

import java.util.Arrays;

public class UnionFind {

    // 부모 노드를 찾는 함수
    private static int getParent(int[] parent, int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = getParent(parent, parent[x]);
    }

    // 두 부모 노드를 합치는 함수
    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        return a == b;
    }

    public static void main(String[] args) {
        int[] parent = new int[11];

        for (int i = 1; i < 11; i++) {
            parent[i] = i;
        }

        System.out.println(Arrays.toString(parent));

        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);

        System.out.println("1과 5는 연결됨? " + (findParent(parent, 1, 5) ? "Yes" : "No"));
        System.out.println("1과 4는 연결됨? " + (findParent(parent, 1, 4) ? "Yes" : "No"));
        System.out.println("5과 8는 연결됨? " + (findParent(parent, 5, 8) ? "Yes" : "No"));
    }
}
