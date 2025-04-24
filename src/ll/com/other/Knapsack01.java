package ll.com.other;

public class Knapsack01 {

    // 解决 0/1 背包问题的主方法
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // 定义一个二维数组 dp，dp[i][j] 表示前 i 个物品中选取，总容量不超过 j 时的最大价值
        int[][] dp = new int[n + 1][capacity + 1];

        // 动态规划求解
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    // 当前物品可以装入背包，选择装入或不装入的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    // 当前物品不能装入背包
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static int knapsackOptimized(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // 使用一维数组，dp[j] 表示容量为 j 时的最大价值
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        return dp[capacity];
    }


    public static void main(String[] args) {
        // 物品重量数组
        int[] weights = {2, 3, 4, 5};
        // 物品价值数组
        int[] values = {3, 4, 5, 6};
        // 背包容量
        int capacity = 8;

        // 调用背包方法
        int maxValue = knapsackOptimized(weights, values, capacity);

        // 输出结果
        System.out.println("背包可以装入的最大价值是: " + maxValue);
    }
}
