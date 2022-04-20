package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Pro43163 {

    class Pair {
        String word;
        int cnt;

        Pair(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Pro43163 p = new Pro43163();
        System.out.println(p.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(p.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Pair> queue = new LinkedList<>();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if (checkWord(begin, words[i])) {
                queue.add(new Pair(words[i], 1));
                visited[i] = true;

                while (!queue.isEmpty()) {
                    Pair p = queue.remove();

                    if (p.word.equals(target)) {
                        ans = Math.min(ans, p.cnt);
                    }

                    if (ans < p.cnt) {
                        break;
                    }

                    for (int j = 0; j < words.length; j++) {
                        if (!visited[j] && checkWord(words[j], p.word)) {
                            queue.add(new Pair(words[j], p.cnt + 1));
                            visited[j] = true;
                        }
                    }
                }
            }
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    public boolean checkWord(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (cnt > 1) {
                return false;
            }
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

}
