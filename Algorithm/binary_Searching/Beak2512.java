import java.io.*;
import java.util.*;

public class Beak2512 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int budget[] = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int min = 0;
    int max = 0;

    for (int i = 0; i < n; i++) {
      budget[i] = Integer.parseInt(st.nextToken());
      max = Math.max(budget[i], max);
    }

    int m = Integer.parseInt(br.readLine());

    int ans = 0;
    while (min <= max) {
      int mid = (min + max) / 2;
      long sum = 0;

      for (int i = 0; i < n; i++)
        sum += Math.min(budget[i], mid);

      if (sum > m)
        max = mid - 1;
      else {
        ans = mid;
        min = mid + 1;
      }

    }

    System.out.println(ans);
  }
}