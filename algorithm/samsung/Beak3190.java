package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak3190 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        Pair head = new Pair(1, 1);

        arr[1][1] = 1;

        Queue<Pair> tailQueue = new LinkedList<>();
        tailQueue.add(new Pair(1, 1));

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            arr[row][col] = 2;
        }

        int l = Integer.parseInt(br.readLine());

        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            map.put(x, c);
        }

        int cnt = 0;
        int dir = 0;

        while (true) {
            cnt++;

            nextWay(head, dir);
            tailQueue.add(new Pair(head.x, head.y));

            // 게임종료 조건
            if (head.x < 1 || head.y < 1 || head.x > n || head.y > n || arr[head.x][head.y] == 1) {
                break;
            }

            if (arr[head.x][head.y] == 0) {
                Pair tail = tailQueue.remove();
                arr[tail.x][tail.y] = 0;
            }

            arr[head.x][head.y] = 1;

            if (map.containsKey(cnt)) {
                dir = changeDir(dir, map.get(cnt));
            }
        }

        System.out.println(cnt);
    }

    public static int changeDir(int curDir, char way) {
        switch (way) {
            case 'L':
                return (curDir + 3) % 4;
            case 'D':
                return (curDir + 1) % 4;
            default:
                return curDir;
        }
    }

    public static void nextWay(Pair head, int dir) {
        switch (dir) {
            case 0:
                head.y++;
                break;
            case 1:
                head.x++;
                break;
            case 2:
                head.y--;
                break;
            case 3:
                head.x--;
                break;
        }
    }

    static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
