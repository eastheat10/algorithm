package beakjoon.etc.sort;

public class MergeSort {

    static int[] buffer;

    public static void mergeSort(int[] arr, int start, int end) {

        int center = (start + end) / 2;
        mergeSort(arr, start, center);
        mergeSort(arr, center + 1, end);

    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 9, 8};
        for (int num : arr)
            System.out.println(num + " ");

        buffer = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1);

        buffer = null;

        System.out.println("=================");
        for (int num : arr)
            System.out.print(num + " ");


    }

}
