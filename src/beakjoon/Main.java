package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 기둥
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		double sum = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		int avg = (int)Math.round(sum / n);
		int tmp = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if (Math.abs(arr[i] - avg) < tmp) {
				index = i;
				tmp = Math.abs(arr[i] - avg);
			}
		}
		tmp = arr[index];

		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += Math.abs(tmp - arr[i]);

		}
		System.out.println(result);

	}

//	public static void main(String[] args) throws IOException {
//  	// 경품
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int[] arr = new int[n + 1];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 1; i <= n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		int result = Integer.MAX_VALUE;
//		for (int i = 1; i <= n - 2; i++) {
//			int a = arr[i];
//			int b = arr[i + 1];
//			int c = arr[i + 2];
//			int sum = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
//			result = Math.min(result, sum);
//		}
//		System.out.println(result);
//	}
}
