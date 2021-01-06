package algo.stage9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int left = x;
		int right = w - x;
		int up = h - y;
		int down = y;

		int[] a = {left, right, up, down};
		int min = a[0];
		for(int i = 1; i < a.length; i++) {
			if(min > a[i])
				min = a[i];
		}

		System.out.println(min);
	}

}