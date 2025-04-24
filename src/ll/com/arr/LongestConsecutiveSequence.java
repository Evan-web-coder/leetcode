package ll.com.arr;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        // 将所有元素加入 HashSet
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // 遍历数组，查找最长连续序列
        for (int num : nums) {
            // 如果当前数字是序列的起点
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 检查序列的下一个数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // 更新最大长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // 测试
    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums1));
        // 输出: 4 (因为最长序列是 [1, 2, 3, 4])

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums2));
        // 输出: 9 (因为最长序列是 [0, 1, 2, 3, 4, 5, 6, 7, 8])
    }
}
