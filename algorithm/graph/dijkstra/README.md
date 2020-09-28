# 다익스트라 알고리즘(Dijkstra Algorithm)

가중치가 주어진 그래프에서 최소값으로 목적지 까지 갈 수 있는 경로를 찾는데 사용된다.
`다익스트라 알고리즘`은 `욕심쟁이 알고리즘(Greedy Algorithm)`에 속하므로 모든 경로를 탐색한다.

![](https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif)

### 시간복잡도

(정점 : V)
일반 다익스트라 알고리즘
O(V^2)

`최소 우선 큐`에 기반한 `다익스트라 알고리즘`은 `피보나치 합`으로 수행한다.
O(E + VlogV)

```java
class Graph {
    private int n;
    private int maps[][];

    public Graph(int n) {
        this.n = n;
        maps = new int[n + 1][n + 1];
    }

    public void input(int i, int j, int w) {
        maps[i][j] = w;
        maps[j][i] = w;
    }

    public void dijkstra(int v) {
        int distance[] = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        // distance 값 초기화
        for (int i = 1; i < n + 1; i++)
            distance[i] = Integer.MAX_VALUE;

        // 시작노드 값 초기화
        distance[v] = 0;
        check[v] = true;

        // 연결노드 distance 갱신
        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && maps[v][i] != 0)
                distance[i] = maps[v][i];
        }

        for (int i = 0; i < n - 1; i++) {
            // 원래 모든 Node가 true될 때 까지인데
            // Node가 n개 있을 때 다익스트라는 n-1번이면 된다.
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            for (int j = 1; j < n + 1; j++) {
                if (!check[j] && distance[j] != Integer.MAX_VALUE) {
                    if (distance[j] < min) {
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

        check[min_index] = true;

        for (int j = 1; j < n + 1; j++) {
            if (!check[j] && maps[min_index][j] != 0)
                if (distance[j] > distance[min_index] + maps[min_index][j])
                    distance[j] = distance[min_index] + maps[min_index][j];
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
}
```