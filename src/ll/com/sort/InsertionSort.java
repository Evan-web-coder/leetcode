package ll.com.sort;

import java.util.Arrays;

/**
 * 插入排序是一种稳定的排序算法。
 * 稳定排序的定义：在排序过程中，相同值的元素在排序后的相对顺序保持不变。
 * 插入排序的稳定性来源：它总是在不打破已排序部分元素的相对顺序的前提下，插入新元素。
 *
 * 插入排序的核心操作是将元素插入到已排序部分中，而在插入过程中：
 * 如果当前元素与已排序部分的某个元素相等，插入排序不会改变它们的相对顺序。
 * 元素的移动是通过从后往前比较，找到合适位置时插入到第一个不大于当前元素的位置。因此，相等的元素不会因为排序而改变其在数组中的先后次序。
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 空数组或只有一个元素，不需要排序
        }

        // 从第二个元素开始
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i]; // 当前待插入的元素
            int j = i - 1;

            // 比较并将前面较大的元素后移
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 找到插入位置
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("排序前: " + Arrays.toString(arr));
        
        insertionSort(arr);
        
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
