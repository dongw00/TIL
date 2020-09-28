package tree.binaryTree;

import java.util.*;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return postOrder(root, ans);
    }

    private List<Integer> postOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return list;

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
        return list;
    }
}