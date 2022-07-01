package graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak1043 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if (k == 0) {
            System.out.println(m);
            return;
        }

        // 진실을 아는 사람
        int[] truePeople = new int[k];
        for (int i = 0; i < k; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 참여
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        List<Integer>[] party = new ArrayList[m + 1];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 1; j < party[i].size(); j++) {
                unionParent(party[i].get(j - 1), party[i].get(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int cur = party[i].get(0);
            boolean check = true;

            for (int trueP : truePeople) {
                if (isSameParent(trueP, cur)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static int getParent(int x) {
        if (arr[x] == x) {
            return x;
        }

        return arr[x] = getParent(arr[x]);
    }

    private static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    private static boolean isSameParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        return a == b;
    }

}
