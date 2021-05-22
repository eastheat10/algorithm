package beakjoon.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 카운팅정렬(계수정렬)
public class A10989 {

	public static void countingSort(int[] arr, int max) {
		int[] tmp = new int[max + 1];
		int[] result = new int[arr.length];

		for(int i = 0; i < arr.length; i++)
			tmp[arr[i]]++;

		for(int i = 1; i <= max; i++)
			tmp[i] += tmp[i-1];

		for(int i = arr.length - 1; i >= 0; i--)
			result[--tmp[arr[i]]] = arr[i];

		for(int i = 0; i < arr.length; i++)
			arr[i] = result[i];

	}

	public static void main (String[] args) throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int max = arr[0];

		for(int i = 1; i < n; i++) {
			if(arr[i] > max)
				max = arr[i];
		}

		countingSort(arr, max);

		for(int num : arr)
			sb.append(Integer.toString(num) + "\n");

		bw.write(sb.toString());
		bw.flush(); bw.close(); br.close();

	}

}
