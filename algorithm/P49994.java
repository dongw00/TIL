public class P49994 {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDU"));
    }

    public static int solution(String dirs) {
        boolean[][][][] check = new boolean[11][11][11][11];

        int[] pos = new int[2];
        pos[0] = pos[1] = 5;

        int[] prev = new int[2];

        int ans = 0;
        for (char c : dirs.toCharArray()) {
            if (c == 'U') {
                int calc = pos[0] - 1;

                if (calc < 0) {
                    continue;
                }
                prev[0] = pos[0];
                prev[1] = pos[1];

                pos[0] = calc;
            } else if (c == 'R') {
                int calc = pos[1] + 1;

                if (calc > 10) {
                    continue;
                }
                prev[0] = pos[0];
                prev[1] = pos[1];

                pos[1] = calc;
            } else if (c == 'D') {
                int calc = pos[0] + 1;

                if (calc > 10) {
                    continue;
                }
                prev[0] = pos[0];
                prev[1] = pos[1];

                pos[0] = calc;
            } else {
                int calc = pos[1] - 1;

                if (calc < 0) {
                    continue;
                }
                prev[0] = pos[0];
                prev[1] = pos[1];

                pos[1] = calc;
            }

            if (!check[prev[0]][prev[1]][pos[0]][pos[1]]) {
                ans++;
            }

            check[prev[0]][prev[1]][pos[0]][pos[1]] = true;
            check[pos[0]][pos[1]][prev[0]][prev[1]] = true;
        }
        return ans;
    }
}
