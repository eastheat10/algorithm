package beakjoon.etc.sort;

public class BubbleSort {
    public static void main(String[] args) {

        int[] bubbleSort = {6, 4, 3, 7, 1, 9, 8};
        int size = bubbleSort.length;

        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (bubbleSort[j] < bubbleSort[j - 1]) {
                    int tmp = bubbleSort[j];
                    bubbleSort[j] = bubbleSort[j - 1];
                    bubbleSort[j - 1] = tmp;
                }
            }
        }

        for (int num : bubbleSort) {
            System.out.println("num = " + num);
        }
    }
}
