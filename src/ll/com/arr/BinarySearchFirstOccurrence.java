package ll.com.arr;

public class BinarySearchFirstOccurrence {
    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid; // 记录当前找到的索引
                right = mid - 1; // 继续在左半部分查找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        System.out.println("First occurrence of " + target + " is at index: " + findFirstOccurrence(nums, target));
    }
}
