package algo.etc.sort;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        int startLeft = partition(arr, start, end);
        if (start < startLeft - 1) {
            quickSort(arr, start, startLeft - 1);
        }
        if (startLeft < end) {
            quickSort(arr, startLeft, end);
        }
    }

    public static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot)
                start++;
            while (arr[end] > pivot)
                end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] quickSort = {6, 4, 3, 7, 1, 9, 8};
        int size = quickSort.length;

        for (int num : quickSort)
            System.out.print(num + " ");

        System.out.println("\n========");

        quickSort(quickSort, 0, size - 1);

        for (int num : quickSort)
            System.out.print(num + " ");

    }
}
