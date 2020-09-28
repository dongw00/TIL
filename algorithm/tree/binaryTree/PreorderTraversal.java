package tree.binaryTree;

import java.util.*;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return preOrder(root, ans);
    }

    private List<Integer> preOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return list;

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
        return list;
    }
}