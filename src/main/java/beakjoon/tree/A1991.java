package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 순회
class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void add(char value, char left, char right) {
        if (root == null) {
            if (value != '.')
                root = new Node(value);
            if (left != '.')
                root.left = new Node(left);
            if (right != '.')
                root.right = new Node(right);
        } else {
            search(root, value, left, right);
        }
    }

    public void search(Node root, char value, char left, char right) {
        if (root == null)
            return;

        if (root.data == value) {
            if (left != '.')
                root.left = new Node(left);
            if (right != '.')
                root.right = new Node(right);
        } else {
            search(root.left, value, left, right);
            search(root.right, value, left, right);
        }
    }

    // 전위 순회 : 루트 -> 왼쪽 자식 -> 오른쪽 자식
    public void preOrder(Node node, StringBuilder sb) {
        sb.append(node.data);

        if (node.left != null)
            preOrder(node.left, sb);
        if (node.right != null)
            preOrder(node.right, sb);
    }

    // 중위 순회 : 왼쪽 자식-> 루트 -> 오른쪽 자식
    public void inOrder(Node node, StringBuilder sb) {
        if (node.left != null)
            inOrder(node.left, sb);

        sb.append(node.data);

        if (node.right != null)
            inOrder(node.right, sb);
    }

    // 후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 루트
    public void postOrder(Node node, StringBuilder sb) {
        if (node.left != null)
            postOrder(node.left, sb);

        if (node.right != null) {
            postOrder(node.right, sb);
        }

        sb.append(node.data);
    }
}

public class A1991 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.add(data, left, right);
        }

        tree.preOrder(tree.root, sb);
        sb.append('\n');
        tree.inOrder(tree.root, sb);
        sb.append('\n');
        tree.postOrder(tree.root, sb);

        System.out.println(sb);

    }

}
