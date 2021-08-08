package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak3190 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int[] head = new int[2];

        arr[1][1] = 2;
        head[0] = head[1] = 1;

        Queue<int[]> tailQueue = new LinkedList<>();
        Queue<int[]> timeQueue = new LinkedList<>();
        tailQueue.add(new int[]{1, 1});

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            arr[row][col] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char nDir = st.nextToken().charAt(0);
            int dir = nDir == 'L' ? 0 : 1;

            timeQueue.add(new int[]{time, dir});
        }

        int cnt = 0;
        int[] tmp = timeQueue.remove();
        int time = tmp[0], ndir = tmp[1];
        int dir = 0;
        while (true) {
            cnt++;
            calc(head, dir);
            tailQueue.add(new int[]{head[0], head[1]});

            if (head[0] < 1 || head[1] < 1 || head[0] >= n + 1 || head[1] >= n + 1
                || arr[head[0]][head[1]] == 2) {
                break;
            }

            if (arr[head[0]][head[1]] == 0) {
                int[] tail = tailQueue.remove();
                arr[tail[0]][tail[1]] = 0;
            }

            arr[head[0]][head[1]] = 2;
            if (cnt == time) {
                dir = dirCalc(dir, ndir);
                if (!timeQueue.isEmpty()) {
                    tmp = timeQueue.remove();
                    time = tmp[0];
                    ndir = tmp[1];
                }
            }
        }
        System.out.println(cnt);
    }

    public static void calc(int[] position, int dir) {
        switch (dir) {
            case 0:
                position[1]++;
                break;
            case 1:
                position[0]++;
                break;
            case 2:
                position[1]--;
                break;
            case 3:
                position[0]--;
                break;
        }
    }

    public static int dirCalc(int dir, int nDir) {
        switch (nDir) {
            case 1:
                return (dir + 1) % 4;
            case 0:
                return (dir + 3) % 4;
            default:
                return dir;
        }
    }
}
