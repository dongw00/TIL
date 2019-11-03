package binarySearch;
import java.io.*;
import java.util.*;

public class Beak2805 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int tree[] = new int[n];

    st = new StringTokenizer(br.readLine());

    int min = 0;
    int max = 0;

    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      max = Math.max(tree[i], max);
    }

    while (min + 1 < max) {
      int mid = (min + max) / 2;
      long sum = 0;

      for (int i = 0; i < n; i++) {
        if (tree[i] > mid)
          sum += tree[i] - mid;
      }

      if (sum >= m)
        min = mid;
      else
        max = mid;
    }

    System.out.println(min);
  }
}