package ll.com.itemtest;

import java.util.ArrayList;
import java.util.List;

// Write a class to implement a binary search tree (BST) with methods for insertion, search, and in-order traversal.
public class BinarySearchTree {
    // 内部节点类
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // 插入值
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = insertRecursive(node.right, val);
        }
        // 如果等于现有值，不插入（保持 BST 唯一性）
        return node;
    }

    // 搜索值
    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (val == node.val) {
            return true;
        }
        if (val < node.val) {
            return searchRecursive(node.left, val);
        }
        return searchRecursive(node.right, val);
    }

    // 中序遍历，返回值列表（升序）
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private void inOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderHelper(node.left, result);
            result.add(node.val);
            inOrderHelper(node.right, result);
        }
    }

    // 测试示例
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);

        System.out.println("搜索 6 是否存在: " + bst.search(6));  // true
        System.out.println("搜索 7 是否存在: " + bst.search(7));  // false
        System.out.println("中序遍历结果: " + bst.inOrderTraversal()); // [1, 3, 6, 8, 10, 14]
    }
}
