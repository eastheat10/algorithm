package fastcampus.datastructure.tree;

public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public boolean insertNode(int data) {
        if (this.head == null) {
            // case1: Node가 하나도 없을 때
            this.head = new Node(data);
            return true;
        } else {
            // case2: Node가 하나 이상 존재할 때
            Node findNode = this.head;
            while (true) {
                if (findNode.value > data) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        return true;
                    }
                } else if (findNode.value < data) {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        return true;
                    }
                } else {
                    System.out.println("중복값!");
                    return false;
                }
            }
        }
    }

    public Node searchNode(int data) {
        // CASE1: Node 하나도 없을 때
        if (this.head == null) {
            return null;
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data)
                    // 찾았을 때
                    return findNode;
                else if (findNode.value > data) {
                    // 찾는 값이 노드의 값보다 작으면 왼쪽 자식
                    findNode = findNode.left;
                } else if (findNode.value < data) {
                    // 찾는 값이 노드의 값보다 작으면 오른쪽 자식
                    findNode = findNode.right;
                }
            }
        }
        // 못찾으면 null
        return null;
    }

    public boolean delete(int value) {
        boolean searched = false;


        Node deleteNode = this.head;
        Node parentNode = this.head;

    }

    public static void main(String[] args) {
        NodeMgmt tree = new NodeMgmt();
        System.out.println(tree.insertNode(1));
        System.out.println(tree.insertNode(2));
        System.out.println(tree.insertNode(3));
        System.out.println(tree.insertNode(1));

        System.out.println(tree.searchNode(3));

    }
}
