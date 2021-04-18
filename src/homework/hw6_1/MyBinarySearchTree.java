package homework.hw6_1;

public class MyBinarySearchTree {

    private Node root = new Node();

    public MyBinarySearchTree() {
        this.root = null;
    }

    // Node 클래스
    private class Node {
        String key;
        Node leftNode;
        Node rightNode;

        Node() {
            this.leftNode = null;
            this.rightNode = null;
        }

        Node(String key) {
            this.key = key;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public void add(String key) {
        // key를 트리에 삽입
        root = addKey(root, key);
    }

    public Node addKey(Node root, String key) {
        //  root: 트리의 루트노드
        //  key: 삽입하고자하는 키
        Node node = root;
        Node newNode = new Node(key);   // 새 노드

        if (node == null) {
            // 노드가 비어있으면 삽입된 키로 이루어진 노드 리턴
            return newNode;
        } else if (node.key.compareToIgnoreCase(newNode.key) > 0) {
            // 삽입하려는 키가 루트보다 작으면 왼쪽 자식노드에 삽입
            node.leftNode = addKey(node.leftNode, key);
            return node;
        } else if (node.key.compareToIgnoreCase(newNode.key) < 0) {
            // 삽입하려는 키가 루트보다 크면 오른쪽 자식노드에 삽입
            node.rightNode = addKey(node.rightNode, key);
            return node;
        } else {
            // 삽입하려는 키가 트리에 존재하면 삽입하지않음
            return node;
        }
    }

    public void printTree() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            // 트리가 비어있지 않으면 작은 원소부터(오름차순) 출력
            inorder(root.leftNode);
            System.out.print(root.key + " ");
            inorder(root.rightNode);
        }
    }

}
