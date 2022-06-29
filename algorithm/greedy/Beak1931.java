package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak1931 {

    static class Pair {

        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Pair(start, end));
        }

        list.sort((o1, o2) -> {
            if (o1.end == o2.end) {
                return Integer.compare(o1.start, o2.start);
            }
            return Integer.compare(o1.end, o2.end);
        });

        int cnt = 0;
        int prev = 0;
        for (Pair el : list) {
            if (prev <= el.start) {
                prev = el.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
