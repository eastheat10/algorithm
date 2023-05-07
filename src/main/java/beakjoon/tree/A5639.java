package beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이진 검색 트리
public class A5639 {

    static Tree1 tree = new Tree1();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            if (s.length() == 0)
                break;
            int n = Integer.parseInt(s);
            tree.add(n);
        }
    }

    static void search() {
        StringBuilder sb = new StringBuilder();
        tree.postOrder(tree.root, sb);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        search();
    }
}

class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int data) {
        this.data = data;
    }
}

class Tree1 {
    Node1 root;

    public void add(int value) {
        if (root == null) {
            root = new Node1(value);
        } else {
            search(root, value);
        }
    }

    public void search(Node1 node, int value) {
        if (node == null) return;

        if (node.data > value) {
            if (node.left == null) {
                node.left = new Node1(value);
            } else {
                search(node.left, value);
            }
        } else if (node.data < value) {
            if (node.right == null) {
                node.right = new Node1(value);
            } else {
                search(node.right, value);
            }
        }
    }

    public void postOrder(Node1 node, StringBuilder sb) {
        if (node.left != null)
            postOrder(node.left, sb);
        if (node.right != null)
            postOrder(node.right, sb);
        sb.append(node.data).append('\n');
    }

}
