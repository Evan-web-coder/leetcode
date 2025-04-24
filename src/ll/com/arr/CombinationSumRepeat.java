package ll.com.arr;

import java.util.*;

public class CombinationSumRepeat {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 为剪枝做准备
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // 找到一个合法组合
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break; // 剪枝
            }

            path.add(candidates[i]);
            // 允许重复使用当前数字 -> 仍然从 i 开始
            backtrack(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1); // 回溯
        }
    }

    // 测试入口
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(nums, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
