package graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Beak14226 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        // screen / clipboard
        boolean[][] visited = new boolean[1001][1001];

        Queue<Emotion> queue = new LinkedList<>();
        queue.add(new Emotion(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            Emotion e = queue.remove();

            if (e.screen == s) {
                System.out.println(e.second);
                break;
            }

            // 클립보드로 이모티콘 복사
            queue.add(new Emotion(e.screen, e.screen, e.second + 1));

            // 클립보드 -> 화면 붙여넣기
            if (e.clipboard > 0 && e.screen + e.clipboard <= s && !visited[e.screen + e.clipboard][e.clipboard]) {
                queue.add(new Emotion(e.screen + e.clipboard, e.clipboard, e.second + 1));
                visited[e.screen + e.clipboard][e.clipboard] = true;
            }

            // 화면 이모티콘 1개 삭제
            if (e.screen > 0 && !visited[e.screen - 1][e.clipboard]) {
                queue.add(new Emotion(e.screen - 1, e.clipboard, e.second + 1));
                visited[e.screen - 1][e.clipboard] = true;
            }
        }
    }

    static class Emotion {
        int screen, clipboard, second;

        Emotion(int screen, int clipboard, int second) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.second = second;
        }
    }
}
