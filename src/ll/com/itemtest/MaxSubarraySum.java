package ll.com.itemtest;

// Write a function that takes an array of integers and returns the maximum sum of any contiguous subarray.
public class MaxSubarraySum {
    // 函数：返回任意连续子数组的最大和
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }

        int maxSum = nums[0];  // 最大和，初始为第一个元素
        int currentSum = nums[0];  // 当前的连续和

        for (int i = 1; i < nums.length; i++) {
            // 当前值 + 当前和 vs 当前值 谁大就选谁（也可能是重新开始）
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
