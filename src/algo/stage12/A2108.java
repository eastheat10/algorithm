package algo.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class A2108 {

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

	public static void main(String[] args)  throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		int avg = 0, med = 0, mode = 0, range = 0; // 평균, 중앙값, 최빈값, 합계
		double sum = 0;
		int max = arr[0], min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i])
				max = arr[i];
			if(min > arr[i])
				min = arr[i];
		}

		// 평균
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		} avg = (int)Math.round(sum / arr.length);

		// 중앙값
		med = arr[n / 2];

		// 범위
		range = max - min;

		// 최빈값
		int[] mode1 = new int[8001];
		int modeMax = 0;
		for(int i = 0; i < arr.length; i++) {
			mode1[arr[i]]++;
		}

		sb.append(avg + "\n" +
				med + "\n" +
				mode + "\n" +
				range + "\n");
		bw.write(sb.toString());
		br.close(); bw.flush(); bw.close();
	}
}
