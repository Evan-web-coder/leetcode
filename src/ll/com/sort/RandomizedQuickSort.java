package ll.com.sort;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {
    // 主函数：调用快速排序
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或单元素数组无需排序
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // 快速排序的递归实现
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 分区操作，返回基准值的正确位置
            int pivotIndex = randomizedPartition(arr, low, high);

            // 对基准值左边的子数组进行快速排序
            quickSort(arr, low, pivotIndex - 1);

            // 对基准值右边的子数组进行快速排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 随机选择基准值并分区
    private static int randomizedPartition(int[] arr, int low, int high) {
        // 随机选择一个索引作为基准值
        Random random = new Random();
        int randomIndex = low + random.nextInt(high - low + 1);

        // 将随机选中的基准值与最后一个元素交换位置
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        // 使用普通分区函数进行分区
        return partition(arr, low, high);
    }

    // 分区函数：将数组按基准值分为两部分
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准值
        int i = low - 1;       // i 用于追踪小于基准值的区域

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // 如果当前元素小于等于基准值
                i++;
                // 交换元素
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准值放到正确位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 返回基准值的位置
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("排序前: " + Arrays.toString(arr));

        quickSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
