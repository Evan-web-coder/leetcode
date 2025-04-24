package ll.com.arr;

public class FindOdd {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(findSingleNum(nums));
        System.out.println(singleNonDuplicate(nums));
    }

    public static int findSingleNum(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 保证 mid 是偶数位置
            if (mid % 2 == 1) {
                mid--;  // 如果是奇数位置，减一调整为偶数位置
            }

            // 比较 mid 和 mid + 1 是否相等
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;  // 出现一次的数字在右半部分
            } else {
                right = mid;  // 出现一次的数字在左半部分
            }
        }

        return nums[left];
    }
}
