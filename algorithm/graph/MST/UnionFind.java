package graph.MST;

public class UnionFind {
	static int[] parent = new int[100001];
	
	public static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y)
			return true;
		else
			return false;
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y)
			parent[y] = x;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++)
			parent[i] = i;
		
		union(1, 2);
		union(2, 3);
		System.out.println("1과 3이 연결? " + isSameParent(1, 3));
	}

}
