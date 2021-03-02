package algo.stage10;

import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.Arrays;

public class A2447 {
	public static StringBuffer sb1 = new StringBuffer();

	static char[][] arr;
	static int count = 0;

	public static void printStar(int x, int y, int n) {
		if(n == 1){
			arr[x][y] = '*';
			return;
		}

		int tmp = n / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) {
					printStar(x + (i * tmp), y + (j * tmp), tmp);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());

		arr = new char[n][n];
		for (int k = 0; k < n; k++) {
			Arrays.fill(arr[k],' ');
		}

		int x = 0, y = 0;

		printStar(x, y, n);

		for (char[] tmp1 : arr) {
			for (char tmp2 : tmp1) {
				sb.append(tmp2);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();bw.close();
		br.close();

	}
}
