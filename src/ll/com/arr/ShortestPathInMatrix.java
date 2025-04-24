package ll.com.arr;

public class ShortestPathInMatrix {
    // 方法：计算从矩阵左上角到右下角的最短路径
    public static int findShortestPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("矩阵不能为空");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 定义 dp 数组存储到达每个位置的最短路径和
        int[][] dp = new int[rows][cols];

        // 初始化左上角
        dp[0][0] = matrix[0][0];

        // 初始化第一行
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // 初始化第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // 填充 dp 数组
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        // 返回右下角的最短路径
        return dp[rows - 1][cols - 1];
    }

    // 方法：计算从矩阵左上角到右下角的最短路径
    public static int findShortestPath3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("矩阵不能为空");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 一维数组用于存储当前行的最短路径
        int[] dp = new int[cols];

        // 初始化第一行
        dp[0] = matrix[0][0];
        for (int j = 1; j < cols; j++) {
            dp[j] = dp[j - 1] + matrix[0][j];
        }

        // 逐行更新 dp 数组
        for (int i = 1; i < rows; i++) {
            // 更新当前行的第一个元素，依赖上一行第一个元素
            dp[0] += matrix[i][0];

            // 更新当前行的其他元素
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
            }
        }

        // dp[cols - 1] 是右下角的最短路径
        return dp[cols - 1];
    }

    // 测试代码
    public static void main(String[] args) {
        // 定义一个矩阵
        int[][] matrix = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        // 计算最短路径
        int shortestPath = findShortestPath(matrix);
        System.out.println("从左上角到右下角的最短路径权值: " + shortestPath); // 输出：7
    }
}
