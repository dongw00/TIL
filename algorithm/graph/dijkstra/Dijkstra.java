package graph.dijkstra;

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
				if (!check[j] && maps[min_index][j] != 0) {
					if (distance[j] > distance[min_index] + maps[min_index][j]) {
						distance[j] = distance[min_index] + maps[min_index][j];
					}
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			System.out.print(distance[i] + " ");
		}
		System.out.println();
	}

}

public class Dijkstra {
	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.input(1, 2, 3);
		g.input(1, 5, 4);
		g.input(1, 4, 4);
		g.input(2, 3, 2);
		g.input(3, 4, 1);
		g.input(4, 5, 2);
		g.input(5, 6, 4);
		g.input(4, 7, 6);
		g.input(7, 6, 3);
		g.input(3, 8, 3);
		g.input(6, 8, 2);
		g.dijkstra(1);
	}
}
