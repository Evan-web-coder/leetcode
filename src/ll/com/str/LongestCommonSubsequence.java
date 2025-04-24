package ll.com.str;

/**
 * 两个字符串的最长公共子串
 */
public class LongestCommonSubsequence {
    public static String findLongestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // 定义 DP 表，dp[i][j] 表示 s1[0..i-1] 和 s2[0..j-1] 的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // 填充 DP 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 当前字符匹配，长度加 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 否则，取上方或左方的较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 通过 DP 表回溯，找出最长公共子序列
        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // 字符匹配，加入结果
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // 往上回溯
                i--;
            } else {
                // 往左回溯
                j--;
            }
        }

        // LCS 是倒序构建的，需反转
        return lcs.reverse().toString();
    }

    // 对空间进行优化
    public static String findLongestCommonSubsequence2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // 使用一维数组保存当前状态
        int[] dp = new int[n + 1];

        // 填充 DP 表
        for (int i = 1; i <= m; i++) {
            int prevDiagonal = 0; // 保存 dp[j-1] 的值，用于计算当前 dp[j]
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // 暂存当前 dp[j] 的值，用于下一轮更新
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prevDiagonal + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiagonal = temp; // 更新 prevDiagonal 为上一轮的 dp[j]
            }
        }

        // 回溯构建最长公共子序列
        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[j] == dp[j - 1]) {
                j--;
            } else {
                i--;
            }
        }

        // LCS 是倒序构建的，需反转
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "acef";

        String lcs = findLongestCommonSubsequence(s1, s2);
        System.out.println("最长公共子序列: " + lcs);
    }
}
