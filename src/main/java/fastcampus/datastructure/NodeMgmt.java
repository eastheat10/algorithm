package fastcampus.datastructure;

public class NodeMgmt {
    Node root = null;

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
        if (this.root == null) {
            // case1: Node가 하나도 없을 때
            this.root = new Node(data);
            return true;
        } else {
            // case2: Node가 하나 이상 존재할 때
            Node findNode = this.root;
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
        if (this.root == null) {
            return null;
        } else {
            Node findNode = this.root;
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

    public Node delete(int value) {
        boolean searched = false;

        // 삭제할 노드
        Node deleteNode = this.root;
        // 삭제할 노드의 부모노드
        Node parentNode = this.root;

        if (this.root == null) {
            // CASE1: Node가 하나도 없을 때
            return null;
        } else {
            // CASE2: Node가 하나이고, 그 Node가 삭제할 노드일 때
            if (this.root.value == value && this.root.left == null && this.root.right == null) {
                Node tmp = this.root;
                this.root = null;
                return tmp;
            }

            // 삭제할 노드 찾기
            while (deleteNode != null) {
                if (deleteNode.value == value) {
                    searched = true;
                    break;
                } else if (deleteNode.value > value) {
                    parentNode = deleteNode;
                    deleteNode = deleteNode.left;
                } else {
                    parentNode = deleteNode;
                    deleteNode = deleteNode.right;
                }
            }
            if (searched == false) {
                // 삭제할 노드를 찾지 못하면 false 리턴
                return null;
            }
        }
        /**
         * 삭제할 Node를 찾음
         * deleteNode = 삭제할 노드, parentNode = deleteNode 부모노드
         */

        /*** CASE1: 삭제할 노드가 리프노드인 경우 ***/
        if (deleteNode.left == null && deleteNode.right == null) {

            if (parentNode.value > value) {
                // 삭제할 노드가 부모의 왼쪽 자식 노드
                parentNode.left = null;

            } else {
                // 삭제할 노드가 부모의 오른쪽 자식 노드
                parentNode.right = null;
            }
            return deleteNode;
        }
        /*** CASE2: 삭제할 노드의 자식이 하나일 경우 ***/
        else if (deleteNode.left != null && deleteNode.right == null) {
            // CASE2-1: 왼쪽 자식만 가지고 있을 경우
            if (parentNode.value > value) {
                // 삭제할 노드가 부모의 왼쪽 자식 노드
                parentNode.left = deleteNode.left;
            } else {
                // CASE2-2: 삭제할 노드가 부모의 오른쪽 자식 노드
                parentNode.right = deleteNode.left;
            }
            return deleteNode;
        } else if (deleteNode.left == null && deleteNode.right != null) {
            // CASE2-1: 오른쪽 자식만 가지고 있을 경우
            if (parentNode.value > value) {
                // 삭제할 노드가 부모의 왼쪽 자식 노드
                parentNode.left = deleteNode.right;
            } else {
                // CASE2-2: 삭제할 노드가 부모의 오른쪽 자식 노드
                parentNode.right = deleteNode.right;
            }
            return deleteNode;
        }
        /*** CASE3: 삭제할 노드의 자식이 둘일 경우 ***/
        else {
            // 직후원소 찾기
            Node successor = deleteNode.right;
            Node successorParent = deleteNode.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successor.right != null) {
                // 직후원소의 오른쪽 자식이 있을 때
                successorParent.left = successor.right;
            } else {
                // 직후원소의 오른쪽 자식이 없을 때
                successorParent.left = null;
            }
            /** 삭제할 노드가 부모노드의 왼쪽 자식노드 **/
            if (parentNode.value > value) {
                // 삭제하려는 노드의 부모노드의 왼쪽자식을 직후원소로 변경
                parentNode.left = successor;
            }
            /** 삭제할 노드가 부모노드의 오른쪽 자식노드 **/
            else {
                parentNode.right = successor;
            }
            successor.right = deleteNode.right;
            successor.left = deleteNode.left;
            return deleteNode;
        }
    }


    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.root.value);
        System.out.println("HEAD LEFT: " + myTree.root.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.root.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.root.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.root.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.root.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.root.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.root.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.root.right.right.right.value);

    }
}
