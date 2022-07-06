package trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak14425 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node root = new Node();

        while (n-- > 0) {
            String str = br.readLine();
            Node now = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }
                now = now.next[c - 'a'];
                if (i == str.length() - 1) {
                    now.isEnd = true;
                }
            }
        }

        int cnt = 0;
        while (m-- > 0) {
            String str = br.readLine();
            Node now = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if (i == str.length() - 1 && now.isEnd) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static class Node {

        Node[] next = new Node[26];
        boolean isEnd;

        Node() {
        }
    }
}
