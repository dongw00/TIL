package hash;

import java.util.*;

public class Pro42579 {
    public static void main(String[] args) {
        Pro42579 p = new Pro42579();
        System.out.println(Arrays.toString(p.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        )));

        System.out.println(Arrays.toString(p.solution(
                new String[]{"A", "A", "B", "A"},
                new int[]{5, 5, 6, 5}
        )));
    }

    static class Pair {
        int num;
        int plays;

        Pair(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);

            List<Pair> list = map.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Pair(i, plays[i]));
            map.put(genres[i], list);
        }

        List<String> sortedGenres = new ArrayList<>();
        for (Map.Entry<String, Integer> el : total.entrySet()) {
            sortedGenres.add(el.getKey());
        }

        sortedGenres.sort((o1, o2) -> -Integer.compare(total.get(o1), total.get(o2)));

        List<Integer> tmp = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Pair> list = map.get(genre);
            list.sort((o1, o2) -> {
                if (o1.plays == o2.plays) {
                    return Integer.compare(o1.num, o2.num);
                }
                return -Integer.compare(o1.plays, o2.plays);
            });

            for (int i = 0; i < 2 && i < list.size(); i++) {
                tmp.add(list.get(i).num);
            }
        }

        int[] ans = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}
