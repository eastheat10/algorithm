package homework.hw6_1;

public class MyBinarySearchTreeTest {
    public static void main(String[] args) {
        System.out.println("hw6_1: 윤동열");

        MyBinarySearchTree tree = new MyBinarySearchTree();

        // tree를 중순위 순회하여 출력
        System.out.print("\n오름차순 출력 = ");
        tree.printTree();

        // tree에 다음과 같이 1개의 단어를 삽입한 후 tree를 중순위 순회하여 출력
        tree.add("cat");
        System.out.print("\n오름차순 출력 = ");
        tree.printTree();   // 또는 System.out.println(tree.toString());

        // tree에 다음과 같이 13개의 단어를 추가로 삽입한 후 tree를 중순위 순회하여 출력
        tree.add("HAT");
        tree.add("ant");
        tree.add("BEE");
        tree.add("dog");
        tree.add("Last");
        tree.add("KEY");
        tree.add("Korea");
        tree.add("egg");
        tree.add("ink");
        tree.add("juice");
        tree.add("free");
        tree.add("go");
        tree.add("CAT");  // 이미 존재하는 단어이므로 삽입되지 않을 것임
        System.out.print("\n오름차순 출력 = ");
        tree.printTree();


    }
}
