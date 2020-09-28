import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak2252 {
	private static int[] indegree;
	private static int N, M;
	private static StringTokenizer st;
	private static ArrayList<Integer> list[];
	private static Queue<Integer> queue;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			indegree[y]++;
		}

		queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.peek());
			System.out.print(" ");
			int current = queue.poll();

			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}
