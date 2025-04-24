package ll.com.sort;

import java.util.Arrays;

/**
 * 冒泡排序是一种基础的排序算法，它的思想是通过相邻元素的比较和交换，将较大的元素逐步“冒泡”到数组末尾。
 * 冒泡排序是一个 稳定的排序算法，因为相同的元素在比较时不会发生位置交换，保持了它们的相对顺序。
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或只有一个元素无需排序
        }

        int n = arr.length;

        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 用于优化：检测本轮是否发生交换

            // 内层循环进行相邻元素比较
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true; // 标记本轮发生了交换
                }
            }

            // 如果本轮没有发生交换，说明数组已经有序，可以提前退出
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前: " + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
