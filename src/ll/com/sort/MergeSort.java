package ll.com.sort;

import java.util.Arrays;

public class MergeSort {
    // 主函数：调用归并排序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        int[] temp = new int[arr.length]; // 辅助数组，用于合并时的临时存储
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    // 递归拆分数组并排序
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return; // 递归结束条件
        }

        int mid = left + (right - left) / 2; // 中间索引，避免整型溢出

        // 分治法：递归对左右两部分进行排序
        mergeSort(arr, left, mid, temp); // 排序左半部分
        mergeSort(arr, mid + 1, right, temp); // 排序右半部分

        // 合并两个有序数组
        merge(arr, left, mid, right, temp);
    }

    // 合并两个有序子数组
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;     // 左子数组的起始索引
        int j = mid + 1;  // 右子数组的起始索引
        int k = 0;        // 辅助数组的索引

        // 比较左右两个子数组中的元素，按升序放入辅助数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 如果左子数组还有剩余元素，直接拷贝到辅助数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 如果右子数组还有剩余元素，直接拷贝到辅助数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将辅助数组中的排序结果复制回原数组
        System.arraycopy(temp, 0, arr, left, k);
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("排序前: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
