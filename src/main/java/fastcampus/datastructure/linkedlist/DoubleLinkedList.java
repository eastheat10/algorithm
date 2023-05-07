package fastcampus.datastructure.linkedlist;

public class DoubleLinkedList<T> {

    private Node<T> root = null;
    private Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (root == null) {
            this.root = new Node<>(data);
            this.tail = this.root;
        } else {
            Node<T> node = this.root;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (root == null) {
            System.out.println("empty list");
            return;
        }
        Node<T> node = this.root;
        System.out.println(node.data);
        while (node.next != null) {
            node = node.next;
            System.out.println(node.data);
        }
    }

    public void printReverse() {
        if (tail == null) {
            System.out.println("empty list");
            return;
        }
        Node node = this.tail;
        System.out.println(node.data);
        while (node.prev != null) {
            node = node.prev;
            System.out.println(node.data);
        }
    }

    public Node<T> search(T data) {
        if (root == null) {
            System.out.println("empty list");
            return null;
        }
        Node<T> node = this.root;
        if (node.data == data) {
            return node;
        }
        while (node.next != null) {
            node = node.next;
            if (node.data == data) {
                return node;
            }
        }
        System.out.println("fail");
        return null;
    }

    public Node<T> reverseSearch(T data) {
        if (tail == null) {
            System.out.println("empty list");
            return null;
        }
        Node<T> node = this.tail;
        if (node.data == data) {
            return node;
        }
        while (node.prev != null) {
            node = node.prev;
            if (node.data == data) {
                return node;
            }
        }
        System.out.println("fail");
        return null;
    }

    public boolean addPrev(T data, T after) {
        if (root == null) {
            this.root = new Node<>(data);
            this.tail = this.root;
            return true;
        } else if (root.data == after) {
            Node<T> newroot = new Node<>(data);
            newroot.next = this.root;
            this.root = newroot;
            return true;
        } else {
            Node<T> node = this.root;
            while (node != null) {
                if (node.data == after) {
                    Node<T> newNode = new Node<>(data);

                    newNode.prev = node.prev;
                    node.prev.next = newNode;

                    newNode.next = node;
                    node.prev = newNode;
                    return true;
                }
                node = node.next;
            }
        }
        System.out.println("fail");
        return false;
    }

    public boolean addNext(T data, T before) {
        if (root == null) {
            this.root = new Node<>(data);
            this.tail = this.root;
            return true;
        } else if (tail.data == before) {
            Node<T> tailNode = new Node<>(data);
            tail.next = tailNode;
            tailNode.prev = this.tail;
            this.tail = tailNode;
            return true;
        } else {
            Node<T> node = this.root;
            while (node != null) {
                if (node.data == before) {
                    Node<T> newNode = new Node<>(data);

                    newNode.next = node.next;
                    node.next.prev = newNode;

                    newNode.prev = node;
                    node.next = newNode;
                    return true;
                }
                node = node.next;
            }
        }
        System.out.println("fail");
        return false;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();
        dl.addNode(1);
        dl.addNode(2);
        dl.addNode(3);
        dl.addNode(4);
        dl.addNode(5);

        System.out.println(dl.addPrev(10, 10));
        System.out.println(dl.addNext(8, 99));

        dl.printAll();
    }

}
