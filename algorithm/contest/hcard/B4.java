package contest.hcard;

public class B4 {

    public static void main(String[] args) {
        System.out.println(solution("111011110011111011111100011111", 3));
        System.out.println(solution("001100", 5));
    }

    public static int solution(String road, int n) {
        int zero = 0;
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < road.length(); right++) {
            if (road.charAt(right) == '0') {
                zero++;
            }
            while (zero > n) {
                if (road.charAt(left) == '0') {
                    zero--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
