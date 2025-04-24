package ll.com.str;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        // 使用一个 HashSet 来存储窗口内的字符
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int start = 0;

        // 遍历字符串，end 指针定义窗口的右边界
        for (int end = 0; end < s.length(); end++) {
            // 如果当前字符重复，缩小窗口
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start++));
            }
            // 将当前字符加入集合，并更新最大长度
            charSet.add(s.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 输出: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 输出: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 输出: 3
        System.out.println(lengthOfLongestSubstring(""));         // 输出: 0
        System.out.println(lengthOfLongestSubstring("abcdef"));   // 输出: 6
    }
}
