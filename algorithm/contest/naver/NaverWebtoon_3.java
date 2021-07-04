package contest.naver;

public class NaverWebtoon_3 {

    public static void main(String[] args) {
        System.out.println(solution("aabcbcd", "abc"));
    }

    public static int solution(String s, String t) {
        int ans = 0;
        while (true) {
            int idx = s.indexOf(t);

            if (idx == -1) {
                break;
            }

            s = s.substring(0, idx) + s.substring(idx + 1);
            ans++;
        }

        return ans;
    }
}
