package level.easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Preorder traversal of n-ary tree
public class PreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            res.add(current.val);
            List<Node> children = current.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
