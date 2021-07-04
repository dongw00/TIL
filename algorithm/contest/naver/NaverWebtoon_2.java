package contest.naver;

import java.util.*;

public class NaverWebtoon_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abcxyasdfasdfxyabc")));
        System.out.println(Arrays.toString(solution("abcxyqwertyxyabc")));
        System.out.println(Arrays.toString(solution("abcabcabcabc")));
        System.out.println(Arrays.toString(solution("llttaattll")));
        System.out.println(Arrays.toString(solution("zzzzzz")));
    }

    public static String[] solution(String s) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        int start = 0, end = s.length() - 1;

        while (start < end) {
            String sStr = s.substring(0, start + 1);
            String eStr = s.substring(end);

            if (sStr.equals(eStr)) {
                list1.add(sStr);
                list2.add(eStr);

                s = s.substring(start + 1, end);
                start = 0; end = s.length() - 1;
            } else {
                start++; end--;
            }
        }

        if (!s.equals("")) {
            list1.add(s);
        }

        String[] ans = new String[list1.size() + list2.size()];
        for (int i = 0; i < list1.size(); i++) {
            ans[i] = list1.get(i);
        }

        int idx = list1.size();

        for (int i = list2.size() - 1; i >= 0; i--) {
            ans[idx++] = list2.get(i);
        }

        return ans;
    }
}
