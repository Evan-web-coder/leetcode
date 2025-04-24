package ll.com.arr;

import java.util.Arrays;

public class ShortestPathLimitedMoves {
    public static int shortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 动态规划数组，初始化为无穷大
        int[] dp = new int[cols];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 起点初始化
        dp[0] = 0;

        // 遍历每一行
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = Integer.MAX_VALUE; // 障碍物，不可通行
                } else {
                    if (j > 0 && dp[j - 1] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - 1] + 1); // 来自左侧
                    }
                    if (i > 0 && dp[j] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j] + 1); // 来自上方
                    }
                }
            }
        }

        // 返回右下角的最短路径长度
        return dp[cols - 1] == Integer.MAX_VALUE ? -1 : dp[cols - 1];
    }

    public static void main(String[] args) {
        // 示例矩阵（0 表示可通行，1 表示障碍物）
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        int result = shortestPath(grid);
        System.out.println("最短路径长度: " + result);
    }
}
