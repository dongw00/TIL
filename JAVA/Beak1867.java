import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1867 {
	private static StringTokenizer st;
	private static ArrayList<Integer> list[];
	private static int n, k;
	private static int visit[];
	private static int visitCount;
	private static int aMatch[];
	private static int bMatch[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visit = new int[n + 1];
		aMatch = new int[n + 1];
		bMatch = new int[n + 1];

		Arrays.fill(aMatch, -1);
		Arrays.fill(bMatch, -1);

		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
		}
		System.out.println(bipartite());
	}

	private static int dfs(int a) {
		if (visit[a] == visitCount)
			return 0;

		visit[a] = visitCount;

		for (int i = 0; i < list[a].size(); i++) {
			int b = list[a].get(i);

			if ((bMatch[b] == -1) || (dfs(bMatch[b]) == 1)) {
				bMatch[b] = a;
				aMatch[a] = b;

				return 1;
			}
		}
		return 0;
	}

	private static int bipartite() {
		int totalCount = 0;

		for (int i = 1; i <= n; i++) {
			visitCount++;
			totalCount += dfs(i);
		}
		return totalCount;
	}
}
