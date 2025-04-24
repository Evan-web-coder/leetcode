package ll.com.arr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定数组 a，要求输出这样的数组 b，b[i] 是 a[i] 左边第一个比 a[i] 大的元素，若不存在则 b[i] = -1
 */
public class LeftFirstGreaterElement {

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 4};
        int[] b = findLeftFirstGreater(a);

        System.out.print("输入数组: ");
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("结果数组: ");
        for (int num : b) {
            System.out.print(num + " ");
        }
    }

    /**
     * 找到数组中每个元素左边第一个比它大的元素
     * @param a 输入数组
     * @return 输出数组 b
     */
    private static int[] findLeftFirstGreater(int[] a) {
        int n = a.length;
        int[] b = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 如果栈顶元素不满足 "比当前元素大"，则弹出
            while (!deque.isEmpty() && a[deque.peek()] <= a[i]) {
                deque.pop();
            }
            // 如果栈为空，说明左边没有比当前元素大的
            b[i] = deque.isEmpty() ? -1 : a[deque.peek()];

            // 当前元素下标入栈
            deque.push(i);
        }

        return b;
    }
}
