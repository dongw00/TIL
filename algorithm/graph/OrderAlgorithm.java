package graph;

public class OrderAlgorithm {

    static class Node {
        int data;
        Node left, right;

        Node() {
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int n = 16;
        Node[] nodes = new Node[n];
        nodes[0] = new Node();

        for (int i = 1; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                nodes[i / 2].left = nodes[i];
            } else {
                nodes[i / 2].right = nodes[i];
            }
        }

        System.out.println("======== preorder ========");
        preorder(nodes[1]);
        System.out.println();

        System.out.println("======== inorder ========");
        inorder(nodes[1]);
        System.out.println();

        System.out.println("======== postorder ========");
        postorder(nodes[1]);
        System.out.println();
    }

    /**
     * 전위 순회
     *
     * @param node
     */
    public static void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + ", ");
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 중위 순회
     *
     * @param node
     */
    public static void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + ", ");
        inorder(node.right);
    }

    /**
     * 후위 순회
     *
     * @param node
     */
    public static void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + ", ");
    }
}
