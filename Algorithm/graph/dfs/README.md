# DFS (깊이 우선 탐색)

![](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif)


### 소개

Root Node 혹은 다른 임의의 노드에서 시작해서 다음 분기(Branch)로 넘어가기 전에 `해당 분기를 완벽하게 탐색`하는 방법이다.
`Stack`과 `재귀함수(Recursion)`으로 구현한다.

- 경로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게되면 다른 방향으로 다시 탐색을 진행
- 모든 노드를 방문하는 경우에 이 방법을 사용한다.

### 사용용도

- 경로찾기
    u, v가 주어졌을 때 u -> v로 가는 경로를 찾을 때
- 그래프의 사이클을 찾을 때
    back edge 즉, 순환을 만들어 주는 마지막 edge를 찾는다.

### 시간복잡도

두 가지의 자료구조(인접 리스트, 인접 행렬)로 구현할 수 있다.

- `인접 리스트` : O(V + E)
- `인접 행렬` : O(V^2)

> 접점(V), 간선(E)

### 재귀함수 구현

```java

/* 인접 리스트 이용 */
class Graph {
  private int V;
  private LinkedList<Integer> adj[];

  Graph(int v) {
      V = v;
      adj = new LinkedList[v];
      // 인접 리스트 초기화
      for (int i=0; i<v; ++i)
          adj[i] = new LinkedList();
  }
  void addEdge(int v, int w) { adj[v].add(w); }

  /* DFS에 의해 사용되는 함수 */
  void DFSUtil(int v, boolean visited[]) {
      // 현재 노드를 방문한 것으로 표시하고 값을 출력
      visited[v] = true;
      System.out.print(v + " ");

      // 방문한 노드와 인접한 모든 노드를 가져온다.
      Iterator<Integer> it = adj[v].listIterator();
      while (it.hasNext()) {
          int n = it.next();
          // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
          if (!visited[n])
              DFSUtil(n, visited);
      }
  }

  /* DFS */
  void DFS(int v) {
      boolean visited[] = new boolean[V];

      // v를 시작 노드로 DFSUtil 재귀 호출
      DFSUtil(v, visited);
  }
}
```

## [BFS (너비 우선 검색)](https://github.com/dongw00/Junior-Web-programmer/tree/master/Algorithm/graph/bfs#bfs-%EB%84%88%EB%B9%84-%EC%9A%B0%EC%84%A0-%EA%B2%80%EC%83%89)

- [DFS와 BFS](https://www.acmicpc.net/problem/1260)
- [연결 요소](https://www.acmicpc.net/problem/11724)
- [이분 그래프](https://www.acmicpc.net/problem/1707)
- [단지번호붙이기](https://www.acmicpc.net/problem/2667)
- [섬의 개수](https://www.acmicpc.net/problem/4963)

> 위 문제 모두 DFS와 BFS를 연습할 수 있는 문제다.