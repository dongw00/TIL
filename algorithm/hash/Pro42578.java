package hash;

import java.util.HashMap;
import java.util.Map;

public class Pro42578 {

    public static void main(String[] args) {
        Pro42578 p = new Pro42578();
        System.out.println(p.solution(new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));

        System.out.println(p.solution(new String[][]{
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        }));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] el : clothes) {
            map.put(el[1], map.getOrDefault(el[1], 0) + 1);
        }

        int ans = 1;

        for (Map.Entry<String, Integer> el : map.entrySet()) {
            ans *= el.getValue() + 1;
        }

        return ans - 1;
    }
}
