package algo.etc.sort;

public class SelectionSort {
    public static void main(String[] args) {

        int[] selectionSort = {6, 4, 3, 7, 1, 9, 8};
        int size = selectionSort.length;

        for (int i = 0; i < size; i++) {
            int min = i;    // 정렬되지 않은 부분 중에서 최솟값의 인덱스 기록
            for (int j = i + 1; j < size; j++) {
                if (selectionSort[j] < selectionSort[min]) {
                    min = j;
                }
            }

            int tmp = selectionSort[i];
            selectionSort[i] = selectionSort[min];
            selectionSort[min] = tmp;
        }

        for (int num : selectionSort) {
            System.out.println("num = " + num);
        }

    }
}
