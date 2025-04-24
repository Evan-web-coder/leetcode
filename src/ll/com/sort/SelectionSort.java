package ll.com.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 如果数组为空或只有一个元素，无需排序
        }

        // 遍历数组
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 假设当前索引 i 的元素是最小的

            // 在未排序部分中找到最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 将找到的最小值与当前元素交换
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("排序前: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}