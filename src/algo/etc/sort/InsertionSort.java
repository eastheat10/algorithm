package algo.etc.sort;

public class InsertionSort {
    public static void main(String[] args) {

        int[] insertionSort = {6, 4, 3, 7, 1, 9, 8};
        int size = insertionSort.length;

        for (int num : insertionSort)
            System.out.print(num + " ");
        System.out.println("\n");

        for (int i = 1; i < size; i++) {
            int j;
            int tmp = insertionSort[i];
            for (j = i; j > 0; j--) {
                if (insertionSort[j - 1] < tmp)
                    break;
                insertionSort[j] = insertionSort[j - 1];
            }
            insertionSort[j] = tmp;
        }

        for (int num : insertionSort) {
            System.out.print(num + " ");
        }
    }
}
