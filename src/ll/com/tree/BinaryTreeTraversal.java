package ll.com.tree;

import java.util.*;

// 二叉树遍历
public class BinaryTreeTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void preorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public void preorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            System.out.print(node.val + " ");

            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
    }

    public void inorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    public void inorderIterative(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.push(current);
                current = current.left;
            }
            current = deque.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public void postorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    public void postorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> output = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().val + " ");
        }
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 将节点值加入结果集
            result.add(node.val);

            // 左子节点先压栈
            if (node.left != null) {
                stack.push(node.left);
            }

            // 右子节点后压栈
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 反转结果集，得到后序遍历顺序
        Collections.reverse(result);
        return result;
    }

    public static void posOrder(TreeNode h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.push(h);
            TreeNode c = null;
            while (!deque.isEmpty()) {
                c = deque.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    deque.push(c.left);
                } else if (c.right != null && h != c.right) {
                    deque.push(c.right);
                } else {
                    System.out.print(deque.pop().val + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    // 广度优先遍历（层序遍历）
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // 从队列中取出节点
            System.out.print(current.val + " "); // 访问节点

            if (current.left != null) {
                queue.add(current.left); // 将左子节点加入队列
            }
            if (current.right != null) {
                queue.add(current.right); // 将右子节点加入队列
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTreeTraversal traversal = new BinaryTreeTraversal();

        System.out.println("Preorder (Recursive):");
        traversal.preorderRecursive(root);
        System.out.println("\nPreorder (Iterative):");
        traversal.preorderIterative(root);

        System.out.println("\n\nInorder (Recursive):");
        traversal.inorderRecursive(root);
        System.out.println("\nInorder (Iterative):");
        traversal.inorderIterative(root);

        System.out.println("\n\nPostorder (Recursive):");
        traversal.postorderRecursive(root);
        System.out.println("\nPostorder (Iterative):");
        traversal.postorderIterative(root);

        List<Integer> result = postOrderTraversal(root);
        System.out.println(result); // 输出 [3, 2, 1]
    }
}
