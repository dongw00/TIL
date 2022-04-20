package graph.dfs;

public class Pro43163 {

    int ans;
    String[] words;
    boolean[] visited;

    public static void main(String[] args) {
        Pro43163 p = new Pro43163();
        System.out.println(p.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(p.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        this.words = words;
        visited = new boolean[words.length];
        ans = 0;

        dfs(begin, target, 0);
        return ans;
    }

    public void dfs(String begin, String target, int cnt) {
        if (begin.equals(target)) {
            ans = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i])
                continue;

            if (checkWord(words[i], begin)) {
                visited[i] = true;
                dfs(words[i], target, cnt + 1);
                visited[i] = false;
            }
        }
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
