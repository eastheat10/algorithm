package fastcampus.datastructure.linkedlist;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("빈 리스트!");
            return;
        } else {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> sl = new SingleLinkedList<>();
        sl.addNode(1);
        System.out.println("sl.head.data = " + sl.head.data);
        sl.addNode(2);
        sl.addNode(3);

        sl.printAll();
    }


}
