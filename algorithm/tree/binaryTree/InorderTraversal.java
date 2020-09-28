package tree.binaryTree;

import java.util.*;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return inOrder(root, ans);
    }

    private List<Integer> inOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return list;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
        return list;
    }
}