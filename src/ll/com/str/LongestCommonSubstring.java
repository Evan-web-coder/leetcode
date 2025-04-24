package ll.com.str;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "zabcf";
        String result = findLongestCommonSubstring2(str1, str2);
        System.out.println("最长公共子串: " + result);
    }

    public static String findLongestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1]; // 动态规划表
        int maxLength = 0; // 记录最长公共子串长度
        int endIndex = 0; // 记录最长公共子串在 s1 中的结束位置

        // 填充动态规划表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1; // 更新子串的结束位置
                    }
                }
            }
        }

        // 提取最长公共子串
        return maxLength == 0 ? "" : s1.substring(endIndex - maxLength + 1, endIndex + 1);
    }

    // 优化空间复杂度
    public static String findLongestCommonSubstring2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n + 1]; // 一维数组，保存当前行的状态
        int maxLength = 0; // 记录最长公共子串长度
        int endIndex = 0; // 记录最长公共子串在 s1 中的结束位置

        // 填充动态规划表
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) { // 从右向左更新，避免数据覆盖
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1; // 更新当前匹配长度
                    if (dp[j] > maxLength) {
                        maxLength = dp[j];
                        endIndex = i - 1; // 更新子串的结束位置
                    }
                } else {
                    dp[j] = 0; // 不匹配时置为 0
                }
            }
        }

        // 提取最长公共子串
        return maxLength == 0 ? "" : s1.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}
