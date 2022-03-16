package devMatching2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                        new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"young", "john", "tod", "emily", "mary"},
                        new int[]{12, 4, 2, 5, 10}
                ))
        );
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> people = new HashMap<>();
        int[] ans = new int[enroll.length];

        people.put("-", new Person("-"));
        for (String el : enroll) {
            people.put(el, new Person(el));
        }

        for (int i = 0; i < referral.length; i++) {
            people.get(enroll[i]).parent = people.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * 100;

            calcProfit(people.get(name), profit);
        }

        for (int i = 0; i < enroll.length; i++) {
            ans[i] = people.get(enroll[i]).profit;
        }
        return ans;
    }

    public static void calcProfit(Person person, int profit) {
        while (person != null) {
            int commission = profit / 10;
            person.profit += profit - commission;
            person = person.parent;

            profit /= 10;
        }
    }

    static class Person {
        String name;
        Person parent;
        int profit;

        public Person(String name) {
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }
    }
}
