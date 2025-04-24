package ll.com.str;

public class LongestPalindrome {
    // 主方法
    public static void main(String[] args) {
        String input = "babadf";
        String result = longestPalindrome(input);
        System.out.println("最长回文子串是: " + result);
    }

    /**
     * 求字符串的最长回文子串
     * @param s 输入字符串
     * @return 最长回文子串
     */
    private static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // 记录最长回文子串的起始和结束索引
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 中心为单字符
            int len1 = expandAroundCenter(s, i, i);
            // 中心为双字符
            int len2 = expandAroundCenter(s, i, i + 1);
            // 选择更长的回文长度
            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * 从中心向外扩展，寻找最长回文子串
     * @param s 输入字符串
     * @param left 左指针
     * @param right 右指针
     * @return 回文子串的长度
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回扩展后的回文子串长度
        return right - left - 1;
    }
}
