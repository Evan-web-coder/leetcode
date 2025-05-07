package ll.com.NikeTest;

import java.util.ArrayList;
import java.util.List;

// Write a function to perform an in-order traversal of a binary tree and return the values in a list.
public class BinaryTreeInOrderTraversal {
    // 定义二叉树节点类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 中序遍历函数：返回节点值列表
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    // 递归辅助函数
    private static void inOrderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // 先遍历左子树
        inOrderHelper(node.left, result);

        // 访问当前节点
        result.add(node.val);

        // 再遍历右子树
        inOrderHelper(node.right, result);
    }
}
