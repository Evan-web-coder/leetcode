package ll.com.arr;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // 排序是为了剪枝和避免重复组合
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp)); // 找到一个合法组合
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 跳过重复元素（避免相同组合）
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // 剪枝：当前数大于剩余目标值，没必要继续
            if (nums[i] > target) {
                break;
            }

            temp.add(nums[i]);
            backtrack(nums, target - nums[i], i + 1, temp, result); // i + 1，保证每个元素只用一次
            temp.remove(temp.size() - 1); // 回溯
        }
    }

    // 测试一下
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = combinationSum(nums, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
