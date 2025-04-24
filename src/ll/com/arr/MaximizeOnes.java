package ll.com.arr;

import java.util.Arrays;

// 翻转01数组后，求最多的1的个数
public class MaximizeOnes {
    public static int maximizeOnesAfterFlip(int[] arr) {
        int totalOnes = Arrays.stream(arr).sum(); // 统计原数组中1的总数
        int maxDiff = 0; // 当前最大差值
        int currentDiff = 0; // 滑动窗口的当前差值

        for (int num : arr) {
            // 将1当作-1，0当作+1，计算滑动窗口的差值
            int value = (num == 1) ? -1 : 1;
            currentDiff = Math.max(value, currentDiff + value);
            maxDiff = Math.max(maxDiff, currentDiff);
        }

        // 如果数组全为1且不能翻转，可以返回totalOnes本身
        if (maxDiff == 0) {
            return totalOnes - 1; // 必须翻转一个区间
        }

        return totalOnes + maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1};
        System.out.println("最大1的个数为: " + maximizeOnesAfterFlip(arr));
    }
}
