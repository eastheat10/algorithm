package algo.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// 버블정렬, 삽입정렬
public class A2750 {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					int tmp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
	    for(int i = 1; i < arr.length; i++) {
	        for(int j = i; j > 0; j--) {
	            if(arr[j-1] > arr[j]) {
	                int temp = arr[j-1];
	                arr[j-1] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		bubbleSort(arr);
		insertionSort(arr);

		for (int num : arr)
			sb.append(num + "\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
