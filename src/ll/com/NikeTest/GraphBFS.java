package ll.com.NikeTest;

import java.util.*;

// Implement a function to perform a breadth-first search (BFS) on a graph represented as an adjacency list.
public class GraphBFS {
    // 广度优先搜索函数
    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // 遍历邻接节点
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

    // 示例
    public static void main(String[] args) {
        // 构建邻接表表示的图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 5));
        graph.put(5, Arrays.asList(4));

        List<Integer> bfsResult = bfs(graph, 0);
        System.out.println("BFS 遍历顺序：" + bfsResult);
        // 输出应该是 [0, 1, 2, 3, 4, 5]
    }
}
