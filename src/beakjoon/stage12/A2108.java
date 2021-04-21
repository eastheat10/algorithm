package beakjoon.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 통계학
public class A2108 {

	public static void main(String[] args)  throws IOException, NumberFormatException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		int avg = 0, med = 0, mode = 0, range = 0; // 평균, 중앙값, 최빈값, 범위
		double sum = 0;

		// 평균
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		} avg = (int)Math.round(sum / arr.length);

		// 중앙값
		med = arr[n / 2];

		// 범위
		range = arr[arr.length - 1] - arr[0];

		// 최빈값
		if (n == 1) {
			mode = arr[0];
			sb.append(avg + "\n" +
					med + "\n" +
					mode + "\n" +
					range + "\n");
			bw.write(sb.toString());
			br.close(); bw.flush(); bw.close();
		}
		else {
			int[] count = new int[8001];
			for (int num : arr)
				count[num + 4000]++;
			int modeMax = 0;    // 최대 몇번 나왔나
			int modeMaxIndex = 0;    // modeMax 인덱스
			for (int i = 0; i < count.length; i++) {
				if (count[i] > modeMax)
					modeMax = count[i];
			}

			boolean secondFlag = false;
			for (int i = 0; i < count.length; i++) {
				if (count[i] == modeMax) {
					if (secondFlag) {
						modeMaxIndex = i - 4000;
						break;
					}
					modeMaxIndex = i - 4000;
					secondFlag = true;
				}
			}

			mode = modeMaxIndex;

			sb.append(avg + "\n" +
					med + "\n" +
					mode + "\n" +
					range + "\n");
			bw.write(sb.toString());
			br.close();
			bw.flush();
			bw.close();
		}
	}
}
