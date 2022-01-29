package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Beak12101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<String>[] list = new ArrayList[11];

        for (int i = 1; i < 11; i++) {
            list[i] = new ArrayList<>();
        }

        list[1].add("1");
        list[2].add("1+1");
        list[2].add("2");
        list[3].add("1+2");
        list[3].add("1+1+1");
        list[3].add("2+1");
        list[3].add("3");

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                for (String op : list[i - j]) {
                    list[i].add(op + "+" + j);
                }
            }
        }

        if (list[n].size() < k) {
            System.out.println(-1);
        } else {
            Collections.sort(list[n]);
            System.out.println(list[n].get(k - 1));
        }
    }
}
