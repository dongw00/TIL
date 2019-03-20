# BFS (너비 우선 검색)

![](https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif)

### 소개

Root Node 혹은 다른 임의의 노드에서 `인접한 노드`를 먼저 탐색하는 방법이다.
`Queue`를 사용해서 구현한다.

### 시간 복잡도

- 인접 리스트 : O(V + E)
- 인접 행렬 : O(V^2)

> 접점(V), 간선(E)

```java
class Graph {
  private int V;
  private LinkedList<Integer> adj[];

  Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i)
      adj[i] = new LinkedList();
  }

  void addEdge(int v, int w) { adj[v].add(w); }

  /* BFS */
  void BFS(int s) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
      s = queue.poll();
      System.out.print(s + " ");

      // 방문한 노드와 인접한 모든 노드를 가져온다.
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
}
```

- [DFS와 BFS](https://www.acmicpc.net/problem/1260)
- [연결 요소](https://www.acmicpc.net/problem/11724)
- [이분 그래프](https://www.acmicpc.net/problem/1707)
- [단지번호붙이기](https://www.acmicpc.net/problem/2667)
- [섬의 개수](https://www.acmicpc.net/problem/4963)

> 위 문제 모두 BFS 기초적인 문제이다.

## 문제 풀이 요령

BFS를 이용해 해결할 수 있는 문제는 3가지 조건을 만족해야한다.

1. 최소 비용 문제
2. 간선의 가중치가 1이다.
3. 정점과 간선의 개수가 적다. (시간 제약, 메모리 제한 내에 만족한다.)

### BFS 문제

- [토마토](https://www.acmicpc.net/problem/7576)
- [토마토](https://www.acmicpc.net/problem/7569)

> 첫 번째 토마토는 높이는 고려하지 않기 때문에 쉬우나 두번째 토마토 문제는 높이를 고려해야하기 때문에 상당히 까다로워진다.

- [숨바꼭질](https://www.acmicpc.net/problem/1697)
- [숨바꼭질 2](https://www.acmicpc.net/problem/12851)
