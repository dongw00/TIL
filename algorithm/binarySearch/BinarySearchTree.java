package binarySearch;

public class BinarySearchTree {

    static class TreeNode {
        int key;
        TreeNode left, right;

        TreeNode(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.key = successor(root);
                root.right = deleteNode(root.right, root.key);
            } else {
                root.key = predecessor(root);
                root.left = deleteNode(root.left, root.key);
            }
        }

        return root;
    }

    private static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    private static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(50);

        insert(node, 30);
        insert(node, 20);
        insert(node, 40);
        insert(node, 70);
        insert(node, 60);
        insert(node, 80);

        inorder(node);
        System.out.println("======================");

        deleteNode(node, 50);

        inorder(node);

    }
}
