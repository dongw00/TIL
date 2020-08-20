package backtracking;

import java.io.BufferedReader;
import java.util.List;

/**
 * Permutations - Leetcode
 *
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backTract(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backTract(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}