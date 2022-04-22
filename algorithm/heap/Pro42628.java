package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Pro42628 {

    public static void main(String[] args) {
        Pro42628 p = new Pro42628();
        System.out.println(Arrays.toString(p.solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(p.solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] str = op.split(" ");

            switch (str[0]) {
                case "I":
                    minQueue.add(Integer.parseInt(str[1]));
                    maxQueue.add(Integer.parseInt(str[1]));
                    break;
                case "D":
                    if (minQueue.isEmpty()) {
                        break;
                    }

                    int num = Integer.parseInt(str[1]);

                    if (num < 0) {
                        int min = minQueue.remove();
                        maxQueue.remove(min);
                    } else {
                        int max = maxQueue.remove();
                        minQueue.remove(max);
                    }
            }
        }

        if (minQueue.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxQueue.remove(), minQueue.remove()};

    }
}
