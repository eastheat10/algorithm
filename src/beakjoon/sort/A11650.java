package beakjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 좌표정렬 (x값 오름차순)
public class A11650 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[0] == arr2[0])
					return arr1[1] - arr2[1];
				else
					return arr1[0] - arr2[0];
			}
		});

		for(int i = 0; i < n; i++)
			sb.append(arr[i][0] + " " + arr[i][1] + "\n");

		bw.write(sb.toString());
		bw.flush(); bw.close(); br.close();

	}

}
