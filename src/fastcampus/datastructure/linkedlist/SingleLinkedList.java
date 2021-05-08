package fastcampus.datastructure.linkedlist;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data; // 데이터
        Node<T> next = null; // 다음노드

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next.data +
                    '}';
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

    public void addNodeInside(T data, T before) {
        Node<T> searchedNode = this.search(before);
        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> addNode = new Node<>(data);
            addNode.next = searchedNode.next;
            searchedNode.next = addNode;
        }
    }

    public Node<T> search(T data) {
        if (head == null) {
            return null;
        }
        Node<T> node = this.head;
        while (node != null) {
            if (node.data == data) {
                return node;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    public boolean deleteNode(T data) {
        if (head == null) {
            // head가 null 이면 빈 리스트
            return false;
        }

        Node<T> node = head;
        if (node.data == data) {
            // head의 data가 삭제하려는 데이터면 head가 원래 head의 다음노드
            head = node.next;
            return true;
        }
        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> sl = new SingleLinkedList<>();
        sl.addNode(1);
        System.out.println("sl.head.data = " + sl.head.data);
        sl.addNode(2);
        sl.addNode(3);

        sl.printAll();

        System.out.println();
        sl.addNodeInside(5, 2);
        sl.printAll();

        System.out.println();

        System.out.println(sl.deleteNode(7));
        sl.printAll();

    }


}
