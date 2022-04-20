package kakao2019;

import java.util.*;

public class Pro42888 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    static class Kakao {
        String op;
        String userId;

        Kakao(String op, String userId) {
            this.op = op;
            this.userId = userId;
        }
    }

    public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        Queue<Kakao> queue = new LinkedList<>();

        for (String el : record) {
            String[] str = el.split(" ");

            String op = str[0];
            String userId = str[1];

            if (op.equals("Change") || op.equals("Enter")) {
                String nickname = str[2];
                map.put(userId, nickname);

                if (op.equals("Change")) {
                    continue;
                }
            }

            queue.add(new Kakao(op, userId));
        }

        String[] ans = new String[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            Kakao k = queue.remove();
            ans[idx++] = buildLog(map.get(k.userId), k.op);
        }
        return ans;
    }

    public static String buildLog(String nickname, String op) {
        switch (op) {
            case "Enter":
                return nickname + "님이 들어왔습니다.";
            case "Leave":
                return nickname + "님이 나갔습니다.";
        }
        return "";
    }
}
