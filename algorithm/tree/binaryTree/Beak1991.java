package tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1991 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] node = new Node[n];
        char a1 = 'A';
        for (int i = 0; i < n; i++) {
            node[i] = new Node(a1++);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            node[a - 'A'].left = b == '.' ? null : node[b - 'A'];
            node[a - 'A'].right = c == '.' ? null : node[c - 'A'];
        }

        System.out.println(preorder(node[0]));
        System.out.println(inorder(node[0]));
        System.out.println(postorder(node[0]));
    }

    public static String preorder(Node node) {
        String val = "";

        val += node.val;
        if (node.left != null) {
            val += preorder(node.left);
        }
        if (node.right != null) {
            val += preorder(node.right);
        }
        return val;
    }

    public static String inorder(Node node) {
        String val = "";

        if (node.left != null) {
            val += inorder(node.left);
        }
        val += node.val;
        if (node.right != null) {
            val += inorder(node.right);
        }
        return val;
    }

    public static String postorder(Node node) {
        String val = "";

        if (node.left != null) {
            val += postorder(node.left);
        }
        if (node.right != null) {
            val += postorder(node.right);
        }

        val += node.val;
        return val;
    }

    static class Node {

        char val;
        Node left;
        Node right;

        Node() {

        }

        Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
