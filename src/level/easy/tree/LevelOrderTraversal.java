package level.easy.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.println(current.val);
                if (null != current.left) {
                    queue.add(current.left);
                }
                if (null != current.right) {
                    queue.add(current.right);
                }
                levelList.add(current.val);
            }
            res.add(levelList);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        System.out.println(levelOrder(node1));
    }
}
